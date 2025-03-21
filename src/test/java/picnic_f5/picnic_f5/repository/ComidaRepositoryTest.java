package picnic_f5.picnic_f5.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import picnic_f5.picnic_f5.model.Comida;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ComidaRepositoryTest {

    @Autowired
    private ComidaRepository comidaRepository;
    private Comida comida;

    @BeforeEach
    void setup(){
        comidaRepository.deleteAll();
        comida = new Comida();
        comida.setNombre("Hamburguesa");
        comida.setPrecio(13.75);
    }

    @Test
    void testSaveComida() {
        Comida savedComida = comidaRepository.save(comida);
        assertNotNull(savedComida.getId());
        assertEquals("Hamburguesa", savedComida.getNombre());
        assertEquals(13.75, savedComida.getPrecio());
    }

    @Test
    void testFindAllComidas(){
        comidaRepository.save(comida);
        List<Comida> comidas = comidaRepository.findAll();

        assertFalse(comidas.isEmpty());
        assertEquals(1, comidas.size());
        assertEquals("Hamburguesa", comidas.get(0).getNombre());
    }

    @Test
    void testFindById(){
        Comida savedComida = comidaRepository.save(comida);
        Optional<Comida> foundComida = comidaRepository.findById(savedComida.getId());

        assertTrue(foundComida.isPresent());
        assertEquals("Hamburguesa", foundComida.get().getNombre());
    }

    @Test
    void testDeleteComida(){
        Comida savedComida = comidaRepository.save(comida);
        comidaRepository.deleteById(savedComida.getId());
        Optional<Comida> deleteComida = comidaRepository.findById(savedComida.getId());
        assertFalse(deleteComida.isPresent());
    }
}
