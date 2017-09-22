/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ricardo
 */
public class ClubTest {

    public ClubTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of crearNuevoSocio method, of class Club.
     * Crea un socio que no existe.
     */
    @Test
    public void testCrearNuevoSocio() throws Exception {
        System.out.println("crearNuevoSocio");
        String DNI = "00000000A";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Socio expResult = new Socio();
        Socio result = instance.crearNuevoSocio(DNI);
        assertEquals(expResult, result);
    }

    /**
     * Test of crearNuevoSocio method, of class Club.
     * Modifica un socio que estaba dado de baja.
     */
    @Test
    public void testCrearNuevoSocio2() throws Exception {
        System.out.println("crearNuevoSocio");
        String DNI = "12345678H";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Socio expResult = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", new Date(), null);

        Socio result = instance.crearNuevoSocio(DNI);
        assertEquals(expResult, result);
    }

    /**
     * Test of crearNuevoSocio method, of class Club.
     * Salta la excepción al ya existir el socio.
     */
    @Test
    public void testCrearNuevoSocio3() throws ParseException {
        System.out.println("crearNuevoSocio");
        String DNI = "12345679H";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);

        Socio result;
        try {
            result = instance.crearNuevoSocio(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of editarDatos method, of class Club.
     * salta la excepción al existir el socio
     */
    @Test
    public void testEditarDatos() throws Exception {
        System.out.println("editarDatos");
        String DNI = "00000000H";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);

        Socio result;
        try {
            result = instance.editarDatos(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of editarDatos method, of class Club.
     * Devuelve el socio al que se le van a editar los datos
     */
    @Test
    public void testEditarDatos2() throws Exception {
        System.out.println("editarDatos2");
        String DNI = "12345678H";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);

        Socio expResult = soc1;
        Socio result = instance.editarDatos(DNI);

        assertEquals(expResult, result);
    }

    /**
     * Test of darBajaSocio method, of class Club.
     * Salta la excepción, socio no existente
     */
    @Test
    public void testDarBajaSocio() throws Exception {
        System.out.println("darBajaSocio");
        String DNI = "00000000H";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);

        try {

            instance.darBajaSocio(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of darBajaSocio method, of class Club.
     * Salta la excepción, el socio ya estaba dado de baja
     */
    @Test
    public void testDarBajaSocio2() throws Exception {
        System.out.println("darBajaSocio2");
        String DNI = "12345678H";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        try {
            instance.darBajaSocio(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of darBajaSocio method, of class Club.
     * Genera el método correctamente
     */
    @Test
    public void testDarBajaSocio3() throws Exception {
        System.out.println("darBajaSocio3");
        String DNI = "12345679H";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Socio expResult = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), new Date());
        Socio result = instance.darBajaSocio(DNI);
        assertEquals(expResult, result);
    }

    /**
     * Test of consultarDatos method, of class Club.
     * Se realiza el método consultar datos correctamente
     */
    @Test
    public void testConsultarDatos() throws Exception {
        System.out.println("consultarDatos");
        String DNI = "12345678h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        instance.consultarDatos(DNI);
    }

    /**
     * Test of consultarDatos method, of class Club.
     * Salta la excepción, el socio no existe
     */
    @Test
    public void testConsultarDatos2() throws ParseException {
        System.out.println("consultarDatos2");
        String DNI = "12345670h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        try {
            instance.consultarDatos(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of crearNuevoReserva method, of class Club.
     * Excepción, socio no existente
     */
    @Test
    public void testCrearNuevoReserva() throws ParseException {
        System.out.println("crearNuevoReserva");
        String DNI = "12345670h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        try {
            instance.crearNuevoReserva(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of crearNuevoReserva method, of class Club.
     * Excepción, el socio no tiene reserva
     */
    @Test
    public void testCrearNuevoReserva2() throws ParseException {
        System.out.println("crearNuevoReserva2");
        String DNI = "12345678h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        try {
            instance.crearNuevoReserva(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of crearNuevoReserva method, of class Club.
     * Excepción, el socio tiene una reserva activa.
     */
    @Test
    public void testCrearNuevoReserva3() throws ParseException {
        System.out.println("crearNuevoReserva3");
        String DNI = "12343359h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("10-01-2013 16:00"), soc2, new Instalacion(null));
        instance.getRegistroReservas().registrarReserva(res);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        try {
            instance.crearNuevoReserva(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of crearNuevoReserva method, of class Club.
     * Se crea la reserva correctamente
     */
    @Test
    public void testCrearNuevoReserva4() throws Exception {
        System.out.println("crearNuevoReserva4");
        String DNI = "12345679h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2012 16:00"), soc2, new Instalacion(null));
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        instance.getRegistroReservas().registrarReserva(res);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);

        Reserva result = instance.crearNuevoReserva(DNI);
        instance.getRegistroReservas().introducirReserva(result, formatoFecha2.parse("01-01-2013 15:00"), inst);
        Reserva expResult = new Reserva(formatoFecha2.parse("01-01-2013 15:00"), soc2, inst);

        assertEquals(expResult, result);

    }

    /**
     * Test of crearNuevoAlquiler method, of class Club.
     * Salta la excepción al no existir el socio.
     */
    @Test
    public void testCrearNuevoAlquiler() throws ParseException {
        System.out.println("crearNuevoAlquiler");
        String DNI = "12345670h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2012 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        instance.getRegistroReservas().registrarReserva(res);
        try {
            instance.crearNuevoAlquiler(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of crearNuevoAlquiler method, of class Club.
     * Excepción, el socio no tiene una reserva activa
     */
    @Test
    public void testCrearNuevoAlquiler2() throws ParseException {
        System.out.println("crearNuevoAlquiler2");
        String DNI = "12345679h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2012 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        instance.getRegistroReservas().registrarReserva(res);
        try {
            instance.crearNuevoAlquiler(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of crearNuevoAlquiler method, of class Club.
     * Se crea el alquiler correctamente
     */
    @Test
    public void testCrearNuevoAlquiler3() throws Exception {
        System.out.println("crearNuevoAlquiler3");
        String DNI = "12345679h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2014 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        instance.getRegistroReservas().registrarReserva(res);
        Alquiler expResult = new Alquiler(res, new ArrayList<Material>(), false);
        Alquiler result = instance.crearNuevoAlquiler(DNI);
        assertEquals(expResult, result);
    }

    /**
     * Test of nuevaCancelacionReserva method, of class Club.
     * Excepción,socio no existe
     */
    @Test
    public void testNuevaCancelacionReserva() throws ParseException {
        System.out.println("nuevaCancelacionReserva");
        String DNI = "12345670h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2014 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        instance.getRegistroReservas().registrarReserva(res);
        try {
            instance.nuevaCancelacionReserva(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of nuevaCancelacionReserva method, of class Club.
     * El socio no tiene una reserva activa.
     */
    @Test
    public void testNuevaCancelacionReserva2() throws ParseException {
        System.out.println("nuevaCancelacionReserva2");
        String DNI = "12345679h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2012 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        instance.getRegistroReservas().registrarReserva(res);
        try {
            instance.nuevaCancelacionReserva(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of nuevaCancelacionReserva method, of class Club.
     * Se realiza la cancelación
     */
    @Test
    public void testNuevaCancelacionReserva3() throws Exception {
        System.out.println("nuevaCancelacionReserva3");
        String DNI = "12345679h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2014 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        instance.getRegistroReservas().registrarReserva(res);
        Reserva result = instance.nuevaCancelacionReserva(DNI);
        assertEquals(res, result);
    }

    /**
     * Test of nuevaDevolucionMaterial method, of class Club.
     * Excepción, socio no existe
     */
    @Test
    public void testNuevaDevolucionMaterial() throws ParseException {
        System.out.println("nuevaDevolucionMaterial");
        String DNI = "12345670h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2014 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        Alquiler alq = new Alquiler(res);
        instance.getRegistroAlquileres().registrarAlquiler(alq);
        instance.getRegistroReservas().registrarReserva(res);
        try {
            instance.nuevaDevolucionMaterial(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of nuevaDevolucionMaterial method, of class Club.
     * Excepción, socio no tiene alquiler
     */
    @Test
    public void testNuevaDevolucionMaterial2() throws ParseException {
        System.out.println("nuevaDevolucionMaterial2");
        String DNI = "12345679h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        try {
            instance.nuevaDevolucionMaterial(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of nuevaDevolucionMaterial method, of class Club.
     * Excepción, el socio tiene alquiler devuelto.
     */
    @Test
    public void testNuevaDevolucionMaterial3() throws ParseException {
        System.out.println("nuevaDevolucionMaterial3");
        String DNI = "12345679h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2014 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        Alquiler alq = new Alquiler(res, new ArrayList<Material>(), true);
        instance.getRegistroAlquileres().registrarAlquiler(alq);
        instance.getRegistroReservas().registrarReserva(res);
        try {
            instance.nuevaDevolucionMaterial(DNI);
            fail("No ha llegado a la excepción");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of nuevaDevolucionMaterial method, of class Club.
     * Se devuelve el material
     */
    @Test
    public void testNuevaDevolucionMaterial4() throws Exception {
        System.out.println("nuevaDevolucionMaterial4");
        String DNI = "12345679h";
        Club instance = new Club();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Socio soc2 = new Socio("12345679H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2014 16:00"), soc2, new Instalacion(null));
        instance.getRegistroSocios().registrarSocio(soc1);
        instance.getRegistroSocios().registrarSocio(soc2);
        Instalacion inst = new Instalacion(new DescripcionInstalacion("", 1.0, ""));
        Alquiler alq = new Alquiler(res);
        instance.getRegistroAlquileres().registrarAlquiler(alq);
        instance.getRegistroReservas().registrarReserva(res);
        Alquiler result = instance.nuevaDevolucionMaterial(DNI);
        assertEquals(alq, result);
    }

    /**
     * Test of validarDNI method, of class Club.
     * No tiene longiutd 9
     */
    @Test
    public void testValidarDNI() {
        System.out.println("validarDNI");
        String DNI = "12";
        Club instance = new Club();
        boolean expResult = false;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarDNI method, of class Club.
     * No tiene numeros
     */
    @Test
    public void testValidarDNI2() {
        System.out.println("validarDNI");
        String DNI = "abcdefghi";
        Club instance = new Club();
        boolean expResult = false;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarDNI method, of class Club.
     * No tiene letra en el último caracter
     */
    @Test
    public void testValidarDNI3() {
        System.out.println("validarDNI3");
        String DNI = "123456789";
        Club instance = new Club();
        boolean expResult = false;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
    }

    /**
     * Test of validarDNI method, of class Club.
     * Válido
     */
    @Test
    public void testValidarDNI4() {
        System.out.println("validarDNI4");
        String DNI = "12345678k";
        Club instance = new Club();
        boolean expResult = true;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmail method, of class Club.
     * No tiene nada tras el @
     */
    @Test
    public void testIsEmail() {
        System.out.println("isEmail");
        String correo = "hola@";
        Club instance = new Club();
        boolean expResult = false;
        boolean result = instance.isEmail(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmail method, of class Club.
     * No tiene punto tras @
     */
    @Test
    public void testIsEmail2() {
        System.out.println("isEmail2");
        String correo = "hola@ñhj";
        Club instance = new Club();
        boolean expResult = false;
        boolean result = instance.isEmail(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmail method, of class Club.
     * Correo válido
     */
    @Test
    public void testIsEmail3() {
        System.out.println("isEmail3");
        String correo = "hola@upo.com";
        Club instance = new Club();
        boolean expResult = true;
        boolean result = instance.isEmail(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDataRes method, of class Club.
     * No está en el formato correcto
     */
    @Test
    public void testIsDateRes() {
        System.out.println("isDateRes");
        String fecha = "12-100";
        Club instance = new Club();
        Date expResult = null;
        Date result = instance.isDateRes(fecha);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDataRes method, of class Club.
     * Fecha correcta
     */
    @Test
    public void testIsDateRes2() throws ParseException {
        System.out.println("isDateRes2");
        String fecha = "12-10-1992 13:00";
        Club instance = new Club();
        Date expResult = new SimpleDateFormat("dd-MM-yyyy HH:00").parse(fecha);
        Date result = instance.isDateRes(fecha);
        assertEquals(expResult, result);
    }

    /**
     * Test of isMovil method, of class Club.
     * No tiene numeros
     */
    @Test
    public void testIsMovil() throws ParseException {
        System.out.println("isMovil");
        String movil = "12-10-199";
        Club instance = new Club();
        int expResult = 0;
        int result = instance.isMovil(movil);
        assertEquals(expResult, result);
    }

    /**
     * Test of isMovil method, of class Club.
     * No tiene longitud 9
     */
    @Test
    public void testIsMovil2() throws ParseException {
        System.out.println("isMovil2");
        String movil = "12-10";
        Club instance = new Club();
        int expResult = 0;
        int result = instance.isMovil(movil);
        assertEquals(expResult, result);
    }

    /**
     * Test of isMovil method, of class Club.
     * Móvil correcto
     */
    @Test
    public void testIsMovil3() throws ParseException {
        System.out.println("isMovil3");
        String movil = "123456789";
        Club instance = new Club();
        int expResult = 123456789;
        int result = instance.isMovil(movil);
        assertEquals(expResult, result);
    }
}
