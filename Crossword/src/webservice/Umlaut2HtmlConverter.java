package webservice;

/**
 * Erstellt aus einer Fragen einen String um ihn für den Service zu nutzen.
 * 
 * @author michael
 *
 */
public class Umlaut2HtmlConverter {

	private final String AE_HTML = "%C3%A4";
	private final String OE_HTML = "%C3%B6";
	private final String UE_HTML = "%C3%BC";
	private final String SS_HTML = "%C3%9F";

	private final String AE = "ä";
	private final String OE = "ö";
	private final String UE = "ü";
	private final String SS = "ß";

	/**
	 * Ersetzt die Sonderzeichen durch URL Konforme Zeichen.
	 * 
	 * @param original
	 * @return
	 */
	public String convertHtmlKonform(String original) {
		return original.replaceAll(" ", "-");

		// return original.toLowerCase().replaceAll(AE, AE_HTML).replaceAll(OE,
		// OE_HTML).replaceAll(UE, UE_HTML)
		// .replaceAll(SS, SS_HTML);
	}

	private String splittedString(String original) {
		StringBuffer result = new StringBuffer();
		String[] split = original.split(",");
		for (int i = 0; i < split.length; i++) {
			result.append(split[i].trim());
			if (i < split.length - 1) {
				result.append("+");
			}
		}

		return result.toString();
	}

}
