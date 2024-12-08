package Lab_8;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.io.IOException;
import java.util.List;

public class LibraryApp {
    private final BookManager bookManager;

    public LibraryApp() {
        bookManager = new BookManager();
        try {
            bookManager.loadBooks();
        } catch (IOException e) {
            System.out.println(e.toString());;
        }
        createMainMenu();
    }

    private void createMainMenu() {
        JFrame frame = new JFrame("Library Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View All Books");
        JButton findButton = new JButton("Find Book");

        addButton.addActionListener(e -> createAddBookFrame());
        viewButton.addActionListener(e -> createViewBooksFrame());
        findButton.addActionListener(e -> createFindBookFrame());

        frame.add(addButton);
        frame.add(viewButton);
        frame.add(findButton);

        frame.setVisible(true);
    }

    private void createAddBookFrame() {
        JFrame frame = new JFrame("Add Book");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 2));

        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField genreField = new JTextField();
        JTextField isbnField = new JTextField();
        JTextArea descriptionField = new JTextArea();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            Book book = new Book(
                    titleField.getText(),
                    authorField.getText(),
                    genreField.getText(),
                    isbnField.getText(),
                    descriptionField.getText()
            );
            bookManager.getBooks().add(book);
            try {
                bookManager.saveBooks();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
            frame.dispose();
        });

        frame.add(new JLabel("Title"));
        frame.add(titleField);
        frame.add(new JLabel("Author"));
        frame.add(authorField);
        frame.add(new JLabel("Genre"));
        frame.add(genreField);
        frame.add(new JLabel("ISBN"));
        frame.add(isbnField);
        frame.add(new JLabel("Description"));
        frame.add(descriptionField);
        frame.add(saveButton);

        frame.setVisible(true);
    }

    private void createViewBooksFrame() {
        JFrame frame = new JFrame("View All Books");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        String[] columnNames = { "Title", "Author", "Genre", "ISBN", "Description" };
        Object[][] data = bookManager.getBooks()
                .stream()
                .map(book -> new Object[]{
                        book.getTitle(), book.getAuthor(),
                        book.getGenre(), book.getIsbn(),
                        book.getDescription()
                }).toArray(Object[][]::new);
        JTable table = new JTable(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Edit Button Action
        editButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a book to edit.");
                return;
            }

            Book book = bookManager.getBooks().get(selectedRow);

            createEditBookFrame(book, selectedRow, frame);
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a book to delete.");
                return;
            }

            bookManager.getBooks().remove(selectedRow);
            try {
                bookManager.saveBooks();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
            frame.dispose();
            createViewBooksFrame();
        });

        frame.setVisible(true);
    }

    private void createEditBookFrame(Book book, int rowIndex, JFrame parentFrame) {
        JFrame frame = new JFrame("Edit Book");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 2));

        JTextField titleField = new JTextField(book.getTitle());
        JTextField authorField = new JTextField(book.getAuthor());
        JTextField genreField = new JTextField(book.getGenre());
        JTextField isbnField = new JTextField(book.getIsbn());
        JTextArea descriptionField = new JTextArea(book.getDescription());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            // Update book details
            book.setTitle(titleField.getText());
            book.setAuthor(authorField.getText());
            book.setGenre(genreField.getText());
            book.setIsbn(isbnField.getText());
            book.setDescription(descriptionField.getText());

            // Save changes and refresh
            try {
                bookManager.saveBooks();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
            frame.dispose();
            parentFrame.dispose();
            createViewBooksFrame(); // Refresh
        });

        frame.add(new JLabel("Title"));
        frame.add(titleField);
        frame.add(new JLabel("Author"));
        frame.add(authorField);
        frame.add(new JLabel("Genre"));
        frame.add(genreField);
        frame.add(new JLabel("ISBN"));
        frame.add(isbnField);
        frame.add(new JLabel("Description"));
        frame.add(descriptionField);
        frame.add(saveButton);

        frame.setVisible(true);
    }


    private void createFindBookFrame() {
        JFrame frame = new JFrame("Find Book");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Search Bar
        JPanel searchPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        frame.add(searchPanel, BorderLayout.NORTH);

        // Table
        String[] columnNames = { "Title", "Author", "Genre", "ISBN", "Description" };
        Object[][] data = {}; // Empty initially
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Search Button Action
        searchButton.addActionListener(e -> {
            String query = searchField.getText();
            if (query.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter a search query.");
                return;
            }

            // Perform search
            List<Book> results = bookManager.findBooks(query);
            Object[][] searchData = results.stream()
                    .map(book -> new Object[]{
                            book.getTitle(), book.getAuthor(),
                            book.getGenre(), book.getIsbn(),
                            book.getDescription()
                    }).toArray(Object[][]::new);
            table.setModel(new javax.swing.table.DefaultTableModel(searchData, columnNames));
        });

        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new LibraryApp();
    }
}
