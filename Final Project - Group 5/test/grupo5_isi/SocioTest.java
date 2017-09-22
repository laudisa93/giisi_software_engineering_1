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
public class SocioTest {

    public SocioTest() {
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
     * Test of getDNI method, of class Socio.
     */
    @Test
    public void testGetDNI() throws ParseException {
        System.out.println("getDNI");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        String expResult = "12345678H";
        String result = soc.getDNI();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFechaBaja method, of class Socio.
     */
    @Test
    public void testGetFechaBaja() throws ParseException {
        System.out.println("getFechaBaja");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Date expResult = null;
        Date result = soc.getFechaBaja();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Socio.
     */
    @Test
    public void testGetNombre() throws ParseException {
        System.out.println("getNombre");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        String expResult = "nombre";
        String result = soc.getNombre();
        assertEquals(expResult, result);

    }

    /**
     * Test of getApellidos method, of class Socio.
     */
    @Test
    public void testGetApellidos() throws ParseException {
        System.out.println("getApellidos");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        String expResult = "apellidos";
        String result = soc.getApellidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMovil method, of class Socio.
     */
    @Test
    public void testGetMovil() throws ParseException {
        System.out.println("getMovil");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        int expResult = 123456789;
        int result = soc.getMovil();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCorreo method, of class Socio.
     */
    @Test
    public void testGetCorreo() throws ParseException {
        System.out.println("getCorreo");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        String expResult = "correo";
        String result = soc.getCorreo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFechaAlta method, of class Socio.
     */
    @Test
    public void testGetFechaAlta() throws ParseException {
        System.out.println("getFechaAlta");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Date expResult = formatoFecha.parse("01-01-2013");
        Date result = soc.getFechaAlta();
        assertEquals(expResult, result);
    }

    /**
     * Test of darAltaSocioExistente method, of class Socio.
     */
    @Test
    public void testDarAltaSocioExistente() throws ParseException {
        System.out.println("darAltaSocioExistente");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        soc.darAltaSocioExistente();
        Date expResult1 = new Date();
        Date expResult2 = null;
        assertEquals(expResult1, soc.getFechaAlta());
        assertEquals(expResult2, soc.getFechaBaja());
    }

    /**
     * Test of introducirDatos method, of class Socio.
     */
    @Test
    public void testIntroducirDatos() {
        System.out.println("introducirDatos");
        String DNI = "12345678h";
        String nombre = "nombre";
        String apellidos = "apellidos";
        int movil = 661122334;
        String correo = "correo";
        Socio instance = new Socio();
        instance.introducirDatos(DNI, nombre, apellidos, movil, correo);
        assertEquals(DNI, instance.getDNI());
        assertEquals(nombre, instance.getNombre());
        assertEquals(apellidos, instance.getApellidos());
        assertEquals(movil, instance.getMovil());
        assertEquals(correo, instance.getCorreo());
    }

    /**
     * Test of darBaja method, of class Socio.
     */
    @Test
    public void testDarBaja() throws ParseException {
        System.out.println("darBaja");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        soc.darBaja();
        assertEquals(new Date(), soc.getFechaBaja());
    }

    /**
     * Test of toString method, of class Socio.
     */
    @Test
    public void testToString() throws ParseException {
        System.out.println("toString");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        String expResult = "\nnombre apellidos\nDNI: 12345678H\nMovil: 123456789\nCorreo: correo\nFechaAlta: 01-01-2013\nFechaBaja: No está dado de baja\n";
        String result = soc.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of escribirFichero method, of class Socio.
     */
    @Test
    public void testEscribirFichero() throws ParseException {
        System.out.println("escribirFichero");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        String expResult = "12345678H/nombre/apellidos/123456789/correo/01-01-2013/null\n";
        String result = soc.escribirFichero();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Socio.
     */
    @Test
    public void testEquals() throws ParseException {
        System.out.println("equals");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Object obj = new Socio("12345678H", "nombre2", "apellidos1", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        boolean expResult = true;
        boolean result = soc.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() throws ParseException {
        System.out.println("equals(no es igual)");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Object obj = new Socio("12345679H", "nombre2", "apellidos1", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        boolean expResult = false;
        boolean result = soc.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() throws ParseException {
        System.out.println("equals(socio nulo)");
        Object obj = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        boolean expResult = false;
        boolean result = soc.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals4() throws ParseException {
        System.out.println("equals(socio nulo)");
        Object obj = new Reserva(new Socio());
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        boolean expResult = false;
        boolean result = soc.equals(obj);
        assertEquals(expResult, result);
    }
}
