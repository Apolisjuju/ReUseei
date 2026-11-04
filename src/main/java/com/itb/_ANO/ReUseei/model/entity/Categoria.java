package com.itb._ANO.ReUseei.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Column(name = "cod_status", nullable = false)
    private Boolean codStatus = true;

   
    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Boolean codStatus) {
        this.codStatus = codStatus;
    }

   
}
