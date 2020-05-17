package Proyecto.Final.CapaPresentacion;

import java.util.ArrayList;
import java.util.Scanner;

import Proyecto.Final.GestorLogico.Account;
import Proyecto.Final.GestorLogico.FactoryPokemon;
import Proyecto.Final.GestorLogico.ataqueEspecial;

public class CapaPresentacion {

	private Scanner input;

	public CapaPresentacion() {

		this.input = new Scanner(System.in);

	}

	public void messageOfWelcome() {

		System.out.println("Bienvenido al nuevo juego de Nintengo, Javamon");

	}

	public String[] getUserAndPassword() {

		System.out.println("Ingrese el usuario");
		String user = input.nextLine();
		System.out.println("Ingrese la contraseña");
		String password = input.nextLine();

		String userAndPassword[] = { user, password };

		return userAndPassword;
	}

	public String[] generateAccount() {

		String[] userAndPassword = getUserAndPassword();

		System.out.println("Ingresa el nombre de tu personaje");
		String account = input.nextLine();
		System.out.println("Ingresa tu edad");
		String age = input.nextLine();
		System.out.println("Ingresa el país");
		String country = input.nextLine();
		System.out.println("Ingresa tu genero (M/F/N)");
		String gender = input.nextLine();

		String[] newAccount = { userAndPassword[0], userAndPassword[1], account, age, country, gender };

		return newAccount;

	}

	public void validationAccount(boolean validation) {

		if (validation == true) {

			System.out.println("Cuenta CREADA exitosamente");

		} else if (validation == false) {

			System.out.println("Lo sentimos, ese personaje ya está registrado en otra cuenta");
			System.out.println("Intentalo de nuevo");

		}

	}

	public int printError(String message) {

		System.out.println(message);
		System.out.println(
				"¿Deseas crear una cuenta nueva? \nMarca: \n1. para crearla \n2. para seguir intentanto ingresar");
		String answer = input.nextLine();
		int answerUser = Integer.parseInt(answer);

		return answerUser;

	}

	public void printMessage() {

		System.out.println("NO hay ninguna cuenta registrada.");
		System.out.println(
				"Por favor crea tu cuenta ingresando tu nuevo usuario/contraseña y tus datos para empezar a jugar");
	}

	public int showOption(String[] userAndPassword) {

		System.out.println("Bienvenido a tu cuenta y a tu javadex " + userAndPassword[0]);
		System.out.println("Selecciona el número de una de las siguentes opciones:");
		System.out.println("1. Fabricar un nuevo Javamon (el javadex solo permite tener 5 Javamones)");
		System.out.println("2. Desechar un Javamon");
		System.out.println("3. Listar los pokemones desechados por todos los usurios (incluyendo esta cuenta)");
		System.out.println("4. Listar los Javamones en el Javadex");
		System.out.println("5. Salir de la cuenta");

		String answerUser = input.nextLine();
		int answerUserToInt = Integer.parseInt(answerUser);

		return answerUserToInt;

	}

	public String namePokemon() {

		System.out.println("¿Cuál nombre le quieres poner a tu Javamon?");
		String name = input.nextLine();
		System.out.println("Javamon creado exitosamente");

		return name;
	}

	public void printMessageOption5(String[] userAndPassword) {

		System.out.println("Saliste de tu cuenta " + userAndPassword[0] + ". Muchas gracias por jugar Javamon");

	}

	public void error() {

		System.out.println("Opción INVALIDA, vuelve a intentarlo");

	}

	public void fullListPokemones() {

		System.out.println("Tu JAVADEX esta FULL, ya ha alcanzado el máximo de Javamones");
		System.out.println("Si quieres crear uno nuevo, deberás eliminar uno de tu JAVADEX");

	}

	public void whitoutPokemon() {

		System.out.println("NO hay Javamones en tu JAVADEX");
		System.out.println("Crea uno para que puedas gestionarlo en tu JAVADEX");

	}

	public void printPokemones(ArrayList<FactoryPokemon> factory) {

		boolean validation = false;

		System.out.println(
				"Elija una de las siguentes opciones:\n1. Filtrar javamon por elemento\n2. Mostrar todos los javamones");

		String option = input.nextLine();

		if (option.equals("1")) {

			System.out.println("Elija el elemento y escribalo: AIRE, AGUA, FUEGO, TIERRA, ETER, ELECTRICIDAD");

			String element = input.nextLine();

			for (int i = 0; i < factory.size(); i++) {

				if (element.equalsIgnoreCase(factory.get(i).getAttackType().toString())) {

					System.out.println(factory.get(i));
					validation = true;

				}

			}

			if (validation == false) {

				System.out.println("NO hay Javamones del tipo " + element);

			}

		} else if (option.equals("2")) {

			for (int i = 0; i < factory.size(); i++) {

				System.out.println(factory.get(i));

			}

		} else {

			error();
		}

	}

	public int deletePokemon(ArrayList<FactoryPokemon> factory) {

		System.out.println("Al eliminar un Javamon, este se enviará a un almacen");
		System.out.println("¿Cuál Javamon quieres eliminar? * Por favor escoge el número de la opcion *");

		for (int i = 0; i < factory.size(); i++) {

			System.out.println((i + 1) + ". " + factory.get(i).getName());

		}

		String answerUser = input.nextLine();

		int option = Integer.parseInt(answerUser);
		return option;
	}

	public String SecurityOption(ArrayList<FactoryPokemon> factory, int answerUser,
			ArrayList<FactoryPokemon> almacenDePokemones) {

		System.out.println(
				"¿Seguro que quieres ELIMINAR a " + factory.get((answerUser - 1)).getName() + " de tu JAVADEX?");
		System.out.println("Marca\nSi. para ELIMNAR el Javamon\nNo. para NO eliminarlo");
		String securityOption = input.nextLine();

		if (securityOption.equalsIgnoreCase("Si")) {

			System.out.println("Pokemon ELIMINADO exitosamente");
			almacenDePokemones.add(factory.get((answerUser - 1)));

		} else if (securityOption.equalsIgnoreCase("No")) {

			System.out.println("Acción CANCELADA");

		} else {

			error();
		}

		return securityOption;
	}

	public void printPokemonesRemove(ArrayList<FactoryPokemon> almacenDePokemones) {

		for (int i = 0; i < almacenDePokemones.size(); i++) {

			System.out.println(almacenDePokemones.get(i));
		}

	}

	public void whitoutPokemonRemove() {

		System.out.println("NO hay Javamones Eliminados");
	}

	public boolean validationAccount1(String[] newAccount2, ArrayList<Account> dataAccount) {

		boolean validation = false;

		for (int i = 0; i < dataAccount.size(); i++) {

			if (newAccount2[0].equals(dataAccount.get(i).getUser())
					&& newAccount2[1].equals(dataAccount.get(i).getPassword())) {

				System.out.println("Lo sentimos. Esa cuenta ya está registrada en nuestro sistema");
				System.out.println("Por favor, intentalo de nuevo");

				validation = true;

			}

		}

		return validation;
	}

}