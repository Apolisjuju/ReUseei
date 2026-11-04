package com.itb._ANO.ReUseei.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "Favorito",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_favorito_usuario_produto",
            columnNames = {"usuario_id", "produto_id"}
        )
    }
)
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    public Favorito() {
    }

    @PrePersist
    public void prePersist() {
        if (dataCadastro == null) {
            dataCadastro = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
