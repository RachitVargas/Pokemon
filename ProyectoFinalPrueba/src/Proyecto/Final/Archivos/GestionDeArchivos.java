package Proyecto.Final.Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import Proyecto.Final.GestorLogico.Account;
import Proyecto.Final.GestorLogico.FactoryPokemon;
import Proyecto.Final.GestorLogico.ataqueEspecial;

public class GestionDeArchivos {

	public void loadingData(ArrayList<Account> dataAccount) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File(
				"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\Account.csv"));

		while (fileReader.hasNextLine()) {

			String currentLine = fileReader.nextLine();
			String datos[] = currentLine.split(",");
			Account readLine = new Account();
			readLine.setUser(datos[0]);
			readLine.setPassword(datos[1]);
			readLine.setAccount(datos[2]);

			dataAccount.add(readLine);

		}

		fileReader.close();
	}

	public boolean generateAccount(String[] newAccount) {

		boolean validation = false;

		File newFile = new File(
				"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
						+ newAccount[2] + ".csv");

		if (!newFile.exists()) {

			try {

				newFile.createNewFile();
				validation = true;

			} catch (IOException e) {
				e.printStackTrace();

				System.out.println("Ha ocurrido un error");
			}

		}

		return validation;
	}

	public void generateJavadex(String[] newAccount) {

		File newFile = new File(
				"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
						+ newAccount[2] + "Javadex.csv");

		if (!newFile.exists()) {

			try {

				newFile.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();

				System.out.println("Ha ocurrido un error");
			}
		}

	}

	public void loadingDataAccount(String[] newAccount) throws IOException {

		Account readLine = new Account();
		readLine.setAccount(newAccount[2]);
		readLine.setAge(newAccount[3]);
		readLine.setCountry(newAccount[4]);
		readLine.setGender(newAccount[5]);

		if (Files.lines(
				Paths.get("C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
						+ newAccount[2] + ".csv"))
				.count() != 0) {

			Files.write(

					Paths.get(
							"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
									+ newAccount[2] + ".csv"),
					("\r\n" + readLine.toStringCsvDataAccount()).getBytes(), StandardOpenOption.APPEND);

		} else {

			Files.write(

					Paths.get(
							"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
									+ newAccount[2] + ".csv"),
					readLine.toStringCsvDataAccount().getBytes(), StandardOpenOption.APPEND);

		}

	}

	public void loadingNewAccount(String[] newAccount) throws IOException {

		Account readLine = new Account();
		readLine.setUser(newAccount[0]);
		readLine.setPassword(newAccount[1]);
		readLine.setAccount(newAccount[2]);

		if (Files.lines(Paths.get(
				"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\Account.csv"))
				.count() != 0) {

			Files.write(

					Paths.get(
							"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\Account.csv"),
					("\r\n" + readLine.toStringCsv()).getBytes(), StandardOpenOption.APPEND);

		} else {

			Files.write(

					Paths.get(
							"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\Account.csv"),
					readLine.toStringCsv().getBytes(), StandardOpenOption.APPEND);

		}

	}

	public void loadingDataPokemon(ArrayList<FactoryPokemon> factory, String[] userAndPassword,
			ArrayList<Account> dataAccount) throws FileNotFoundException {

		String account = "";

		for (int i = 0; i < dataAccount.size(); i++) {

			if (dataAccount.get(i).getUser().equals(userAndPassword[0])
					&& dataAccount.get(i).getPassword().equals(userAndPassword[1])) {

				account = dataAccount.get(i).getAccount();

			}

		}

		Scanner fileReader = new Scanner(
				new File("C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
						+ account + "javadex.csv"));

		while (fileReader.hasNextLine()) {

			String currentLine = fileReader.nextLine();
			String dataPokemon[] = currentLine.split(",");
			FactoryPokemon readLine = new FactoryPokemon();

			readLine.setName(dataPokemon[0]);
			readLine.setExperience(dataPokemon[1]);
			readLine.setSuperiorAttackPower(dataPokemon[2]);
			readLine.setLowerAttackPower(dataPokemon[3]);
			readLine.setMediumAttackPower(dataPokemon[4]);
			readLine.setSuperiorDefense(dataPokemon[5]);
			readLine.setDefensaInferior(dataPokemon[6]);
			readLine.setMediumDefense(dataPokemon[7]);
			readLine.setAttackType(Enum.valueOf(ataqueEspecial.class, dataPokemon[8]));

			factory.add(readLine);

		}

		fileReader.close();

	}

	public static void savePokemonOnlist(FactoryPokemon newPokemon, ArrayList<Account> dataAccount,
			String[] userAndPassword) throws IOException {

		String account = "";

		for (int i = 0; i < dataAccount.size(); i++) {

			if (dataAccount.get(i).getUser().equals(userAndPassword[0])
					&& dataAccount.get(i).getPassword().equals(userAndPassword[1])) {

				account = dataAccount.get(i).getAccount();

			}

		}

		if (Files.lines(
				Paths.get("C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
						+ account + "Javadex.csv"))
				.count() != 0) {

			Files.write(

					Paths.get(
							"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
									+ account + "Javadex.csv"),
					("\r\n" + newPokemon.toStringCsv()).getBytes(), StandardOpenOption.APPEND);

		} else {

			Files.write(

					Paths.get(
							"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
									+ account + "Javadex.csv"),
					newPokemon.toStringCsv().getBytes(), StandardOpenOption.APPEND);

		}

	}

	public static void saveDeletePokemonOnList(ArrayList<FactoryPokemon> factory, int helper) throws IOException {

		if (Files.lines(Paths.get(
				"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\AlmacenDePokemonesDesechados.csv"))
				.count() != 0) {

			Files.write(

					Paths.get(
							"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\AlmacenDePokemonesDesechados.csv"),
					("\r\n" + factory.get(helper - 1).toStringCsv()).getBytes(), StandardOpenOption.APPEND);

		} else {

			Files.write(

					Paths.get(
							"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\AlmacenDePokemonesDesechados.csv"),
					factory.get(helper - 1).toStringCsv().getBytes(), StandardOpenOption.APPEND);
		}

	}

	public static void readPokemonesRemove(ArrayList<FactoryPokemon> almacenDePokemones) throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File(
				"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\AlmacenDePokemonesDesechados.csv"));

		while (fileReader.hasNextLine()) {

			String currentLine = fileReader.nextLine();
			String data[] = currentLine.split(",");
			FactoryPokemon readLine = new FactoryPokemon();

			readLine.setName(data[0]);
			readLine.setExperience(data[1]);
			readLine.setSuperiorAttackPower(data[2]);
			readLine.setLowerAttackPower(data[3]);
			readLine.setMediumAttackPower(data[4]);
			readLine.setSuperiorDefense(data[5]);
			readLine.setDefensaInferior(data[6]);
			readLine.setMediumDefense(data[7]);
			readLine.setAttackType(Enum.valueOf(ataqueEspecial.class, data[8]));

			almacenDePokemones.add(readLine);
		}

		fileReader.close();

	}

	public static void deletePokemonOnList(ArrayList<Account> dataAccount, String[] userAndPassword) {

		String account = "";

		for (int i = 0; i < dataAccount.size(); i++) {

			if (dataAccount.get(i).getUser().equals(userAndPassword[0])
					&& dataAccount.get(i).getPassword().equals(userAndPassword[1])) {

				account = dataAccount.get(i).getAccount();

			}

		}

		File file = new File("C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
				+ account + "Javadex.csv");

		file.delete();

	}

	public static void createListPokemonAgain(ArrayList<Account> dataAccount, String[] userAndPassword) {

		String account = "";

		for (int i = 0; i < dataAccount.size(); i++) {

			if (dataAccount.get(i).getUser().equals(userAndPassword[0])
					&& dataAccount.get(i).getPassword().equals(userAndPassword[1])) {

				account = dataAccount.get(i).getAccount();

			}

		}

		File newFile = new File(
				"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\" + account
						+ "Javadex.csv");

		if (!newFile.exists()) {

			try {

				newFile.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();

				System.out.println("Ha ocurrido un error");
			}
		}
	}

	public static void savePokemonAgainOnList(ArrayList<FactoryPokemon> factory, String[] userAndPassword,
			ArrayList<Account> dataAccount) throws IOException {

		String account = "";

		for (int i = 0; i < dataAccount.size(); i++) {

			if (dataAccount.get(i).getUser().equals(userAndPassword[0])
					&& dataAccount.get(i).getPassword().equals(userAndPassword[1])) {

				account = dataAccount.get(i).getAccount();

			}

		}

		for (int i = 0; i < factory.size(); i++) {

			if (Files.lines(Paths
					.get("C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
							+ account + "Javadex.csv"))
					.count() != 0) {

				Files.write(

						Paths.get(
								"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
										+ account + "Javadex.csv"),
						("\r\n" + factory.get(i).toStringCsv()).getBytes(), StandardOpenOption.APPEND);

			} else {

				Files.write(

						Paths.get(
								"C:\\Users\\User\\eclipse-workspace\\ProyectoFinalPrueba\\src\\Proyecto\\Final\\Archivos\\"
										+ account + "Javadex.csv"),
						factory.get(i).toStringCsv().getBytes(), StandardOpenOption.APPEND);

			}

		}

	}

}
