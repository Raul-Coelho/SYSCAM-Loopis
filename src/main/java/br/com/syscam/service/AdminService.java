package br.com.syscam.service;

import br.com.syscam.model.Administrador;
import br.com.syscam.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private PessoaRepository repository;

    public boolean salvar(Administrador administrador) {

        try {
            if (!buscar(administrador.getEmail()).isPresent()) {
                this.repository.save(administrador);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public Optional<Administrador> buscar(String email) {
        return this.repository.findById(email);
    }

    public boolean atualizar(Administrador administrador) {
        if (buscar(administrador.getEmail()).isPresent()) {
            this.repository.save(administrador);
            return true;
        }
        return false;
    }

    public List<Administrador> listar() {
        return this.repository.findAll();


    }


    public boolean remover(String email){
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
