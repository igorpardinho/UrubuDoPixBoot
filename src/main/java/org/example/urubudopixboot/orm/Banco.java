package org.example.urubudopixboot.orm;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bancos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Banco {


    public Banco(String name, Set<Cliente> cliente){
        this.name = name;
        this.cliente = cliente;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private Set<Cliente> cliente = new HashSet<Cliente>();

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
