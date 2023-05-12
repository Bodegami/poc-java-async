package br.com.bode.springasync.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private Tasks tasks;

    @GetMapping
    public String execute() throws InterruptedException {
        long inicio = System.currentTimeMillis();

        tasks.execute();

        long fim = System.currentTimeMillis();
        return (fim - inicio) + "ms" ;
    }

}
