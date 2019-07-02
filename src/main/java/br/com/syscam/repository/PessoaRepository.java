package br.com.syscam.repository;

import br.com.syscam.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Administrador, Integer> {

}
