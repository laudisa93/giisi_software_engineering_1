
public class SalesLineItem {
    private int quantify;
    private ProductDescription description;

    public SalesLineItem(int quantify, ProductDescription description) {
        this.quantify = quantify;
        this.description = description;
    }

    public double getSubtotal(){
        return this.quantify*this.description.getPrice();
    }
}
