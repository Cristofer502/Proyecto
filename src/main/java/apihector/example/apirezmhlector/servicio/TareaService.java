package apihector.example.apirezmhlector.servicio;

import apihector.example.apirezmhlector.FUNCION.Tarea;
import apihector.example.apirezmhlector.Manejo_Excepciones.ResourceNotFoundException;
import apihector.example.apirezmhlector.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> obtenerTodasTareas() {
        return tareaRepository.findAll();
    }

    public List<Tarea> obtenerTareasPorTitulo(String titulo) {
        return tareaRepository.findByTitulo(titulo);
    }

    public List<Tarea> obtenerTareasPorFechaEntrega(Date fechaEntrega) {
        return tareaRepository.findByFechaEntrega(fechaEntrega);
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarTarea(String id, Tarea tarea) {
        Tarea existente = tareaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada"));
        existente.setTitulo(tarea.getTitulo());
        existente.setDescripcion(tarea.getDescripcion());
        existente.setFechaEntrega(tarea.getFechaEntrega());
        return tareaRepository.save(existente);
    }

    public void eliminarTarea(String id) {
        tareaRepository.deleteById(id);
    }
}
