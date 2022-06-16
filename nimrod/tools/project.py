from nimrod.tools.suite_generator import SuiteGenerator
from nimrod.tools.suite_generator import Suite

class Project(SuiteGenerator):

    def _get_tool_name(self):
        return "project"

    def _exec_tool(self):
        pass

    def _test_classes(self):
        classes = []
        list_class_names = self.suite_classes_dir.replace(".jar", ".txt")

        with open(list_class_names, 'r') as f:
            class_names = f.readlines()
            for class_name in class_names:
                classes.append(class_name.replace('\n', ''))
        
        return classes