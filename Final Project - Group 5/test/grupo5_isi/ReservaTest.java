/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class ReservaTest {

    public ReservaTest() {
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
     * Test of setFecha method, of class Reserva.
     */
    @Test
    public void testSetFecha() throws ParseException {
        System.out.println("setFecha");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Date fecha = new Date();
        Reserva instance = new Reserva(soc);
        instance.setFecha(fecha);
        assertEquals(fecha, instance.getFecha());
    }

    /**
     * Test of setInst method, of class Reserva.
     */
    @Test
    public void testSetInst() throws ParseException {
        System.out.println("setInst");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Instalacion inst = new Instalacion(null);
        Instalacion instEsp = inst;
        Reserva instance = new Reserva(soc);
        instance.setInst(inst);
        assertEquals(instEsp, instance.getInst());
    }

    /**
     * Test of getSocio method, of class Reserva.
     */
    @Test
    public void testGetSocio() throws ParseException {
        System.out.println("getSocio");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva instance = new Reserva(soc);
        Socio expResult = soc;
        Socio result = instance.getSocio();
        assertEquals(expResult, result);
    }

    /**
     * Test of escribirFichero method, of class Reserva.
     */
    @Test
    public void testEscribirFichero() throws ParseException {
        System.out.println("escribirFichero");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva instance = new Reserva(formatoFecha2.parse("01-01-2013 19:00"), soc, new Instalacion(new DescripcionInstalacion("", 7.0, "inst01")));
        String expResult = "12345678H/inst01/01-01-2013 19:00\n";
        String result = instance.escribirFichero();
        assertEquals(expResult, result);
    }

    /**
     * Test of escribirFichero2 method, of class Reserva.
     */
    @Test
    public void testEscribirFichero2() throws ParseException {
        System.out.println("escribirFichero2");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva instance = new Reserva(formatoFecha2.parse("01-01-2013 19:00"), soc, new Instalacion(new DescripcionInstalacion("", 7.0, "inst01")));
        String expResult = "12345678H/inst01/01-01-2013 19:00";
        String result = instance.escribirFichero2();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Reserva.
     */
    @Test
    public void testToString() throws ParseException {
        System.out.println("toString");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva instance = new Reserva(formatoFecha2.parse("01-01-2013 19:00"), soc, new Instalacion(new DescripcionInstalacion("", 7.0, "inst01")));
        String expResult = "Pista: inst01 el dia 01-01-2013 19:00";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
