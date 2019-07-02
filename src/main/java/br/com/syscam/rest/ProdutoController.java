package br.com.syscam.rest;

import br.com.syscam.model.Produto;
import br.com.syscam.repository.ProdutoRepository;
import br.com.syscam.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    private ProdutoService produtoService;

    @PostMapping
    public @ResponseBody boolean salvar(@RequestBody Produto produto){
        try{
            produtoRepository.save(produto);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @GetMapping("/{codigo}")
    public @ResponseBody Optional<Produto> buscar(@PathVariable("codigo") int codigo ){
        return produtoRepository.findById(codigo);
    }

    @GetMapping
    public @ResponseBody List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @PutMapping
    public @ResponseBody boolean atualizar (@RequestBody Produto produto ){
        if(buscar(produto.getCodigo()).isPresent()){
            produtoRepository.save(produto);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{codigo}")
    public @ResponseBody boolean remover(@RequestBody int codigo){
        try{
            produtoRepository.deleteById(codigo);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
