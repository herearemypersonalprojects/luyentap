package strategypattern;

public class InsuranceStrategyHigh extends InsuranceStrategy {
    public int getAdjustment() {
        return 30000;
    }

    public double getWeight() {
        return 0.1;
    }

    public int getConstant() {
        return 76500;
    }
}
