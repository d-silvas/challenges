from euler.euler_problem import EulerProblem
from num2words import num2words
import re


class EulerProblem0017(EulerProblem):
    """
    Requires num2words library
    """

    def _solve(self):
        count: int = 0
        for i in range(1, 1001):
            count += len(self.get_num_only_letters(i))
        return count

    def get_num_only_letters(self, number: int) -> str:
        return re.sub(r"[ -]", "", num2words(number, lang="en"))
