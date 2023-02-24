package mx.edu.utez.pokemon.Service.Destin;


import mx.edu.utez.pokemon.Destinos.Destinos;
import mx.edu.utez.pokemon.Destinos.DestinosRepository;
import mx.edu.utez.pokemon.Usuario.Usuario;
import mx.edu.utez.pokemon.Usuario.UsuarioReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DestinoService {
    @Autowired
    private DestinosRepository repository_u;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Destinos>> getAll(){
        return new ResponseEntity<>(this.repository_u.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity(this.repository_u.findById(id),HttpStatus.OK);
    }
}
