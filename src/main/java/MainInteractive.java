import java.util.Scanner;

public class MainInteractive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of test cases: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Test case #" + i + " ---");
            System.out.print("Enter ticket number (0-9999): ");
            int ticketNumber = scanner.nextInt();
            System.out.print("Enter lucky number (0-9): ");
            int luckyNumber = scanner.nextInt();
            System.out.print("Enter bonus day (0 or 1): ");
            int bonusDay = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter expected result: ");
            String expected = scanner.nextLine();

            String result = Lottery.checkLotteryResult(ticketNumber, luckyNumber, bonusDay);

            System.out.println("Actual result:   " + result);
            System.out.println("Expected result: " + expected);

            if (result.equals(expected)) {
                System.out.println("==>  PASS\n");
            } else {
                System.out.println("==>  FAIL\n");
            }
        }

        scanner.close();
    }
}
