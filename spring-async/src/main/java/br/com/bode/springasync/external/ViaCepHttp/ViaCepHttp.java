package br.com.bode.springasync.external.ViaCepHttp;

import br.com.bode.springasync.cadastro.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ViaCepHttp {

    @Autowired
    private ObjectMapper mapper;


    public Endereco execute(String cep) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/"))
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(response.body(), Endereco.class);
    }

}
