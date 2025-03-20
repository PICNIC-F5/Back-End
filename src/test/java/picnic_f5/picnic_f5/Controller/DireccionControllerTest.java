package picnic_f5.picnic_f5.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import picnic_f5.picnic_f5.model.Direccion;
import picnic_f5.picnic_f5.repository.DireccionRepository;

public class DireccionControllerTest {
    @InjectMocks
    private DireccionController direccionController;

    @Mock
    private DireccionRepository direccionRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateDireccion() {

        Direccion direccion = new Direccion();
        direccion.setNombre("Montaña");
        direccion.setDireccion("Picos de Europa");
        direccion.setPrecio(100.00);

        when(direccionRepository.save(any(Direccion.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Direccion result = direccionController.createDireccion(direccion);
        assertEquals("Montaña", result.getNombre());
        verify(direccionRepository, times(1)).save(any(Direccion.class));

    }

    @Test
    void testDeleteDireccion() {

    }

    @Test
    void testGetAllDirecciones() {

    }

    @Test
    void testUpdateDireccion() {

        Long id = 1L;
        Direccion direccionExistente = new Direccion();
        direccionExistente.setId(id);
        direccionExistente.setNombre("Playa");
        direccionExistente.setDireccion("Costa de la muerte");
        direccionExistente.setPrecio(200.00);

        Direccion detallesDireccion = new Direccion();
        detallesDireccion.setNombre("Nueva Playa");
        detallesDireccion.setDireccion("Nueva Costa");
        detallesDireccion.setPrecio(259.00);

        when(direccionRepository.findById(id)).thenReturn(Optional.of(direccionExistente));
        when(direccionRepository.save(any(Direccion.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Direccion result = direccionController.updateDireccion(id, detallesDireccion);

        assertEquals("Nueva Playa", result.getNombre());
        assertEquals("Nueva Costa", result.getDireccion());
        assertEquals(250.00, result.getPrecio());
        verify(direccionRepository, times(1)).findById(id);
        verify(direccionRepository, times(1)).save(any(Direccion.class));
    }
}
