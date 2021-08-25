package app;

import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Scanner;
import java.util.regex.Pattern;


public class Catalog {
	private String catalogName;
	private static final int NUMBER_OF_BOOK_FIELDS = 7;
    ArrayList<Book> bookList = new ArrayList<Book>();
    

	public Catalog(String catalogName)
	{
		this.catalogName = catalogName;
	}
	
	// sort by book category
	public void sortByParameters(String bookCat)
	{
		System.out.println("Sorted by: " + bookCat);
		System.out.println("Found books: ");
		for (Book book : bookList) {
			String str = book.getBookCategory().toLowerCase();
		    if (str.equals(bookCat.toLowerCase())) {
	            book.printInfo();
	        }
	    }
	}
	
	// sort without book category
	public void sortByParameters(String...arg)
	{
		System.out.println("Sorted by: " + arg);
		System.out.println("Found books: ");
        bookList.forEach(n -> { if (n.getAuthor() == arg[0] || n.getTitle() == arg[1])
        	n.printInfo(); });
        	//System.out.println(n); });
	}
	
	public void addBook()
	{
		System.out.print("Book adding.");
        Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the title of the book: ");
        String titleStr = scanner.nextLine();
		System.out.println("Enter the authors: ");
        String authorStr = scanner.nextLine();
		System.out.println("Enter the category: ");
        String categoryStr = scanner.nextLine();
		System.out.println("Enter the publishing year: ");
        String publishingYearStr = scanner.nextLine();
		System.out.println("Enter the number of pages: ");
        String numberOfPagesStr = scanner.nextLine();
		System.out.println("Enter the number of copies: ");
        int numberOfCopiesInt = scanner.nextInt();
    	System.out.println("Enter the number of available copies: ");
        int numberOfAvailableCopiesInt = scanner.nextInt();
        //scanner1.close();

        BookCategory bookCat = BookCategory.valueOf(categoryStr);
		Book book = new Book(titleStr, authorStr, bookCat, publishingYearStr, numberOfPagesStr, numberOfCopiesInt, numberOfAvailableCopiesInt);
		bookList.add(book);
		System.out.println("Book has been added.");
	}
	
	public void removeBookFromCatalog(int index)
	{
		Book.removeBook();
		bookList.remove(index);
	}
	
	public void printAllBooks()
	{
		System.out.println("List of all books in our library: ");
		for(int i = 0; i < bookList.size(); i++) {
			System.out.print("\r\n");
			System.out.print(i+1 + ".");
			bookList.get(i).printInfo();
        }
	}
	
	public void borrowBook(int index)
	{
		
	}
	
	public void writeToFileAllBooks(String fileName)
	{
		try {
		      File myObj = new File(fileName);
		      if(myObj.exists())
		      {
		    	  myObj.delete();
		      }
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        FileWriter myWriter = new FileWriter(fileName, false);
		        for(int i = 0; i < bookList.size(); i++) {
					String bookListStr = ("Title: " + bookList.get(i).getTitle() + "\r\n" + 
							 "Author: " + bookList.get(i).getAuthor() +"\r\n" +
							 "Category: " + bookList.get(i).getBookCategory() + "\r\n" +
							 "Publishing Year: " + bookList.get(i).getPublishingYear() + "\r\n" +
							 "Number of Pages: " + bookList.get(i).getNumberOfPages() + "\r\n" +
							 "Number of Copies: " + bookList.get(i).getNumberOfCopies() + "\r\n" +
							 "Number of available Copies: " + bookList.get(i).getNumberOfCopies() + "\r\n" + "\r\n");

			        myWriter.write(bookListStr);
		        }
		        myWriter.close();
		      } 
		      else 
		      {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	} // end of method
	
	public void importCatalog(String filePath)
	{
		String[] array;
		// array has size one bigger because of blank space separator
	    array = new String[Catalog.NUMBER_OF_BOOK_FIELDS+1];
	    int counter = 0;
		try {
		      File myObj = new File(filePath);
		      Scanner myReader = new Scanner(myObj).useDelimiter(Pattern.compile("(\\n)|;"));
		      while (myReader.hasNextLine()) 
		      {  
		    	  String data = myReader.nextLine();
		    	  array[counter] = data;

		    	  if(counter<Catalog.NUMBER_OF_BOOK_FIELDS)
		    	  {
	   		    	  String[] sentences = array[counter].split("\\: ");
	   		    	  array[counter] = sentences[1];
		    	  }
		    	  counter++;

		    	 if(counter == Catalog.NUMBER_OF_BOOK_FIELDS+1)
		    	 {
		    		 counter = 0;
		    	 }
		    	 
		    	 if(counter == Catalog.NUMBER_OF_BOOK_FIELDS)
		    	 {
		    		 Book book = new Book(array[0], array[1],  BookCategory.valueOf(array[2]), array[3], array[4], Integer.valueOf(array[5]), Integer.valueOf(array[6]));
		    		 bookList.add(book);
		    	 }
		    	 
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
} // end of class
