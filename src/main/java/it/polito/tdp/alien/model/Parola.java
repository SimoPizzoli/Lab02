package it.polito.tdp.alien.model;

import java.util.*;

public class Parola {
	
	private String parola;
	private List<String> traduzioni;
	
	public Parola(String parola) {
		this.parola = parola;

		this.traduzioni = new LinkedList<String>();
	}
	
	public void addTraduzione(String traduzione) {
		traduzioni.add(traduzione);
	}
	
	public List<String> getElencoTraduzioni(){
		return traduzioni;
	}
	
	public boolean isDuplicato(String trad) {
		for(String s : this.traduzioni)
			if(s.equals(trad))
				return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	public String getParola() {
		return this.parola;
	}
}
