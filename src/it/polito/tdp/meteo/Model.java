package it.polito.tdp.meteo;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.meteo.bean.SimpleCity;
import it.polito.tdp.meteo.db.MeteoDAO;

public class Model {

	private final static int COST = 100;
	private final static int NUMERO_GIORNI_CITTA_CONSECUTIVI_MIN = 3;
	private final static int NUMERO_GIORNI_CITTA_MAX = 6;
	private final static int NUMERO_GIORNI_TOTALI = 15;
	
	MeteoDAO mDAO = new MeteoDAO();
	List<SimpleCity> soluzione = new LinkedList<SimpleCity>();
	List<String> citta = new LinkedList<String>();

	public Model() {
		citta.add("Milano");
		citta.add("Torino");
		citta.add("Genova");
	}
	
	
	public void calcola()

	public String getUmiditaMedia(int mese) {
		StringBuilder dati = new StringBuilder();
		dati.append("Milano: " + mDAO.getAvgRilevamentiLocalitaMese(mese, "Milano") + " ");
		dati.append("Torino: " + mDAO.getAvgRilevamentiLocalitaMese(mese, "Torino") + " ");
		dati.append("Genova: " + mDAO.getAvgRilevamentiLocalitaMese(mese, "Genova") + " ");
		return dati.toString();
	}

	public String trovaSequenza(int mese) {
		List<SimpleCity> parziale = new LinkedList<SimpleCity>();
		calcola(parziale,0);
		return "TODO!";
	}
	
	public void calcola(List<SimpleCity> parziale, int level) {
		if(level==15) {
			if((this.punteggioSoluzione(parziale) > this.punteggioSoluzione(soluzione)) && this.controllaParziale(parziale))
				soluzione = parziale;
		}
		
		for(int i=0; i<3; i++) {
			if(citta.get(i).equals(parziale.get(parziale.size()-1))) {
				parziale.add(new SimpleCity(citta.get(i), ) )
			}
		}
	}
		
	private Double punteggioSoluzione(List<SimpleCity> soluzioneCandidata) {
	    double score = 0.0;
		for(SimpleCity sc: soluzioneCandidata)
			score += sc.getCosto();
		return score;
	}

	private boolean controllaParziale(List<SimpleCity> parziale) {
		
		return true;
	}

}
