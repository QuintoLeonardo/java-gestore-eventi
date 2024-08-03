package com.example.gestoreeventi.model;

import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotali;
    private int numeroPostiPrenotati;

    public Evento(String titolo, LocalDate data, int numeroPostiTotali) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        if (numeroPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        this.data = data;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    public void prenota() {
        if (data.isBefore(LocalDate.now())) {
            System.out.println("Non è possibile prenotare per un evento già passato.");
            return;
        }
        if (numeroPostiPrenotati >= numeroPostiTotali) {
            System.out.println("Non ci sono posti disponibili.");
            return;
        }
        numeroPostiPrenotati++;
    }

    public void disdici() {
        if (data.isBefore(LocalDate.now())) {
            System.out.println("Non è possibile disdire un evento già passato.");
            return;
        }
        if (numeroPostiPrenotati <= 0) {
            System.out.println("Non ci sono prenotazioni da disdire.");
            return;
        }
        numeroPostiPrenotati--;
    }

    @Override
    public String toString() {
        return data + " - " + titolo;
    }
}
