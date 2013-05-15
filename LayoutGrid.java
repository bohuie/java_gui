import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutGrid extends JFrame
{
  public LayoutGrid()
  {
    // set up panel 
    JPanel panel = new JPanel();
    panel.setBorder( BorderFactory.createEmptyBorder( 5, 5, 5, 5 )); // top,L,bottom,R
    panel.setLayout( new GridLayout( 5, 4, 5, 5 ));  // numRows,numCols,hgap,vgap

    // create 19 buttons 
    String[] buttons = { "Clr", "Bck", "", "Close", 
                         "7", "8", "9", "/", 
                         "4", "5", "6", "*", 
                         "1", "2", "3", "-", 
                         "0", ".", "=", "+" };
    // the blank is a label, everything else is a button
    for( int i=0; i<buttons.length; i++ )
    {
      if( i == 2 )
        panel.add( new JLabel( buttons[i] ));
      else if( i == 3 )
      {
        JButton exitButton = new JButton( buttons[i] );
        exitButton.addActionListener( new ActionListener() 
        {
          public void actionPerformed( ActionEvent event ) 
          {
            System.exit( 0 );
          }
        });
        panel.add( exitButton ); 
      }
      else 
        panel.add( new JButton( buttons[i] ));
    }
    add( panel );

    // set frame attributes
    setTitle( "Grid Layout Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    LayoutGrid ex = new LayoutGrid();
    ex.setVisible( true );
  }
}
