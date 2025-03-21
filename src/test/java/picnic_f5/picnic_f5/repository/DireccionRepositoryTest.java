package picnic_f5.picnic_f5.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import picnic_f5.picnic_f5.model.Direccion;

@DataJpaTest
public class DireccionRepositoryTest {

    @Autowired
    private DireccionRepository direccionRepository;

    private Direccion direccion;

   @BeforeEach
    void setUp() {
        direccionRepository.deleteAll();
        direccion = new Direccion();
        direccion.setNombre("Montaña");
        direccion.setDireccion("Picos de Europa");
        direccion.setPrecio(100.00);
    }
    @Test
    void testSaveComida() {
        Direccion savedDireccion = direccionRepository.save(direccion);
        assertNotNull(savedDireccion.getId());
        assertEquals("Montaña", savedDireccion.getNombre());
        assertEquals("Picos de Europa", savedDireccion.getDireccion());
        assertEquals(100.00, savedDireccion.getPrecio());
    }

    @Test
    void testFindAllDirecciones() {
        direccionRepository.save(direccion);
        List<Direccion> direcciones = direccionRepository.findAll();

        assertFalse(direcciones.isEmpty());
        assertEquals(1, direcciones.size());
        assertEquals("Montaña", direcciones.get(0).getNombre());
    }

    @Test
    void testFindById() {
        Direccion savedDireccion = direccionRepository.save(direccion);
        Optional<Direccion> foundDireccion = direccionRepository.findById(savedDireccion.getId());
       
        assertTrue(foundDireccion.isPresent());
        assertEquals("Montaña", foundDireccion.get().getNombre());
    
    }

    @Test
    void testDeleteDireccion() {
        Direccion savedDireccion = direccionRepository.save(direccion);
        direccionRepository.deleteById(savedDireccion.getId());
        Optional<Direccion> deletedDireccion = direccionRepository.findById(savedDireccion.getId());
        assertFalse(deletedDireccion.isPresent());
    }
}
