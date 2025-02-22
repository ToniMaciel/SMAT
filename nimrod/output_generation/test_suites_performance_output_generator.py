from typing import List, TypedDict
from os import path
from nimrod.dynamic_analysis.behavior_change import BehaviorChange
from nimrod.dynamic_analysis.semantic_conflict import SemanticConflict
from nimrod.output_generation.output_generator import OutputGenerator, OutputGeneratorContext
from nimrod.tests.utils import get_base_output_path


class TestSuitesPerformanceOutput(TypedDict):
    project_name: str
    base_path: str
    generation_time_seconds: float
    execution_time_seconds: float
    total_time: float
    formatted_total_time: str


class TestSuitesPerformanceOutputGenerator(OutputGenerator[List[TestSuitesPerformanceOutput]]):
    def __init__(self) -> None:
        super().__init__("test_suites_performance")

    def _generate_report_data(self, context: OutputGeneratorContext) -> List[TestSuitesPerformanceOutput]:
        report_data: List[TestSuitesPerformanceOutput] = list()

        total_generation_time = 0
        total_execution_time = 0

        for test_suite in context.test_suites:
            total_generation_time += test_suite.generation_time_seconds
            total_execution_time += test_suite.execution_time_seconds

        report_data.append({
            "project_name": context.scenario.project_name,
            "base_path": path.join(get_base_output_path(), context.scenario.project_name, context.scenario.scenario_commits.merge[:6]),
            "generation_time_seconds": total_generation_time,
            "execution_time_seconds": total_execution_time,
            "total_time": total_generation_time + total_execution_time,
            "formatted_total_time": self.format_seconds(total_generation_time + total_execution_time)
        })

        return report_data
    
    def format_seconds(self, seconds):
      hours, remainder = divmod(seconds, 3600)
      minutes, seconds = divmod(remainder, 60)
      
      if hours > 0:
          return f"{int(hours)}h {int(minutes)}m {int(seconds)}s"
      elif minutes > 0:
          return f"{int(minutes)}m {int(seconds)}s"
      else:
          return f"{seconds:.2f}s"