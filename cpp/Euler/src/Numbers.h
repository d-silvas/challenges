#pragma once

// TODO: Move these into the namespace
unsigned long long sumNumbersBelow(unsigned long long n);
unsigned long long gcd(unsigned long long a, unsigned long long b);
unsigned long long lcm(unsigned long long a, unsigned long long b);
bool isPrime(long long n);
bool isPrime(unsigned long long n);

namespace Numbers
{
	bool isPerfectSquare(unsigned long long n);
	bool isSqrtBelowOrEqual(unsigned long long n, unsigned long long max);
	bool isSumOfSquaresBelow(unsigned long long n, unsigned int numSquares, unsigned int maxAddend);
	bool isSumOfExactlySquaresBelow(unsigned long long n, int numSquares, int maxAddend);
}