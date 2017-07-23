package CREATE_BOOKDB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import java.io.*;
import COMMON_BOOKDB.Book;
import COMMON_BOOKDB.FileIO;
import org.apache.commons.lang3.*;

public class CreateBookDb {

	private JFrame frmCreateBookDatabase;
	private JLabel lblEnterIsbn;
	private JTextField textFieldIsbn;
	private JLabel lblEnterTitle;
	private JTextField textFieldTitle;
	private JLabel lblEnterAuthor;
	private JTextField textFieldAuthor;
	private JLabel lblEnterPublisher;
	private JTextField textFieldPublisher;
	private JLabel lblEnterMonthYear;
	private JTextField textFieldMonthYear;
	private JLabel lblEnterEdition;
	private JTextField textFieldEdition;
	private JLabel lblAddBookTo;
	private JLabel lblEnterTheFollowing;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateBookDb window = new CreateBookDb();
					window.frmCreateBookDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateBookDb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/** Create frame content */
		frmCreateBookDatabase = new JFrame();
		frmCreateBookDatabase.setResizable(false);
		frmCreateBookDatabase.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frmCreateBookDatabase.setTitle("Create Book Database");
		frmCreateBookDatabase.setBounds(100, 100, 537, 417);
		frmCreateBookDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateBookDatabase.getContentPane().setLayout(null);

		lblAddBookTo = new JLabel("Add Book to Library");
		lblAddBookTo.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblAddBookTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddBookTo.setBounds(10, 11, 511, 33);
		frmCreateBookDatabase.getContentPane().add(lblAddBookTo);
		
		lblEnterTheFollowing = new JLabel("Enter the following:");
		lblEnterTheFollowing.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterTheFollowing.setBounds(15, 65, 190, 20);
		frmCreateBookDatabase.getContentPane().add(lblEnterTheFollowing);
		
		/** Add input content */
		lblEnterIsbn = new JLabel("Enter ISBN:");
		lblEnterIsbn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEnterIsbn.setBounds(15, 101, 138, 20);
		lblEnterIsbn.setLabelFor(textFieldIsbn);
		frmCreateBookDatabase.getContentPane().add(lblEnterIsbn);

		textFieldIsbn = new JTextField();
		textFieldIsbn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldIsbn.setBounds(194, 101, 293, 20);
		frmCreateBookDatabase.getContentPane().add(textFieldIsbn);
		textFieldIsbn.setColumns(10);

		lblEnterTitle = new JLabel("Enter Title:");
		lblEnterTitle.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEnterTitle.setBounds(15, 136, 138, 20);
		lblEnterTitle.setLabelFor(textFieldTitle);
		frmCreateBookDatabase.getContentPane().add(lblEnterTitle);

		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldTitle.setBounds(194, 136, 293, 20);
		frmCreateBookDatabase.getContentPane().add(textFieldTitle);
		textFieldTitle.setColumns(10);

		lblEnterAuthor = new JLabel("Enter Author:");
		lblEnterAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEnterAuthor.setBounds(15, 171, 138, 20);
		lblEnterAuthor.setLabelFor(textFieldAuthor);
		frmCreateBookDatabase.getContentPane().add(lblEnterAuthor);

		textFieldAuthor = new JTextField();
		textFieldAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldAuthor.setBounds(194, 171, 293, 20);
		frmCreateBookDatabase.getContentPane().add(textFieldAuthor);
		textFieldAuthor.setColumns(10);

		lblEnterPublisher = new JLabel("Enter Publisher:");
		lblEnterPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEnterPublisher.setBounds(15, 206, 138, 20);
		lblEnterPublisher.setLabelFor(textFieldPublisher);
		frmCreateBookDatabase.getContentPane().add(lblEnterPublisher);

		textFieldPublisher = new JTextField();
		textFieldPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldPublisher.setBounds(194, 206, 293, 20);
		frmCreateBookDatabase.getContentPane().add(textFieldPublisher);
		textFieldPublisher.setColumns(10);

		lblEnterMonthYear = new JLabel("Enter Month & Year:");
		lblEnterMonthYear.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEnterMonthYear.setBounds(15, 241, 138, 20);
		lblEnterMonthYear.setLabelFor(textFieldMonthYear);
		frmCreateBookDatabase.getContentPane().add(lblEnterMonthYear);

		textFieldMonthYear = new JTextField();
		textFieldMonthYear.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldMonthYear.setBounds(194, 241, 293, 20);
		frmCreateBookDatabase.getContentPane().add(textFieldMonthYear);
		textFieldMonthYear.setColumns(10);

		lblEnterEdition = new JLabel("Enter Edition:");
		lblEnterEdition.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEnterEdition.setBounds(15, 276, 138, 20);
		lblEnterEdition.setLabelFor(textFieldEdition);
		frmCreateBookDatabase.getContentPane().add(lblEnterEdition);

		textFieldEdition = new JTextField();
		textFieldEdition.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldEdition.setBounds(194, 276, 293, 20);
		frmCreateBookDatabase.getContentPane().add(textFieldEdition);
		textFieldEdition.setColumns(10);

		btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					btnSubmit_CLICK();
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSubmit.setBounds(204, 317, 151, 28);
		frmCreateBookDatabase.getContentPane().add(btnSubmit);
		
	} // End of method initialize()

	private void btnSubmit_CLICK() {

		// -------------- First, validate all the text fields
		// If any problem, a dialog warning pops up to stop the program
		boolean isValidated = validateTextFields();

		if (!isValidated)
			return;

		// -------------- All the text fields have been validated
		FileIO fileIOHandler = new FileIO();

		// Declare output file database: bookDatabase.txt
		// MUST use \ to qualify '\' in the path of the file
		File outputFile = new File("E:\\\\JAVA\\OUTPUTS\\bookDatabase.txt");

		String strIsbn = textFieldIsbn.getText();
		long isbn = Long.parseLong(strIsbn);

		String strTitle = textFieldTitle.getText();
		String strAuthor = textFieldAuthor.getText();
		String strPublisher = textFieldPublisher.getText();
		String strMonthYear = textFieldMonthYear.getText();
		String strEdition = textFieldEdition.getText();

		// Create a Book object
		Book aBook = new Book(isbn, strTitle);
		aBook.setAuthor(strAuthor);
		aBook.setPublisher(strPublisher);
		aBook.setMonth_year(strMonthYear);
		aBook.setEdition(strEdition);

		// Get the string of book data
		String strBookInfo = aBook.toString();

		try {

			// Write the string to the book database file
			// by adding a line to the file
			fileIOHandler.appendOneLineToFile(outputFile, strBookInfo);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// At this point, already successfully inserting a new book record into
		// the database
		JOptionPane.showMessageDialog(frmCreateBookDatabase,
				"The new book record has been successfully inserted into the database.");

		// After successfully inserting a new book record to the database
		// refresh all the text fields to prepare for the next record
		textFieldIsbn.setText("");
		textFieldTitle.setText("");
		textFieldAuthor.setText("");
		textFieldPublisher.setText("");
		textFieldMonthYear.setText("");
		textFieldEdition.setText("");

	} // End of btnSubmit_CLICK

	
	/****************************
	 * Name: validateTextFields 
	 * Parameters: None Return: boolean --> TRUE: all
	 * the text fields are successfully validate --> FALSE: at least one text
	 * field has failed the validation Description: --> This method verify to be
	 * sure each text field contains valid data: --> Valid data: not null, not
	 * zero-size data, not empty String, not filled only with blank space -->
	 * For ISBN: valid data must also be numeric, i.e. only consisting of digits
	 * 
	 ****************************/
	private boolean validateTextFields() {

		boolean isValidated = true;

		// ----------- Validate ISBN text field

		try {
			Validate.notBlank(textFieldIsbn.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCreateBookDatabase,
					"All the text fields must have valid values - ISBN must have a Numeric Value.");
			textFieldIsbn.requestFocusInWindow(); // make it ready to enter the
													// value
			textFieldIsbn.selectAll(); // select all text in the text field to
										// delete it or to replace it
			isValidated = false;
		}

		if (!isValidated)
			return (isValidated);

		// For ISBN, also need to verify the entered value is a valid numeric
		try {
			@SuppressWarnings("unused")
			long tempLong = Long.parseLong(textFieldIsbn.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCreateBookDatabase, "ISBN must have a Numeric Value.");
			textFieldIsbn.requestFocusInWindow(); // make it ready to enter the
													// value
			textFieldIsbn.selectAll(); // select all text in the text field to
										// delete it or to replace it
			isValidated = false;
		}

		if (!isValidated)
			return (isValidated);

		// ----------- Validate Title text field

		try {
			Validate.notBlank(textFieldTitle.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCreateBookDatabase,
					"All the text fields must have valid values - Title cannot be blank !!!.");
			textFieldTitle.requestFocusInWindow(); // make it ready to enter the
													// value
			textFieldTitle.selectAll(); // select all text in the text field to
										// delete it or to replace it
			isValidated = false;
		}

		if (!isValidated)
			return (isValidated);

		// ----------- Validate Author text field

		try {
			Validate.notBlank(textFieldAuthor.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCreateBookDatabase,
					"All the text fields must have valid values - Author cannot be blank !!!.");
			textFieldAuthor.requestFocusInWindow(); // make it ready to enter
													// the value
			textFieldAuthor.selectAll(); // select all text in the text field to
											// delete it or to replace it
			isValidated = false;
		}

		if (!isValidated)
			return (isValidated);

		// ----------- Validate Publisher text field

		try {
			Validate.notBlank(textFieldPublisher.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCreateBookDatabase,
					"All the text fields must have valid values - Publisher cannot be blank !!!.");
			textFieldPublisher.requestFocusInWindow(); // make it ready to enter
														// the value
			textFieldPublisher.selectAll(); // select all text in the text field
											// to delete it or to replace it
			isValidated = false;
		}

		if (!isValidated)
			return (isValidated);

		// ----------- Validate MonthYear text field

		try {
			Validate.notBlank(textFieldMonthYear.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCreateBookDatabase,
					"All the text fields must have valid values - Month&Year cannot be blank !!!.");
			textFieldMonthYear.requestFocusInWindow(); // make it ready to enter
														// the value
			textFieldMonthYear.selectAll(); // select all text in the text field
											// to delete it or to replace it
			isValidated = false;
		}

		if (!isValidated)
			return (isValidated);

		// ----------- Validate Edition text field

		try {
			Validate.notBlank(textFieldEdition.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCreateBookDatabase,
					"All the text fields must have valid values - Edition cannot be blank !!!.");
			textFieldEdition.requestFocusInWindow(); // make it ready to enter
														// the value
			textFieldEdition.selectAll(); // select all text in the text field
											// to delete it or to replace it
			isValidated = false;
		}

		return (isValidated);

	} // End of method validateTextFields()
	
} // End of class CreateBookDb
