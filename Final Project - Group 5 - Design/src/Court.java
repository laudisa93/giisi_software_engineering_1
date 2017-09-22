
import java.util.*;


public class Court {
    
    private int numCourt;
    private Date start; //
    private Date end; //

    public Court(/*int numCourt, Date start, Date end*/) {
        this.numCourt = numCourt;
        this.start = start;
        this.end = end;
    }

    public Date getEnd() { //Tiene que ser posterior al inicio
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getNumCourt() {//Controlar numero de pistas
        return numCourt;
    }

    public void setNumCourt(int numCourt) {
        this.numCourt = numCourt;
    }
    
    public void bookCourt(){
        //identificar socio
        Court c1 = new Court();
        
    }
            
}
