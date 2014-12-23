package client;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {
	public static boolean[][] board = new boolean[3][7];
	public static int x, y;
	public static String face;
	public static Paint myFrame;

	public static void waitForCont() {
		/*
		 * Scanner keyboard = new Scanner(System.in);
		 * 
		 * System.out.println("press enter to continue");
		 * 
		 * keyboard.next();
		 */
		JOptionPane.showMessageDialog(null, "Press ok to go next step...", "Next Step", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void show() {
		for (int i = 0; i < 3; i++, System.out.println())
			for (int j = 0; j < 7; j++)
				if (i == x && j == y)
					System.out.print("P");
				else
					System.out.print((board[i][j] == true ? 1 : 0));
		System.out.println();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 7; j++)
				myFrame.board[i][j] = board[i][j];
		myFrame.x = x;
		myFrame.y = y;
		myFrame.repaint();
		waitForCont();
	}

	public static boolean validCell(int i, int j) {
		return i >= 0 && i < 3 && j >= 0 && j < 7;
	}

	public static void T() {
		board[x][y] = !board[x][y];
		System.out.println("T:");
		show();
	}

	public static void F() {
		if (face == "UP" && validCell(x - 1, y))
			x--;
		if (face == "DOWN" && validCell(x + 1, y))
			x++;
		if (face == "RIGHT" && validCell(x, y + 1))
			y++;
		if (face == "LEFT" && validCell(x, y - 1))
			y--;
		System.out.println("F:");
		show();
	}

	public static void R() {
		if (face == "UP")
			face = "RIGHT";
		else if (face == "RIGHT")
			face = "DOWN";
		else if (face == "DOWN")
			face = "LEFT";
		else if (face == "LEFT")
			face = "UP";
		System.out.println("R:");
		show();
	}

	public static void L() {
		if (face == "UP")
			face = "LEFT";
		else if (face == "LEFT")
			face = "DOWN";
		else if (face == "DOWN")
			face = "RIGHT";
		else if (face == "RIGHT")
			face = "UP";
		System.out.println("L:");
		show();
	}

	public static void prog2() {
		T();
		F();
		T();
		F();
		T();
	}

	public static void prog1() {
		prog2();
		R();
		F();
		R();
		prog2();
	}

	public static void main(String[] args) {
		myFrame = new Paint("ProGame");
		myFrame.setDefaultCloseOperation(Paint.EXIT_ON_CLOSE);
		myFrame.setSize(700, 400);
		myFrame.setVisible(true);
		x = 2;
		y = 0;
		face = "UP";
		prog1();
	}
}
