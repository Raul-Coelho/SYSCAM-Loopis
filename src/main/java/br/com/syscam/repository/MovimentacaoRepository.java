package br.com.syscam.repository;

import br.com.syscam.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Integer> {

    @Query("SELECT m FROM Movimentacao m WHERE m.data BETWEEN ?1 AND ?2 ORDER BY m.data ASC")
    public List<Movimentacao> findByDataBetween(LocalDate inicio, LocalDate fim);
}
