package br.com.tonsoft.apimoney.repository;

import br.com.tonsoft.apimoney.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
