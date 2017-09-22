
import java.util.*;


public class Sale {
    private Date time;
    private List<SalesLineItem> lineItems;
    private Payment payment;

    public Sale() {
        this.time = new Date(System.currentTimeMillis());
        this.lineItems=new ArrayList<SalesLineItem>();
    }

    public void makeLineItem(ProductDescription description, int quantify ){
        SalesLineItem sl = new SalesLineItem(quantify, description);
        this.lineItems.add(sl);
    }
    
    public void makePayment(float cash){
        this.payment = new Payment(cash);
    }
    
    public float getTotal(){
        SalesLineItem sAux;
        Iterator it = this.lineItems.iterator(); 
        float total=0;
        while(it.hasNext()){
            sAux = (SalesLineItem)it.next();
            total+=sAux.getSubtotal();
        }
//      for(SalesLineItem sli: this.lineItems){
//      }
        return total;
    }
}
