package br.com.algaworks.entregas.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Email //verifica se tem a estrutura correta
    @Size(max = 255, min = 5) // minimo a@a.a
    private String email;

    @NotBlank
    @Size(max = 20)
    private String telefone;
}
