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
public class RegistroSocios {

    private List<Socio> socios;

    public RegistroSocios() {
        socios = new ArrayList();
    }

    public void registrarSocio(Socio soc) {
        socios.add(soc); //añadimos los socios en una lista llamada socio
    }

    //guardamos los socios en el fichero
    public void registrarSocioFichero(Socio soc, String cad) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(cad, true);
            pw = new PrintWriter(fichero);
            pw.print(soc.escribirFichero());

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

    public void ModificarSocioFichero(String ficheroAntiguo, Socio soc) {
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
                        texto += soc.escribirFichero();
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

    public Socio crearNuevoSocio() {
        //Crea el socio
        Socio soc = new Socio();
        return soc;
    }

    public void introducirDatos(Socio soc, String DNI, String nombre, String apellidos,
            int movil, String correo) {
        //introducimos los datos del socio en soc
        soc.introducirDatos(DNI, nombre, apellidos, movil, correo);
    }
    //metodo que nos sirve para buscar un socio
    public Socio buscarSocio(String DNI) {
        Iterator<Socio> it = socios.iterator();
        Socio soc = null;
        while (it.hasNext() && soc == null) {
            Socio aux = it.next();
            if (aux.getDNI().equalsIgnoreCase(DNI)) {
                soc = aux;
            }
        }
        
        return soc;

    }
}
