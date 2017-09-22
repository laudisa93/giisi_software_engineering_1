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
public class Socio {

    private String DNI;
    private String nombre;
    private String apellidos;
    private int movil;
    private String correo;
    private Date fechaAlta;
    private Date fechaBaja;

    public Socio() {
        fechaAlta = new Date();
        fechaBaja = null;
    }

    public Socio(String DNI, String nombre, String apellidos, int movil, String correo, Date fechaAlta, Date fechaBaja) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.movil = movil;
        this.correo = correo;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getMovil() {
        return movil;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void darAltaSocioExistente() {
        //ponemos fechabaja a null y fecha añta a la fecha de hoy para no tener qie volver a crear el socio
        fechaBaja = null;
        fechaAlta = new Date();
    }

    public void introducirDatos(String DNI, String nombre, String apellidos, int movil, String correo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.movil = movil;
        this.correo = correo;
    }

    public void darBaja() {
        //nos da la fecha del sistema para que la cambiemos por el null que teniamos puesto antes de dar de baja a un socio
        this.fechaBaja = new Date();
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String result = "\n" + nombre + " " + apellidos
                + "\nDNI: " + DNI
                + "\nMovil: " + movil
                + "\nCorreo: " + correo
                + "\nFechaAlta: " + formatoFecha.format(fechaAlta);
        if (fechaBaja == null) {
            result += "\nFechaBaja: No está dado de baja\n";
        } else {
            result += "\nFechaBaja: " + formatoFecha.format(fechaBaja) + "\n";
        }
        return result;
    }

    public String escribirFichero() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String result = DNI + "/" + nombre + "/" + apellidos + "/" + movil + "/"
                + correo + "/" + formatoFecha.format(fechaAlta);
        if (fechaBaja == null) {
            result += "/null\n";
        } else {
            result += "/" + formatoFecha.format(fechaBaja) + "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Socio other = (Socio) obj;
        if ((other.DNI != null) && !this.DNI.equalsIgnoreCase(other.DNI)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.DNI != null ? this.DNI.hashCode() : 0);
        return hash;
    }
}
