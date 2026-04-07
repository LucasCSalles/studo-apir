package br.com.fiap.study_apir.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.study_apir.model.Produto;
@Service
public class RepositoryProdutoMockup {
    private List<Produto> produtos = new ArrayList<>();
    private long ID = 0L;
    

    public RepositoryProdutoMockup() {
    
        Produto produto = new Produto(ID++,"UVA",BigDecimal.valueOf(12.2));
        produtos.add(produto);
        produto = new Produto(ID++,"MAMAO", BigDecimal.valueOf(23.23));
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
    public Produto create (Produto produto){
        produto.setId(ID++);
        produtos.add(produto);
        return produto;
        //Gerar o id
        //Atribuir o id ao novo produto sendo cadastrado
        //Salvar no Banco de dadaos
        //Retornar o prodto novo 


    }
    public boolean update(Long id, Produto produto){
        Optional<Produto> optProduto = this.findById(id);
        if(optProduto.isPresent()){
            Produto produtoAtual = optProduto.get();
            produtoAtual.setNome(produto.getNome());
            produtoAtual.setValor(produto.getValor());
            return true;
        }else {
            return false;
        }
    }
}