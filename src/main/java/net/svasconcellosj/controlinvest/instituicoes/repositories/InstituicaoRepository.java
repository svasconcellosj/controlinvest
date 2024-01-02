package net.svasconcellosj.controlinvest.instituicoes.repositories;

import net.svasconcellosj.controlinvest.instituicoes.model.InstituicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoModel, BigInteger> {
}
