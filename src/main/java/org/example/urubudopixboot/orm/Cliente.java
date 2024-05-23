package org.example.urubudopixboot.orm;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@EqualsAndHashCode
public class Cliente {

    public Cliente(String nome, Banco banco) {
        this.nome = nome;
        this.banco = banco;

    }

    @ManyToOne
    private Banco banco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false)
    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private Double saldo = 0.0;


    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + idCliente + '\'' +
                ", nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", "+banco +
                '}';
    }
}
