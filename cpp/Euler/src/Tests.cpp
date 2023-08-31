#include <iostream>
#include <string>
#include <vector>
#include "Numbers.h"

class BoolFunctionTest
{
private:
	std::string description;
	bool result;
	bool expected;
	std::string testString;
public:
	BoolFunctionTest(std::string description, bool result, bool expected) 
		: description(description), result (result), expected (expected)
	{
		testString = "[" + description + "]"
			+ "\tExpected: " + (expected ? "True" : "False")
			+ "\t Got: " + (result ? "True" : "False");
	}

	std::string toString()
	{
		return testString;
	}
};

void runArrayOfTests(const std::vector<BoolFunctionTest> &tests)
{
	for (BoolFunctionTest result : tests)
	{
		std::cout << result.toString() << std::endl;
	}
	std::cout << std::endl;
}

void runTests()
{
	std::vector<BoolFunctionTest> testIsPerfectSquare = {
		BoolFunctionTest(std::string("isPerfectSquare(1)"), Numbers::isPerfectSquare(1), true),
		BoolFunctionTest(std::string("isPerfectSquare(2)"), Numbers::isPerfectSquare(2), false),
		BoolFunctionTest(std::string("isPerfectSquare(3)"), Numbers::isPerfectSquare(3), false),
		BoolFunctionTest(std::string("isPerfectSquare(4)"), Numbers::isPerfectSquare(4), true),
		BoolFunctionTest(std::string("isPerfectSquare(1563032513462436)"), Numbers::isPerfectSquare(1563032513462436), true),
		BoolFunctionTest(std::string("isPerfectSquare(1563032513462437)"), Numbers::isPerfectSquare(1563032513462437), false)
	};

	std::vector<BoolFunctionTest> testIsSqrtBelowOrEqual = {
		BoolFunctionTest(std::string("isSqrtBelowOrEqual(4, 2)"), Numbers::isSqrtBelowOrEqual(4, 2), true),
		BoolFunctionTest(std::string("isSqrtBelowOrEqual(5, 2)"), Numbers::isSqrtBelowOrEqual(5, 2), false),
	};

	std::vector<BoolFunctionTest> testIsSumOfSquaresBelow = {
		// TODO: Review these tests, as the addends have to be different, i.e. 4 = 2^2 + 2^2 is NOT valid
		BoolFunctionTest(std::string("isSumOfSquaresBelow(4ULL, 2, 2)"), Numbers::isSumOfSquaresBelow(4ULL, 2, 2), false),
		BoolFunctionTest(std::string("isSumOfSquaresBelow(5ULL, 2, 2)"), Numbers::isSumOfSquaresBelow(5ULL, 2, 2), true),
		BoolFunctionTest(std::string("isSumOfSquaresBelow(6ULL, 2, 2)"), Numbers::isSumOfSquaresBelow(6ULL, 2, 2), false),
		// 30 = 1^2 + 2^2 + 3^2 + 4^2 = 1^2 + 2^2 + 5^2
		BoolFunctionTest(std::string("isSumOfSquaresBelow(30ULL, 2, 30)"), Numbers::isSumOfSquaresBelow(30ULL, 2, 30), false),
		BoolFunctionTest(std::string("isSumOfSquaresBelow(30ULL, 30, 2)"), Numbers::isSumOfSquaresBelow(30ULL, 30, 2), false),
		BoolFunctionTest(std::string("isSumOfSquaresBelow(30ULL, 4, 4)"), Numbers::isSumOfSquaresBelow(30ULL, 4, 4), true),
		BoolFunctionTest(std::string("isSumOfSquaresBelow(30ULL, 5, 3)"), Numbers::isSumOfSquaresBelow(30ULL, 5, 3), false),
		BoolFunctionTest(std::string("isSumOfSquaresBelow(30ULL, 5, 2)"), Numbers::isSumOfSquaresBelow(30ULL, 5, 2), false),
		BoolFunctionTest(std::string("isSumOfSquaresBelow(30ULL, 5, 4)"), Numbers::isSumOfSquaresBelow(30ULL, 5, 4), false),
	};

	runArrayOfTests(testIsPerfectSquare);
	runArrayOfTests(testIsSqrtBelowOrEqual);
	runArrayOfTests(testIsSumOfSquaresBelow);
}
