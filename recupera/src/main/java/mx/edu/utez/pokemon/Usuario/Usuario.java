package mx.edu.utez.pokemon.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.Viajes.Viajes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    @Column(nullable = false,length = 150)
    private String name;

    @Column(nullable = false, length =150)
    private String correo;

    @Column(nullable = false, length = 150)
    private String fecha_nac;
    //@Column(name = "equipo",nullable = false,length = 150)
    //private String equipo;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Viajes> pokemons;
}
