from abc import ABC, abstractmethod

from performance.performance import Performance


class EulerProblem(ABC):
    perf: Performance

    def __init__(self, perf: Performance):
        self.perf = perf

    def solve(self) -> int:
        self.perf.start()
        solution = self._solve()
        self.perf.end()
        return solution

    @abstractmethod
    def _solve(self) -> int:
        raise Exception("Pls implement _solve() method")
