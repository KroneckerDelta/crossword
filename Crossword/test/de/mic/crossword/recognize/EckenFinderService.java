package de.mic.crossword.recognize;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import org.marvinproject.image.corner.moravec.Moravec;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvin.util.MarvinAttributes;

/**
 * Findes auf einem Bild die Ecken.
 * 
 * @author Michael
 *
 */
public class EckenFinderService {
	/**
	 * Liefert ein Bildmit markierten Ecken zurück.
	 * 
	 * @param image
	 * @return Bild
	 */
	public Image getCornerImage(BufferedImage image) {
		Moravec moravec = new Moravec();
		// MarvinImagePlugin moravec =
		// MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.corner.moravec");
		moravec.load();
		moravec.setAttribute("threshold", 50000);

		// 1. Figures
		MarvinImage imageIn = new MarvinImage(image, "png");
		MarvinAttributes attr = new MarvinAttributes();
		moravec.process(imageIn, null, attr);
		imageIn = showCorners(imageIn, attr, 6);
		imageIn.update();
		// MarvinImageIO.saveImage(imageIn, "./Crossword/bilder/neu.png");

		return imageIn.getBufferedImage();
	}

	public static void main(String[] args) {

		Moravec moravec = new Moravec();
		// MarvinImagePlugin moravec =
		// MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.corner.moravec");
		moravec.load();
		moravec.setAttribute("threshold", 50000);

		// 1. Figures
		MarvinImage imageIn = MarvinImageIO.loadImage("./Crossword/bilder/1.png");
		MarvinAttributes attr = new MarvinAttributes();
		moravec.process(imageIn, null, attr);
		imageIn = showCorners(imageIn, attr, 6);
		MarvinImageIO.saveImage(imageIn, "./Crossword/bilder/2.png");
		//
		// // 2. Face
		// moravec.setAttribute("threshold", 2000);
		// moravec.setAttribute("matrixSize", 7);
		// imageIn = MarvinImageIO.loadImage("./Crossword/bilder/1.png");
		// attr = new MarvinAttributes();
		// moravec.process(imageIn, null, attr);
		// imageIn = showCorners(imageIn, attr, 3);
		// MarvinImageIO.saveImage(imageIn, "./Crossword/bilder/3.png");
		// //
		// // // 3. House
		// moravec.setAttribute("threshold", 1500);
		// moravec.setAttribute("matrixSize", 7);
		// imageIn = MarvinImageIO.loadImage("./Crossword/bilder/1.png");
		// attr = new MarvinAttributes();
		// moravec.process(imageIn, null, attr);
		// imageIn = showCorners(imageIn, attr, 3);
		// MarvinImageIO.saveImage(imageIn, "./Crossword/bilder/4.png");
	}

	private static MarvinImage showCorners(MarvinImage image, MarvinAttributes attr, int rectSize) {
		MarvinImage ret = image.clone();
		int[][] cornernessMap = (int[][]) attr.get("cornernessMap");
		int rsize = 0;
		for (int x = 0; x < cornernessMap.length; x++) {
			for (int y = 0; y < cornernessMap[0].length; y++) {
				// Is it a corner?
				if (cornernessMap[x][y] > 0) {
					rsize = Math.min(Math.min(Math.min(x, rectSize), Math.min(cornernessMap.length - x, rectSize)),
							Math.min(Math.min(y, rectSize), Math.min(cornernessMap[0].length - y, rectSize)));
					ret.fillRect(x, y, rsize, rsize, Color.red);
				}
			}
		}

		return ret;
	}
}