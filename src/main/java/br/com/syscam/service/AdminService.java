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
            if (!buscar(administrador.getCodigo()).isPresent()) {
                this.repository.save(administrador);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public Optional<Administrador> buscar(Integer codigo) {
        return this.repository.findById(codigo);
    }

    public boolean atualizar(Administrador administrador) {
        if (buscar(administrador.getCodigo()).isPresent()) {
            this.repository.save(administrador);
            return true;
        }
        return false;
    }

    public List<Administrador> listar() {
        return this.repository.findAll();


    }


    public boolean remover(Integer codigo){
        try{
            if(buscar(codigo).isPresent()){
                repository.deleteById(codigo);
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }
}
