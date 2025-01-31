import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double percent, int period) {
           double pay = amount * Math.pow((1 + percent / 12), 12 * period);

           return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double percent, int period) {
        return round(amount + amount * percent * period, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void setupDeposit() {
        int period, action, amount;
        double outValue = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            outValue = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outValue = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outValue);
    }
    public static void main(String[] args) {
        new DepositCalculator().setupDeposit();
    }
}
