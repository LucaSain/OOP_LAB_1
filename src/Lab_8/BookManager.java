package Lab_8;

import java.io.*;
import java.util.*;

public class BookManager {
    private final List<Book> books = new ArrayList<>();
    private final String fileName = "books.csv";

    public void loadBooks() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            books.add(Book.fromCSV(data));
        }
        reader.close();
    }

    public void saveBooks() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Book book : books) {
            writer.write(String.join(",", book.toCSV()));
            writer.newLine();
        }
        writer.close();
    }

    public List<Book> findBooks(String query) {
        query = query.toLowerCase();
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query) || book.getAuthor().toLowerCase().contains(query)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> getBooks() {
        return books;
    }
}
