package webservice;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebContent {

	public static void main(String[] args) {
		System.out.println("Starte Programm");
		Scanner scanner;
		try {
			System.out.println("Starte Scanner");
			URL url = new URL(
					"https://www.kreuzwort-raetsel.net/suche.php?field=0&s=die+Ackerkrume+lockern&go=suchen#suchbox");

			scanner = new Scanner(url.openStream());
			System.out.println("Scanner fertig! Lese Seite:");
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}
		System.out.println(
				"##################################################################################################################");
		System.out.println(
				"##################################################################################################################");
		System.out.println(
				"##################################################################################################################");
		URL url;
		try {

			url = new URL(
					"https://www.kreuzwort-raetsel.net/suche.php?field=0&s=die+Ackerkrume+lockern&go=suchen#suchbox");
			Scanner scanner2 = new Scanner(new InputStreamReader(url.openStream()));
			while (scanner2.hasNextLine()) {
				System.out.println(scanner2.nextLine());
			}
			scanner2.close();
		} catch (MalformedURLException e) {
			System.err.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		}

	}
}
