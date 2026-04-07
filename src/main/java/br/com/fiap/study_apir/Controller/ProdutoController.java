package br.com.fiap.study_apir.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.RepositoryProdutoMockup;

@RestController
@RequestMapping("api/${api.version}/produtos")
public class ProdutoController {
    
    @Autowired
    private RepositoryProdutoMockup mockup;

    @PostMapping("/create")
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(mockup.create(produto));
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
    Optional<Produto> optProduto = mockup.findById(id);
   return optProduto.map(p -> ResponseEntity.ok(p)).orElse(ResponseEntity.noContent().build());
    // if(optProduto.isPresent()){
        // return ResponseEntity.ok(optProduto.get());
    //    // return ResponseEntity.status(HttpStatus.OK).body(mockup.findById(id )); 
    // } else {
    //     return ResponseEntity.noContent().build();
    // }      
    }

    @GetMapping("/todomundao")
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(mockup.findAll());
    }

    @PutMapping("/pdate/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Produto produto){
        if(mockup.update(id, produto)){
            return ResponseEntity.ok("Produto atualizado");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(mockup.deleteById(id)) {
            return ResponseEntity.noContent().build();
            
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
