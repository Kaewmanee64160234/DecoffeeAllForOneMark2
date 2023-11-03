/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableColor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author toey
 */
   public class TableColor extends JTable {

    public TableColor() {
        getTableHeader().setDefaultRenderer((TableCellRenderer) new TableColorHeader());
        getTableHeader().setPreferredSize(new Dimension(0, 35));
    }

    private class TableColorHeader extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(30, 30, 30));
            com.setForeground(new Color(200, 200 ,200));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 14));
            return com;
        }

    }
}



