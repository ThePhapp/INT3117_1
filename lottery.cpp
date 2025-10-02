#include "lottery.h"

string checkLotteryResult(int ticketNumber, int luckyNumber, int bonusDay) {
    if (ticketNumber < 0 || ticketNumber > 9999) {
        return "Error: invalid ticket number";
    }
    if (luckyNumber < 0 || luckyNumber > 9) {
        return "Error: invalid lucky number";
    }
    if (bonusDay != 0 && bonusDay != 1) {
        return "Error: invalid bonus day";
    }

    int lastDigit = ticketNumber % 10;
    int lastTwo = ticketNumber % 100;

    long long prize = 0;

    if (lastTwo == luckyNumber * 10 + luckyNumber) {
        prize = 10'000'000;
    } else if (lastDigit == luckyNumber) {
        prize = 1'000'000;
    } else {
        prize = 0;
    }

    if (bonusDay == 1) {
        prize *= 2;
    }

    if (prize > 0) {
        return to_string(prize);
    }
    return "Lose";
}
