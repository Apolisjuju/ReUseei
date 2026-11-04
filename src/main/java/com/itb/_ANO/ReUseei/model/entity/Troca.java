package com.itb._ANO.ReUseei.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Troca")
public class Troca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_solicitante_id", nullable = false)
    private Usuario usuarioSolicitante;

    @ManyToOne
    @JoinColumn(name = "usuario_destinatario_id", nullable = false)
    private Usuario usuarioDestinatario;

    @ManyToOne
    @JoinColumn(name = "produto_ofertado_id", nullable = false)
    private Produto produtoOfertado;

    @ManyToOne
    @JoinColumn(name = "produto_desejado_id", nullable = false)
    private Produto produtoDesejado;

    @Column(name = "valor_adicional", precision = 10, scale = 2)
    private BigDecimal valorAdicional;

    @Column(length = 500)
    private String mensagem;

    @Column(nullable = false, length = 30)
    private String status = "PENDENTE";

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "cod_status", nullable = false)
    private Boolean codStatus = true;

    public Troca() {
    }

    @PrePersist
    public void prePersist() {
        if (dataHora == null) {
            dataHora = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public Usuario getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    public void setUsuarioDestinatario(Usuario usuarioDestinatario) {
        this.usuarioDestinatario = usuarioDestinatario;
    }

    public Produto getProdutoOfertado() {
        return produtoOfertado;
    }

    public void setProdutoOfertado(Produto produtoOfertado) {
        this.produtoOfertado = produtoOfertado;
    }

    public Produto getProdutoDesejado() {
        return produtoDesejado;
    }

    public void setProdutoDesejado(Produto produtoDesejado) {
        this.produtoDesejado = produtoDesejado;
    }

    public BigDecimal getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(BigDecimal valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Boolean getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Boolean codStatus) {
        this.codStatus = codStatus;
    }
}
