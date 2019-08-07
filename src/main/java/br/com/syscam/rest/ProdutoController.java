package br.com.syscam.rest;

import br.com.syscam.model.Movimentacao;
import br.com.syscam.model.Produto;
import br.com.syscam.repository.ProdutoRepository;
import br.com.syscam.service.MovimentacaoService;
import br.com.syscam.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
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
                movimentacaoService.salvar(new Movimentacao(LocalDateTime.now(),subTotal,false,produto));
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
        return produtoService.listar();
    }

    @PutMapping
    public @ResponseBody boolean atualizar (@RequestBody Produto produto ){
        if(buscar(produto.getCodigo()).isPresent()){
            produtoService.atualizar(produto);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{codigo}")
    public @ResponseBody boolean remover(@PathVariable("codigo") int codigo){
        try{
            if(buscar(codigo).isPresent()){
                produtoService.deletar(codigo);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }



}
