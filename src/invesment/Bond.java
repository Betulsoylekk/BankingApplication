package invesment;

import java.time.LocalDate;

/**
 * Class for Bond
 */
public class Bond extends Investment{
    private String issuer;
    // inital amount the bond is bought for
    private double faceValue;
    private double couponRate;
    private LocalDate issueDate;
    private LocalDate maturityDate;

    public Bond(String name, double faceValue, double couponRate) {
    	super(name);
        this.faceValue = faceValue;
        this.couponRate = couponRate;
    }

    // Getters and setters

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }

    public double getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(double couponRate) {
        this.couponRate = couponRate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }
    
    public String toString() {
    	return super.getName();
    }
}


