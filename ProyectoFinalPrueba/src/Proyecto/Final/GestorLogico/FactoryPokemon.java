package Proyecto.Final.GestorLogico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FactoryPokemon {

	private String name;
	private String experience;
	private String superiorAttackPower;
	private String lowerAttackPower;
	private String mediumAttackPower;
	private String superiorDefense;
	private String defensaInferior;
	private String mediumDefense;
	private ataqueEspecial attackType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String string) {
		this.experience = string;
	}

	public String getSuperiorAttackPower() {
		return superiorAttackPower;
	}

	public void setSuperiorAttackPower(String string) {
		this.superiorAttackPower = string;
	}

	public String getLowerAttackPower() {
		return lowerAttackPower;
	}

	public void setLowerAttackPower(String string) {
		this.lowerAttackPower = string;
	}

	public String getMediumAttackPower() {
		return mediumAttackPower;
	}

	public void setMediumAttackPower(String string) {
		this.mediumAttackPower = string;
	}

	public String getSuperiorDefense() {
		return superiorDefense;
	}

	public void setSuperiorDefense(String string) {
		this.superiorDefense = string;
	}

	public String getDefensaInferior() {
		return defensaInferior;
	}

	public void setDefensaInferior(String string) {
		this.defensaInferior = string;
	}

	public String getMediumDefense() {
		return mediumDefense;
	}

	public void setMediumDefense(String string) {
		this.mediumDefense = string;
	}

	public ataqueEspecial getAttackType() {
		return attackType;
	}

	public void setAttackType(ataqueEspecial ataqueEspecial) {
		this.attackType = ataqueEspecial;
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", experience=" + experience + ", superiorAttackPower=" + superiorAttackPower
				+ ", lowerAttackPower=" + lowerAttackPower + ", mediumAttackPower=" + mediumAttackPower
				+ ", superiorDefense=" + superiorDefense + ", defensaInferior=" + defensaInferior + ", mediumDefense="
				+ mediumDefense + ", attackType=" + attackType + "]";
	}

	public String toStringCsv() {
		return name + "," + experience + "," + superiorAttackPower + "," + lowerAttackPower + "," + mediumAttackPower
				+ "," + superiorDefense + "," + defensaInferior + "," + mediumDefense + "," + attackType;
	}

	public FactoryPokemon makePokemon(String answerUser) {

		FactoryPokemon pokemon = new FactoryPokemon();

		pokemon.setName(answerUser);
		pokemon.setExperience(Integer.toString(random()));
		pokemon.setSuperiorAttackPower(Integer.toString(random()));
		pokemon.setLowerAttackPower(Integer.toString(random()));
		pokemon.setMediumAttackPower(Integer.toString(random()));
		pokemon.setSuperiorDefense(Integer.toString(random()));
		pokemon.setDefensaInferior(Integer.toString(random()));
		pokemon.setMediumDefense(Integer.toString(random()));
		pokemon.setAttackType(ataqueEspecial.getRandomAttack());

		return pokemon;

	}

	private int random() {

		double random = Math.random();
		random = random * 20 + 1;
		return (int) random;
	}
}
