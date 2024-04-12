package br.com.igor.cafecg_backend.repositories;

import br.com.igor.cafecg_backend.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto,Long>{
}
