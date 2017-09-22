/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class Reserva {

    private Date fecha;
    private Socio socio;
    private Instalacion inst;

    public Reserva(Socio socio) {
        this.socio = socio;
    }

    public Reserva(Date fecha, Socio socio, Instalacion inst) {
        this.fecha = fecha;
        this.socio = socio;
        this.inst = inst;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setInst(Instalacion inst) {
        this.inst = inst;
    }

    public Instalacion getInst() {
        return inst;
    }

    public Socio getSocio() {
        return socio;
    }

    public Date getFecha() {
        return fecha;
    }

    public String escribirFichero() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return socio.getDNI() + "/" + inst.getDescripcion().getItemId() + "/" + formatoFecha.format(fecha) + "\n";
    }

    public String escribirFichero2() { //Métodod para escribir los alquileres en los ficheros, aprovechando que usa los datos de reserva
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return socio.getDNI() + "/" + inst.getDescripcion().getItemId() + "/" + formatoFecha.format(fecha);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return "Pista: " + inst.getDescripcion().getItemId() + " el dia " + formatoFecha.format(fecha);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (this.fecha != other.fecha && (this.fecha == null || !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.socio != other.socio && (this.socio == null || !this.socio.equals(other.socio))) {
            return false;
        }
        if (this.inst != other.inst && (this.inst == null || !this.inst.equals(other.inst))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.fecha != null ? this.fecha.hashCode() : 0);
        hash = 89 * hash + (this.socio != null ? this.socio.hashCode() : 0);
        hash = 89 * hash + (this.inst != null ? this.inst.hashCode() : 0);
        return hash;
    }
}
