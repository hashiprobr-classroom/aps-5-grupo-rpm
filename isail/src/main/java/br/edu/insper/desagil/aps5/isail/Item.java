package br.edu.insper.desagil.aps5.isail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private String nome;
    private double minimo;
    private List<LocalDateTime> momentos;
    private List<Comprador> compradores;
    private List<Double> ofertas;

    public Item(String nome, double minimo) {
        this.nome = nome;
        this.minimo = minimo;
        this.momentos = new ArrayList<>();
        this.compradores = new ArrayList<>();
        this.ofertas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    private int encontraMaior() {
        int maior = 0;
        for (int i = 1; i < ofertas.size(); i++) {
            if (ofertas.get(maior) < ofertas.get(i)) {
                maior = i;
            }
        }
        return maior;
    }

    public void fazLance(Comprador comprador, double oferta) {
        if (oferta < minimo) {
            return;
        }

        if (!ofertas.isEmpty()) {
            int maior = encontraMaior();
            if (oferta <= ofertas.get(maior)) {
                return;
            }
        }

        momentos.add(LocalDateTime.now());
        compradores.add(comprador);
        ofertas.add(oferta);

        comprador.incrementa();
    }

    public void imprimeMelhorLance() {
        if (ofertas.isEmpty()) {
            System.out.println("Nenhum lance foi feito ainda!");
        } else {
            int maior = encontraMaior();
            System.out.println(compradores.get(maior) + " ofereceu " + ofertas.get(maior) + " (" + momentos.toString() + ")");
        }
    }

}
