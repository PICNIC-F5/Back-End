package picnic_f5.picnic_f5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import picnic_f5.picnic_f5.model.Comida;

public interface ComidaRepository extends JpaRepository<Comida, Long> {
}
