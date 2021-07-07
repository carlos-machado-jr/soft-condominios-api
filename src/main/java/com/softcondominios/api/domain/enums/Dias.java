package com.softcondominios.api.domain.enums;

public enum Dias {
	DOMINGO(1, "DOM"),
	SEGUNDA(2, "SEG"),
	TERCA(3, "TER"),
	QUARTA(4, "QUA"),
	QUINTA(5, "QUI"),
	SEXTA(6, "SEX"),
	SABADO(7, "SAB");
	
	private int id;
	private String dia;
	
	private Dias(int i, String dia) {
		this.id = i;
		this.dia = dia;
	}

	public int getId() {
		return id;
	}

	public String getDia() {
		return dia;
	}

	
	
	
}
