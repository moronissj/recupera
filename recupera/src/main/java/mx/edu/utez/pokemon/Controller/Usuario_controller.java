package mx.edu.utez.pokemon.Controller;

import mx.edu.utez.pokemon.Usuario.Usuario;
import mx.edu.utez.pokemon.Service.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-pokemon/usuarios")
@CrossOrigin(origins = {"*"})
public class Usuario_controller {
    @Autowired
    private UsuarioService service;
    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public Usuario saveUsuario(
            @Valid @RequestBody Usuario usuario)
    {
        return service.saveUsuario(usuario);
    }
    @PutMapping("/{id}")
    public Usuario
    update(@RequestBody Usuario usuario,
                     @PathVariable("id") Long Id)
    {
        return service.updateUsuario(
                usuario, Id);
    }
    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id")
                                       Long Id)
    {
        service.deleteById(
                Id);
        return "Deleted Successfully";
    }


}
