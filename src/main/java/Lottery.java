public class Lottery {
    public static String checkLotteryResult(int ticketNumber, int luckyNumber, int bonusDay) {
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
        long prize = 0L;

        if (lastTwo == luckyNumber * 10 + luckyNumber) {
            prize = 10_000_000L;
        } else if (lastDigit == luckyNumber) {
            prize = 1_000_000L;
        } else {
            prize = 0L;
        }

        if (bonusDay == 1) {
            prize *= 2;
        }

        if (prize > 0) {
            return Long.toString(prize);
        }
        return "Lose";
    }
}
