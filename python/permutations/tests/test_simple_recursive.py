import unittest

from permutations.simple_recursive import SimpleRecursive
from permutations.tests.constants import (
    PERMUTATIONS_OF_1,
    PERMUTATIONS_OF_12,
    PERMUTATIONS_OF_123,
    PERMUTATIONS_OF_1234,
    PERMUTATIONS_OF_12345,
)


class TestNumberUtils(unittest.TestCase):
    simple_recursive = SimpleRecursive()

    def test_digits_sum(self):
        self.assertCountEqual(self.simple_recursive.permutate([1]), PERMUTATIONS_OF_1)
        self.assertCountEqual(
            self.simple_recursive.permutate([1, 2]), PERMUTATIONS_OF_12
        )
        self.assertCountEqual(
            self.simple_recursive.permutate([1, 2, 3]), PERMUTATIONS_OF_123
        )
        self.assertCountEqual(
            self.simple_recursive.permutate([1, 2, 3, 4]), PERMUTATIONS_OF_1234
        )
        self.assertCountEqual(
            self.simple_recursive.permutate([1, 2, 3, 4, 5]), PERMUTATIONS_OF_12345
        )
