package de.mic.crossword.recognize;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageService {

	private BufferedImage makeGrey(BufferedImage colorImage) {
		BufferedImage grayImage = new BufferedImage(colorImage.getWidth(), colorImage.getHeight(),
				BufferedImage.TYPE_BYTE_GRAY);
		Graphics g = grayImage.getGraphics();
		g.drawImage(colorImage, 0, 0, null);
		g.dispose();

		return grayImage;
	}

	public Image loadImage() {
		URL resource = ImageService.class.getResource("/bilder/1.png");
		BufferedImage read = null;
		try {
			read = ImageIO.read(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return makeGrey(read);

	}

	public void findEgdes(int[] image) {

		// float kernely[][] = { { -1, -2, -1 }, { 0, 0, 0 }, { 1, 2, 1 } };
		// float kernelx[][] = { { -1, 0, 1 }, { -2, 0, 2 }, { -1, 0, 1 } };
		//
		// double magX = 0.0; // this is your magnitude
		//
		// for (int a = 0; a < 3; a++) {
		// for (int b = 0; b < 3; b++) {
		// int xn = x + a - 1;
		// int yn = y + b - 1;
		//
		// int index = xn + yn * width;
		// magX += image[index] * kernelx[a][b];
		// }
		// }
	}

	public static void main(String[] args) {
		ImageService imageService = new ImageService();

		JFrame f = new JFrame();
		JPanel p = new JPanel();

		ImageIcon icon = new ImageIcon(imageService.loadImage());
		JButton jButton = new JButton(icon);
		p.add(jButton);
		f.setContentPane(p);
		f.pack();
		f.setVisible(true);

	}
}
