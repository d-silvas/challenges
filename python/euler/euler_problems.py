from importlib import import_module
from typing import Type
from euler.euler_problem import EulerProblem


class EulerProblems:
    # TODO not throw, catch in upstream
    def find_or_throw(num: str) -> Type[EulerProblem]:
        try:
            # TODO: add leading zeroes to num
            module_to_check = import_module(f".euler_problem_{num}", "euler")
            problem_class = getattr(module_to_check, f"EulerProblem{num}")
            return problem_class
        except Exception:
            raise
