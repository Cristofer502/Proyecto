package apihector.example.apirezmhlector.repository;

import apihector.example.apirezmhlector.FUNCION.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNombre(String nombre);

    List<Curso> findByCreditos(int creditos);
}