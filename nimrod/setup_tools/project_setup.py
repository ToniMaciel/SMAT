from os.path import exists

from nimrod.setup_tools.setup_tool import Setup_tool
from nimrod.tools.project import Project
from nimrod.tools.junit import JUnit

class Project_setup(Setup_tool):

    def run_tool_for_semantic_conflict_detection(self, evo, scenario, jarBase, jarParentLeft, jarParentRight, jarMerge,
                                                 commitBaseSha, commitParentLeft, commitParentRight, commitMergeSha,
                                                 tool, projectName=None):
        conflict_info = []
        try:
            self.setup_for_full_merge_scenario(evo, scenario, jarBase, jarParentLeft, jarParentRight, jarMerge)
            test_results_left = self.generate_and_run_test_suites(evo, scenario, commitBaseSha, commitParentLeft,
                                    commitParentRight, commitMergeSha, conflict_info, tool)
            if (len(test_results_left[0]) > 0):
                self.check_semantic_conflict_occurrence(test_results_left[0], test_results_left[1], test_results_left[2],
                                    test_results_left[3], test_results_left[4], commitBaseSha, commitParentLeft,
                                    commitParentRight, commitMergeSha, tool, conflict_info)
                self.check_behavior_change_commit_pair(test_results_left[0], test_results_left[1], test_results_left[2],
                                    test_results_left[4], commitBaseSha, commitParentLeft, commitMergeSha, tool, conflict_info)
        except:
            print("Some project versions could not be evaluated")

        return conflict_info
    
    def generate_and_run_test_suites(self, evo, scenario, commitBaseSha, commitParentTestSuite, commitOtherParent,
                                     commitMergeSha, conflict_info, tool):
        path_suite = []
        test_result_base = set()
        test_result_parent_test_suite = set()
        test_result_other_parent = set()
        test_result_merge = set()
        try:
            path_suite = self.generate_test_suite(scenario, evo.project_dep)

            test_result_base = self.run_test_suite(path_suite.suite_classes_dir, evo.project_dep.sut_class,
                                                   evo.project_dep.baseDir, evo.project_dep)
            test_result_parent_test_suite = self.run_test_suite(path_suite.suite_classes_dir, evo.project_dep.sut_class,
                                                                evo.project_dep.parentReg, evo.project_dep)
            test_result_other_parent = self.run_test_suite(path_suite.suite_classes_dir, evo.project_dep.sut_class,
                                                           evo.project_dep.parentNotReg, evo.project_dep)
            test_result_merge = self.run_test_suite(path_suite.suite_classes_dir, evo.project_dep.sut_class,
                                                    evo.project_dep.mergeDir, evo.project_dep)
        except Exception as err:
            print(err)
            print("Some project versions could not be evaluated")
            conflict_info.append(["NONE", set(), "NO-INFORMATION", commitBaseSha, commitParentTestSuite, commitMergeSha,
                                    tool])

        return path_suite, test_result_base, test_result_parent_test_suite, test_result_other_parent, test_result_merge

    def generate_test_suite(self, scenario, project_dep):
        classpath_list = project_dep.parentReg.split("/")[:-1]
        path_projects_jars = "/".join(classpath_list)

        classpath_list.append(scenario.merge_scenario.get_merge_hash()+"-TestFiles.jar")
        path_test_jar = "/".join(classpath_list)

        if not exists(path_test_jar):
            raise Exception("Jar with project tests not provided")

        project = Project(
            java=project_dep.java,
            classpath=project_dep.parentReg,
            sut_class=project_dep.sut_class,
            sut_classes=project_dep.sut_classes,
            sut_method=project_dep.sut_method,
            params=self.tool_parameters,
            tests_src=project_dep.tests_dst + '/' + project_dep.project.get_project_name() + '/' + scenario.merge_scenario.get_merge_hash(),
            suite_dir=path_projects_jars,
            suite_classes_dir=path_test_jar,
            suite_name="Project"
        )
        
        self.test_suite = project.generate(make_dir=False)
        return self.test_suite
    
    def run_test_suite(self, classes_dir, sut_class, mutant_dir, project_dep):
        junit = JUnit(java=project_dep.java, classpath=classes_dir)
        res = junit.run_with_mutant(self.test_suite, sut_class, mutant_dir, run_with_coverage=False)
        return res