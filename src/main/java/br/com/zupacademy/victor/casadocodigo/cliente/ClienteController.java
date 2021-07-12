package br.com.zupacademy.victor.casadocodigo.cliente;

import br.com.zupacademy.victor.casadocodigo.estado.EstadoRepository;
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
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    @PostMapping
    public void cadastraCliente(@Valid @RequestBody CadastraClienteRequest cadastraClienteRequest) {

        var pais = paisRepository.findByNome(cadastraClienteRequest.nomePais)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe esse País cadastrado no sistema"));

        var estado = estadoRepository.findByNomeAndPaisNome(cadastraClienteRequest.nomeEstado, cadastraClienteRequest.nomePais)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe esse estado para esse pais"));

        if (clienteRepository.existsByEmail(cadastraClienteRequest.email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe esse Email cadastrado!");
        }

        if (clienteRepository.existsByDocumento(cadastraClienteRequest.documento)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe esse Documento cadastrado!");
        }

        Cliente novoCliente = cadastraClienteRequest.toModel(pais, estado);
        clienteRepository.save(novoCliente);
    }

}
