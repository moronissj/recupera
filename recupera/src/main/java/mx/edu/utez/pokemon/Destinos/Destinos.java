package mx.edu.utez.pokemon.Destinos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.Viajes.Viajes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Destinos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_destinos;
    @Column(nullable = false,length = 150)
    private String nombre_destino;

    @Column(nullable = false, length =150)
    private String descripcion;

    @Column(nullable = false, length = 150)
    private Double precio;

    @Column(nullable = false, length = 150)
    private Double calificacion;

    @Column(nullable = false, length = 150)
    private Boolean disponibilidad;

}
