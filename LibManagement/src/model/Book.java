package model;

public class Book implements Comparable<Book> {

    private String bookID;
    private String bookTitle;
    private String author;
    private int year;

    public Book() {

    }

    public Book(String bookID, String bookTitle, String author, int year) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.author = author;
        this.year = year;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return bookID + " - " + bookTitle + " - " + author + " - " + year;
    }

    @Override
    public int compareTo(Book o) {
        return this.compareTo(o);
    }
}
