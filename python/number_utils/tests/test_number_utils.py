import unittest

from number_utils.number_utils import NumberUtils


class TestNumberUtils(unittest.TestCase):
    number_utils = NumberUtils()

    def test_digits_sum(self):
        self.assertEqual(self.number_utils.digits_sum(0), 0)
        self.assertEqual(self.number_utils.digits_sum(1), 1)
        self.assertEqual(self.number_utils.digits_sum(None), 0)
        self.assertEqual(self.number_utils.digits_sum(123456789000123456789000), 90)
