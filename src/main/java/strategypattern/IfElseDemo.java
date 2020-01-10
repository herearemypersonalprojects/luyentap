package strategypattern;

public class IfElseDemo {
    InsuranceStrategy strategy;

    public double calculateInsurance(double income) {
        if (income <= 10000) {
            strategy = new InsuranceStrategyLow();
        } else if (income <= 30000) {
            strategy = new InsuranceStrategyMedium();
        } else if (income <= 60000) {
            strategy = new InsuranceStrategyHigh();
        } else {
            strategy = new InsuranceStrategyVeryHigh();
        }

        return strategy.calculate(income);
    }
}
