/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectInTable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author USER
 */
public class ActionSelecButton extends JButton {

    private boolean mousePress;

    public ActionSelecButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));

        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mousePress = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePress = false;
            }

        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D gp = (Graphics2D) graphics.create();
        gp.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        if (mousePress) {
            gp.setColor(Color.white);//color when click
        } else {
            gp.setColor(Color.gray);
        }
        gp.fill(new Ellipse2D.Double(x, y, size, size));
        gp.dispose();
        super.paintComponent(graphics);
    }

}
