import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryTest {

    @Test
    public void t1() {
        assertEquals("Error: invalid ticket number", Lottery.checkLotteryResult(10000, 5, 0));
    }

    @Test
    public void t2() {
        assertEquals("Error: invalid lucky number", Lottery.checkLotteryResult(1234, -1, 0));
    }

    @Test
    public void t3() {
        assertEquals("Error: invalid bonus day", Lottery.checkLotteryResult(1234, 5, 2));
    }

    @Test
    public void t4() {
        assertEquals("Lose", Lottery.checkLotteryResult(1234, 5, 0));
    }

    @Test
    public void t5() {
        assertEquals("1000000", Lottery.checkLotteryResult(1237, 7, 0));
    }

    @Test
    public void t6() {
        assertEquals("2000000", Lottery.checkLotteryResult(1237, 7, 1));
    }

    @Test
    public void t7() {
        assertEquals("10000000", Lottery.checkLotteryResult(77, 7, 0));
    }

    @Test
    public void t8() {
        assertEquals("20000000", Lottery.checkLotteryResult(8877, 7, 1));
    }
}