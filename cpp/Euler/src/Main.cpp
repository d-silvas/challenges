#include <iostream>
#include <chrono>
#include "solutions/Solutions.h"
#include <thread>

#include "Tests.h"

int main()
{
	runTests(); return 0;
	std::chrono::high_resolution_clock::time_point t1 = std::chrono::high_resolution_clock::now();
	p201 sol = p201();
	long long a = sol.solve();
	std::chrono::high_resolution_clock::time_point t2 = std::chrono::high_resolution_clock::now();

	auto duration = std::chrono::duration_cast<std::chrono::milliseconds>(t2 - t1).count();

	//std::cout << sol << std::endl;
	std::cout << duration << " millisec" << std::endl;

	std::cin.get();
}
