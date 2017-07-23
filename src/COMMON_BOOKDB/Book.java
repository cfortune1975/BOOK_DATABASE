package COMMON_BOOKDB;

/**
 * @author Thuan Nguyen
 *
 */

public class Book {

	// --------------- Declare attributes
	private long isbn;
	private String title;
	private String author;
	private String publisher;
	private String month_year; // year of publication
	private String edition; // e.g. 1st Edition, 2nd Edition, 3rd Edition

	// --------------- Declare constructors
	public Book() {

		isbn = 0;
		title = "";
		author = "";
		publisher = "";
		month_year = "";
		edition = "";

	} // End of default constructor

	// Another constructor
	public Book(long anIsbn, String aTitle) {

		isbn = anIsbn;
		title = aTitle;
		author = "";
		publisher = "";
		month_year = "";
		edition = "";

	} // End of another constructor

	// Another constructor
	// This constructor recreates a book object out of a string of book info
	// The string aStrBookData is of CSV format - has been verified: NOT NULL
	// and NOT EMPTY STRING
	public Book(String aStrBookData) {

		Book aBook = recreateBookFromString(aStrBookData);

		isbn = aBook.getIsbn();
		title = aBook.getTitle();
		author = aBook.getAuthor();
		publisher = aBook.getPublisher();
		month_year = aBook.getMonth_year();
		edition = aBook.getEdition();

	} // End of another constructor

	// --------------- GET & SET methods

	public long getIsbn() {
		return (isbn);
	}

	public void setIsbn(long anIsbn) {
		isbn = anIsbn;
	}

	public String getTitle() {
		return (title);
	}

	public void setTitle(String aTitle) {
		title = aTitle;
	}

	public String getAuthor() {
		return (author);
	}

	public void setAuthor(String anAuthor) {
		author = anAuthor;
	}

	public String getPublisher() {
		return (publisher);
	}

	public void setPublisher(String aPublisher) {
		publisher = aPublisher;
	}

	public String getMonth_year() {
		return (month_year);
	}

	public void setMonth_year(String aMonth_year) {
		month_year = aMonth_year;
	}

	public String getEdition() {
		return (edition);
	}

	public void setEdition(String anEdition) {
		edition = anEdition;
	}

	// --------------- Other methods

	// This method returns a string that stores all data fields of a book record
	// The fields are separated by a comma ','
	// The string can be used to insert a book record (a line) into a .CSV file
	// database
	// This method overrides the same method of class Object from which all Java
	// classes inherit
	@Override
	public String toString() {

		String bookStr = Long.toString(isbn) + "," + title + "," + author + "," + publisher + "," + month_year + ","
				+ edition;

		return (bookStr);

	} // End of toString

	// This method recreate a Book object out of a string of CSV format.
	// This string contains all data fields of the book
	// After recreating the book, the method returns the object
	public static Book recreateBookFromString(String aStrBookData) {

		Book aBook = new Book();

		if (aStrBookData.isEmpty()) {
			return (null);
		}

		int preCommaIndex = 0; // index of the preceding comma in the CSV string
		int nextCommaIndex = 0; // index of the next comma in the CSV string
		String nextSubstring = "";

		// ---------- Retrieve the ISBN number
		// Get the index of the 1st comma that separates isbn and title
		nextCommaIndex = aStrBookData.indexOf(',');

		// Get the substring of the ISBN number
		// BE CAREFUL!!!: substring (int startIndex, int endIndex) - See manual
		// of this method
		// Actually, the substring starts at startIndex and extends to (endIndex
		// - 1) - NOT endIndex
		// So, endIndex must be nextCommaIndex, NOT nextCommaIndex - 1
		nextSubstring = aStrBookData.substring(0, nextCommaIndex);

		// Convert this string to long'
		long anIsbn = Long.parseLong(nextSubstring);

		// Set ISBN number
		aBook.setIsbn(anIsbn);

		// ---------- Retrieve the title
		// Get the index of the 1st comma that separates isbn and title
		preCommaIndex = nextCommaIndex;
		nextCommaIndex = aStrBookData.indexOf(',', preCommaIndex + 1);

		// Get the substring of title
		nextSubstring = aStrBookData.substring(preCommaIndex + 1, nextCommaIndex);

		// Set title
		aBook.setTitle(nextSubstring);

		// ---------- Retrieve the author
		// Get the index of the 1st comma that separates isbn and title
		preCommaIndex = nextCommaIndex;
		nextCommaIndex = aStrBookData.indexOf(',', preCommaIndex + 1);

		// Get the substring of author
		nextSubstring = aStrBookData.substring(preCommaIndex + 1, nextCommaIndex);

		// Set title
		aBook.setAuthor(nextSubstring);

		// ---------- Retrieve the publisher
		// Get the index of the 1st comma that separates isbn and title
		preCommaIndex = nextCommaIndex;
		nextCommaIndex = aStrBookData.indexOf(',', preCommaIndex + 1);

		// Get the substring of publisher
		nextSubstring = aStrBookData.substring(preCommaIndex + 1, nextCommaIndex);

		// Set title
		aBook.setPublisher(nextSubstring);

		// ---------- Retrieve month & year
		// Get the index of the 1st comma that separates isbn and title
		preCommaIndex = nextCommaIndex;
		nextCommaIndex = aStrBookData.indexOf(',', preCommaIndex + 1);

		// Get the substring of month_year
		nextSubstring = aStrBookData.substring(preCommaIndex + 1, nextCommaIndex);

		// Set title
		aBook.setMonth_year(nextSubstring);

		// ---------- Retrieve edition

		// Get the substring of edition - last substring starting from index of
		// last comma + 1
		preCommaIndex = nextCommaIndex;
		nextSubstring = aStrBookData.substring(preCommaIndex + 1);

		// Set title
		aBook.setEdition(nextSubstring);

		return (aBook);
	}

	public void displayBookInfo() {

		System.out.println(toString());

	} // End of displayBookInfo

} // End of class Book
