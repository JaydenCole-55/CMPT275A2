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
	    // Create the frame
        JFrame frame = new JFrame("Part Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // Creating panel to get all the user inputs
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout( new GridLayout(4, 2, 5, 10));
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // Construct all the user inputs
        JLabel heightLabel  = new JLabel(" Enter height (m):");
        JLabel thickLabel   = new JLabel(" Enter thickness (m):");
        JLabel holeRadLabel = new JLabel(" Enter hole radius (m):");

        JTextField userHeight = new JTextField("");
        JTextField userThick  = new JTextField("");
        JTextField userRad    = new JTextField("");

        JButton calcBut = new JButton("Calculate");
        calcBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fnCalculateVolume();
                String height = userHeight.getText();
                String thinkness = userThick.getText();
                String radius = userRad.getText();
            }
        });
        JPanel volOutput = new JPanel();

        // Create volume output subpanel
        volOutput.setLayout( new GridLayout(2, 1, 2, 5) );
        JLabel volOutputHeader = new JLabel("<html><div style='text-align: centre;'>Needed liquid (m<sup>3</sup>):" +
                "</div></html>");
        JLabel volOutputNumber = new JLabel("<html><div style='text-align: centre;'>" + Double.toString(volumeInit) +
                "</div></html>");

        // Modify volume output subpanel components
        volOutputHeader.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Add subpanel components to volume output panel
        volOutput.add(volOutputHeader);
        volOutput.add(volOutputNumber);

        // Add each component to the overall input panel
        inputPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        inputPanel.add(heightLabel);
        inputPanel.add(userHeight);
        inputPanel.add(thickLabel);
        inputPanel.add(userThick);
        inputPanel.add(holeRadLabel);
        inputPanel.add(userRad);
        inputPanel.add(calcBut);
        inputPanel.add(volOutput);

        // Cylinder graphic panel
        JPanel cylPanel = new JPanel();
        JLabel placeHolder = new JLabel("I am a placeholder of the second panel");
        cylPanel.add(placeHolder);

        // Add input and graphic panel to the frame

        // Make and add visual buffer panels around the two panels
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(new JPanel());
        frame.add(new JPanel());
        frame.add(inputPanel);
        frame.add(cylPanel);
        frame.add(new JPanel());
        frame.add(new JPanel());

        frame.setVisible(true);
    }

    private static void fnCalculateVolume(){

        System.out.println("I am in fnCalculateVolume");
    }
}