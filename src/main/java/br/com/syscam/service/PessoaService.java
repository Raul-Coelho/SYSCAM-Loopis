package br.com.syscam.service;

import br.com.syscam.model.Pessoa;
import br.com.syscam.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public boolean salvar(Pessoa pessoa) {

        try {
            if (!buscar(pessoa.getEmail()).isPresent()) {
                this.repository.save(pessoa);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public Optional<Pessoa> buscar(String email) {
        return this.repository.findById(email);
    }

    public boolean atualizar(Pessoa pessoa) {
        if (buscar(pessoa.getEmail()).isPresent()) {
            this.repository.save(pessoa);
            return true;
        }
        return false;
    }

    public List<Pessoa> listar() {
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
