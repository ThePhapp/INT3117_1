#include <iostream>
#include <vector>
#include <string>
#include "lottery.h"
using namespace std;

// Cấu trúc dữ liệu test case
struct TestCase {
    int ticketNumber;
    int luckyNumber;
    int bonusDay;
    string expected;
};

int main() {
    vector<TestCase> tests = {

        {-1, 5, 0, "Error: invalid ticket number"},
        {0, 5, 0, "Lose"},
        {1, 5, 0, "Lose"},
        {9998, 5, 0, "Lose"},
        {9999, 5, 0, "Lose"},
        {10000, 5, 0, "Error: invalid ticket number"},

        {1234, -1, 0, "Error: invalid lucky number"},
        {1234, 0, 0, "Lose"},
        {1234, 9, 0, "Lose"},
        {1234, 10, 0, "Error: invalid lucky number"},

        {1234, 5, -1, "Error: invalid bonus day"},
        {1234, 5, 0, "Lose"},
        {1234, 5, 1, "Lose"},

        {77, 7, 0, "10000000"},
        {77, 7, 1, "20000000"},
        {7, 7, 0, "1000000"},
        {7, 7, 1, "2000000"}
    };

    int passCount = 0;
    for (int i = 0; i < tests.size(); i++) {
        string actual = checkLotteryResult(tests[i].ticketNumber, tests[i].luckyNumber, tests[i].bonusDay);
        cout << "Test case #" << (i+1) << ": ";
        if (actual == tests[i].expected) {
            cout << "PASS\n";
            passCount++;
        } else {
            cout << "FAIL\n";
            cout << "   Input: ticket=" << tests[i].ticketNumber
                 << ", lucky=" << tests[i].luckyNumber
                 << ", bonusDay=" << tests[i].bonusDay << "\n";
            cout << "   Expected: " << tests[i].expected << "\n";
            cout << "   Actual:   " << actual << "\n";
        }
    }

    cout << "\n==> Passed " << passCount << "/" << tests.size() << " test cases\n";

    return 0;
}
