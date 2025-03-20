package picnic_f5.picnic_f5.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Direccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private double precio;
}
