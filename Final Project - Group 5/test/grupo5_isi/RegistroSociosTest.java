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
public class RegistroSociosTest {
    
    public RegistroSociosTest() {
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
     * Test of registrarSocio method, of class RegistroSocios.
     */
    @Test
    public void testRegistrarSocio() throws ParseException {
        System.out.println("registrarSocio");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);;
        RegistroSocios instance = new RegistroSocios();
        instance.registrarSocio(soc);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of crearNuevoSocio method, of class RegistroSocios.
     */
    @Test
    public void testCrearNuevoSocio() throws ParseException {
        System.out.println("crearNuevoSocio");
        RegistroSocios instance = new RegistroSocios();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio expResult = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        Socio result = instance.crearNuevoSocio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of introducirDatos method, of class RegistroSocios.
     */
    @Test
    public void testIntroducirDatos() {
        System.out.println("introducirDatos");
        Socio soc = new Socio();
        String DNI = "12345678H";
        String nombre = "nombre";
        String apellidos = "apellidos";
        int movil = 660047716;
        String correo = "correo@yahoo.es";
        RegistroSocios instance = new RegistroSocios();
        instance.introducirDatos(soc, DNI, nombre, apellidos, movil, correo);
        assertEquals(soc.getDNI(),DNI);
        assertEquals(soc.getNombre(),nombre);
        assertEquals(soc.getApellidos(),apellidos);
        assertEquals(soc.getMovil(),movil);
        assertEquals(soc.getCorreo(),correo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarSocio method, of class RegistroSocios.
     */
    @Test
    public void testBuscarSocio() throws ParseException {
        System.out.println("buscarSocio");
        String DNI = "12345678H";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Socio soc2 = new Socio("12345678H", "nombre", "apellidos", 123456789, "correo", formatoFecha.parse("01-01-2013"), null);
        RegistroSocios instance = new RegistroSocios();
        Socio expResult = soc2;
        instance.registrarSocio(soc2);
        Socio result = instance.buscarSocio(DNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
