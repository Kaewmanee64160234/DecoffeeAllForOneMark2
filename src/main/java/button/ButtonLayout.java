/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package button;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class ButtonLayout {


    public class MenuPane extends JPanel {

        public MenuPane() {
            setLayout(new GridBagLayout());

            JButton singleplayerButton = new JButton("SinglePLayer");
            JButton multiplayerButton = new JButton("MultiPlayer");
            JButton optionsButton = new JButton("Options");
            JButton quitButton = new JButton("Quit");

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipadx = 20;
            gbc.ipady = 20;

            add(singleplayerButton, gbc);
            gbc.gridy++;
            add(multiplayerButton, gbc);
            gbc.gridy++;
            add(optionsButton, gbc);
            gbc.gridy++;
            add(quitButton, gbc);
        }
    }
}
