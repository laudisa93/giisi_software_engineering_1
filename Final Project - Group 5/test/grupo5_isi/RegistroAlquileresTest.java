/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo5_isi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author francisco
 */
public class RegistroAlquileresTest {
    
    public RegistroAlquileresTest() {
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
     * Test of registrarAlquiler method, of class RegistroAlquileres.
     */
    @Test
    public void testRegistrarAlquiler() throws ParseException {
        System.out.println("registrarAlquiler");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(formatoFecha2.parse("10-01-2013 16:00"), soc1, new Instalacion(null));
        RegistroAlquileres instance = new RegistroAlquileres();
        Alquiler alq=new Alquiler(res);
        instance.registrarAlquiler(alq);
        Alquiler expResult=instance.tieneAlquiler(soc1);
        assertEquals(expResult, alq);
    }

    /**
     * Test of crearNuevaAlquiler method, of class RegistroAlquileres.
     */
    @Test
    public void testCrearNuevaAlquiler() throws ParseException {
        System.out.println("crearNuevaAlquiler");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(formatoFecha2.parse("10-01-2013 16:00"), soc1, new Instalacion(null));
        RegistroAlquileres instance = new RegistroAlquileres();
        Alquiler alq=new Alquiler(res);
        Alquiler expResult=alq;
        Alquiler result = instance.crearNuevaAlquiler(res);
        assertEquals(expResult, result);
    }

    /**
     * Test of devolverAlquiler method, of class RegistroAlquileres.
     */
    @Test
    public void testDevolverAlquiler() throws ParseException {
        System.out.println("devolverAlquiler");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(formatoFecha2.parse("10-01-2013 16:00"), soc1, new Instalacion(null));
        Alquiler alq = new Alquiler(res);
        RegistroAlquileres instance = new RegistroAlquileres();
        instance.devolverAlquiler(alq);
        boolean expResult=true;
        assertEquals(expResult, alq.isDevuelto());
    }

    /**
     * Test of tieneAlquiler method, of class RegistroAlquileres.
     */
    @Test
    public void testTieneAlquiler() throws ParseException {
        System.out.println("tieneAlquiler");
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(formatoFecha2.parse("10-01-2013 16:00"), soc1, new Instalacion(null));
        Alquiler alq = new Alquiler(res);
        RegistroAlquileres instance = new RegistroAlquileres();
        instance.registrarAlquiler(alq);
        Alquiler expResult = alq;
        Alquiler result = instance.tieneAlquiler(soc1);
        assertEquals(expResult, result);
    }
}
