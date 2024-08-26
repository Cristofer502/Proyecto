package apihector.example.apirezmhlector.servicio;

import apihector.example.apirezmhlector.FUNCION.Curso;
import apihector.example.apirezmhlector.Manejo_Excepciones.ResourceNotFoundException;
import apihector.example.apirezmhlector.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obtenerTodosCursos() {
        return cursoRepository.findAll();
    }

    public List<Curso> obtenerCursosPorNombre(String nombre) {
        return cursoRepository.findByNombre(nombre);
    }

    public List<Curso> obtenerCursosPorCreditos(int creditos) {
        return cursoRepository.findByCreditos(creditos);
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso actualizarCurso(Long id, Curso curso) {
        Curso existente = cursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        existente.setNombre(curso.getNombre());
        existente.setDescripcion(curso.getDescripcion());
        existente.setCreditos(curso.getCreditos());
        return cursoRepository.save(existente);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
