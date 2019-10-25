package com.edu.atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Atividade salvar(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public List<Atividade> getAllByUserName() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return atividadeRepository.findByCriadorUsername(username);
    }
}
