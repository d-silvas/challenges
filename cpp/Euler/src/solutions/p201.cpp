#include <iostream>
#include <algorithm>
#include <vector>
#include "../Numbers.h"
#include "Solutions.h"

p201::p201()
{
	MIN_SUM = 0;
	MAX_SUM = 0;
	for (int i = 0; i < 100; i++)
	{
		S[i] = i * i;
	}

	// Results of sum go from 1^2 + 2^2 + ... + 50^2 to 51^2 + ... + 100^2
	for (int i = 0; i < 50; i++)
	{
		MIN_SUM += S[i];
	}
	for (int i = 50; i < 100; i++)
	{
		MAX_SUM += S[i];
	}

	for (int i = MIN_SUM; i <= MAX_SUM; i++)
	{
		bool res = Numbers::isSumOfSquaresBelow(MIN_SUM, 50, 100);
		std::cout << i << (res ? ": YES!" : ": NU") << std::endl;
	}


}

long long p201::solve()
{
	return 0LL;
}


// Bonds: numSquares <= 50;
// maxAddend: <= 100
// n: From 1 to 287925
class isSumOfSquaresFactory
{
private:
	std::vector<isSumOfSquares> members;
public:
	isSumOfSquares getMemberByNum(int n)
	{
		auto it = std::find_if(members.begin(), members.end(), [&n](const isSumOfSquares& obj) {
			return obj.n == n; 
		});


		if (it != members.end())
		{
			// found element. it is an iterator to the first matching element.
			// if you really need the index, you can also get it:
			auto index = std::distance(members.begin(), it);
			return members.at(index)
		}
	}
};

class isSumOfSquares
{
public:
	int n;
	std::vector<std::vector<int>> sum;

};
