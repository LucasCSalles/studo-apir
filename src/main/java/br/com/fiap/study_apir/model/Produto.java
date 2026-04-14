package br.com.fiap.study_apir.model;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Produto {
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
