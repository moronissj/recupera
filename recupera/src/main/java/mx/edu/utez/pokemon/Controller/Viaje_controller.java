package mx.edu.utez.pokemon.Controller;

import mx.edu.utez.pokemon.Viajes.Viajes;
import mx.edu.utez.pokemon.Service.Viaje.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-pokemon/viajes")
@CrossOrigin(origins = {"*"})

public class Viaje_controller {
    @Autowired
    private ViajeService service;


    @GetMapping("/")
    public ResponseEntity<List<Viajes>> getAll(){
        return this.service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public Viajes saveViaje(
            @Valid @RequestBody Viajes viaje)
    {
        return service.saveViaje(viaje);
    }
    @PutMapping("/{id}")
    public Viajes
    updateViaje(@RequestBody Viajes viaje,
           @PathVariable("id") Long Id)
    {
        return service.updateViaje(
                viaje, Id);
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
