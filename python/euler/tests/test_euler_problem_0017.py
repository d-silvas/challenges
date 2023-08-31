import unittest
from unittest.mock import Mock

from euler.euler_problem_0017 import EulerProblem0017
from performance.performance import Performance


class TestNumberUtils(unittest.TestCase):
    problem = EulerProblem0017(Mock(Performance()))

    def test_digits_sum(self):
        self.assertEqual(self.problem.get_num_only_letters(0), "zero")
        self.assertEqual(
            self.problem.get_num_only_letters(342), "threehundredandfortytwo"
        )
