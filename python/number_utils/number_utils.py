class NumberUtils:
    def digits_sum(self, num: int) -> int:
        """
        As seen in https://stackoverflow.com/questions/14939953/sum-the-digits-of-a-number
        """

        sum = 0

        while num:
            sum, num = sum + num % 10, num // 10

        return sum
