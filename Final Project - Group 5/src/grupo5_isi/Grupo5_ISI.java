/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.util.Date;
import java.util.Iterator;
import poo.io.IO;

/**
 *
 * @author Ricardo
 */
public class Grupo5_ISI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creas una clase 
        Club club = new Club();
        
        //Leer ficheros que vamos a usar durante la aplicacion
        club.leerFichero("instalaciones.txt", 1);
        club.leerFichero("materiales.txt", 2);
        club.leerFichero("Socios.txt", 3);
        club.leerFichero("Reservas.txt", 4);
        club.leerFichero("Alquileres.txt", 5);
        int operacion;

        do {
            System.out.println("\n1.Dar de Alta.\n2.Editar datos.\n3.Dar de Baja.\n4.Consultar datos."
                    + "\n5.Crear nueva Reserva\n6.Crear nuevo Alquiler\n7.Cancelar Reserva.\n"
                    + "8.Devolver Alquiler\n0.Salir\n");

            System.out.println("Introduzca una opción: ");
            operacion = (int) IO.readNumber();
            //menu
            switch (operacion) {
                case 0:
                    break;
                case 1: //Nueva Alta Socio
                    try {
                        System.out.println("Nueva Alta de Socio.\n");
                        String DNI = null;
                        do {    //Nos estara pidiendo un DNI hasta que metamos uno correcto, 8numeros y 1letra
                            System.out.println("Por favor, introduzca el DNI del cliente.");
                            DNI = IO.readLine();
                        } while (!club.validarDNI(DNI));
                        //Una vez que hemos metido bien el DNI nos creamos un Socio
                        Socio soc = club.crearNuevoSocio(DNI);//vemos que el socio no existe
                        //Algunas cosas que tenemos que tener en cuenta al crear un socio
                        if (soc.getNombre() == null) {

                            boolean correoValido;
                            int movil;
                            String correo;
                            System.out.println("Por favor, introduzca el nombre del cliente.");
                            String nombre = IO.readLine();

                            System.out.println("Por favor, introduzca los apellidos del cliente.");
                            String apellidos = IO.readLine();

                            do {          //movil tiene que tener como minimo 9 numeros(solo nuemeros)
                                System.out.println("Por favor, introduzca el movil del cliente.");
                                String StMovil = IO.readLine();
                                movil = club.isMovil(StMovil);
                                if (movil == 0) {
                                    System.err.println("Error. El movil " + StMovil + " no es válido.");
                                }
                            } while (movil == 0);
                            do {         //el correo tiene que tener como minimo una algo@4digitos.
                                System.out.println("Por favor, introduzca el correo del cliente.");
                                correo = IO.readLine();
                                correoValido = club.isEmail(correo);
                                if (!correoValido) {
                                    System.err.println("Error. El correo " + correo + " no es válido.");
                                }
                            } while (!correoValido);
                            //si todo esta bien se introduce los datos del socio
                            club.introducirDatos(soc, DNI, nombre, apellidos, movil, correo);

                        }
                        System.out.println("El socio con DNI " + soc.getDNI() + " se ha registrado en el club correctamente.");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:  //editar datos
                    try {
                        System.out.println("\nEditar Datos.\n");
                        
                        String DNI = null;
                        do {
                            System.out.println("Por favor, introduzca el DNI del cliente.");
                            DNI = IO.readLine();
                        } while (!club.validarDNI(DNI)); //comprueba en validarDni que el dni tiene la forma correcta(8numero y 1 letra)
                        //pregunta en editar datos si existe ese socio 
                        Socio soc = club.editarDatos(DNI);
                        //introducimos los datos nuevos
                        boolean correoValido;
                        int movil;
                        String correo;
                        //Algunas cosas que tenemos que tener en cuenta al crear un socio
                        System.out.println("Por favor, introduzca el nuevo nombre del cliente.");
                        String nombre = IO.readLine();

                        System.out.println("Por favor, introduzca los nuevos apellidos del cliente.");
                        String apellidos = IO.readLine();

                        do {
                            System.out.println("Por favor, introduzca el nuevo movil del cliente.");
                            String StMovil = IO.readLine();
                            movil = club.isMovil(StMovil);
                            if (movil == 0) {
                                System.err.println("Error. El movil " + StMovil + " no es válido.");
                            }
                        } while (movil == 0);
                        do {
                            System.out.println("Por favor, introduzca el nuevo correo del cliente.");
                            correo = IO.readLine();
                            correoValido = club.isEmail(correo);
                            if (!correoValido) {
                                System.err.println("Error. El correo " + correo + " no es válido.");
                            }
                        } while (!correoValido);
                        //si todo esta bien se introduce los datos del socio
                        club.introducirNuevosDatos(soc, DNI, nombre, apellidos, movil, correo);

                        System.out.println("Se han modificado los datos del socio con DNI " + soc.getDNI() + " correctamente.");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:  //da de baja a un socio
                    try {
                        System.out.println("\nDar Baja de Socio.\n");

                        String DNI = null;
                        do {
                            System.out.println("Por favor, introduzca el DNI del cliente.");
                            DNI = IO.readLine();
                        } while (!club.validarDNI(DNI)); //como siempre comprueba que el DNI este bien introducido

                        //vamos al metodo daBajaSocio, para que busque si el socio existe y no esta dado de baja
                        Socio soc = club.darBajaSocio(DNI);

                        boolean confirmacion = false;
                        String c = null;
                        //pide la confirmacion del socio introduciendo s
                        System.out.println("Confirme baja del socio con DNI " + soc.getDNI() + " pulsando S.");
                        c = IO.readLine();
                        if (c.equalsIgnoreCase("s")) {
                            confirmacion = true;
                        }
                        if (confirmacion) { //si es s la confirmacion llamamos al metodo confirmarBaja que es el encargado de llamar a los otros metodos para completar la baja del socio
                            club.confirmarDarBaja(soc); 
                            System.out.println("El socio con DNI " + soc.getDNI() + " se ha dado de baja en el club.");
                        } else { // no se dio de baja el socio
                            System.out.println("El socio con DNI " + soc.getDNI() + " no se ha dado de baja en el club.");
                        }
                    //
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:  //Consultar los datos del  socio
                    try {
                        System.out.println("\nConsultar Datos de Socio.\n");

                        String DNI = null;
                        do {
                            System.out.println("Por favor, introduzca el DNI del cliente.");
                            DNI = IO.readLine();
                        } while (!club.validarDNI(DNI)); //volvemos a comprobar los datos del socio
                        
                        club.consultarDatos(DNI); // llamamos al metodo consultarDatos que se encargara de llamar a los otros metodos para que nos devuleva los datos del socio que queremos consultar 
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:    //Reservar una pista
                    try {
                        System.out.println("\nCrear nueva Reserva.\n");
                        String DNI = null;
                        do {
                            System.out.println("Por favor, introduzca el DNI del cliente.");
                            DNI = IO.readLine();
                        } while (!club.validarDNI(DNI)); //lo de siempre de comprobar los datos del socio

                        Reserva res = club.crearNuevoReserva(DNI); //llamamos al metodo crear nueva reserva que se encargar de llamar a los otros metodos para comprobar que no tiene reserva echar con anterioridad
                        Reserva aux = null;
                        Instalacion inst = null;
                        Date fecha = null;
                        do {//una vez comprobado
                            do {    //introducimos la fecha cuando queremos reserva la pista
                                System.out.println("Por favor, introduzca una fecha para la reserva (dd-MM-aaaa HH:mm): ");
                                String fechaL = IO.readLine();
                                fecha = club.isDateRes(fechaL);
                                if (fecha == null) { //comprobamos que los campos de la fecha esta bien introducidos
                                    System.err.println("Error. La fecha " + fechaL + " no es válida.");
                                }
                            } while (fecha == null);

                            do { //introducimos la pista que queremos reservar
                                System.out.println("Por favor, introduzca la pista para la reserva: ");
                                String idPista = IO.readLine();

                                inst = club.buscarInstalacion(idPista);

                                if (inst == null) { // si no existe la pista que hemos metido por teclado
                                    System.out.println("La instalacion que ha seleccinado no existe.");
                                }
                            } while (inst == null);
                            //si exsiste la pista 
                            aux = club.buscarReserva(inst, fecha);
                            //si la pista tiene reserva no podremos reserva la pista
                            if (aux != null) {
                                System.err.println("Error. Ya existe reserva para la fecha introducida.");
                            } 
                        } while (aux != null);// si no tiene reserva la pista pues nos dejara reservar la pista
                        //llamamos al metodo introducir reserva que se encargara de llamar a los distintos metodos para realizar la reserva de esa pista en esa hora
                        club.introducirReserva(res, fecha, inst);
                        //reserva echa perfecta a jugar!!!!
                        System.out.println("El socio con DNI " + DNI + " ha realizadod la reserva " + res + " correctamente.");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 6:     //Hacer un alquiler para poder hacer el alquiler tenemos que tener echo una reserva de pista
                    try {
                        System.out.println("\nCrear nuevo Alquiler.\n");

                        String DNI = null;
                        Reserva res = null;
                        do {
                            System.out.println("Por favor, introduzca el DNI del cliente.");
                            DNI = IO.readLine();
                        } while (!club.validarDNI(DNI)); //comprobacion tipica de que existe el socio que quiere hacer el alquiler de material
                        //llamamos al metodo crearNuevoAlquiler que se encargara de llamar a los distintos metodos para crear el alquiler de material
                        Alquiler alq = club.crearNuevoAlquiler(DNI);

                        Material mat = null;
                        boolean finAlq = false;
                        String c = null;
                        
                        while (!finAlq) {
                            do { //introducimos el nombre del material que queremos alquilar
                                System.out.println("Por favor, introduzca el material que desea alquilar: ");
                                String idMaterial = IO.readLine();
                                //buscamos de que exista ese material con el metodo buscarMarterial
                                mat = club.buscarMaterial(idMaterial);

                                if (mat == null) { //si el materia es nulo es que no existe ese material
                                    System.out.println("El material que ha seleccinado no existe.");
                                }
                            } while (mat == null);
                            //introducimos el material alquilado con el metodo introducirMaterial
                            club.introducirMaterial(alq, mat);
                            //si queremos volver alquilar algo podemos introducir s y volveremos a alquilar otro material
                            System.out.println("Pulse S si quiere alquilar más materiales.");
                            c = IO.readLine();
                            if (!c.equalsIgnoreCase("s")) {
                                finAlq = true;
                            }
                        }
                        //registramo el alquiler del socio y lo guardamos
                        club.registrarAlquiler(alq);

                        System.out.println("El socio con DNI " + DNI + " ha realizadod un alquiler correctamente.");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 7:     //Cancelacion de reserva
                    try {
                        System.out.println("\nNueva cancelacion Reserva.\n");

                        String DNI = null;
                        do {
                            System.out.println("Por favor, introduzca el DNI del cliente.");
                            DNI = IO.readLine();
                        } while (!club.validarDNI(DNI)); //tipica comprobacion de que existe el socio
                        
                        //Metodo que se encargara de llamar a los distintos metodos para cancelar una reserva
                        Reserva res = club.nuevaCancelacionReserva(DNI);

                        boolean confirmacion = false;
                        String c = null;
                        System.out.println("Confirme cancelar la reserva " + res + " pulsando S.");
                        c = IO.readLine();
                        if (c.equalsIgnoreCase("s")) {
                            confirmacion = true;
                        }//confirmamos la cancelacion pulsando s

                        if (confirmacion) { //si hemos pulsado s
                            club.confirmarCancelarReserva(res, DNI);
                            //por cada cancelacion tenemos que devolver el material
                            Alquiler alq = club.tieneAlquiler(DNI);//metodo que comprobara si tenemos material alquilado
                            if (alq != null) {//si tiene alquiler
                                Iterator<Material> it = alq.getMateriales().iterator();
                                String c2;
                                while (it.hasNext()) {//recorremos la lista de alquilere del socio hasta que devuelva todos los materiales que tiene alquilados
                                    Material mat = it.next();
                                    do {
                                        System.out.println("Pulse S si se ha devuelto el material " + mat.getDescripcion().getItemId());
                                        c2 = IO.readLine();
                                    } while (!c.equalsIgnoreCase("s"));//tenemos que pulsar s para confirma
                                }
                                club.registrarDevolucion(alq, DNI);//metodo para devolver el material

                                System.out.println("La reserva " + res + " se ha cancelado correctamente.");
                            }
                        } else {
                            System.out.println("La reserva " + res + " no se ha cancelado correctamente.");
                        }

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 8:    //devolucion alquiler
                    try {
                        System.out.println("\nNueva Devolucion Aquiler.\n");

                        String DNI = null;
                        do {
                            System.out.println("Por favor, introduzca el DNI del cliente.");
                            DNI = IO.readLine();
                        } while (!club.validarDNI(DNI));//comprobamos si el usuario existe

                        Alquiler alq = club.nuevaDevolucionMaterial(DNI);//metodo que se encargara de llama a otros metodos para devolver un material

                        Iterator<Material> it = alq.getMateriales().iterator();
                        String c;
                        while (it.hasNext()) {//tenemos que devolver todo el material
                            Material mat = it.next();
                            do {
                                System.out.println("Pulse S si se ha devuelto el material " + mat.getDescripcion().getItemId());
                                c = IO.readLine();
                            } while (!c.equalsIgnoreCase("s"));
                        }
                        //se registra la devolucion
                        club.registrarDevolucion(alq, DNI);

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                default://si meter una opcion que no sea de las que tenemos
                    System.out.println("Eliga una operación entre las disponibles.");
            }
        } while (operacion != 0);
    }
}
