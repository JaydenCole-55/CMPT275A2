package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static int FRAME_WIDTH  = 600;
    static int FRAME_HEIGHT = 600;
    private static double volumeInit = 0.0;
    private double myHeight = 0.0;
    private double myThickness = 0.0;
    private double myRadius = 0.0;

    public static void main(String[] args) {
        UI myUI = new UI();
        myUI.setVisible(true);
    }
}