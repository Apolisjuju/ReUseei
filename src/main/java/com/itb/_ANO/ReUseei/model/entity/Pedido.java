package com.itb._ANO.ReUseei.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_pedido", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPedido;

    @Column(name = "data_hora_pedido", nullable = false)
    private LocalDateTime dataHoraPedido;

    @Column(name = "data_hora_entrega")
    private LocalDateTime dataHoraEntrega;

    @Column(nullable = false, length = 30)
    private String status = "PENDENTE";

    @Column(name = "cod_status", nullable = false)
    private Boolean codStatus = true;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    @PrePersist
    public void prePersist() {
        if (dataHoraPedido == null) {
            dataHoraPedido = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    public LocalDateTime getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(LocalDateTime dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Boolean codStatus) {
        this.codStatus = codStatus;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
