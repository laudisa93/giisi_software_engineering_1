/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

/**
 *
 * @author Ricardo
 */
public class DescripcionInstalacion {
    //clase donde tenemos los atributos de las instalaciones
    private String descripcion;
    private Double precio;
    private String itemId;

    public DescripcionInstalacion(String descripcion, Double precio, String itemId) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.itemId != null ? this.itemId.hashCode() : 0);
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
        final DescripcionInstalacion other = (DescripcionInstalacion) obj;
        if ((this.itemId == null) ? (other.itemId != null) : !this.itemId.equals(other.itemId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Descripcion Instalacion{\n\t" + "descripcion=" + descripcion + "\n\tprecio=" + precio + "\n\titemId=" + itemId + "\n}";
    }

    
    
}
