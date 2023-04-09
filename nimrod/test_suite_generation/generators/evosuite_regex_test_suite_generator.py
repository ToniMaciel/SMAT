import logging
import os
import re
from typing import List
from nimrod.core.merge_scenario_under_analysis import MergeScenarioUnderAnalysis

from nimrod.test_suite_generation.generators.evosuite_test_suite_generator import EvosuiteTestSuiteGenerator
from nimrod.tests.utils import get_config
from nimrod.tools.java import Java
from nimrod.tools.bin import EVOSUITE_REGEX, EVOSUITE_RUNTIME_REGEX


class EvosuiteRegexTestSuiteGenerator(EvosuiteTestSuiteGenerator):

    def __init__(self, java: Java, use_all_criterions: bool) -> None:
        super().__init__(java)
        self._use_all_criterions = use_all_criterions

    def get_generator_tool_name(self) -> str:
        return ("EVOSUITE_REGEX_ALL_CRITERIONS" if self._use_all_criterions else "EVOSUITE_REGEX")  

    def _execute_tool_for_tests_generation(self, input_jar: str, output_path: str, scenario: MergeScenarioUnderAnalysis, use_determinism: bool) -> None:
        for class_name, methods in scenario.targets.items():
          logging.debug(f"Starting generation for class {class_name}")
          params = [
              '-jar', EVOSUITE_REGEX,
              '-projectCP', input_jar,
              '-class', class_name,
              '-Dassertion_strategy=all',
              '-Dp_reflection_on_private=0',
              '-Dreflection_start_percent=0',
              '-Dp_functional_mocking=0',
              '-Dfunctional_mocking_percent=0',
              '-Dminimize=false',
              '-Djunit_check=false',
              '-Dinline=false'
          ]

          if self._use_all_criterions:
            params.append('-Dcriterion=LINE:BRANCH:EXCEPTION:OUTPUT:METHOD:METHODNOEXCEPTION:CBRANCH')
          else:
            params.append('-Dcriterion=LINE:BRANCH')

          if use_determinism:
            params += ["-Dstopping_condition=MaxTests",
                       f"-seed={self.SEED}", f'-Dsearch_budget={self.DETERMINISTIC_TESTS_QUANTITY}']
          else:
            params += [f'-Dsearch_budget={self.SEARCH_TIME_AVAILABLE}']

          if(len(methods) > 0):
            params.append(
                f'-Dtarget_method_regex={self._create_method_regex(methods)}')

          self._java.exec_java(output_path, self._java.get_env(), 3000, *tuple(params))

    # Evosuite needs to add its own Runtime in order to compile test suite
    def _compile_test_suite(self, input_jar: str, output_path: str, extra_class_path: List[str] = []) -> str:
        class_path_with_additional_runtime = super()._compile_test_suite(input_jar, output_path, [EVOSUITE_RUNTIME_REGEX] + extra_class_path)
        return self._remove_superclass_evosuite_runtime(class_path_with_additional_runtime)
    
    def _remove_superclass_evosuite_runtime(self, input_string: str) -> str:
        paths = input_string.split(':')
        filtered_paths = [path for path in paths if "evosuite-standalone" not in path]
        output_string = ":".join(filtered_paths)
        return output_string

    def _create_method_regex(self, methods: "List[str]"):
        rectified_methods = [self._convert_method_signature(
            method) for method in methods]
        rectified_methods.append("deserializeObject.*")
        rectified_methods.append("<init>.*")
        return ("|").join(rectified_methods)

    def _convert_method_signature(self, meth_signature: str) -> str:
        if "(" not in meth_signature:
            return ".*"
        meth_name = meth_signature[:meth_signature.rfind("(")]
        meth_args = meth_signature[meth_signature.find(
            "(") + 1:meth_signature.rfind(")")].split("|")
        asm_meth_format = self._asm_based_method_method_descriptor(meth_args)
        return meth_name+asm_meth_format

    # See at: https://asm.ow2.io/asm4-guide.pdf -- Section 2.1.3 and 2.1.4
    # Java type Type descriptor
    # boolean Z
    # char C
    # byte B
    # short S
    # int I
    # float F
    # long J
    # double D
    # Object Ljava/lang/Object;
    # int[] [I
    # Object[][] [[Ljava/lang/Object;
    def _asm_based_method_method_descriptor(self, method_arguments):
        result = "("
        for arg in method_arguments:
            arg = arg.strip()
            result = result + ".*" + self._asm_based_type_descriptor(arg)
        result = result + ").*"
        return result

    def _asm_based_type_descriptor(self, arg):
        result = ''
        if '[]' in arg:
            result = result + '['
            arg = arg.replace('[]', '')

        if arg == '':
            result = result + ''
        elif arg == 'int':
            result = result + 'I'
        elif arg == 'float':
            result = result + 'F'
        elif arg == 'boolean':
            result = result + 'Z'
        elif arg == 'char':
            result = result + 'C'
        elif arg == 'byte':
            result = result + 'B'
        elif arg == 'short':
            result = result + 'S'
        elif arg == 'long':
            result = result + 'J'
        elif arg == 'double':
            result = result + 'D'
        elif arg == 'void':
            result = result + 'V'
        elif arg == 'String':
            result = result + 'Ljava/lang/String;'
        else:
            temp = "L.*" + arg.split('.')[-1] + ';'
            result = result + temp

        return re.escape(result)
        
