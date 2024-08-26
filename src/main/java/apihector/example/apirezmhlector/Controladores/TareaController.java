package apihector.example.apirezmhlector.Controladores;

import apihector.example.apirezmhlector.FUNCION.Tarea;
import apihector.example.apirezmhlector.servicio.TareaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> obtenerTodasTareas() {
        return tareaService.obtenerTodasTareas();
    }

    @GetMapping("/titulo/{titulo}")
    public List<Tarea> obtenerTareasPorTitulo(@PathVariable String titulo) {
        return tareaService.obtenerTareasPorTitulo(titulo);
    }

    @GetMapping("/fecha/{fechaEntrega}")
    public List<Tarea> obtenerTareasPorFechaEntrega(@PathVariable Date fechaEntrega) {
        return tareaService.obtenerTareasPorFechaEntrega(fechaEntrega);
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        return new ResponseEntity<>(tareaService.crearTarea(tarea), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable String id, @RequestBody Tarea tarea) {
        return new ResponseEntity<>(tareaService.actualizarTarea(id, tarea), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable String id) {
        tareaService.eliminarTarea(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
