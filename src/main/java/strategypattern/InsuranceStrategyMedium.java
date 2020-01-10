package strategypattern;

public class InsuranceStrategyMedium extends InsuranceStrategy {
    public int getAdjustment() {
        return 10000;
    }

    public double getWeight() {
        return 0.2;
    }

    public int getConstant() {
        return 35600;
    }
}
