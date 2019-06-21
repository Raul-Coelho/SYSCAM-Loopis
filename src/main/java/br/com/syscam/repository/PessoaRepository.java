package br.com.syscam.repository;

import br.com.syscam.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {
}
