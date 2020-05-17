package Proyecto.Final.GestorLogico;

import java.util.Random;

public enum ataqueEspecial {

	AIRE, AGUA, FUEGO, TIERRA, ETER, ELECTRICIDAD;

	public static ataqueEspecial getRandomAttack() {

		Random random = new Random();
		return values()[random.nextInt(values().length)];
	
	}
	
}
