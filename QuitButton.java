import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class QuitButton extends JFrame 
{
  public QuitButton() 
  {
    JPanel panel = new JPanel();
    panel.setLayout( null );
    panel.setToolTipText( "A panel container" );

    // create button 
    JButton quitButton = new JButton( "Quit" );
    quitButton.setBounds( 50, 60, 80, 30 );
    quitButton.setToolTipText( "A button component" );
    quitButton.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent event ) {
        System.exit( 0 );
      }
    });
    panel.add( quitButton );

    // set frame attributes
    add( panel );
    setTitle( "Quit button" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  public static void main( String[] args ) 
  {
    QuitButton ex = new QuitButton();
    ex.setVisible( true );
  }
}
