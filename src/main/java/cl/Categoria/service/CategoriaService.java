package cl.Categoria.service;


import cl.Categoria.dto.request.CategoriaRequestDTO;
import cl.Categoria.dto.response.CategoriaResponseDTO;
import cl.Categoria.model.Categoria;
import cl.Categoria.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private CategoriaResponseDTO mapToDTO(Categoria categoria){

        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNombre()
        );

    }

    public void eliminar(Long id){
        categoriaRepository.deleteById(id);
    }


    public List<CategoriaResponseDTO> buscarTodo(){
        return categoriaRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<CategoriaResponseDTO> buscarPorId(Long id){
        return categoriaRepository.findById(id).map(this::mapToDTO);
    }

    public CategoriaResponseDTO guardar(CategoriaRequestDTO dto){
        Categoria categoria = new Categoria(
                null,
                dto.getNombreCategoria()
        );
        return mapToDTO(categoriaRepository.save(categoria));
    }

    public Optional<CategoriaResponseDTO> actualizar(Long id, CategoriaRequestDTO dto) {
        return categoriaRepository.findById(id).map(existente -> {

            existente.setNombre(dto.getNombreCategoria());
            return mapToDTO(categoriaRepository.save(existente));
        });
    }

}