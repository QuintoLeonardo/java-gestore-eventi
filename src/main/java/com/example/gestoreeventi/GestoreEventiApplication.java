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

        // Prenotazioni
        System.out.println("Quante prenotazioni vuoi effettuare?");
        int prenotazioniDaEffettuare = scanner.nextInt();
        for (int i = 0; i < prenotazioniDaEffettuare; i++) {
            evento.prenota();
        }

        // Stato delle prenotazioni
        System.out.println("Posti prenotati: " + evento.getNumeroPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));

        // Disdette
        System.out.println("Quante prenotazioni vuoi disdire?");
        int disdetteDaEffettuare = scanner.nextInt();
        for (int i = 0; i < disdetteDaEffettuare; i++) {
            evento.disdici();
        }

        // Stato finale delle prenotazioni
        System.out.println("Posti prenotati: " + evento.getNumeroPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));

        scanner.close();
    }
}