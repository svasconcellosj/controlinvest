package net.svasconcellosj.controlinvest.instituicoes.controllers;

import jakarta.validation.Valid;
import net.svasconcellosj.controlinvest.instituicoes.Dtos.InstituicaoDto;
import net.svasconcellosj.controlinvest.instituicoes.model.InstituicaoModel;
import net.svasconcellosj.controlinvest.instituicoes.services.InstituicaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instituicoes")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping
    public ResponseEntity buscaInstituicoes() {
        List listaInstituicoes = instituicaoService.findAllInstituicoes();
        return ResponseEntity.status(HttpStatus.OK).body(listaInstituicoes);
    }

    @PostMapping
    public ResponseEntity gravaInstituicao(@RequestBody @Valid InstituicaoDto instituicaoDto) {
        var novaInstituicao = new InstituicaoModel();
        BeanUtils.copyProperties(instituicaoDto, novaInstituicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(instituicaoService.saveInstituicao(novaInstituicao));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity buscaInstituicao(@PathVariable BigInteger id) {
        Optional<InstituicaoModel> instituicaoModel = instituicaoService.findInstituicao(id);
        if (instituicaoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instituição não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(instituicaoModel);
    }
}
