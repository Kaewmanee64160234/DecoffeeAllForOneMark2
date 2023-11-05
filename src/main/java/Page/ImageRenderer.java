/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Page;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author USER
 */
public class ImageRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    public ImageRenderer() {
    }

    @Override
    protected void setValue(Object value) {
          if (value instanceof ImageIcon) {
            setIcon((ImageIcon) value);
        } else {
            setText((value == null) ? "" : value.toString());
        }
    }
    
    
    
}
