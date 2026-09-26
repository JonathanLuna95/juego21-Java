package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;

public class Dealer {

    private ArrayList<Carta> naipe;

    public ArrayList<Carta> getNaipe() {
        return naipe;
    }

    public void setNaipe(ArrayList<Carta> naipe) {
        this.naipe = naipe;
    }
    
    public void generarNaipe() {

        ArrayList<String> palos = new ArrayList<String>();
        palos.add("T");
        palos.add("CN");
        palos.add("CR");
        palos.add("D");

        ArrayList<String> valores = new ArrayList<String>();
        valores.add("A");
        valores.add("2");
        valores.add("3");
        valores.add("4");
        valores.add("5");
        valores.add("6");
        valores.add("7");
        valores.add("8");
        valores.add("9");
        valores.add("10");
        valores.add("J");
        valores.add("Q");
        valores.add("K");

        for (String palo : palos) {

            for (String valor : valores) {

                Carta carta = new Carta();

                carta.setValor(valor);
                carta.setPalo(palo);

                naipe.add(carta);
            }
        }
    }
    
    public void imprimirNaipe() {

        for (Carta carta : naipe) {
            carta.imprimir();
        }
    }
    
    public Dealer() {
        naipe = new ArrayList<Carta>();
        generarNaipe();
    }
    
    public int generarAleatorio(int maximo) {

        int numero = (int) (Math.random() * (maximo + 1));

        return numero;
    }
    
    public Carta entregarCarta() {

        int posicion = generarAleatorio(naipe.size() - 1);

        Carta carta = naipe.get(posicion);

        naipe.remove(posicion);

        return carta;
    }
}