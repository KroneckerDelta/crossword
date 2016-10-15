package de.mic.crossword;

import static de.mic.crossword.Testfragen.ALGERISCHE_STADT;
import static de.mic.crossword.Testfragen.ANZAHL_REIHEN;
import static de.mic.crossword.Testfragen.ANZAHL_SPALTEN;
import static de.mic.crossword.Testfragen.AN_JEDEN_PLATZ_ORT;
import static de.mic.crossword.Testfragen.AUSFUEHREN_VERRICHTEN;
import static de.mic.crossword.Testfragen.BALDRIANGEWAECHS;
import static de.mic.crossword.Testfragen.BIBL_STAMMVATER_ARCHE;
import static de.mic.crossword.Testfragen.BUCH_DES_ALTEN_TESTAMENTS;
import static de.mic.crossword.Testfragen.BUNDESSTAAT_DER_USA;
import static de.mic.crossword.Testfragen.DIE_ACKERKRUME_LOCKERN;
import static de.mic.crossword.Testfragen.DUESENFLUGZEUG;
import static de.mic.crossword.Testfragen.EINWOHNER_DER_GRIECH_HAUPTSTADT;
import static de.mic.crossword.Testfragen.EIWEISSHALTIGE_NUTZPFLANZE;
import static de.mic.crossword.Testfragen.FEINER_UNTERSCHIED_FEINHEIT;
import static de.mic.crossword.Testfragen.FRANZ_WEIBLICHER_ARTIKEL;
import static de.mic.crossword.Testfragen.FREUNDLICH;
import static de.mic.crossword.Testfragen.FRUEHERE_MUENZE;
import static de.mic.crossword.Testfragen.GARTENGERAET_HARKE;
import static de.mic.crossword.Testfragen.GEBIRGE_ZWISCHEN_EUROPA_UND_ASIEN;
import static de.mic.crossword.Testfragen.HANDARBEITSTECHNIK;
import static de.mic.crossword.Testfragen.KNOCHENGERUEST;
import static de.mic.crossword.Testfragen.LAUTSTAERKEMASS;
import static de.mic.crossword.Testfragen.PAPSTKRONE;
import static de.mic.crossword.Testfragen.REGE_MUNTER;
import static de.mic.crossword.Testfragen.REICH_AN_LICHT;
import static de.mic.crossword.Testfragen.RUHMESBAU_BEI_REGENSBURG;
import static de.mic.crossword.Testfragen.STADT_AN_DER_MURG;
import static de.mic.crossword.Testfragen.VERMUTEN;
import static de.mic.crossword.Testfragen.WEIBLICHES_BUEHNENFACH;
import static de.mic.crossword.Testfragen.WESTAFRIKANER;
import static de.mic.crossword.Testfragen.WIDERHALL;
import static de.mic.crossword.Testfragen.WUERDIGEN_AUSZEICHNEN_UGS;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import de.mic.crossword.Raetsel.Richtung;
import webservice.AntwortenService;
import webservice.webseite.KreuzwortraetselDotCom;

public class TestRaetsel {
	private RaetselTestdatenLoesungen raetselTestdatenLoesungen;

	public Raetsel create() {
		Raetsel r = new Raetsel();
		List<Zelle> alleZellen = new ArrayList<>();
		for (int i = 0; i < ANZAHL_SPALTEN; i++) {
			for (int j = 0; j < ANZAHL_REIHEN; j++) {
				alleZellen.add(new Zelle(new Point(i, j)));
			}
		}
		r.addAll(alleZellen);
		// Fragen hinzufügen
		erstelleDieFragen(r);

		erstelleDieGewinnerZellen(r);

		fuegeEchteFragenHinzu(r);

		// fuegeAntwortenHinzu(r);
		return r;
	}

	private void fuegeAntwortenHinzu(Raetsel r) {

		RaetselAntwortenService service = new RaetselAntwortenService();
		List<Zelle> fragen = r.getFrageZellen();
		service.sammleAntworten(fragen);
	}

