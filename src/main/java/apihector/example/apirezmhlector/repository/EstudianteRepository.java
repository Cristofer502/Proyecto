package apihector.example.apirezmhlector.repository;

import apihector.example.apirezmhlector.FUNCION.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByNombre(String nombre);

    List<Estudiante> findByApellido(String apellido);

    @Query("SELECT e FROM Estudiante e WHERE e.nombre = :nombre AND e.apellido = :apellido")
    List<Estudiante> findByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
}

