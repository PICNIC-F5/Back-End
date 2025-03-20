package picnic_f5.picnic_f5.model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class ComidaTest {

    @Test
    void testGettersAndSetters() {

        Comida comida = new Comida();
        comida.setId(1L);
        comida.setNombre("Hamburguesa");
        comida.setPrecio(13.75);
    
        assertEquals(1L, comida.getId());
        assertEquals("Hamburguesa", comida.getNombre());
        assertEquals(13.75, comida.getPrecio());

    }

    @Test
    void testNoArgsContructor(){
        Comida comida  = new Comida();
        assertNull(comida.getId());
        assertNull(comida.getNombre());
        assertEquals(0.0, comida.getPrecio());
    }
}
