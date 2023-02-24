package mx.edu.utez.pokemon.Viajes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposityViaje extends JpaRepository<Viajes,Long> {

        }
