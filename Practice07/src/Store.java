
import java.util.*;
import java.util.ArrayList;


public class Store {
    private String address;
    private String name;
    private ProductCatalog catalog;
    private List <Sale> completeSale;
    private Register register;

    public Store(String name, String address) {
        this.name=name;
        this.address=address;
        this.completeSale = new ArrayList<Sale>();
        this.catalog = new ProductCatalog();
        this.register =new Register(catalog, this);
    }

    public void addCompleteSale(Sale s){
        this.completeSale.add(s);
    }
}
