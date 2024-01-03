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
        // Adiciona tratamento para exceções de persistência
        try {
            return instituicaoRepository.save(instituicaoModel);
        } catch (Exception e) {
            // Adicione aqui o que deseja fazer em caso de falha na persistência
            throw new RuntimeException("Erro ao salvar instituição", e);
        }
    }

    public Optional<InstituicaoModel> findInstituicao(BigInteger id) {
        return instituicaoRepository.findById(id);
    }

    public InstituicaoModel updateInstituicao(BigInteger id, InstituicaoModel instituicao) {
        // Adiciona tratamento para exceções de persistência
        try {
            if (instituicaoRepository.existsById(id)) {
                instituicao.setId(id);
                return instituicaoRepository.save(instituicao);
            }
            return null; // Handle the case where the entity with the given id doesn't exist
        } catch (Exception e) {
            // Adicione aqui o que deseja fazer em caso de falha na persistência
            throw new RuntimeException("Erro ao atualizar instituição", e);
        }
    }

    public void deleteInstituicao(BigInteger id) {
        // Adiciona tratamento para exceções de persistência
        try {
            instituicaoRepository.deleteById(id);
        } catch (Exception e) {
            // Adicione aqui o que deseja fazer em caso de falha na persistência
            throw new RuntimeException("Erro ao excluir instituição", e);
        }
    }
}
