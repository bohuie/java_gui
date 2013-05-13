import javax.swing.*;

public class GUIComponents 
{
  public static void main(String[] args) 
  {
    // Create buttons
    JButton jbtOK     = new JButton("OK"); 
    JButton jbtCancel = new JButton("Cancel");

    // Create a label 
    JLabel jlblName = new JLabel("Enter your name: "); 

    // Create a text field with default text 
    JTextField jtfName = new JTextField("Type Name Here"); 

    // Create check boxes 
    JCheckBox jchkBold   = new JCheckBox("Bold");
    JCheckBox jchkItalic = new JCheckBox("Italic");

    // Create radio buttons
    JRadioButton jrbRed    = new JRadioButton("Red");
    JRadioButton jrbYellow = new JRadioButton("Yellow");

    // Create a combo box with several choices
    String[] choices = {"Year 1", "Year 2", "Year 3", "Year 4"};
    JComboBox jcboColor = new JComboBox( choices ); 

    // Create a panel to group components
    JPanel panel = new JPanel();
    panel.add(jbtOK); 
    panel.add(jbtCancel); 
    panel.add(jlblName);
    panel.add(jtfName); 
    panel.add(jchkBold); 
    panel.add(jchkItalic); 
    panel.add(jrbRed); 
    panel.add(jrbYellow); 
    panel.add(jcboColor); 

    JFrame frame = new JFrame();
    frame.add(panel); 
    frame.setTitle("Show GUI Components"); 
    frame.setSize(450, 100);
    frame.setLocation(200, 100); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    frame.setVisible(true);
  }
}
