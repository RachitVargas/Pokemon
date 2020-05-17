package Proyecto.Final.Principal;

import java.io.FileNotFoundException;
import java.io.IOException;

import Proyecto.Final.GestorLogico.GestorLogico;

public class Principal {

	public static void main(String[] args) throws IOException {

		GestorLogico gestorLogico = new GestorLogico();

		int option = 0;

		do {

			gestorLogico.runProgram();

		} while (option == 0);

	}

}
