
package com.pessoa.pessoa.service;

import com.pessoa.pessoa.dto.PessoaDTO;
import com.pessoa.pessoa.entity.Pessoa;
import com.pessoa.pessoa.entity.Trabalho;
import com.pessoa.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());

        Trabalho trabalho = new Trabalho();
        trabalho.setCargo(dto.getTrabalho().getCargo());
        trabalho.setSalario(dto.getTrabalho().getSalario());

        pessoa.setTrabalho(trabalho);

        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public Pessoa atualizar(Long id, PessoaDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();
        pessoa.setNome(dto.getNome());

        Trabalho trabalho = pessoa.getTrabalho();
        trabalho.setCargo(dto.getTrabalho().getCargo());
        trabalho.setSalario(dto.getTrabalho().getSalario());

        return pessoaRepository.save(pessoa);
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }
}
