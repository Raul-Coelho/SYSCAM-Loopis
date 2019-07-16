package br.com.syscam.service;

import br.com.syscam.model.Movimentacao;
import br.com.syscam.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public boolean salvar(Movimentacao movimentacao){
        try {
            if(!buscar(movimentacao.getProtocolo()).isPresent()){
                this.movimentacaoRepository.save(movimentacao);
                return true;
            }else{
                return false;
            }
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
}
