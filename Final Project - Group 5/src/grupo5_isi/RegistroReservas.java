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
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class RegistroReservas {

    private List<Reserva> reservas;

    public RegistroReservas() {
        reservas = new ArrayList();
    }

    public void registrarReserva(Reserva res) {
        //añadimos la reserva en la lista reserva
        reservas.add(res);
    }

    public void registrarReservaFichero(Reserva res, String cad) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(cad, true);
            pw = new PrintWriter(fichero);
            pw.print(res.escribirFichero());

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
    

    public void ModificarReservaFichero(String ficheroAntiguo, Socio soc) {
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

    public void cancelarReserva(Reserva res) {
        //borra de la lista res la reserva
        reservas.remove(res);
    }

    public Reserva crearNuevaReserva(Socio soc) {//crea una reserva con los datos del socio
        Reserva res = new Reserva(soc);
        return res;
    }

    public void introducirReserva(Reserva res, Date fecha, Instalacion inst) {
        //introducimos la fecha y la pista que queremos reserva
        res.setFecha(fecha);
        res.setInst(inst);
    }

    public Reserva buscarReserva(Instalacion inst, Date fecha) {
        //busca las reservas que tiene una pista y nos devuelve los datos de la pista
        Iterator<Reserva> it = reservas.iterator();
        Reserva res = null;
        while (it.hasNext() && res == null) {
            Reserva aux = it.next();
            if (aux.getFecha().equals(fecha) && aux.getInst().equals(inst)) {
                res = aux;
            }
        }
        return res;
    }

    public Reserva tieneReserva(Socio soc) {
        Iterator<Reserva> it = reservas.iterator();
        Reserva res = null;
        while (it.hasNext() && res == null) {
            Reserva aux = it.next();
            if (aux.getSocio().equals(soc) && isReservaActiva(aux)) {
                res = aux;
            }
        }
        return res;
    }

    private boolean isReservaActiva(Reserva res) {
        boolean activa = false;
        Date fechaActual = new Date();
        Date fechaRes = res.getFecha();
        if (fechaRes.after(fechaActual)) {
            activa = true;
        }

        return activa;
    }

    public boolean isReservaCancelable(Reserva res) {
        //metodo que mirara si es posible realizar la cancelacion ya que solo se puede efectuar si hay mas de un dia como minimo para cancelar
        boolean cancelable = false;
        Date fechaActual;
        Date fechaRes = res.getFecha();
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 1); //le suma 1 días
        fechaActual = c1.getTime();

        if (fechaRes.after(fechaActual)) {
            cancelable = true;
        }

        return cancelable;
    }
}
