package br.com.fiap.study_apir.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fiap.study_apir.model.Produto;

public class RepositoryProdutoMockup {
    private List<Produto> produtos = new ArrayList<>();
    

    public RepositoryProdutoMockup() {
    
        Produto produto = new Produto(1L,"UVA",BigDecimal.valueOf(12.2));
        produtos.add(produto);
        produto = new Produto(5L,"MAMAO", BigDecimal.valueOf(23.23));
        produtos.add(produto);


    }
    public List<Produto> findAll(){
        return produtos;
    }
    public Optional<Produto> findById(Long id){
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public boolean deleteById(Long id){
        
        return produtos.removeIf(p -> p.getId().equals(id));
    }
}