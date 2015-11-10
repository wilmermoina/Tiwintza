/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.modelos;

import ec.gob.tiwintza.entidades.RolEntidad;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eborja
 */
public class RolModeloTest {
    
    public RolModeloTest() {
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
     * Test of insertarRol method, of class RolModelo.
     * @throws java.lang.Exception
     */
    @Test
    public void testInsertarRol() throws Exception {
        System.out.println("insertar Rol");
        RolEntidad objRolIngresar = new RolEntidad("Test");
        boolean booResultadoEsperado = true;
        boolean booResultado = RolModelo.insertarRol(objRolIngresar);
        assertEquals(booResultado, booResultadoEsperado);
    }
    
    @Test
    public void testEliminarRol() throws Exception{
        System.out.println("Eliminar Rol");
        int intResultadoNoEsperado=1;
        int intResultado= RolModelo.eliminarRol(12);
        assertNotSame(intResultado, intResultadoNoEsperado);
    }
    
    @Test
    public void testActualizarRol() throws Exception{
        System.out.println("Actualizar Rol");
        RolEntidad objR=new RolEntidad(13, "Administrador test");
        int intResultadoNoEsperado=1;
        int intResultado= RolModelo.actualizarRol(objR);
        assertNotSame(intResultado, intResultadoNoEsperado);
    }
}
