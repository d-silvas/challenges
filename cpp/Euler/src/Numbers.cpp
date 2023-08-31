#include <iostream>
#include <vector>
#include <cmath>

unsigned long long sumNumbersBelow(unsigned long long n)
{
	return n * (n + 1) / 2;
}

unsigned long long gcd(unsigned long long a, unsigned long long b)
{
	while (a != 0) {
		unsigned long long c = a;
		a = b % a;
		b = c;
	}
	return b;
}

unsigned long long lcm(unsigned long long a, unsigned long long b)
{
	// Parenthesis avoid overflow
	return a * (b / gcd(a, b));
}

bool isPrime(long long n)
{
	if (n < 0) n = -n;
	if (n <= 1) return false;
	if (n <= 3) return true;

	if (n % 2 == 0 || n % 3 == 0) return false;

	for (long long i = 5; i * i <= n; i = i + 6)
		if (n % i == 0 || n % (i + 2) == 0)
			return false;

	return true;
}

bool isPrime(unsigned long long n)
{
	if (n <= 1) return false;
	if (n <= 3) return true;

	if (n % 2 == 0 || n % 3 == 0) return false;

	for (unsigned long long i = 5; i * i <= n; i = i + 6)
		if (n % i == 0 || n % (i + 2) == 0)
			return false;

	return true;
}

namespace Numbers {
	bool isPerfectSquare(unsigned long long n)
	{
		long double squareRoot = std::sqrt(n);
		return (squareRoot - std::floor(squareRoot) == 0);
	}

	bool isSqrtBelowOrEqual(unsigned long long n, unsigned long long max)
	{
		return std::sqrt(n) <= max;
	}

	bool isSumOfSquaresBelow(unsigned long long n, unsigned int numSquares, unsigned int maxAddend)
	{
		if (numSquares == 1)
		{
			return Numbers::isPerfectSquare(n) && Numbers::isSqrtBelowOrEqual(n, maxAddend);
		}
		else
		{
			for (unsigned int i = 1; i <= maxAddend && i*i < n; i++)
			{
				unsigned long long candidate = n - i*i;
				if (Numbers::isSumOfSquaresBelow(candidate, numSquares - 1, maxAddend))
				{
					return true;
				}
			}
		}
		return false;
	}

	bool isSumOfExactlySquaresBelow(unsigned long long n, int numSquares, int maxAddend)
	{
		// TODO: Implement
		while (numSquares--)
		{
			for (int i = 1; i <= maxAddend && i * i < n; i++)
			{
				unsigned long long candidate = n - i * i;
				if (Numbers::isSumOfSquaresBelow(candidate, numSquares - 1, maxAddend))
				{
					return true;
				}
			}
		}


		if (numSquares == 1)
		{
			return Numbers::isPerfectSquare(n);
		}
		else
		{
			for (int i = 1; i <= maxAddend && i * i < n; i++)
			{
				unsigned long long candidate = n - i * i;
				if (Numbers::isSumOfSquaresBelow(candidate, numSquares - 1, maxAddend))
				{
					return true;
				}
			}
		}
		return false;
	}
}