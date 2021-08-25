package app;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Catalog catalog = new Catalog("Catalog of Books");
		int choice = 2;
	    Scanner scan = new Scanner(System.in);
		while(choice != 0)
		{
			System.out.println("\r\n======================================");
			System.out.println("Option menu: ");
			System.out.println("Choose 1 to add book. ");
			System.out.println("Choose 2 to print all books. ");
			System.out.println("Choose 3 to print books of given category.");
			System.out.println("Choose 4 to import all boks from file.");
			System.out.println("Choose 5 to save catalog to a file.");
			System.out.println("Choose 0 to end the program.");
			System.out.print("Choice: ");
		    choice = scan.nextInt();

			switch(choice)
			{
			case 1:
				catalog.addBook();
				break;
			case 2:
				System.out.print("Number of titles: ");
				Book.printNumber();
				catalog.printAllBooks();
				break;
			case 3:
				System.out.print("Enter category: ");
				String category = scan.next();
				catalog.sortByParameters(category);
				break;
			case 4:
				//System.out.print("Enter file name: ");
				//String fileName = scan.next();
				catalog.importCatalog("bookCatalog.txt");
				break;
			case 5:
				catalog.writeToFileAllBooks("bookCatalog.txt");
				break;
			case 0:
				break;
			}
		}

		
	    scan.close();

	}
}
