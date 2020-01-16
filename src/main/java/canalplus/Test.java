package canalplus;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class Test {
    private double unusedPercentage;
    private double outstanding;
    private double notional;
    private double rating;
    private Date expiry;
    private Date maturity;
    private Date start;

    public Test(double unusedPercentage,
                double outstanding,
                double notional,
                double rating,
                Date expiry,
                Date maturity,
                Date start) {
        this.unusedPercentage = unusedPercentage;
        this.outstanding = outstanding;
        this.notional = notional;
        this.rating = rating;
        this.expiry = expiry;
        this.maturity = maturity;
        this.start = start;
    }

    public double calcCapital() {
        return riskAmount() * duration() * getRating(rating);
    }

    private double getRating(double rating) {
        return rating * 0.43d;
    }

    private double riskAmount() {
        if (unusedPercentage != 1.00)
            return outstanding + calcUnusedRiskAmount();
        else return outstanding;
    }

    private double calcUnusedRiskAmount() {
        return (notional - outstanding) * unusedPercentage;
    }

    private double duration() {
        if (expiry == null)
            return ((maturity.getTime() - start.getTime()) / DateUtils.MILLIS_PER_DAY) / 365;
        else if (maturity == null)
            return ((expiry.getTime() - start.getTime()) / DateUtils.MILLIS_PER_DAY) / 365;
        else {
            long millisToExpiry = expiry.getTime() - start.getTime();
            long millisFromExpiryToMaturity = maturity.getTime() - expiry.getTime();
            double revolverDuration = (millisToExpiry / DateUtils.MILLIS_PER_DAY) / 365;
            double termDuration = (millisFromExpiryToMaturity / DateUtils.MILLIS_PER_DAY) / 365;
            return revolverDuration + termDuration;
        }
    }

    private void setUnusedPercentage() {
        if (expiry != null && maturity != null) {
            if (rating > 4) unusedPercentage = 0.95;
            else unusedPercentage = 0.50;
        } else if (maturity != null) {
            unusedPercentage = 1.00;
        } else if (expiry != null) {
            if (rating > 4) unusedPercentage = 0.75;
            else unusedPercentage = 0.25;
        }
    }
}
