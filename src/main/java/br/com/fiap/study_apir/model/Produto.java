package br.com.fiap.study_apir.model;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produtos")
@Data
public class Produto {
public Produto() {
}
    @Id
    private Long id ;
private  String nome ;
private BigDecimal valor;
public Produto(Long id, String nome, BigDecimal valor) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
    }
}
