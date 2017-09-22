
public class Register {
    private Sale currentSale;
    private ProductCatalog catalog;
    private ProductDescription desc;
    private Store store;

    public Register(ProductCatalog catalog,Store store) {
        this.catalog = catalog;
        this.store = store;
    }

    public float endSale(){
        return currentSale.getTotal();
    }
    public void enterItem(String id, int cantidad){
        this.desc=this.catalog.getProductDesc(id);
        this.currentSale.makeLineItem(desc, cantidad);
    }
    public void makeNewSale(){
        this.currentSale = new Sale();
    }
    public void makePayment(float cash){
        this.currentSale.makePayment(cash);
        this.store.addCompleteSale(currentSale);
    }
}
