package org.example.urubudopixboot;

import org.example.urubudopixboot.services.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class UrubuDoPixBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UrubuDoPixBootApplication.class, args);
    }

    private final ClienteService CLIENTE_SERVICE;

    public UrubuDoPixBootApplication(ClienteService CLIENTE_SERVICE) {
        this.CLIENTE_SERVICE = CLIENTE_SERVICE;
    }

    @Override
    public void run(String... args) {

        boolean isTrue = true;
        while (isTrue) {
            System.out.println("O que deseja fazer?");
            System.out.println("1 - para interagir com o Cliente:");
            System.out.println("0 - para Sair");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    CLIENTE_SERVICE.menu();
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }


    }
}
