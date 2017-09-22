/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class RegistroAlquileres {

    private List<Alquiler> alquileres;

    public RegistroAlquileres() {
        alquileres = new ArrayList();
    }

    public void registrarAlquiler(Alquiler alq) {
        //añade el alquiler completo del usuario a la lista aqluiler
        alquileres.add(alq);
    }

    public void registrarAlquilerFichero(Alquiler alq, String cad) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(cad, true);
            pw = new PrintWriter(fichero);
            pw.print(alq.escribirFichero());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
    
    /**
     * ModificarFichero modifica mi fichero alquileres y actualiza el alquiler que se ha devuelto
     * @param ficheroAntiguo
     * @param soc
     * @param alq 
     */
    
        public void ModificarAlquilerFichero(String ficheroAntiguo, Socio soc, Alquiler alq) {
        File FficheroAntiguo = null;
        FileWriter FficheroNuevo = null;
        try {
            FficheroAntiguo = new File(ficheroAntiguo);
            if (FficheroAntiguo != null) {
                /*Abro un flujo de lectura*/
                BufferedReader Flee = new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                String texto = "";

                /*Recorro el fichero de texto linea a linea*/
                while ((Slinea = Flee.readLine()) != null) {
                    /*Si la linea obtenida es distinta al la buscada 
                     *para eliminar*/
                    if (Slinea.substring(0, 9).equalsIgnoreCase(soc.getDNI())) {
                        /*la escribo en el fichero nuevo*/
                        texto += alq.escribirFichero();
                    } else {
                        texto += Slinea + "\n";
                    }
                }

                Flee.close();
                FficheroNuevo = new FileWriter(FficheroAntiguo);
                PrintWriter pw = new PrintWriter(FficheroNuevo);
                pw.print(texto);
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != FficheroNuevo) {
                    FficheroNuevo.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }

        }
    }

    public Alquiler crearNuevaAlquiler(Reserva res) {
        //Añadimos el aquiler nuevo en la lista alquiler
        Alquiler alq = new Alquiler(res);
        return alq;
    }

    public void devolverAlquiler(Alquiler alq) {
        //ponemos devuelto a verdadero
        alq.setDevuelto(true);
    }

    public Alquiler tieneAlquiler(Socio soc) {
        //buscamos si ese socio tiene alquiler en la lista alquileres
        Iterator<Alquiler> it = alquileres.iterator();
        Alquiler alq = null;
        while (it.hasNext() && alq == null) {
            Alquiler aux = it.next();
            if (aux.getReserva().getSocio().equals(soc) && !aux.isDevuelto()) {
                alq = aux;
            }
        }
        return alq;
    }
}
