package mx.edu.utez.pokemon.Viajes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.Destinos.Destinos;
import mx.edu.utez.pokemon.Usuario.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "viajes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_viajes;
    @Column(name = "fecha_salida",nullable = false, unique = true, length = 150)
    private String fecha_salida;
    @Column(name = "fecha_regreso", nullable = false, length = 150)
    private String fecha_regreso;




    @ManyToOne
    @JoinColumn(name = "id_destinos", nullable = false)
    @JsonIgnore
    private Destinos destinos;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

}
