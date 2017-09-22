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
 * @author francisco
 */
public class RegistroReservasTest {
    
    public RegistroReservasTest() {
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
     * Test of registrarReserva method, of class RegistroReservas.
     */
    @Test
    public void testRegistrarReserva() throws ParseException {
        System.out.println("registrarReserva");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2014 16:00"), soc1, new Instalacion(null));
        RegistroReservas instance = new RegistroReservas();
        instance.registrarReserva(res);
        Reserva expResult=res;
        Reserva result=instance.tieneReserva(soc1);
    }

    /**
     * Test of cancelarReserva method, of class RegistroReservas.
     */
    @Test
    public void testCancelarReserva() throws ParseException {
        System.out.println("cancelarReserva");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(formatoFecha2.parse("01-01-2014 16:00"), soc1, new Instalacion(null));
        RegistroReservas instance = new RegistroReservas();
        instance.cancelarReserva(res);
        Reserva expResult=null;
        Reserva result=instance.tieneReserva(soc1);
        assertEquals(expResult, result);
    }

    /**
     * Test of crearNuevaReserva method, of class RegistroReservas.
     */
    @Test
    public void testCrearNuevaReserva() throws ParseException {
        System.out.println("crearNuevaReserva");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(soc1);
        RegistroReservas instance = new RegistroReservas();
        Reserva result = instance.crearNuevaReserva(soc1);
        Reserva expResult=res;
        assertEquals(expResult, result);
    }

    /**
     * Test of introducirReserva method, of class RegistroReservas.
     */
    @Test
    public void testIntroducirReserva() throws ParseException {
        System.out.println("introducirReserva");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(soc1);
        RegistroReservas instance = new RegistroReservas();
        Instalacion in1=new Instalacion(null);
        instance.introducirReserva(res, formatoFecha.parse("01-01-2013"), in1);
        Instalacion expResul=res.getInst();
        Instalacion resul=in1;
        assertEquals(expResul, resul);
        Date expResul2 = res.getFecha();
        Date resul2=formatoFecha.parse("01-01-2013");
        assertEquals(expResul2, resul2);
               
    }

    /**
     * Test of buscarReserva method, of class RegistroReservas.
     */
    @Test
    public void testBuscarReserva() throws ParseException {
        System.out.println("buscarReserva");
        System.out.println("introducirReserva");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), formatoFecha.parse("02-01-2013"));
        Reserva res = new Reserva(soc1);
        RegistroReservas instance = new RegistroReservas();
        Instalacion in1=new Instalacion(null);
        instance.introducirReserva(res, formatoFecha.parse("01-01-2013"), in1);
        instance.registrarReserva(res);
        Reserva expResult = res;
        Reserva result = instance.buscarReserva(in1, formatoFecha.parse("01-01-2013"));
        assertEquals(expResult, result);
    }

    /**
     * Test of tieneReserva method, of class RegistroReservas.
     */
    @Test
    public void testTieneReserva() throws ParseException {
        System.out.println("tieneReserva");
        System.out.println("buscarReserva");
        System.out.println("introducirReserva");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Socio soc1 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Reserva res = new Reserva(soc1);
        RegistroReservas instance = new RegistroReservas();
        Instalacion in1=new Instalacion(null);
        instance.introducirReserva(res, formatoFecha.parse("01-08-2013"), in1);
        instance.registrarReserva(res);
        Reserva expResult = res;
        Reserva result = instance.tieneReserva(soc1);
        assertEquals(expResult, result);
    }
}
