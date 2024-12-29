package invesment;

/**
 * Abstact Class for Investment
 */
public abstract class Investment {
	private String name;

    public Investment(String name) {
        this.name = name;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
