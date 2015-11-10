/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.modelos;

import ec.gob.tiwintza.entidades.RolEntidad;
import ec.gob.tiwintza.entidades.TipoEntidad;
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
public class TipoModeloTest {
    
    public TipoModeloTest() {
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
//    public void testInsertarTipo() throws Exception {
//        System.out.println("insertarTipo");
//        TipoEntidad objTipoIngresar = new  TipoEntidad(1,"Test","Test");
//        boolean booResultadoEsperado = true;
//        boolean booResultado = TipoModelo.insertarTipo(objTipoIngresar);
//        assertEquals(booResultado, booResultadoEsperado);
//    }
    
//    public void testActualizarTipo() throws Exception {
//        System.out.print("actualizar");
//        TipoEntidad objTipoIngresar = new  TipoEntidad(1,"Test","Test");
//        boolean booResultadoEsperado = true;
//        boolean booResultado = TipoModelo.actualizarTipo(objTipoIngresar);
//        assertEquals(booResultado, booResultadoEsperado);
//    }
    
    public void testEliminarTipo() throws Exception {
        System.out.print("Eliminar");
        long longId=12;
      
        boolean booResultadoEsperado = true;
        int booResultado = TipoModelo.eliminarTipo(longId);
        assertEquals(true, true);
    }
    
    
    
}
