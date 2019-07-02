package br.com.syscam.service;

import br.com.syscam.model.Produto;
import br.com.syscam.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public boolean salvar(Produto produto){
        try {
            if(!buscar(produto.getCodigo()).isPresent()){
                this.produtoRepository.save(produto);
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }

    public Optional<Produto> buscar(int codigo){
        return  this.produtoRepository.findById(codigo);
    }

    public boolean atualizar(Produto produto){
        if(buscar(produto.getCodigo()).isPresent()){
            this.produtoRepository.save(produto);
        }
            return false;

    }

    public List<Produto> listar(){
        return  this.produtoRepository.findAll();
    }

    public boolean deletar(int codigo){
        try{
            if(buscar(codigo).isPresent()){
                this.produtoRepository.deleteById(codigo);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

}
