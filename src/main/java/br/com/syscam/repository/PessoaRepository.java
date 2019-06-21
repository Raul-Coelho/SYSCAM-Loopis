package br.com.syscam.repository;

import br.com.syscam.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Administrador, String> {
}
