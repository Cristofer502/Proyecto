package apihector.example.apirezmhlector.Controladores;

import apihector.example.apirezmhlector.FUNCION.Estudiante;
import apihector.example.apirezmhlector.servicio.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> obtenerTodosEstudiantes() {
        return estudianteService.obtenerTodosEstudiantes();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Estudiante> obtenerEstudiantesPorNombre(@PathVariable String nombre) {
        return estudianteService.obtenerEstudiantesPorNombre(nombre);
    }

    @GetMapping("/apellido/{apellido}")
    public List<Estudiante> obtenerEstudiantesPorApellido(@PathVariable String apellido) {
        return estudianteService.obtenerEstudiantesPorApellido(apellido);
    }

    @GetMapping("/nombre-apellido/{nombre}/{apellido}")
    public List<Estudiante> obtenerEstudiantesPorNombreYApellido(@PathVariable String nombre, @PathVariable String apellido) {
        return estudianteService.obtenerEstudiantesPorNombreYApellido(nombre, apellido);
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        return new ResponseEntity<>(estudianteService.crearEstudiante(estudiante), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return new ResponseEntity<>(estudianteService.actualizarEstudiante(id, estudiante), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
