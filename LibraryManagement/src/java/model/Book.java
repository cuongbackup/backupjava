package model;

import java.io.Serializable;

public class Book implements Serializable, DatabaseInfo{
    private String bookID, title,author,category, description;
    private int pubYear, quantity,availQtt;
    private char status='H';
    private BookDAO bdao= new BookDB();
    public Book() {
    }
    public Book(BookDAO b){
        bdao=b;
    }
    
    public Book(String bookID, String title, String author, String category, String description, int pubYear, int quantity, int availQtt) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
        this.pubYear = pubYear;
        this.quantity = quantity;
        this.availQtt = availQtt;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTacgia() {
        return author;
    }

    public void setTacgia(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailQtt() {
        return availQtt;
    }

    public void setAvailQtt(int availQtt) {
        this.availQtt = availQtt;
    }

    @Override
    public String toString() {
        return bookID + " - " + title + " : " + author + " - " + pubYear;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    public Book addNew(){
        return bdao.addNew(this);
    }
    public static String getHeaderRow(){
        return "<TR><TH>Book ID</TH><TH>Title</TH><TH>Author</TH><TH>Description</TH><TH>Publish year</TH><TH>Category</TH><TH>Update</TH></TR>";
    }
    public String getDataRow(){
        return "<TR><TD>"+bookID+"</TD><TD>"+title+"</TD><TD>"+author+"</TD><TD>"+description+"</TD><TD>"+pubYear+"</TD><TD>"+category+"</TD><TD><A href='update?id="+bookID+"'>Update</A></TD></TR>";
    }
}
