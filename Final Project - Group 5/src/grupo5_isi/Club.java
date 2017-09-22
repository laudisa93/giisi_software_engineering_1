/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ricardo
 */
public class Club {

    private RegistroSocios registroSocios;
    private RegistroAlquileres registroAlquileres;
    private RegistroReservas registroReservas;
    private CatalagoInstalacion catalogoInst;
    private CatalagoMaterial catalogoMat;
    private Almacen almacen;

    public Club() {
        registroSocios = new RegistroSocios();
        registroAlquileres = new RegistroAlquileres();
        registroReservas = new RegistroReservas();
        catalogoInst = new CatalagoInstalacion();
        catalogoMat = new CatalagoMaterial();
        almacen = new Almacen();
    }
    
    //metodo para crear socio
    public Socio crearNuevoSocio(String DNI) throws Exception {
        Socio soc = null;
        //Buscamos que el socio no este creado
        Socio aux = registroSocios.buscarSocio(DNI);
        if (aux == null) { //si no esta creado creamos un socio nuevo
            soc = registroSocios.crearNuevoSocio();//el metodo crearNuevoSocio crea el socio en registro socio
            return soc;
        } else if (aux.getFechaBaja() != null) {//si el socio existe pero tiene fecha de baja!=null modificamos su fecha alta por la de hoy
            aux.darAltaSocioExistente();        //y ponemos la fechaBaja a null
            registroSocios.ModificarSocioFichero("Socios.txt", aux);
            return aux;
        } else {
            throw new Exception("Error. El socio con DNI " + aux.getDNI() + " ya se encuentra registrado.");//si existe el socio lanza una excepcion
        } 
    }

    public void introducirDatos(Socio soc, String DNI, String nombre, String apellidos, int movil, String correo) {
        //cuando hemos creado un socio nuevo o modificado un socio si todo esta bien guardamos los datos en registraSocio
        registroSocios.introducirDatos(soc, DNI, nombre, apellidos, movil, correo);

        registroSocios.registrarSocio(soc);
        registroSocios.registrarSocioFichero(soc, "Socios.txt");
    }

    public void introducirNuevosDatos(Socio soc, String DNI, String nombre, String apellidos, int movil, String correo) {
        //introduce los datos
        registroSocios.introducirDatos(soc, DNI, nombre, apellidos, movil, correo);
        //guarda en el registro el socio
        registroSocios.registrarSocio(soc);
        //modifica el fichero con el registro nuevo del socio
        registroSocios.ModificarSocioFichero("Socios.txt", soc);
    }

    public Socio editarDatos(String DNI) throws Exception {
        //busca el socio con el metodo buscarSocio e el registro   
        Socio soc = registroSocios.buscarSocio(DNI);
        
        if (soc == null) {   //prueba primero que existe el socio con ese dni que le hemos pasado
            throw new Exception("Error. No existe ningun socio con DNI " + DNI + " registrado en el club.");
        }
        return soc;
    }

    public Socio darBajaSocio(String DNI) throws Exception {
        //comprueba que el socio existe con buscarSocio
        Socio soc = registroSocios.buscarSocio(DNI);
        //mira que exista el socio y que la fechaBaja sea nula
        if (soc != null && soc.getFechaBaja() == null) {
            return soc;
        } else { //si no existe el socio o la fechaBaja es distinta a nula lanza una excepcion
            throw new Exception("Error. El socio con DNI " + soc.getDNI() + " no está dado de alta en el club.");
        }
    }

    public void confirmarDarBaja(Socio soc) {
        //para dar baja a un socio llamamos al metodo darBaja para que nos cambie la fecha baja del socio de null a fecha del sistema
        soc.darBaja();
        // modificamos el socio
        registroSocios.ModificarSocioFichero("Socios.txt", soc);
    }

    public void consultarDatos(String DNI) throws Exception {
        //buscamos el socio con buscarSocio
        Socio soc = registroSocios.buscarSocio(DNI);
        //si existe el socio imprimira los datos
        if (soc != null) {
            System.out.println(soc);
        } else {    //si no existe el socio nos dara una excepcion
            throw new Exception("Error. No existe ningun socio con DNI " + DNI + " registrado en el club.");
        }
    }

