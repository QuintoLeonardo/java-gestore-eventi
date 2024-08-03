package com.example.gestoreeventi;

import com.example.gestoreeventi.model.Evento;
import java.time.LocalDate;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestoreEventiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestoreEventiApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        // Creazione di un nuovo evento
        System.out.println("Inserisci il titolo dell'evento:");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci la data dell'evento (formato AAAA-MM-GG):");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr);

        System.out.println("Inserisci il numero totale di posti:");
        int numeroPostiTotali = scanner.nextInt();

        Evento evento = new Evento(titolo, data, numeroPostiTotali);
    }
}