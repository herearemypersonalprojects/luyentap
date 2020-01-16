package replace_conditional_calculations_with_strategy;

public class InsuranceStrategyVeryHigh extends InsuranceStrategy {
    public InsuranceStrategyVeryHigh() {
    }

    @Override
    public int getAdjustment() {
        return 60000;
    }

    @Override
    public double getWeight() {
        return 0.02;
    }

    @Override
    public int getConstant() {
        return 105600;
    }
}