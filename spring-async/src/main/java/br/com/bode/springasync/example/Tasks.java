package br.com.bode.springasync.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Tasks {

    @Async
    public void execute() throws InterruptedException {

        System.out.println("iniciando metodo");
        Thread.sleep(2000);
        System.out.println("finalizando metodo");
        System.out.println(2/0);

    }

}
