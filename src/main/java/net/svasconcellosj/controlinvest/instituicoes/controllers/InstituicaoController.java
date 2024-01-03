package net.svasconcellosj.controlinvest.instituicoes.controllers;

import net.svasconcellosj.controlinvest.instituicoes.model.InstituicaoModel;
import net.svasconcellosj.controlinvest.instituicoes.services.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instituicoes")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping
    public ResponseEntity<List<InstituicaoModel>> getAllInstituicoes() {
        try {
            List<InstituicaoModel> instituicoes = instituicaoService.findAllInstituicoes();
            return new ResponseEntity<>(instituicoes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstituicaoModel> getInstituicaoById(@PathVariable("id") BigInteger id) {
        try {
            Optional<InstituicaoModel> instituicao = instituicaoService.findInstituicao(id);
            return instituicao.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<InstituicaoModel> saveInstituicao(@RequestBody InstituicaoModel instituicaoModel) {
        try {
            InstituicaoModel savedInstituicao = instituicaoService.saveInstituicao(instituicaoModel);
            return new ResponseEntity<>(savedInstituicao, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstituicaoModel> updateInstituicao(@PathVariable("id") BigInteger id,
                                                              @RequestBody InstituicaoModel instituicaoModel) {
        try {
            InstituicaoModel updatedInstituicao = instituicaoService.updateInstituicao(id, instituicaoModel);
            return updatedInstituicao != null ?
                    new ResponseEntity<>(updatedInstituicao, HttpStatus.OK) :
                    new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInstituicao(@PathVariable("id") BigInteger id) {
        try {
            instituicaoService.deleteInstituicao(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
