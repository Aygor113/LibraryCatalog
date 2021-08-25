package app;

public class Book  {
	static int number;		// number of all books
	private final String title;
	private final String author;
	private final BookCategory bookCategory;
	private final String publishingYear;
	private final String numberOfPages;
	private int numberOfCopies;
	private int availableCopies;
	
	
	public Book(String title, String author, BookCategory bookCategory,
			String publishingYear, String numberOfPages, int numberOfCopies, int availableCopies)
	{
		this.title = title;
		this.author = author;
		this.bookCategory = bookCategory;
		this.publishingYear = publishingYear;
		this.numberOfPages = numberOfPages;
		this.numberOfCopies = numberOfCopies;
		this.availableCopies = availableCopies;
		number++;
	}
	
	public String getBookCategory()
	{		
		String bookCat = bookCategory.name();
		return bookCat;
	}
	
	public String getTitle()
	{		
		return title;
	}
	
	public String getAuthor()
	{		
		return author;
	}
	
	public String getPublishingYear()
	{		
		return publishingYear;
	}
	
	public String getNumberOfPages()
	{		
		return numberOfPages;
	}
	
	public int getNumberOfCopies()
	{		
		return numberOfCopies;
	}
	
	public int getNumberOfAvailableCopies()
	{		
		return availableCopies;
	}
	
	public void setNumberOfAvailableCopies(int numberOfBooks)
	{		
		availableCopies += numberOfBooks;
	}
	
	public void printInfo()
	{
		System.out.print("\nBook title: " + title + "\n" + 
						 "Author: " + author +"\n" +
						 "Category: " + bookCategory + "\n" +
						 "Available: " + availableCopies + " / " + numberOfCopies + "\n");
	}
	
	public void borrowBook()
	{
		if(getNumberOfAvailableCopies() >= 1)
		{
			setNumberOfAvailableCopies(-1);
			System.out.print("Book has been borrowed.");
		}
		else
		{
			System.out.print("There are no books left."); 
		}
	}
	
	static void removeBook()
	{
		number--;
		System.out.print("You have removed this book");
	}
	
	static void printNumber()
	{
		System.out.print("Total number of books in library: " + number + "\n");
	}
}
