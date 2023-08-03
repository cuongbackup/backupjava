/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.connect;

import com.model.ArticleModel;

public class TestDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        ArticleModel artical = new ArticleModel();
        System.out.println("id=" + artical.getTotalRows());

    }

}
