/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class TextEditorModel {
    private String document;
    private List<TextEditorObserver> observers;

    public TextEditorModel() {
        this.document = "";
        this.observers = new ArrayList<>();
    }

    public void attach(TextEditorObserver observer) {
        this.observers.add(observer);
    }

    public void detach(TextEditorObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (TextEditorObserver observer : this.observers) {
            observer.update(this);
        }
    }

    public void setDocument(String document) {
        this.document = document;
        this.notifyObservers();
    }

    public String getDocument() {
        return this.document;
    }
}

