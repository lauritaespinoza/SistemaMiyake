
package util.almacen;

//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.TextComponent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


public class MetodoGenerales{
   
    
    public static void activarControles2(JComponent componetes, boolean estado){
        Component[] contenedor = componetes.getComponents(); 
        for (int i = 0; i < contenedor.length; i++) {
            if (contenedor[i] instanceof  JTextField || 
                    contenedor[i] instanceof JLabel || 
                    contenedor[i] instanceof JButton || 
//                    contenedor[i] instanceof JTextArea ||
                    contenedor[i] instanceof JTextComponent ||
                    contenedor[i] instanceof JComboBox) {
                contenedor[i].setEnabled(estado);
            }
        }
    }
    
   public static void activarControles3(JComponent componetes, boolean estado){
        Component[] contenedor = componetes.getComponents(); 
        for (int i = 0; i < contenedor.length; i++) {
            if (contenedor[i] instanceof  JTextField || 
                    contenedor[i] instanceof JLabel || 
                    contenedor[i] instanceof JButton || 
//                    contenedor[i] instanceof JDateChooser ||
//                    contenedor[i] instanceof JTextArea ||
                    contenedor[i] instanceof JTextComponent ||
                    contenedor[i] instanceof JComboBox) {
                contenedor[i].setEnabled(estado);
            }
        }
    }
     public static void activarControles33(JComponent componetes, boolean estado) {
        Component[] contenedor = componetes.getComponents();
        Component aux;
        for (int i = 0; i < contenedor.length; i++) {
            if (contenedor[i] instanceof JTextField
                    || contenedor[i] instanceof JLabel
                    || contenedor[i] instanceof JButton
                    || contenedor[i] instanceof JCheckBox
                    || contenedor[i] instanceof JRadioButton
                    || //                    contenedor[i] instanceof JDateChooser ||
                    //                    contenedor[i] instanceof JTextArea ||
                    contenedor[i] instanceof JTextComponent
                    || contenedor[i] instanceof JComboBox) {
                contenedor[i].setEnabled(estado);
//               
                if (contenedor[i] instanceof JTextField) {
                    aux = contenedor[i];
                    ((JTextField) aux).setText("");
                }
                if (contenedor[i] instanceof JComboBox) {
                    aux = contenedor[i];
                    ((JComboBox) aux).setSelectedIndex(-1);
                }
                if (contenedor[i] instanceof JCheckBox) {
                    aux = contenedor[i];
                    ((JCheckBox) aux).setSelected(false);
                }
                if (contenedor[i] instanceof JRadioButton) {
                    aux = contenedor[i];
                    ((JRadioButton) aux).setSelected(false);
                }
            }
        }
    }

 
   
}
