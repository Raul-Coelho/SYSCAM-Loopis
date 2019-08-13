package br.com.syscam.repository;

import br.com.syscam.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query("FROM Produto p WHERE LOWER(p.descricao) like %?1% OR LOWER(p.categoria) like %?1% ")
    List<Produto> findByDescricaoLike(String referencia);
}
