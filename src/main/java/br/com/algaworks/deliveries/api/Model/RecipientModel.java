package br.com.algaworks.deliveries.api.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientModel {

    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

}
