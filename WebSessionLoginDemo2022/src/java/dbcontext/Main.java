/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontext;

import dao.UserDao;
import entity.User;

/**
 *
 * @author Ly Quynh Tran
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserDao dao = new UserDao();
        Boolean check = dao.login(new User("dadmin", "abc123"));
        System.out.println(""+check);
        check=dao.registerUser(new User("D", "Nguyen","d@email.com","admin","abc123"));
        System.out.println("Insert: "+check);
    }

}
