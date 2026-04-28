package br.com.fiap.study_apir.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "clientes")
@Data

public class Cliente {
@Id
private Long id;
@Column(name = "nome_clientes", length = 100,columnDefinition = "char(100)", nullable = false)
private String nome;
}
