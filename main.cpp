#include <iostream>
#include "lottery.h"
using namespace std;

int main() {
    int n;
    cout << "Enter number of test cases: ";
    cin >> n;

    for (int i = 1; i <= n; i++) {
        int ticketNumber, luckyNumber, bonusDay;
        string expected;

        cout << "\n--- Test case #" << i << " ---\n";
        cout << "Enter ticket number (0-9999): ";
        cin >> ticketNumber;
        cout << "Enter lucky number (0-9): ";
        cin >> luckyNumber;
        cout << "Enter bonus day (0 or 1): ";
        cin >> bonusDay;

        cin.ignore();
        cout << "Enter expected result: ";
        getline(cin, expected);

        string result = checkLotteryResult(ticketNumber, luckyNumber, bonusDay);

        cout << "Actual result:   " << result << endl;
        cout << "Expected result: " << expected << endl;

        if (result == expected) {
            cout << "==>  PASS\n";
        } else {
            cout << "==>  FAIL\n";
        }
    }

    return 0;
}