	private void fuegeEchteFragenHinzu(Raetsel r) {

		// Erste Reihe
		erstelleFrage(r, DIE_ACKERKRUME_LOCKERN, new Point(0, 0), Richtung.SENKRECHT, new Point(1, 0), 5);
		erstelleFrage(r, WESTAFRIKANER, new Point(0, 1), Richtung.WAAGERECHT, new Point(1, 1), 7);
		erstelleFrage(r, GARTENGERAET_HARKE, xy(0, 3), Richtung.WAAGERECHT, xy(0, 3), 6);
		erstelleFrage(r, BIBL_STAMMVATER_ARCHE, xy(0, 4), Richtung.WAAGERECHT, xy(1, 4), 4);
		erstelleFrage(r, WUERDIGEN_AUSZEICHNEN_UGS, xy(0, 5), Richtung.WAAGERECHT, xy(0, 6), 5);
		erstelleFrage(r, EIWEISSHALTIGE_NUTZPFLANZE, xy(0, 8), Richtung.WAAGERECHT, xy(0, 7), 4);
		erstelleFrage(r, PAPSTKRONE, xy(0, 9), Richtung.WAAGERECHT, xy(1, 9), 5);
		erstelleFrage(r, LAUTSTAERKEMASS, xy(0, 11), Richtung.WAAGERECHT, xy(0, 9), 4);
		erstelleFrage(r, BALDRIANGEWAECHS, xy(0, 12), Richtung.WAAGERECHT, xy(1, 12), 5);

		// zweite Reihe
		erstelleFrage(r, AN_JEDEN_PLATZ_ORT, xy(1, 5), Richtung.SENKRECHT, xy(1, 6), 7);
		// dritte Reihe
		erstelleFrage(r, RUHMESBAU_BEI_REGENSBURG, xy(2, 0), Richtung.SENKRECHT, xy(3, 0), 8);
		erstelleFrage(r, FRANZ_WEIBLICHER_ARTIKEL, xy(2, 2), Richtung.WAAGERECHT, xy(3, 2), 2);
		erstelleFrage(r, REGE_MUNTER, xy(2, 5), Richtung.WAAGERECHT, xy(3, 5), 7);
		erstelleFrage(r, BUNDESSTAAT_DER_USA, xy(2, 8), Richtung.SENKRECHT, xy(2, 9), 4);

		// vierte Reihe
		erstelleFrage(r, AUSFUEHREN_VERRICHTEN, xy(3, 8), Richtung.WAAGERECHT, xy(4, 8), 3);
		erstelleFrage(r, WIDERHALL, xy(3, 11), Richtung.WAAGERECHT, xy(4, 11), 4);

		// fünfte Reihe
		erstelleFrage(r, HANDARBEITSTECHNIK, xy(4, 0), Richtung.SENKRECHT, xy(4, 1), 6);
		erstelleFrage(r, FREUNDLICH, xy(4, 7), Richtung.WAAGERECHT, xy(5, 7), 4);
		erstelleFrage(r, WEIBLICHES_BUEHNENFACH, xy(4, 10), Richtung.WAAGERECHT, xy(5, 10), 5);

		// Ab hier nur noch die Gewinnerspalten.
		// 8
		erstelleFrage(r, DUESENFLUGZEUG, xy(5, 0), Richtung.SENKRECHT, xy(6, 0), 3);
		// 9
		erstelleFrage(r, FRUEHERE_MUENZE, xy(5, 2), Richtung.WAAGERECHT, xy(6, 2), 5);
		erstelleFrage(r, ALGERISCHE_STADT, xy(10, 0), Richtung.SENKRECHT, xy(10, 1), 4);
		// 7
		erstelleFrage(r, EINWOHNER_DER_GRIECH_HAUPTSTADT, xy(5, 4), Richtung.WAAGERECHT, xy(5, 4), 7);
		erstelleFrage(r, STADT_AN_DER_MURG, xy(7, 0), Richtung.SENKRECHT, xy(7, 1), 7);
		// 1
		erstelleFrage(r, KNOCHENGERUEST, xy(8, 0), Richtung.SENKRECHT, xy(9, 0), 7);
		// 3
		erstelleFrage(r, VERMUTEN, xy(6, 3), Richtung.SENKRECHT, xy(6, 4), 5);
		// 4
		erstelleFrage(r, GEBIRGE_ZWISCHEN_EUROPA_UND_ASIEN, xy(10, 5), Richtung.SENKRECHT, xy(10, 6), 4);
		erstelleFrage(r, REICH_AN_LICHT, xy(6, 9), Richtung.WAAGERECHT, xy(7, 9), 4);
		// 6
		erstelleFrage(r, BUCH_DES_ALTEN_TESTAMENTS, xy(7, 8), Richtung.SENKRECHT, xy(7, 9), 4);
		// 5
		erstelleFrage(r, FEINER_UNTERSCHIED_FEINHEIT, xy(5, 6), Richtung.SENKRECHT, xy(5, 7), 6);

	}

