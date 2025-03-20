package picnic_f5.picnic_f5.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
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

    }

    @Test
    void testDeleteDireccion() {

    }

    @Test
    void testGetAllDirecciones() {

    }

    @Test
    void testUpdateDireccion() {

    }
}
