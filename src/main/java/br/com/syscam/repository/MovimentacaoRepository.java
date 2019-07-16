package br.com.syscam.repository;

import br.com.syscam.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Integer> {
}
