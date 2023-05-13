package br.com.bode.springasync.cadastro.controller;

import br.com.bode.springasync.cadastro.dto.ClienteRequest;
import br.com.bode.springasync.cadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrosincrono")
public class CadastroControllerSincrono {

    @Autowired
    private CadastroService service;

    @PostMapping
    public String cadastraSync(@RequestBody ClienteRequest request) {
        long inicio = System.currentTimeMillis();
        service.executeSincrono(request);
        long fim = System.currentTimeMillis();

        return "Execucao sincrona em " + (fim - inicio) + " ms";
    }
}
