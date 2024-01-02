package net.svasconcellosj.controlinvest.instituicoes.services;

import net.svasconcellosj.controlinvest.instituicoes.model.InstituicaoModel;
import net.svasconcellosj.controlinvest.instituicoes.repositories.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    public List<InstituicaoModel> findAllInstituicoes() {
        return instituicaoRepository.findAll();
    }

    public InstituicaoModel saveInstituicao(InstituicaoModel instituicaoModel) {
        return instituicaoRepository.save(instituicaoModel);
    }

    public Optional<InstituicaoModel> findInstituicao(BigInteger id) {
        return instituicaoRepository.findById(id);
    }
}
