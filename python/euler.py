from typing import Type
from euler.euler_problem import EulerProblem
from euler.euler_problems import EulerProblems
from performance.performance import Performance

if __name__ == "__main__":
    problem_class: Type[EulerProblem] = EulerProblems.find_or_throw("0017")
    problem = problem_class(Performance())
    print(problem.solve())
