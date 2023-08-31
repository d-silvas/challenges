#include <iostream>
#include "Numbers.h"

unsigned long long p1()
{
	unsigned long long n = 1000;

	auto sumMult3 = 3 * sumNumbersBelow(n / 3);
	auto sumMult5 = 5 * sumNumbersBelow(n / 5);
	auto sumMult15 = 15 * sumNumbersBelow(n / 15);

	return sumMult3 - sumMult15 - sumMult15;
}

unsigned long long p2()
{
	unsigned long long limit = 4000000;

	unsigned long long x0 = 1;
	unsigned long long x1 = 2;

	unsigned long long sum = 0;

	while (x1 <= limit)
	{
		if (!(x1 & 1)) {
			sum += x1;
		}

		unsigned long long x2 = x0 + x1;
		x0 = x1;
		x1 = x2;
	}

	return sum;
}

unsigned long long p3()
{
	unsigned long long x = 600851475143;

	// Keep in mind the condition inside for gets evaluated every loop with the new value of x
	for (unsigned long long factor = 2; factor * factor <= x; factor++) {
		while (x % factor == 0 && x != factor) {
			x /= factor;
		}
	}

	return x;
}

unsigned long long p4() { return 0; }

unsigned long long p5()
{
	// Calculate lcm(1, 2, ..., 20), which can be done in steps (or recursively):
	//	= lcm(lcm(1, ..., 19), 20) = lcm(lcm(lcm(1, ..., 18), 19), 20) = ...
	unsigned int x = 20000;

	unsigned long long result = 1;
	for (unsigned int i = 2; i <= x; i++) {
		result = lcm(result, i);
	}

	return result;
}

// See http://code.jasonbhill.com/sage/project-euler-problem-27/
unsigned long long p27()
{
	long long result;
	long long nUpperLimit = 10000;
	int consecutivePrimes = 0;
	int maxConsecutivePrimes = 0;

	for (long long a = -999; a <= 999; a++)
	{
		for (long long b = -999; b <= 999; b += 2)
		{
			consecutivePrimes = 0;
			for (long long n = 0; n < nUpperLimit; n++)
			{
				if (isPrime(n*n + a*n + b))
				{
					consecutivePrimes++;
				}
				else
				{
					break;
				}
			}
			if (consecutivePrimes >= maxConsecutivePrimes)
			{
				maxConsecutivePrimes = consecutivePrimes;
				std::cout << "[" << consecutivePrimes << "]: a=" << a << ", b=" << b 
					<< ", ab = " << a*b <<std::endl;
			}
		}
	}
	return 0;
}
