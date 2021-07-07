package br.com.zupacademy.victor.casadocodigo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public void cadastraAutor(@Valid @RequestBody CadastraAutorRequest cadastraAutorRequest){
        if (autorRepository.existsByEmail(cadastraAutorRequest.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe Usuario com esse Email Cadastrado!");
        }
        Autor novoAutor = cadastraAutorRequest.toModel();
        autorRepository.save(novoAutor);
    }
}
