/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class Alquiler {
    private Reserva reserva;
    private List<Material> materiales;
    private boolean devuelto;

    public Alquiler(Reserva reserva) {
        this.reserva = reserva;
        devuelto = false;
        materiales = new ArrayList();
    }

    public Alquiler(Reserva reserva, ArrayList<Material> materiales, boolean devuelto) {
        this.reserva = reserva;
        this.materiales = materiales;
        this.devuelto = devuelto;
    }
    
    
    
    public void añadirMaterial(Material mat){
        materiales.add(mat);
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public boolean isDevuelto() {
        return devuelto;
    }
    
    
    public String escribirFichero(){
        String result = reserva.escribirFichero2();
        Iterator<Material> it = materiales.iterator();
        while (it.hasNext()) {
            Material matAux = it.next();
            result += "/" + matAux.getDescripcion().getItemId();    
        }
        if(devuelto){
            result += "/true\n";  
        } else{
           result += "/false\n"; 
        }
        return result;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alquiler other = (Alquiler) obj;
        if (this.reserva != other.reserva && (this.reserva == null || !this.reserva.equals(other.reserva))) {
            return false;
        }
        if (this.materiales != other.materiales && (this.materiales == null || !this.materiales.equals(other.materiales))) {
            return false;
        }
        if (this.devuelto != other.devuelto) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.reserva != null ? this.reserva.hashCode() : 0);
        hash = 31 * hash + (this.materiales != null ? this.materiales.hashCode() : 0);
        hash = 31 * hash + (this.devuelto ? 1 : 0);
        return hash;
    }
    
    
    
}
