package com.krakedev.juegos.test;

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

        juego.inicializar();

        juego.repartirRonda();

        jugador1.imprimir();
        jugador2.imprimir();
        jugador3.imprimir();

	}

}
