package apihector.example.apirezmhlector.Controladores;


import apihector.example.apirezmhlector.FUNCION.Curso;
import apihector.example.apirezmhlector.servicio.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> obtenerTodosCursos() {
        return cursoService.obtenerTodosCursos();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Curso> obtenerCursosPorNombre(@PathVariable String nombre) {
        return cursoService.obtenerCursosPorNombre(nombre);
    }

    @GetMapping("/creditos/{creditos}")
    public List<Curso> obtenerCursosPorCreditos(@PathVariable int creditos) {
        return cursoService.obtenerCursosPorCreditos(creditos);
    }

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.crearCurso(curso), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.actualizarCurso(id, curso), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
