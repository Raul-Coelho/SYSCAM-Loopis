package br.com.syscam.rest;

import br.com.syscam.model.Movimentacao;
import br.com.syscam.model.Produto;
import br.com.syscam.repository.ProdutoRepository;
import br.com.syscam.service.MovimentacaoService;
import br.com.syscam.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private MovimentacaoService movimentacaoService;


    @PostMapping
    public @ResponseBody boolean salvar(@RequestBody Produto produto){
        try{
            if(!buscar(produto.getCodigo()).isPresent()){
                produtoService.salvar(produto);
                Double subTotal = produto.getPreco()*produto.getQuantidade();
                movimentacaoService.salvar(produto);
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            return false;
        }

    }
    @GetMapping("/{codigo}")
    public @ResponseBody Optional<Produto> buscar(@PathVariable("codigo") int codigo ){
        return produtoService.buscar(codigo);
    }

    @GetMapping
    public @ResponseBody List<Produto> listar(){
        return produtoService.listar("");

    }
    @GetMapping("/buscar")
    public @ResponseBody List<Produto> buscarProdutos(@RequestParam(value = "referencia",required =false)
                                                      String referencia){
        return produtoService.listar(referencia);

    }


    @PutMapping
    public @ResponseBody boolean atualizar (@RequestBody Produto produto ){
        if(buscar(produto.getCodigo()).isPresent()){
            movimento(produto);
            produtoService.atualizar(produto);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{codigo}")
    public @ResponseBody boolean remover(@PathVariable("codigo") int codigo){
        try{
            if(buscar(codigo).isPresent()){
                movimento(buscar(codigo).get());
                produtoService.deletar(codigo);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    private void movimento(Produto produto){
        int quantidade = 0;
        Double subTotal;
        Optional<Produto> produtoAnterior = produtoService.buscar(produto.getCodigo());
        if(produto.getQuantidade()>produtoAnterior.get().getQuantidade()){
            quantidade = produto.getQuantidade()-produtoAnterior.get().getQuantidade();
            subTotal=produto.getPreco()*quantidade;
            movimentacaoService.salvarMovimento(quantidade,subTotal,produto.getDescricao(),false);
        }else{
            quantidade = produtoAnterior.get().getQuantidade()-produto.getQuantidade();
            subTotal=produto.getPreco()*quantidade;
            movimentacaoService.salvarMovimento(quantidade,subTotal,produto.getDescricao(),true);
        }

    }

}
