package br.com.fiap.study_apir.model;


import java.math.BigDecimal;

import lombok.Data;

@Data
public class Produto {
private Long id ;
private  String nome ;
private BigDecimal valor;
public Produto(Long id, String nome, BigDecimal valor) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
}


}
