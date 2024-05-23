package org.example.urubudopixboot.repository;

import org.example.urubudopixboot.orm.Banco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends CrudRepository<Banco, Long> {
}
