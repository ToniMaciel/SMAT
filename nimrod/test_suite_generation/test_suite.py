from typing import List


class TestSuite:
    def __init__(self, generator_name: str, path: str, class_path: str, test_classes_names: List[str], generation_time: float = 0, execution_time: float = 0) -> None:
        self._generator_name = generator_name
        self._path = path
        self._class_path = class_path
        self._test_classes_names = test_classes_names
        self._generation_time_seconds = generation_time
        self._execution_time_seconds = execution_time

    @property
    def generator_name(self) -> str:
        return self._generator_name

    @property
    def path(self) -> str:
        return self._path

    @property
    def class_path(self) -> str:
        return self._class_path

    @property
    def test_classes_names(self) -> List[str]:
        return self._test_classes_names
    
    @property
    def generation_time_seconds(self) -> float:
        return self._generation_time_seconds
    
    @property
    def execution_time_seconds(self) -> float:
        return self._execution_time_seconds

    def set_execution_time_seconds(self, time: float) -> None:
        self._execution_time_seconds = time
        