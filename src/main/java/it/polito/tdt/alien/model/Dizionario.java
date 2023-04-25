package it.polito.tdt.alien.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dizionario {
	
	private Map <String, List<String>> mappaTranslate;
	
	public Dizionario() {
		mappaTranslate= new HashMap<>();
	}
	
	public void add(String key, List<String> lista) {
		List<String> risultato= mappaTranslate.get(key);
		
		if(risultato==null) {
			mappaTranslate.put(key, lista);
		}
		
		else {
			for(String s:lista) {
				risultato.add(s);
			}
		}
	}
	
	public String stampa(String key) {
		List<String> risultato= mappaTranslate.get(key);
		String end=""+key+" ";
		
		if(risultato==null){
			return "Nessun valore inserito";
		}
		else {
			for(String s: risultato) {
				end+=s+" ";
			}
		}
		
		return end.substring(0,end.length()-1);
	}
	
	
	

}
