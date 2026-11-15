package cl.Categoria.repository;

import cl.Categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    /*
     * JpaRepository<Entidad, TipoPK> hereda:
     * save()        → INSERT o UPDATE automático
     * findById()    → SELECT WHERE id = ?
     * findAll()     → SELECT * FROM categorias
     * deleteById()  → DELETE WHERE id = ?
     * count()       → SELECT COUNT(*)
     * existsById()  → comprueba si existe un id
     * */

}