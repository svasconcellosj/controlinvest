package net.svasconcellosj.controlinvest.instituicoes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(name = "instituicoes")
@Data
public class InstituicaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @NotNull
    @Size(min = 5, max = 100)
    private String nome;

    @NotNull
    @Size(min = 14, max = 14)
    private String cnpj;

    @NotNull
    @Size(min = 1, max = 1, message = "Tipo deve ser um únido caracter.")
    private String tipo;

    @NotNull
    @Size(min = 5, max = 40)
    private String segmento;
}
