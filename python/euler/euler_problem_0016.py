from euler.euler_problem import EulerProblem
from number_utils.number_utils import NumberUtils


class EulerProblem0016(EulerProblem):
    # TODO I'm not using dependency injection but I guess it should not matter
    # When I want to test a function I can use the real dependencies no problems !?
    number_utils = NumberUtils()

    def _solve(self):
        return self.number_utils.digits_sum(2**1000)
