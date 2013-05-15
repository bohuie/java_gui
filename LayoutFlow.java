import java.awt.*;
import javax.swing.*;

public class LayoutFlow extends JFrame
{
  public LayoutFlow()
  {
    // by default, the layout manager used is the flow layout manager
    JPanel panel = new JPanel();

    // create a button 
    JButton button = new JButton( "button" );

    // create a tree (default will show some components for you)
    JTree tree = new JTree();

    // create a text area of specific size 
    JTextArea area = new JTextArea( "text area" );
    area.setPreferredSize( new Dimension( 100, 100 ));

    // add components "tightly"
    panel.add( button );
    panel.add( tree );
    panel.add( area );
    add( panel );
    pack();

    // set frame attributes
    setTitle( "FlowLayout Example" );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    LayoutFlow ex = new LayoutFlow();
    ex.setVisible( true );
  }
}
