package br.com.zupacademy.victor.casadocodigo.estado;

import br.com.zupacademy.victor.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/estado")
public class EstadoController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public void cadastraEstado(@Valid @RequestBody CadastraEstadoRequest cadastraEstadoRequest){

        var pais = paisRepository.findByNome(cadastraEstadoRequest.nomePais)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe esse País cadastrado no sistema"));

        if (estadoRepository.existsByNomeAndPaisNome(cadastraEstadoRequest.nome, cadastraEstadoRequest.nomePais)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe esse estado cadastrado para esse País!");
        }

      var novoEstado = cadastraEstadoRequest.toModel(pais);
      estadoRepository.save(novoEstado);

    }


}
