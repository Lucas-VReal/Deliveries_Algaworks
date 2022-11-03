package br.com.algaworks.entregas.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
public class Clientes {

    private long id;
    private String nome;
    private String email;
    private String telefone;
}
