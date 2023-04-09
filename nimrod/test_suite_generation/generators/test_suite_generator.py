from abc import ABC, abstractmethod
import logging
from os import makedirs, path
from time import time
from typing import List

from nimrod.tests.utils import get_config
from nimrod.core.merge_scenario_under_analysis import MergeScenarioUnderAnalysis
from nimrod.tests.utils import get_base_output_path
from nimrod.test_suite_generation.test_suite import TestSuite
from nimrod.tools.bin import HAMCREST, JUNIT

from nimrod.tools.java import Java
from nimrod.utils import generate_classpath


class TestSuiteGenerator(ABC):
    SEARCH_TIME_AVAILABLE = int(get_config().get(
        'test_suite_generation_search_time_available', 300))
    DETERMINISTIC_TESTS_QUANTITY = int(get_config().get(
        'test_suite_generation_deterministic_tests_quantity', 100_000_000))
    SEED = int(get_config().get('test_suite_generation_seed', 42))

    def __init__(self, java: Java) -> None:
        self._java = java

    def generate_and_compile_test_suite(self, scenario: MergeScenarioUnderAnalysis, input_jar: str, use_determinism: bool) -> TestSuite:
        if use_determinism:
            logging.debug('Using deterministic test suite generation')
            
        suite_dir = self.get_generator_tool_name() + "_" + str(int(time()))
        test_suite_path = path.join(get_base_output_path(), scenario.project_name, scenario.scenario_commits.merge[:6], suite_dir)

        makedirs(test_suite_path, exist_ok=True)
        makedirs(path.join(test_suite_path, "classes"), exist_ok=True)

        logging.info(f"Starting generation with {self.get_generator_tool_name()}")
        self._execute_tool_for_tests_generation(input_jar, test_suite_path, scenario, use_determinism)
        logging.info(f"Finished generation with {self.get_generator_tool_name()}")

        logging.info(f"Starting compilation for suite generated with {self.get_generator_tool_name()}")
        tests_class_path = self._compile_test_suite(input_jar, test_suite_path)
        logging.info(f"Finished compilation for suite generated with {self.get_generator_tool_name()}")

        return TestSuite(
            generator_name=self.get_generator_tool_name(),
            class_path=tests_class_path,
            path=test_suite_path,
            test_classes_names=self._get_test_suite_class_names(test_suite_path)
        )

    @abstractmethod
    def get_generator_tool_name(self) -> str:
        pass

    @abstractmethod
    def _execute_tool_for_tests_generation(self, input_jar: str, test_suite_path: str, scenario: MergeScenarioUnderAnalysis, use_determinism: bool) -> None:
        pass

    @abstractmethod
    def _get_test_suite_class_paths(self, test_suite_path: str) -> List[str]:
        pass

    @abstractmethod
    def _get_test_suite_class_names(self, test_suite_path: str) -> List[str]:
        pass

    def _compile_test_suite(self, input_jar: str, test_suite_path: str, extra_class_path: List[str] = []) -> str:
        compiled_classes_path = path.join(test_suite_path, 'classes')
        class_path = generate_classpath([input_jar, test_suite_path, compiled_classes_path, JUNIT, HAMCREST] + extra_class_path)

        for java_file in self._get_test_suite_class_paths(test_suite_path):
            self._java.exec_javac(java_file, test_suite_path, None, None,
                                  '-classpath', class_path, '-d', compiled_classes_path)
        return generate_classpath([compiled_classes_path] + extra_class_path)
