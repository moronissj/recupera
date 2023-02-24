package mx.edu.utez.pokemon.Service.Viaje;


import mx.edu.utez.pokemon.Viajes.Viajes;
import mx.edu.utez.pokemon.Viajes.ReposityViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class ViajeService {
    @Autowired
    private ReposityViaje repository_v;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Viajes>> getAll(){
        return new ResponseEntity<>(this.repository_v.findAll(),HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity<Object>(this.repository_v.findById(id), HttpStatus.OK);
    }

    @Transactional
        public Viajes saveViaje(Viajes viaje)
        {
            return repository_v.save(viaje);
        }

        @Transactional
        public Viajes
        updateViaje(Viajes viaje,
                   Long Id)
        {
            Viajes depDB
                    = repository_v.findById(Id)
                    .get();

            if (Objects.nonNull(viaje.getFecha_salida())
                    && !"".equalsIgnoreCase(
                    viaje.getFecha_salida())) {
                depDB.setFecha_salida(
                        viaje.getFecha_salida());
            }

            if (Objects.nonNull(
                    viaje.getFecha_regreso())
                    && !"".equalsIgnoreCase(
                    viaje.getFecha_regreso())) {
                depDB.setFecha_regreso(
                        viaje.getFecha_regreso());
            }
            return repository_v.save(depDB);
        }

        // Delete operation
        @Transactional
        public void deleteById(Long Id)
        {
            repository_v.deleteById(Id);
        }

    }

