package br.com.fiap.study_apir.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.RepositoryProdutoMockup;

@RestController
@RequestMapping("api/${api.version}/produtos")
public class ProdutoController {
    private RepositoryProdutoMockup mockup = new RepositoryProdutoMockup();

    @PostMapping("/create")
    public ResponseEntity<String> create(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Criado");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
    //Pruduto produto = mockup.findById(id ); 
        return ResponseEntity.status(HttpStatus.OK).body(mockup.findById(id ));

    }
    @GetMapping("/todomundao")
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(mockup.findAll());
    }

    @PutMapping("/d")
    public ResponseEntity<String> update(){
        return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado");
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<String> delete(){
        //Void 
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deletado chefia");
    }
}
