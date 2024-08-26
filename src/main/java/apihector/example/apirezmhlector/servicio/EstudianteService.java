package apihector.example.apirezmhlector.servicio;

import apihector.example.apirezmhlector.FUNCION.Curso;

import apihector.example.apirezmhlector.FUNCION.Estudiante;
import apihector.example.apirezmhlector.Manejo_Excepciones.ResourceNotFoundException;
import apihector.example.apirezmhlector.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> obtenerTodosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public List<Estudiante> obtenerEstudiantesPorNombre(String nombre) {
        return estudianteRepository.findByNombre(nombre);
    }

    public List<Estudiante> obtenerEstudiantesPorApellido(String apellido) {
        return estudianteRepository.findByApellido(apellido);
    }

    public List<Estudiante> obtenerEstudiantesPorNombreYApellido(String nombre, String apellido) {
        return estudianteRepository.findByNombreAndApellido(nombre, apellido);
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
        Estudiante existente = estudianteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));
        existente.setNombre(estudiante.getNombre());
        existente.setApellido(estudiante.getApellido());
        return estudianteRepository.save(existente);
    }

    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}
