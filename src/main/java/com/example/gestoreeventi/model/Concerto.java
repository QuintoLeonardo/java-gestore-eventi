package com.example.gestoreeventi.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Concerto extends Evento {
    private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, LocalDate data, int numeroPostiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    // Getter e setter
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // formattazione data e ora
    public String getDataEOraFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return getData().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " " + ora.format(formatter);
    }

    // formattazione prezzo
    public String getPrezzoFormattato() {
        return String.format("%.2f€", prezzo);
    }

    @Override
    public String toString() {
        return getDataEOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}
    
    
    