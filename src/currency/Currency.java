package currency;

/**
 * Enumaration class for all currency types in the system
 */
public enum Currency {
    USD("United States Dollar"),
    EUR("Euro"),
    XAU("Gold"),
    TRY("Turkish Lira");

    private String fullName;

    Currency(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
    
    
}
