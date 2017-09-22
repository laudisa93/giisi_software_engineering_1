
import java.util.*;


public class ProductCatalog {
    private List<ProductDescription> descriptions;

    public ProductCatalog() {
        this.descriptions = new ArrayList<ProductDescription>();
    }

    public List getDescriptions() {
        return descriptions;
    }

    public ProductDescription getProductDesc(String id){
        Iterator it = this.descriptions.iterator();
        boolean enc = false;
        ProductDescription p = null;
        while(it.hasNext() && !enc){
            p =(ProductDescription)it.next();
            if(p.getItemID().equals(id)){
                enc=true;
            }

        }
        return p;
    }
}
