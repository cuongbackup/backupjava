package controller;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T> {
	protected String title;
	protected ArrayList<T> choice;

	public Menu() {

	}

	public Menu(String td, String[] mc) {
		title = td;
		choice = new ArrayList<>();
		for (String s : mc)
			choice.add((T) s);
	}

	public void display() {
		System.out.println(title);
		System.out.println("---------------------------------");
		for (int i = 0; i < choice.size(); i++)
			System.out.println((i + 1) + ". " + choice.get(i));
		System.out.println("---------------------------------");
	}

	public int getSelected() {
		display();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.print("Enter selection: ");
				return Integer.valueOf(sc.nextLine().trim());
			} catch(NumberFormatException e) {
				System.out.println("Wrong input!");
			}

		}
	}

	public abstract void execute(int n);

	public void run() {
		while (true) {
			int n = getSelected();
			execute(n);
			if (n > choice.size())
				break;

		}
	}
}
