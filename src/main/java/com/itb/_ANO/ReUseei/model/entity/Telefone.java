package com.itb._ANO.ReUseei.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 3)
    private String ddd;

    @Column(nullable = false, length = 15)
    private String numero;

    @Column(length = 20)
    private String tipo;

    @Column(name = "cod_status", nullable = false)
    private Boolean codStatus = true;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Telefone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Boolean codStatus) {
        this.codStatus = codStatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
