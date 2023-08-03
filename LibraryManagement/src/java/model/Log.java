package model;

import java.time.LocalDate;

public class Log {
    private int logID,bookID,userID;
    private LocalDate bDate,rDate,mrDate;
    private String description;

    public Log(int logID, int bookID, int userID, LocalDate bDate, LocalDate rDate, LocalDate mrDate, String description) {
        this.logID = logID;
        this.bookID = bookID;
        this.userID = userID;
        this.bDate = bDate;
        this.rDate = rDate;
        this.mrDate = mrDate;
        this.description = description;
    }

    public Log(int bookID, int userID, String description) {
        this.bookID = bookID;
        this.userID = userID;
        bDate=LocalDate.now();
        mrDate=bDate.plusDays(15);
        this.description = description;
    }
    
    

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public LocalDate getrDate() {
        return rDate;
    }

    public void setrDate(LocalDate rDate) {
        this.rDate = rDate;
    }

    public LocalDate getMrDate() {
        return mrDate;
    }

    public void setMrDate(LocalDate mrDate) {
        this.mrDate = mrDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
