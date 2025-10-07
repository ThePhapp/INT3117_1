import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryTest {

    @Test
    public void testInvalidTicketNumberBelow() {
        assertEquals("Error: invalid ticket number", Lottery.checkLotteryResult(-1, 5, 0));
    }

    @Test
    public void testInvalidTicketNumberAbove() {
        assertEquals("Error: invalid ticket number", Lottery.checkLotteryResult(10000, 5, 0));
    }

    @Test
    public void testInvalidLuckyBelow() {
        assertEquals("Error: invalid lucky number", Lottery.checkLotteryResult(1234, -1, 0));
    }

    @Test
    public void testInvalidLuckyAbove() {
        assertEquals("Error: invalid lucky number", Lottery.checkLotteryResult(1234, 10, 0));
    }

    @Test
    public void testInvalidBonusDay() {
        assertEquals("Error: invalid bonus day", Lottery.checkLotteryResult(1234, 5, -1));
    }

    @Test
    public void testTwoDigitMatch() {
        assertEquals("10000000", Lottery.checkLotteryResult(77, 7, 0));
    }

    @Test
    public void testSingleDigitMatchWithBonus() {
        assertEquals("2000000", Lottery.checkLotteryResult(7, 7, 1));
    }

    @Test
    public void testLose() {
        assertEquals("Lose", Lottery.checkLotteryResult(1234, 5, 0));
    }
}
