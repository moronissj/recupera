package mx.edu.utez.pokemon.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioReposity extends JpaRepository<Usuario,Long> {
}