    public Reserva crearNuevoReserva(String DNI) throws Exception {
        //para crear la reserva primero buscamos al socio que va hacer la reserva
        Socio soc = registroSocios.buscarSocio(DNI); //buscamos el socio para comprarbar que existe
        Reserva resAux = registroReservas.tieneReserva(soc); //preguntamos en el metodo tieneReserva si tiene reserva el socio
        //si el socio es nulo o la fechade baja del socio es distinta de nula, es que  el socio es como si no existiera, no puede hacer reserva 
        if (soc == null || soc.getFechaBaja() != null) {
            throw new Exception("Error. No existe ningun socio con DNI " + DNI + " registrado en el club."); //salta una excepcion
        } else if (resAux != null) {//si cuando comprobamos las reservas del socio tenia reservas no puede hacer una reserva ya que nada mas que se puede tener una reserva por socio
            throw new Exception("Error. El socio con DNI " + soc.getDNI() + " ya tiene una reserva activa.");
        } else {//sino se crea la reserva llamando a crearNuevaReserva que es la que se encarga de hacer la reserva
            return registroReservas.crearNuevaReserva(soc);
        }
    }

    public Instalacion buscarInstalacion(String idPista) {
        //buscamos las instalaciones que tenemos en el club, las pistas que tenemos, la tendremos guardadas en almacen
        return almacen.buscarInstalacion(idPista);
    }

    public Reserva buscarReserva(Instalacion inst, Date fecha) {
        //buscaremos las reservas que tenga esa pista para que no tengamos 2 reservas mismo dia misma hora
        return registroReservas.buscarReserva(inst, fecha);
    }

    public void introducirReserva(Reserva res, Date fecha, Instalacion inst) {
        //Introducimos los datos de la reserva
        registroReservas.introducirReserva(res, fecha, inst);//introducimos la fecha y la pista para esa reserva
        registroReservas.registrarReserva(res); //registramos la reserva
        registroReservas.registrarReservaFichero(res, "Reservas.txt"); //y guardamos la reserva
    }

    public Alquiler crearNuevoAlquiler(String DNI) throws Exception {
        //metodo para crear alquiler
        Socio soc = registroSocios.buscarSocio(DNI); //buscamos el socio
        Reserva res = registroReservas.tieneReserva(soc); //miramos que tiene reservada algun pista

        if (soc == null || soc.getFechaBaja() != null) { //si el socio es nulo o la fechaBaja no es nula el socio no existe
            throw new Exception("Error. No existe ningun socio con DNI " + DNI + " registrado en el club.");
        } else if (res == null) { //si la reserva es nula no se puede hacer ningun alquiler
            throw new Exception("Error. El socio con DNI " + soc.getDNI() + " no tiene una reserva activa.");
        } else { //creamos el aquiler
            Alquiler alq = registroAlquileres.crearNuevaAlquiler(res);
            return alq;
        }
    }

    public void introducirMaterial(Alquiler alq, Material mat) {
        //añadir el alquiler del material en la lista añadirMaterial
        alq.añadirMaterial(mat);
    }

    public void registrarAlquiler(Alquiler alq) {
        //registramos todo el alquiler echo por el socio
        registroAlquileres.registrarAlquiler(alq);//resgistramos el alquiler
        registroAlquileres.registrarAlquilerFichero(alq, "Alquileres.txt");//y lo guardamos en el fichero
    }

    public Material buscarMaterial(String idMaterial) {
        //metodo que devuelve la lista del material que tenemos en nuestro club
        return almacen.buscarMaterial(idMaterial);
    }

