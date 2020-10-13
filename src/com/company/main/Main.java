package com.company.main;

public class Main {
    // Instantiates non static UI class
    public static void main(String[] args) {
        UI myUI = new UI();
        myUI.setTitle("Part Calculator");
        myUI.setVisible(true);
    }
}