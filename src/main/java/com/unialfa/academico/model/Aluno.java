package com.unialfa.academico.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "MATRICULA")
    private Long id;
    private String nome;
    @Column(name = "DT_NASCIMENTO")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    private String telefone;
    private String bairro;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "CODIGO_CURSO")
    private Curso curso;
}