    public Reserva nuevaCancelacionReserva(String DNI) throws Exception {
        //metodo que cancelarReserva
        Socio soc = registroSocios.buscarSocio(DNI); //comprobara que el socio existe
        Reserva res = registroReservas.tieneReserva(soc); //comprobara que ese socio tiene una reserva
        //si el socio no existe o la fechabaja es nula el socio no existe por lo tanto no puede cancerlar una reserva
        if (soc == null || soc.getFechaBaja() != null) {
            throw new Exception("Error. No existe ningun socio con DNI " + DNI + " registrado en el club.");
        } else if (res == null) { //si el socio no tiene una reserva no puede cancerlar ninguna reserva
            throw new Exception("Error. El socio con DNI " + soc.getDNI() + " no tiene ninguna reserva.");
        } else if (!registroReservas.isReservaCancelable(res)) { //consultams que tengamos mas de un dia como minimo para poder cancelar
            throw new Exception("Error. La reserva " + res + " no es cancelable, le quedan menos de 24 horas.");
        } else { //si esposibe cancelar la reserva devolvera la reserva que tengamos echa con ese socio
            return res;
        }
    }

    public Alquiler tieneAlquiler(String DNI) {
        //buscaremos si el socio tiene material alquilado
        Socio soc = registroSocios.buscarSocio(DNI); //miramos si el socio existe
        return registroAlquileres.tieneAlquiler(soc); //miramos que el socio tenga algun alquiler
    }

    public void confirmarCancelarReserva(Reserva res, String DNI) {
        //buscaremos los datos suficientes del socio para cancelar la reserva
        Socio soc = registroSocios.buscarSocio(DNI);//busca el socio
        registroReservas.cancelarReserva(res);//metodo para borrar la reserva de la lista
        registroReservas.ModificarReservaFichero("Reservas.txt", soc); //guardamos la modificacion
    }

    public Alquiler nuevaDevolucionMaterial(String DNI) throws Exception {
        //Metodo de cancelar material
        Socio soc = registroSocios.buscarSocio(DNI); //buscamos al socio
        Alquiler alq = registroAlquileres.tieneAlquiler(soc); //miramos que tenga algun alquiler

        if (soc == null || soc.getFechaBaja() != null) { //miramos que si es socio 
            throw new Exception("Error. No existe ningun socio con DNI " + DNI + " registrado en el club.");
        } else if (alq == null || alq.isDevuelto()) { // miramos si tiene alquiler
            throw new Exception("Error. El socio con DNI " + soc.getDNI() + " no tiene ningún alquiler.");
        } else { //devolvemos el alquiler que tenga con la lista alq
            return alq;
        }
    }

    public void registrarDevolucion(Alquiler alq, String DNI) {
        //metodo para registrar la devolucion del material
        Socio soc = registroSocios.buscarSocio(DNI); //buscamos al socio
        registroAlquileres.devolverAlquiler(alq); //devolvemos el material
        registroAlquileres.ModificarAlquilerFichero("Alquileres.txt", soc, alq); //registramo la devolucion
    }
    
    public boolean validarDNI(String DNI) { 
        //No verifica la última letra del dni para que sea correcta por facilidad al crear socios nuevos.
        boolean valido = false;
        if (DNI.length() == 9) {
            String num = DNI.substring(0, DNI.length() - 1);
            DNI = DNI.toUpperCase(); // Paso la letra del DNI a mayúscula.
            if ('A' <= DNI.charAt(DNI.length() - 1) && DNI.charAt(DNI.length() - 1) <= 'Z') {
                for (int i = 0; i < num.length(); i++) {
                    if ('0' <= num.charAt(i) && num.charAt(i) <= '9') {
                        valido = true;
                    } else {
                        System.err.println("Error: " + DNI + " - DNI debe contener 8 dígitos y una letra.");
                        valido = false;
                    }
                }
            } else {
                System.err.println("Error: El DNI " + DNI + " - DNI debe contener 8 dígitos y una letra.");
            }
        } else {
            System.err.println("Error: El DNI " + DNI + " no tiene 9 caracteres.");
        }
        return valido;
    }

