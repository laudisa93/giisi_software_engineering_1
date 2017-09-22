/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Ricardo
 */
public class Almacen {
    //aqui tendremos guardado las pistas y el material que tenemos
    private Set<Instalacion> instalaciones;
    private Set<Material> materiales;

    public Almacen() {
        instalaciones = new HashSet<Instalacion>();
        materiales = new HashSet<Material>();
    }

    public Instalacion buscarInstalacion(String itemId) {
        //metodo para buscar las pista que tenemos
        Iterator<Instalacion> it = instalaciones.iterator();
        Instalacion inst = null;
        while (it.hasNext() && inst == null) {
            Instalacion aux = it.next();
            if (aux.getDescripcion().getItemId().equals(itemId)) {
                inst = aux;
            }
        }
        return inst;
    }

    public void addMaterial(DescripcionMaterial desc) {
        //metodo para añadir material a la lista material
        Material mat = new Material(desc);
        materiales.add(mat);
    }

    public void addInstalacion(DescripcionInstalacion desc) {
        //metodo para añadir instalaciones a la lista instalaciones
        Instalacion inst = new Instalacion(desc);
        instalaciones.add(inst);
    }

    public Material buscarMaterial(String itemId) {
        //metodo para buscar los materiales que tenemos en el club
        Iterator<Material> it = materiales.iterator();
        Material mat = null;
        while (it.hasNext() && mat == null) {
            Material aux = it.next();
            if (aux.getDescripcion().getItemId().equals(itemId)) {
                mat = aux;
            }
        }
        return mat;
    }
}
