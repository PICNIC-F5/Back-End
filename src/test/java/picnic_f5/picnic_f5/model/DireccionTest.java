package picnic_f5.picnic_f5.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class DireccionTest {
    @Test
    void testGettersAndeSetters() {
        Direccion direccion = new Direccion();
        direccion.setId(1L);
        direccion.setNombre("Montaña");
        direccion.setDireccion("Picos de Europa");
        direccion.setPrecio(100.00);;

        assertEquals(1L, direccion.getId());
        assertEquals("Montaña", direccion.getNombre());
        assertEquals("Picos de Europa", direccion.getDireccion());
        assertEquals(100.00, direccion.getPrecio());
    }

    @Test
    void testNoArgsContructor(){

        Direccion direccion = new Direccion();

        assertNull(direccion.getId());
        assertNull(direccion.getNombre());
        assertNull(direccion.getDireccion());
        assertEquals(0.0, direccion.getPrecio());
    }
}
