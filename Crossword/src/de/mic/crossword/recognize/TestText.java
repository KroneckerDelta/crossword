package de.mic.crossword.recognize;

import static marvin.MarvinPluginCollection.findTextRegions;

import java.awt.Color;
import java.util.Date;
import java.util.List;

import marvin.image.MarvinImage;
import marvin.image.MarvinSegment;
import marvin.io.MarvinImageIO;

public class TestText {
	public TestText(int maxFontLineWidth, int minTextWidth) {
		MarvinImage image = MarvinImageIO.loadImage("bilder/1.png");
		image = findText(image, 15, maxFontLineWidth, minTextWidth, 150);
		String time = new Date().toString();
		MarvinImageIO.saveImage(image, "bilder/Text1_" + maxFontLineWidth + "__" + minTextWidth + ".png");

	}

	public MarvinImage findText(MarvinImage image, int maxWhiteSpace, int maxFontLineWidth, int minTextWidth,
			int grayScaleThreshold) {
		List<MarvinSegment> segments = findTextRegions(image, maxWhiteSpace, maxFontLineWidth, minTextWidth,
				grayScaleThreshold);

		for (MarvinSegment s : segments) {
			if (s.height >= 5) {
				s.y1 -= 5;
				s.y2 += 5;
				image.drawRect(s.x1, s.y1, s.x2 - s.x1, s.y2 - s.y1, Color.red);
				image.drawRect(s.x1 + 1, s.y1 + 1, (s.x2 - s.x1) - 2, (s.y2 - s.y1) - 2, Color.red);
			}

		}
		return image;
	}

	public static void main(String[] args) {
		// new TestText(4, 18);
		// optimale Erkennung bei 4/10
		new TestText(4, 19);

		// for (int maxFontLineWidth = 0; maxFontLineWidth < 5;
		// maxFontLineWidth++) {
		// for (int minTextWidth = 0; minTextWidth < 81; minTextWidth++) {
		// try {
		// new TextTExt(maxFontLineWidth, minTextWidth);
		//
		// } catch (Exception e) {
		// System.out.println("Schlechte Kombi: " + maxFontLineWidth + " / " +
		// minTextWidth);
		// }
		// }
		// }
	}
}
