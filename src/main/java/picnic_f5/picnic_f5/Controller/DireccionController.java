package picnic_f5.picnic_f5.Controller;

import org.springframework.web.bind.annotation.*;
import picnic_f5.picnic_f5.model.Direccion;
import picnic_f5.picnic_f5.repository.DireccionRepository;
import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {
    private DireccionRepository direccionrepository;

    @GetMapping
    public List<Direccion> getAllDirecciones(){
        return direccionrepository.findAll();
    }
 
    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        return direccionrepository.save(direccion);
    }
    
    @PutMapping("/{id}")
    public Direccion updateDireccion(@PathVariable Long id, @RequestBody Direccion detallesDireccion) {
    return direccionrepository.findById(id)
    .map(direccion -> {
        direccion.setNombre(detallesDireccion.getNombre());
        direccion.setDireccion(detallesDireccion.getDireccion());
        direccion.setPrecio(detallesDireccion.getPrecio());
        return direccionrepository.save(direccion);
    }).orElseThrow(() -> new RuntimeException("Direccion no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deleteDireccion(@PathVariable Long id) {
        direccionrepository.deleteById(id);
    }


}