    public boolean isEmail(String correo) {
        //comprobamos que el campo email este bien introducido
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{0,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public Date isDateRes(String fechax) {
        //comprobamos que el campo fecha esta bien introducido
        Date fecha;
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            fecha = formatoFecha.parse(fechax);
        } catch (Exception e) {
            return null;
        }
        return fecha;
    }

    public int isMovil(String cadena) {
        //verifica qeu el movil tiene 9 digitos numericos
        if (cadena.length() == 9) {
            try {
                int movil = Integer.parseInt(cadena);
                return movil;
            } catch (NumberFormatException nfe) {
                return 0;
            }
        }
        return 0;
    }

    /**
     * leerFichero recibe como parametro tipoCatalogo 
     * tipoCatalogo=1 ->instalaciones 
     * tipoCatalogo=2 -> materiales
     * tipoCatalogo=3 -> socios
     * tipoCatalogo=4 -> reservas
     * tipoCatalogo=5 -> alquileres
     */
    public void leerFichero(String nombreFichero, int tipoFichero) {
        File fichero = new File(nombreFichero);
        String linea;
        if (fichero != null) {
            try {
                FileReader file = new FileReader(fichero);
                BufferedReader buffer = new BufferedReader(file);
                SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                while ((linea = buffer.readLine()) != null) {
                    String array[] = linea.split("/");
                    switch (tipoFichero) {
                        case 1:
                            DescripcionInstalacion desInst = new DescripcionInstalacion(array[0],
                                    Double.parseDouble(array[1]), array[2]);
                            this.catalogoInst.add(desInst);
                            this.almacen.addInstalacion(desInst);
                            break;
                        case 2:
                            DescripcionMaterial desMat = new DescripcionMaterial(array[0], Double.parseDouble(array[1]),
                                    array[2]);
                            this.catalogoMat.add(desMat);
                            this.almacen.addMaterial(desMat);
                            break;
                        case 3:
                            Date fechaAlta = formatoFecha.parse(array[5]);
                            Date fechaBaja;
                            if (array[6].equals("null")) {
                                fechaBaja = null;
                            } else {
                                fechaBaja = formatoFecha.parse(array[6]);
                            }
                            Socio soc = new Socio(array[0], array[1], array[2], Integer.parseInt(array[3]),
                                    array[4], fechaAlta, fechaBaja);
                            this.registroSocios.registrarSocio(soc);
                            break;
                        case 4:
                            Date fecha = formatoFecha2.parse(array[2]);
                            Socio socAux = registroSocios.buscarSocio(array[0]);
                            Instalacion instAux = almacen.buscarInstalacion(array[1]);
                            Reserva res = new Reserva(fecha, socAux, instAux);
                            this.registroReservas.registrarReserva(res);
                            break;
                        case 5:
                            Socio socAux2 = registroSocios.buscarSocio(array[0]);
                            Date fechaAux = formatoFecha2.parse(array[2]);
                            Instalacion instAux2 = almacen.buscarInstalacion(array[1]);
                            Reserva resAux = new Reserva(fechaAux, socAux2, instAux2);
                            boolean devueltoAux;
                            ArrayList<Material> materialesAux = new ArrayList<Material>();
                            int i = 4;
                            while (i < array.length - 1) {
                                Material matAux = almacen.buscarMaterial(array[i]);
                                materialesAux.add(matAux);
                                i++;
                            }
                            if (array[i].equals("true")) {
                                devueltoAux = true;
                            } else {
                                devueltoAux = false;
                            }

                            Alquiler alq = new Alquiler(resAux, materialesAux, devueltoAux);
                            registroAlquileres.registrarAlquiler(alq);
                            break;
                        default:
                            System.out.println("Tipo de fichero no existente.");
                    }
                }
                try {
                    if (null != file) {
                        file.close();
                    }
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Fichero leido correctamente.");
        }


    }

    public RegistroSocios getRegistroSocios() {
        return registroSocios;
    }

    public RegistroAlquileres getRegistroAlquileres() {
        return registroAlquileres;
    }

    public RegistroReservas getRegistroReservas() {
        return registroReservas;
    }
}
