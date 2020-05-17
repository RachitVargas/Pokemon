package Proyecto.Final.GestorLogico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import Proyecto.Final.Archivos.GestionDeArchivos;
import Proyecto.Final.CapaPresentacion.CapaPresentacion;

public class GestorLogico {

	CapaPresentacion presentacion;
	ArrayList<Account> dataAccount;
	ArrayList<FactoryPokemon> factory;
	GestionDeArchivos archivos;
	ArrayList<FactoryPokemon> almacenDePokemones;

	public GestorLogico() {

		this.presentacion = new CapaPresentacion();
		this.dataAccount = new ArrayList<Account>();
		this.factory = new ArrayList<FactoryPokemon>();
		this.archivos = new GestionDeArchivos();
		this.almacenDePokemones = new ArrayList<FactoryPokemon>();
	}

	public void runProgram() throws IOException {

		presentacion.messageOfWelcome();
		this.archivos.loadingData(this.dataAccount);
		String userAndPassword[] = presentacion.getUserAndPassword();
		int option = Option(userAndPassword);
		runOption(option, userAndPassword);

	}

	private void runOption(int option, String[] userAndPassword) throws IOException {

		switch (option) {

		case 1:

			presentacion.printMessage();
			String[] newAccount = presentacion.generateAccount();

			boolean validation = this.archivos.generateAccount(newAccount);
			presentacion.validationAccount(validation);

			if (validation == true) {

				this.archivos.generateJavadex(newAccount);
				this.archivos.loadingDataAccount(newAccount);
				this.archivos.loadingNewAccount(newAccount);

			}

			break;

		case 2:

			int answerUser = 0;
			this.archivos.loadingDataPokemon(this.factory, userAndPassword, this.dataAccount);

			while (answerUser != 5) {

				answerUser = presentacion.showOption(userAndPassword);

				if (answerUser == 1) {

					if (this.factory.size() < 5) {

						FactoryPokemon newPokemon = createPokemon();
						this.factory.add(newPokemon);
						GestionDeArchivos.savePokemonOnlist(newPokemon, this.dataAccount, userAndPassword);

					} else {

						presentacion.fullListPokemones();

					}

				} else if (answerUser == 2) {

					try {

						deletePokemon();

						GestionDeArchivos.deletePokemonOnList(this.dataAccount, userAndPassword);
						GestionDeArchivos.createListPokemonAgain(this.dataAccount, userAndPassword);
						GestionDeArchivos.savePokemonAgainOnList(this.factory, userAndPassword, this.dataAccount);

					} catch (IndexOutOfBoundsException e) {

						presentacion.error();
					}

				} else if (answerUser == 3) {

					this.almacenDePokemones.clear();
					GestionDeArchivos.readPokemonesRemove(this.almacenDePokemones);

					if (this.almacenDePokemones.size() == 0) {

						presentacion.whitoutPokemonRemove();

					} else {

						presentacion.printPokemonesRemove(almacenDePokemones);

					}

				} else if (answerUser == 4) {

					if (this.factory.size() == 0) {

						presentacion.whitoutPokemon();

					} else {

						presentacion.printPokemones(this.factory);
					}

				} else if (answerUser == 5) {

					presentacion.printMessageOption5(userAndPassword);
					this.factory.clear();

				} else {

					presentacion.error();
				}

			}

			break;

		case 3:

			int answerUser2 = presentacion.printError("Lo sentimos, datos erroneos. Vuelve a intentarlo");

			if (answerUser2 == 1) {

				String[] newAccount2 = presentacion.generateAccount();
				boolean validationAccount = presentacion.validationAccount1(newAccount2, this.dataAccount);

				if (validationAccount == false) {

					validation = this.archivos.generateAccount(newAccount2);
					presentacion.validationAccount(validation);

					if (validation == true) {

						this.archivos.loadingNewAccount(newAccount2);
						this.archivos.generateJavadex(newAccount2);
						this.archivos.loadingDataAccount(newAccount2);

					}

				}

			} else if (answerUser2 != 2) {

				presentacion.error();

			}

			break;

		}

	}

	private void deletePokemon() throws IOException {

		int helper = 0;

		if (this.factory.size() == 0) {

			presentacion.whitoutPokemon();

		} else {

			int answerUser = presentacion.deletePokemon(this.factory);
			String securityOption = presentacion.SecurityOption(this.factory, answerUser, this.almacenDePokemones);
			helper = answerUser;

			if (securityOption.equalsIgnoreCase("Si")) {

				GestionDeArchivos.saveDeletePokemonOnList(this.factory, helper);
				this.factory.remove(helper - 1);

			}
		}

	}

	private FactoryPokemon createPokemon() {

		FactoryPokemon pokemon = new FactoryPokemon();
		String answerUser = presentacion.namePokemon();
		FactoryPokemon pokemonReady = pokemon.makePokemon(answerUser);

		return pokemonReady;
	}

	private int Option(String[] userAndPassword) {

		int option = 0;

		if (this.dataAccount.size() == 0) {

			option = 1;

		} else {

			for (int i = 0; i < this.dataAccount.size(); i++) {

				if (this.dataAccount.get(i).getUser().equals(userAndPassword[0])
						&& this.dataAccount.get(i).getPassword().equals(userAndPassword[1])) {

					option = 2;

					i = (this.dataAccount.size() + 1);

				} else if (this.dataAccount.get(i).getUser().equals(userAndPassword[0])
						|| this.dataAccount.get(i).getPassword().equals(userAndPassword[1])
						|| this.dataAccount.get(i).getUser() != userAndPassword[0]
						|| this.dataAccount.get(i).getPassword() != userAndPassword[1]) {

					option = 3;

				}
			}
		}

		return option;

	}

}
