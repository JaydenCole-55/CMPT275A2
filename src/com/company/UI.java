package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame{
    static int FRAME_WIDTH  = 600;
    static int FRAME_HEIGHT = 600;

    private double volume      = 0.0;
    private double myHeight    = 1.0;
    private double myThickness = 0.5;
    private double myHRadius   = 1.0;

    public UI(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setUpDisplay();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setUpDisplay(){
        // Create the frame
        setLayout(new GridLayout(3, 2));

        // Creating panel to hold all the user inputs
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout( new GridLayout(4, 2, 5, 10));
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // Construct all the user inputs
        JLabel heightLabel  = new JLabel(" Enter height (m):");
        JLabel thickLabel   = new JLabel(" Enter thickness (m):");
        JLabel holeRadLabel = new JLabel(" Enter hole radius (m):");

        JTextField userHeight = new JTextField("1");
        JTextField userThick  = new JTextField("1");
        JTextField userHRad   = new JTextField("1");

        // Create volume output subpanel
        JPanel volOutput = new JPanel();
        volOutput.setLayout( new GridLayout(2, 1, 2, 5) );
        JLabel volOutputHeader = new JLabel("<html><div style='text-align: centre;'>Needed liquid (m<sup>3</sup>):" +
                "</div></html>");
        JLabel volOutputNumber = new JLabel("<html><div style='text-align: centre;'>" + Double.toString(volume) +
                "</div></html>");

        // Modify volume output subpanel components
        volOutputHeader.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Add subpanel components to volume output panel
        volOutput.add(volOutputHeader);
        volOutput.add(volOutputNumber);

        // Create calculate button and its listener
        JButton calcBut = new JButton("Calculate");
        calcBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fnCalculateVolume();
                String height = userHeight.getText();
                String thickness = userThick.getText();
                String hRadius = userHRad.getText();

                try{
                    myHeight = Double.parseDouble(height);
                    myThickness = Double.parseDouble(thickness);
                    myHRadius = Double.parseDouble(hRadius);
                } catch (Exception exception){
                    throw exception;
                }
                volume = fnCalculateVolume();

                volOutputNumber.setText("<html><div style='text-align: centre;'>" + Double.toString(volume) +
                        "</div></html>");

                // Update graphic
                fnUpdateGraphic();
            }
        });

        // Add each component to the overall input panel
        inputPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        inputPanel.add(heightLabel);
        inputPanel.add(userHeight);
        inputPanel.add(thickLabel);
        inputPanel.add(userThick);
        inputPanel.add(holeRadLabel);
        inputPanel.add(userHRad);
        inputPanel.add(calcBut);
        inputPanel.add(volOutput);

        // Cylinder graphic panel
        JPanel cylPanel = new JPanel();
        JLabel placeHolder = new JLabel("I am a placeholder of the second panel");
        cylPanel.add(placeHolder);

        // Make and add visual buffer panels around the two panels
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        add(new JPanel());
        add(new JPanel());
        add(inputPanel);
        add(cylPanel);
        add(new JPanel());
        add(new JPanel());
    }

    private double fnCalculateVolume(){
        double volume = 0.0;
        double outerVol = -1.0;
        double innerVol = -1.0;
        double pi = 3.14159265;

        outerVol = pi*(myHRadius + myThickness)*(myHRadius + myThickness)*myHeight;
        innerVol = pi*(myHRadius)*(myHRadius)*myHeight;

        return outerVol-innerVol;
    }

    private void fnUpdateGraphic(){
    }
}
