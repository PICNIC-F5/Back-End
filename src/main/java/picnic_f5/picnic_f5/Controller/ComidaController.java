package picnic_f5.picnic_f5.Controller;

import java.util.List;
import picnic_f5.picnic_f5.model.Comida;
import picnic_f5.picnic_f5.repository.ComidaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comidas")
public class ComidaController {

    private ComidaRepository comidaRepository;

    @GetMapping
    public List<Comida> getAllComidas(){
        return comidaRepository.findAll();
    }

    @PostMapping
    public Comida createComida(@RequestBody Comida comida) {
        return comidaRepository.save(comida);
    }

    @PutMapping("/{id}")
    public Comida updateComida(@PathVariable Long id, @RequestBody Comida detallesComida) {
        return comidaRepository.findById(id)
        .map(comida -> {
            comida.setNombre(detallesComida.getNombre());
            comida.setPrecio(detallesComida.getPrecio());
            return comidaRepository.save(comida);
        }).orElseThrow(() -> new RuntimeException("Comida no encontrada"));
    }
    @DeleteMapping("/{id}")
    public void deleteComida(@PathVariable Long id) {
        comidaRepository.deleteById(id);
    }


}
