package Lab_8;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private String description;

    public Book(String title, String author, String genre, String isbn, String description) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.description = description;
    }

    public String[] toCSV() {
        return new String[] { title, author, genre, isbn, description };
    }

    public static Book fromCSV(String[] data) {
        return new Book(data[0], data[1], data[2], data[3], data[4]);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }
}
