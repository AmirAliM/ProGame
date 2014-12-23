package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Paint extends JFrame {
	public int x, y;
	public boolean[][] board = new boolean[3][7];

	public Paint(String name) {
		super(name);
	}

	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, 1500, 1500);

		for (int i = 1; i < 8; i++)
			for (int j = 1; j < 4; j++) {
				if (board[j - 1][i - 1] == false)
					g.setColor(Color.blue);
				else
					g.setColor(Color.yellow);
				g.fillRect(i * 80, j * 80, 80, 80);
			}
		for (int i = 1; i <= 8; i++) {
			g.setColor(Color.black);
			g.drawLine(i * 80, 80, i * 80, 320);
		}
		for (int i = 1; i <= 4; i++) {
			g.setColor(Color.black);
			g.drawLine(80, i * 80, 640, i * 80);
		}
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 7; j++) {
				if (i == x && j == y) {
					g.setColor(Color.black);
					g.fillOval(80 * (j + 1) + 5, 80 * (i + 1) + 5, 70, 70);
				}
			}
	}
}
