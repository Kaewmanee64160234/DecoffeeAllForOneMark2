/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package button;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */

public class MyButton implements ActionListener {
    JFrame interfaceFrame;
    JButton singleplayerButton, multiplayerButton, optionsButton, quitButton;

    public MyButton() {
        JFrame.setDefaultLookAndFeelDecorated(false);
                interfaceFrame = new JFrame("G-Mine B0.4");
                interfaceFrame.setSize(800,600);
                interfaceFrame.setLayout(new GridLayout(9,1, 20, 15));

                singleplayerButton = new JButton("SinglePLayer");
                singleplayerButton.addActionListener(this);
                interfaceFrame.add(singleplayerButton);
                singleplayerButton.setBounds(20, 20, 200, 100);

                multiplayerButton = new JButton("MultiPlayer");
                multiplayerButton.addActionListener(this);
                interfaceFrame.add(multiplayerButton);

                optionsButton = new JButton("Options");
                optionsButton.addActionListener(this);
                interfaceFrame.add(optionsButton);

                quitButton = new JButton("Quit");
                quitButton.addActionListener(this);
                interfaceFrame.add(quitButton);

                interfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                interfaceFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    
}
