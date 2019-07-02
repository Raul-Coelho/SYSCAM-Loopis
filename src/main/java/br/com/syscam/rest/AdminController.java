package br.com.syscam.rest;

import br.com.syscam.model.Administrador;
import br.com.syscam.repository.PessoaRepository;
import br.com.syscam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administradores")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping
    public @ResponseBody boolean salvar(@RequestBody Administrador administrador) {

        try {
           if(buscar(administrador.getCodigo()).isPresent()){
               return false;
           }else {
               service.salvar(administrador);
               return true;
           }
        } catch (Exception e) {

            return false;
        }
    }

    @GetMapping("/{codigo}")
    public @ResponseBody Optional<Administrador> buscar(@PathVariable("codigo") Integer codigo) {
        return service.buscar(codigo);
    }

    @GetMapping
    public @ResponseBody List<Administrador> listar(){
        return service.listar();
    }


    @PutMapping
    public @ResponseBody boolean atualizar(@RequestBody Administrador administrador) {
        if (buscar(administrador.getCodigo()).isPresent()) {
            this.service.atualizar(administrador);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{codigo}")
    public @ResponseBody boolean remover(@PathVariable("codigo") Integer codigo){
        try{
            if(buscar(codigo).isPresent()){
                service.remover(codigo);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }







}
