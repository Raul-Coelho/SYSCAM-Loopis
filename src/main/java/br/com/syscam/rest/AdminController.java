package br.com.syscam.rest;

import br.com.syscam.model.Administrador;
import br.com.syscam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/administradores")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping(value = "/teste")
    public @ResponseBody String teste(){
        return "NUmfoi";
    }

    @PostMapping
    public @ResponseBody boolean salvar(@RequestBody Administrador administrador) {

        try {
           if(buscar(administrador.getEmail()).isPresent()){
               return false;
           }else {
               service.salvar(administrador);
               return true;
           }
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/{email}")
    public @ResponseBody Optional<Administrador> buscar(@PathVariable("email") String email) {
        return service.buscar(email);
    }

    @GetMapping
    public @ResponseBody List<Administrador> listar(){
        return service.listar();
    }


    @PutMapping
    public @ResponseBody boolean atualizar(@RequestBody Administrador administrador) {
        if (buscar(administrador.getEmail()).isPresent()) {
            this.service.atualizar(administrador);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{email}")
    public @ResponseBody boolean remover(@PathVariable("email") String email){
        try{
            if(buscar(email).isPresent()){
                service.remover(email);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @PostMapping("/login")
    public @ResponseBody boolean login(@RequestBody Administrador administrador){
        Optional<Administrador> admin = buscar(administrador.getEmail());
        if(admin.isPresent()){
            if(admin.get().getSenha().equals(administrador.getSenha())){
                return true;
            }
        }
        return false;
    }




}
