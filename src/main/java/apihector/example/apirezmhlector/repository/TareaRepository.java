package apihector.example.apirezmhlector.repository;
import apihector.example.apirezmhlector.FUNCION.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface TareaRepository extends MongoRepository<Tarea, String> {
    List<Tarea> findByTitulo(String titulo);

    List<Tarea> findByFechaEntrega(Date fechaEntrega);

}
