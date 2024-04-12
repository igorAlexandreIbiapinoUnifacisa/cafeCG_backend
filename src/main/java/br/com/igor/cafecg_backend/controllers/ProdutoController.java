package br.com.igor.cafecg_backend.controllers;

import br.com.igor.cafecg_backend.entities.Produto;
import br.com.igor.cafecg_backend.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;
    //Get / produto => retornar todos os produtos
    @GetMapping
    public List<Produto> listarTodosOsProdutos() {
        return repository.findAll();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoPorId (@PathVariable Long id){
        try {
            return new ResponseEntity<> (repository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Post / produto => adicionar um novo produto
    @PostMapping

    public Produto adcionarProduto(@RequestBody Produto novo){
        return repository.save(novo);
    }
    //Delete / produto/id => remover o produto por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId (@PathVariable Long id){
        try {
        repository.findById(id).get();
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterarProdutoPorId(@PathVariable Long id,@RequestBody Produto novosDados){
        try{

            Produto produtoAntigo = repository.findById(id).get();
            produtoAntigo.setNome(novosDados.getNome());
            produtoAntigo.setDescricao(novosDados.getDescricao());
            produtoAntigo.setPreco(novosDados.getPreco());

            return new ResponseEntity<>(repository.save(produtoAntigo), HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}

