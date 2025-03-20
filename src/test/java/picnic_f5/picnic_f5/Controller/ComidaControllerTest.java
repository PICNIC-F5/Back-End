package picnic_f5.picnic_f5.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import picnic_f5.picnic_f5.model.Comida;
import picnic_f5.picnic_f5.repository.ComidaRepository;

public class ComidaControllerTest {

    @InjectMocks
    private ComidaController comidaController;

    @Mock
    private ComidaRepository comidaRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateComida() {
        Comida comida = new Comida();
        comida.setNombre("Hot Dog");
        comida.setPrecio(13.41);

        when(comidaRepository.save(any(Comida.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Comida result = comidaController.createComida(comida);
        assertEquals("Hot Dog", result.getNombre());
        verify(comidaRepository, times(1)).save(any(Comida.class));
    }

    @Test
    void testDeleteComida() {

    }

    @Test
    void testGetAllComidas() {
    Comida comida1 = new Comida();
    comida1.setId(1L);
    comida1.setNombre("Hamburguesa");
    comida1.setPrecio(13.75);

    Comida comida2 = new Comida();
    comida2.setId(2L);
    comida2.setNombre("Pizza");
    comida2.setPrecio(23.85);

    when(comidaRepository.findAll()).thenReturn(Arrays.asList(comida1, comida2));
    List<Comida> result = comidaController.getAllComidas();
    assertEquals(2, result.size());
    assertEquals("Hamburguesa", result.get(0).getNombre());
    verify(comidaRepository, times(1)).findAll();
}
    @Test
    void testUpdateComida() {

    }
}
