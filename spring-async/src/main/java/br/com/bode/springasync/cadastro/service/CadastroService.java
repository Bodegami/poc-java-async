package br.com.bode.springasync.cadastro.service;

import br.com.bode.springasync.cadastro.dto.ClienteRequest;
import br.com.bode.springasync.cadastro.model.Cliente;
import br.com.bode.springasync.cadastro.model.Endereco;
import br.com.bode.springasync.cadastro.repository.ClienteRepository;
import br.com.bode.springasync.external.ViaCepHttp.ViaCepHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ViaCepHttp viaCepHttp;



    @Async
    public void executeAsincrono(ClienteRequest request) {
        long inicio = System.currentTimeMillis();

        Cliente cliente = toModel(request);
        clienteRepository.save(cliente);

        long fim = System.currentTimeMillis();
        System.out.println("Execucao async em " + (fim - inicio) + " ms");
    }

    public void executeSincrono(ClienteRequest request) {
        long inicio = System.currentTimeMillis();

        Cliente cliente = toModel(request);
        clienteRepository.save(cliente);

        long fim = System.currentTimeMillis();
        System.out.println("Execucao sync em " + (fim - inicio) + " ms");
    }


    private Cliente toModel(ClienteRequest request) {
        return new Cliente(
                request.getNome(),
                request.getSobrenome(),
                request.getTelefone(),
                getEndereco(request.getCep())
        );
    }

    private Endereco getEndereco(String cep) {
        try {
            Endereco endereco = viaCepHttp.execute(cep);
            return endereco;
        }
        catch (Exception e) {
            throw new RuntimeException("Error ao buscar endereco: " + e.getMessage());
        }
    }

}
