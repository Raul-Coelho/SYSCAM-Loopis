package br.com.syscam.rest;

import br.com.syscam.model.Pessoa;
import br.com.syscam.repository.PessoaRepository;
import br.com.syscam.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    private PessoaService service;

    @PostMapping
    public @ResponseBody boolean salvar(@RequestBody Pessoa pessoa) {

        try {
            repository.save(pessoa);
            System.out.println("foi");
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    @GetMapping(value = "/{email}")
    public @ResponseBody Optional<Pessoa> buscar(@PathVariable("email") String email) {
        return repository.findById(email);
    }

    @GetMapping
    public @ResponseBody List<Pessoa> listar(){
        return repository.findAll();
    }


    @PutMapping
    public @ResponseBody boolean atualizar(@RequestBody Pessoa pessoa) {
        if (buscar(pessoa.getEmail()).isPresent()) {
            this.repository.save(pessoa);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{email}")
    public @ResponseBody boolean remover(@RequestBody String email){
        try{
            if(buscar(email).isPresent()){
                repository.deleteById(email);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }







}
