package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Juego21 juego = new Juego21();

		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Pedro");
		Jugador jugador3 = new Jugador("Maria");

		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		juego.agregarJugador(jugador3);

		for (int i = 0; i < 10; i++) {

			System.out.println("PARTIDA " + (i + 1));

			juego.inicializar();
			ArrayList<Jugador> ganadores = juego.jugar();

			if (ganadores.size() > 0) {

				for (Jugador ganador : ganadores) {
					System.out.println("Ganador: " + ganador.getNickname());
				}

			} else {
				System.out.println("No hubo ganador");
			}

			juego.reiniciarJugadores();

			System.out.println("--------------------");
		}

	}

}
