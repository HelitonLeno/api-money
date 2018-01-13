package br.com.tonsoft.apimoney.endpoint;

import br.com.tonsoft.apimoney.model.Categoria;
import br.com.tonsoft.apimoney.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaEndPoint {

    @Autowired
    private CategoriaRepository categoriaRepo;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Categoria> categorias = categoriaRepo.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody Categoria categoria,
                                          HttpServletResponse response) {

        Categoria catSave = categoriaRepo.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(catSave.getId()).toUri();

        return ResponseEntity.created(uri).body(catSave);
    }

    @GetMapping("/{id}")
    public Categoria findCategoryById(@PathVariable("id") Long id){
        return categoriaRepo.findOne(id);
    }
}

