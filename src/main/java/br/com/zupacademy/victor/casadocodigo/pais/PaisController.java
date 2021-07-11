package br.com.zupacademy.victor.casadocodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public void cadastraPais(@Valid @RequestBody CadastraPaisRequest cadastraPaisRequest){
        if (paisRepository.existsByNome(cadastraPaisRequest.getNome())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe País cadastrado com esse nome");
        }
        Pais novoPais = cadastraPaisRequest.toModel();
        paisRepository.save(novoPais);

    }
}
