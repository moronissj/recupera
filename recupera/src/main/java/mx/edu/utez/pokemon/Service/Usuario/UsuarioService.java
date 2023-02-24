package mx.edu.utez.pokemon.Service.Usuario;

import mx.edu.utez.pokemon.Usuario.Usuario;
import mx.edu.utez.pokemon.Usuario.UsuarioReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class UsuarioService {
    @Autowired
    private UsuarioReposity repository_u;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Usuario>> getAll(){
        return new ResponseEntity<>(this.repository_u.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity(this.repository_u.findById(id),HttpStatus.OK);
    }
    @Transactional
    public Usuario saveUsuario(Usuario usuario)
    {
        return repository_u.save(usuario);
    }

    @Transactional
    public Usuario
    updateUsuario(Usuario usuario,
                     Long Id)
    {
        Usuario depDB
                = repository_u.findById(Id)
                .get();

        if (Objects.nonNull(usuario.getName())
                && !"".equalsIgnoreCase(
                usuario.getName())) {
            depDB.setName(
                    usuario.getName());
        }

        if (Objects.nonNull(
                usuario.getCorreo())
                && !"".equalsIgnoreCase(
                usuario.getCorreo())) {
            depDB.setCorreo(
                    usuario.getCorreo());
        }

        if (Objects.nonNull(
                usuario.getFecha_nac())
                && !"".equalsIgnoreCase(
                usuario.getFecha_nac())) {
            depDB.setFecha_nac(
                    usuario.getFecha_nac());
        }


        return repository_u.save(depDB);
    }

    // Delete operation
    @Transactional
    public void deleteById(Long Id)
    {
        repository_u.deleteById(Id);
    }
}
