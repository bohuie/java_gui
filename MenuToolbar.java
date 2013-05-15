import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class MenuToolbar extends JFrame
{
  public MenuToolbar()
  {
    // create toolbar
    JToolBar toolbar = new JToolBar();

    // create icons for toolbar
    ImageIcon icon = new ImageIcon( getClass().getResource( "exit.png" ));

    JButton exitButton = new JButton( icon );
    toolbar.add( exitButton );
    exitButton.addActionListener( new ActionListener() 
    {
      public void actionPerformed( ActionEvent event ) 
      {
        System.exit( 0 );
      }
    });
    add( toolbar, BorderLayout.NORTH );

    setTitle( "Simple toolbar" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  { 
    MenuToolbar ex = new MenuToolbar();
    ex.setVisible( true );
  }
}
