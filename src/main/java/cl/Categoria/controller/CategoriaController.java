package cl.Categoria.controller;
import cl.Categoria.dto.request.CategoriaRequestDTO;
import cl.Categoria.dto.response.CategoriaResponseDTO;
import cl.Categoria.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/categoria")
@RequiredArgsConstructor
@Tag(name = "Categoria", description = "Operaciones relacionadas con la categoria de los productos")

public class CategoriaController {
    @Autowired
    private final CategoriaService categoriaService;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria", description = "Obtiene una categoria por su Id.")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Busca todas las categorias", description = "Obtiene toda una lista de categorias.")
    public ResponseEntity<?> buscarTodo(){
        return ResponseEntity.ok(categoriaService.buscarTodo());
    }

    @PostMapping
    @Operation(summary = "Agregar una categoria", description = "Agrega una categoria.")
    public ResponseEntity<?> agregar(@Valid @RequestBody CategoriaRequestDTO dto) {
        return ResponseEntity.status(201).body(categoriaService.guardar(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar categoria", description = "Elimina una categoria por su Id.")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (categoriaService.buscarPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una categoria", description = "Actualiza una categoria por Id.")
    public ResponseEntity<CategoriaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDTO dto) {
        return categoriaService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}