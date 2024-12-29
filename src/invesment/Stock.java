package invesment;

/**
 * Class for Stock
 */
public class Stock extends Investment {

    private double price;
    private int quantity;

    public Stock(String name, double price, int quantity) {
        super(name);
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String toString() {
    	return super.getName();
    }
}



