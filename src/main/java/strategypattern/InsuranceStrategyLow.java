package strategypattern;

public class InsuranceStrategyLow extends InsuranceStrategy {
    public int getAdjustment() {
        return 0;
    }

    public double getWeight() {
        return 0.365;
    }

    public int getConstant() {
        return 0;
    }
}
