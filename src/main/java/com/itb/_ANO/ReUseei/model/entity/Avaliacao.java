package com.itb._ANO.ReUseei.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Avaliacao", schema = "dbo")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer nota;

    @Column(length = 500)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "avaliador_id", nullable = false)
    private Usuario avaliador;

    @ManyToOne
    @JoinColumn(name = "avaliado_id", nullable = false)
    private Usuario avaliado;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "troca_id")
    private Troca troca;

    @Column(name = "data_avaliacao", nullable = false)
    private LocalDateTime dataAvaliacao;

    @Column(name = "cod_status", nullable = false)
    private Boolean codStatus = true;

    public Avaliacao() {
    }

    @PrePersist
    public void prePersist() {
        if (dataAvaliacao == null) {
            dataAvaliacao = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Usuario avaliador) {
        this.avaliador = avaliador;
    }

    public Usuario getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(Usuario avaliado) {
        this.avaliado = avaliado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Troca getTroca() {
        return troca;
    }

    public void setTroca(Troca troca) {
        this.troca = troca;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Boolean getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Boolean codStatus) {
        this.codStatus = codStatus;
    }
}
