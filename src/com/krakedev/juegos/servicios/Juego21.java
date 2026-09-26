package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {
	
	private ArrayList<Jugador> jugadores;
	private Dealer dealer;
	
	public Juego21() {
	    jugadores = new ArrayList<Jugador>();
	}
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
	public void cargarValores() {
		for(Carta carta : dealer.getNaipe()) {
			switch (carta.getValor()) {
			case "A" :
				carta.setValorJuego(11);
				break;
			case "J" :
			case "Q" :
			case "K" :
				carta.setValorJuego(10);
				break;
			default :
				int x = Integer.parseInt(carta.getValor());
				carta.setValorJuego(x);
				break;
			}
		}
	}
	
	public void inicializar() {
		this.dealer = new Dealer();
		cargarValores();
	}
	
	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}
	
	public void repartirCarta(Jugador jugador) {
		Carta carta = this.dealer.entregarCarta();
		jugador.recibirCarta(carta);
	}
	
	public void repartirRonda() {
		for(Jugador jugador : jugadores) {
			repartirCarta(jugador);
		}
		 calcularTotal();
	}
	
	public void calcularTotal() {
	    for (Jugador jugador : jugadores) {

	        int total = 0;

	        for (Carta carta : jugador.getCartas()) {
	            total = total + carta.getValorJuego();
	        }

	        jugador.setPuntajeCartas(total);
	    }
	}
	
	public ArrayList<Jugador> validarGanador() {

	    ArrayList<Jugador> ganadores = new ArrayList<Jugador>();

	    for (Jugador jugador : jugadores) {

	        if (jugador.getPuntajeCartas() == 21) {
	            ganadores.add(jugador);
	        }
	    }

	    return ganadores;
	}
	
	public ArrayList<Jugador> jugar() {

	    ArrayList<Jugador> ganadores = new ArrayList<Jugador>();

	    for (int i = 0; i < 3; i++) {

	        repartirRonda();

	        ganadores = validarGanador();

	        if (ganadores.size() > 0) {
	            break;
	        }
	    }

	    return ganadores;
	}
	
	public void reiniciarJugadores() {
	    for (Jugador jugador : jugadores) {
	        jugador.setPuntajeCartas(0);
	        jugador.getCartas().clear();
	    }
	}

}
