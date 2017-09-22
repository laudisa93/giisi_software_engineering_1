/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

/**
 *
 * @author Ricardo
 */
public class DescripcionMaterial {
    private String descripcion;
    private Double precio;
    private String itemId;

    public DescripcionMaterial(String descripcion, Double precio, String itemId) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.itemId != null ? this.itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DescripcionMaterial other = (DescripcionMaterial) obj;
        if ((this.itemId == null) ? (other.itemId != null) : !this.itemId.equals(other.itemId)) {
            return false;
        }
        return true;
    }
    
     
}
