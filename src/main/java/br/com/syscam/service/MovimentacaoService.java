package br.com.syscam.service;

import br.com.syscam.model.Movimentacao;
import br.com.syscam.model.Produto;
import br.com.syscam.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public boolean salvar(Produto produto){
        try {
                Movimentacao movimentacao = new Movimentacao(
                        LocalDate.now(),
                        LocalTime.now(),
                        false,
                        produto.getPreco()*produto.getQuantidade(),
                        produto.getDescricao(),
                        produto.getQuantidade()
                );
                this.movimentacaoRepository.save(movimentacao);
                return true;
        }catch (Exception e){
            return false;
        }
    }

    public Optional<Movimentacao> buscar(int protocolo){
        return this.movimentacaoRepository.findById(protocolo);
    }

    public boolean atualizar(Movimentacao movimentacao){
        if (buscar(movimentacao.getProtocolo()).isPresent()) {
            this.movimentacaoRepository.save(movimentacao);
            return true;
        }
        return false;
    }

    public List<Movimentacao> listar(){
        return this.movimentacaoRepository.findAll();
    }

    public boolean remover(int protocolo){
        try{
            if(buscar(protocolo).isPresent()){
                this.movimentacaoRepository.deleteById(protocolo);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public boolean salvarMovimento(int quantidade, Double preco, String produto, boolean isVenda) {
        try{
            Movimentacao movimentacao = new Movimentacao(
                    LocalDate.now(),
                    LocalTime.now(),
                    isVenda,
                    preco,
                    produto,
                    quantidade
            );
            movimentacaoRepository.save(movimentacao);
            return true;
        }catch (Exception ex){
            return false;
        }

    }
}
