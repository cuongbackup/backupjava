package model;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Library {
    private ArrayList<Book> books= new ArrayList<>();
    private ArrayList<User> users= new ArrayList<>();
    private ArrayList<Log> logs= new ArrayList<>();

    public Library() {
        books=BookDB.getAllBook();
    }
//------------------------------------------------------------------    
    public static <T> ArrayList<T> search(ArrayList<T> list,Predicate<T> p){
        ArrayList<T> result= new ArrayList<>();
        for(T b:list) 
            if(p.test(b)) result.add(b);
        return result;
    }
//-------------------------------------------------------------------

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }
    
//-------------------------------------------------------------------
    public static void main(String[] args) {
        Library lib= new Library();
        ArrayList<Book> res=lib.search(lib.getBooks(),p->p.getTitle().contains("program"));
        System.out.println(res);
    }
//------------------------------------------------------------------
    public void addBook(Book b){
        books.add(b);
    }
    
}
