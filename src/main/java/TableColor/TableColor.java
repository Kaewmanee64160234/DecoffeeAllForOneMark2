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

    public TableColor(TableModel dm) {
        super(dm);

        // สร้าง renderer สำหรับตารางและหัวตาราง
        DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) getTableHeader().getDefaultRenderer();

        // กำหนดสีพื้นหลังและสีตัวอักษรสำหรับตารางและหัวตาราง
        tableRenderer.setBackground(Color.LIGHT_GRAY);
        tableRenderer.setForeground(Color.BLACK);
        headerRenderer.setBackground(Color.BLUE);
        headerRenderer.setForeground(Color.WHITE);

        // กำหนด renderer ให้กับตารางและหัวตาราง
        setDefaultRenderer(Object.class, tableRenderer);
        getTableHeader().setDefaultRenderer(headerRenderer);
    }

}