	private void erstelleFrage(Raetsel r, String frage, Point frageXY, Richtung richtung, Point antwortXY, int anzahl) {
		Frage f2 = new Frage(frage);
		f2.addZellen(r.getZellen(anzahl, richtung, antwortXY));
		Zelle zelle = r.getZelle(frageXY.x, frageXY.y);
		zelle.addFrage(f2);
		f2.setAntworten(getAntworten(f2));
	}

	private static Point xy(int x, int y) {
		return new Point(x, y);
	}

	private void erstelleDieFragen(Raetsel r) {
		erstelleFrageProReihe(0, r, 0, 2, 4, 5, 7, 9, 11, 12);
		erstelleFrageProReihe(1, r, 0, 8);
		erstelleFrageProReihe(2, r, 0, 2, 5, 11);
		erstelleFrageProReihe(3, r, 6, 8);
		erstelleFrageProReihe(4, r, 0, 5);
		erstelleFrageProReihe(5, r, 0, 1, 2, 10);
		erstelleFrageProReihe(6, r, 5, 8);
		erstelleFrageProReihe(7, r, 4, 9, 12);
		erstelleFrageProReihe(8, r, 0, 2, 3, 7, 8);
		erstelleFrageProReihe(9, r, 0, 6, 11);
		erstelleFrageProReihe(10, r, 4, 10);
		erstelleFrageProReihe(11, r, 0, 3, 8);
		erstelleFrageProReihe(12, r, 0, 6);
	}

	private List<String> getAntworten(Frage f) {
		RaetselAntwortenService s = new RaetselAntwortenService() {

			@Override
			protected List<String> getAntworten(String frage) {

				AntwortenService service = new AntwortenService(new KreuzwortraetselDotCom()) {
					@Override
					public List<String> getAntworten(String frage) {
						return new ArrayList<String>();
					}
				};

				if (raetselTestdatenLoesungen == null) {
					raetselTestdatenLoesungen = new RaetselTestdatenLoesungen(service);
				}
				return raetselTestdatenLoesungen.getAntworten(frage);
			}
		};
		return s.getAntworten(f.getFrage());

	}

	private void erstelleDieGewinnerZellen(Raetsel r) {
		erstelleGewinnerZelle(r, 1, 6, 8);
		erstelleGewinnerZelle(r, 2, 10, 9);
		erstelleGewinnerZelle(r, 4, 7, 7);
		erstelleGewinnerZelle(r, 5, 9, 1);
		erstelleGewinnerZelle(r, 7, 1, 2);
		erstelleGewinnerZelle(r, 8, 6, 3);
		erstelleGewinnerZelle(r, 9, 10, 4);
		erstelleGewinnerZelle(r, 10, 7, 6);
		erstelleGewinnerZelle(r, 12, 5, 5);

	}

	private void erstelleGewinnerZelle(Raetsel r, int y, int x, int stelle) {
		r.getZelle(x, y).addGewinnfeld(stelle);

	}

	private void erstelleFrageProReihe(int x, Raetsel r, int... alleY) {

		for (int y : alleY) {
			r.getZelle(x, y).addEigenschaft(Zelltyp.BUCHSTABE);
		}

	}

}
