import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryTest {

    // 1️⃣ Kiểm thử giá trị không hợp lệ
    @Test
    public void testInvalidTicketNumberBelow() {
        assertEquals("Error: invalid ticket number", Lottery.checkLotteryResult(-1, 5, 0));
    }

    @Test
    public void testInvalidTicketNumberAbove() {
        assertEquals("Error: invalid ticket number", Lottery.checkLotteryResult(10000, 5, 0));
    }

    @Test
    public void testValidTicketNumberBoundaryLow() {
        assertEquals("Lose", Lottery.checkLotteryResult(0, 5, 0));
    }

    @Test
    public void testValidTicketNumberBoundaryHigh() {
        assertEquals("Lose", Lottery.checkLotteryResult(9999, 5, 0));
    }

    // 2️⃣ Lucky number không hợp lệ
    @Test
    public void testInvalidLuckyBelow() {
        assertEquals("Error: invalid lucky number", Lottery.checkLotteryResult(1234, -1, 0));
    }

    @Test
    public void testInvalidLuckyAbove() {
        assertEquals("Error: invalid lucky number", Lottery.checkLotteryResult(1234, 10, 0));
    }

    // 3️⃣ Bonus day không hợp lệ
    @Test
    public void testInvalidBonusDay() {
        assertEquals("Error: invalid bonus day", Lottery.checkLotteryResult(1234, 5, -1));
    }

    // 4️⃣ Hai chữ số cuối trùng (Jackpot)
    @Test
    public void testTwoDigitMatchExact() {
        assertEquals("10000000", Lottery.checkLotteryResult(77, 7, 0));
    }

    @Test
    public void testTwoDigitMatchBoundary() {
        assertEquals("20000000", Lottery.checkLotteryResult(8877, 7, 1));
    }

    // 5️⃣ Một chữ số cuối trùng và bonus
    @Test
    public void testSingleDigitMatchWithBonus() {
        assertEquals("2000000", Lottery.checkLotteryResult(7, 7, 1));
    }

    @Test
    public void testSingleDigitMatchWithBonusLongNumber() {
        assertEquals("2000000", Lottery.checkLotteryResult(1237, 7, 1));
    }

    // 6️⃣ Một chữ số cuối trùng nhưng không có bonus
    @Test
    public void testSingleDigitMatchWithoutBonus() {
        assertEquals("1000000", Lottery.checkLotteryResult(1237, 7, 0));
    }

    // 7️⃣ Không trùng (Lose)
    @Test
    public void testLoseCase() {
        assertEquals("Lose", Lottery.checkLotteryResult(1234, 5, 0));
    }

    // 8️⃣ Không trùng dù có bonus
    @Test
    public void testLoseWithBonus() {
        assertEquals("Lose", Lottery.checkLotteryResult(1234, 5, 1));
    }

    // 9️⃣ Cả hai điều kiện endsWith trùng lặp (phủ branch phụ)
    @Test
    public void testDoubleLuckyNumberButBonus() {
        assertEquals("20000000", Lottery.checkLotteryResult(77, 7, 1)); // Vẫn ưu tiên 2 số
    }
}