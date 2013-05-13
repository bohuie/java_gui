import java.awt.event.*;
import javax.swing.*; 

public class MenuBasic extends JFrame 
{
  public MenuBasic()
  {
    JMenuBar menubar = new JMenuBar();

    // set up File menu 
    JMenu file = new JMenu( "File" );
    file.setMnemonic( KeyEvent.VK_F );

    // set up menu item inside File called Exit
    ImageIcon icon = new ImageIcon( getClass().getResource( "exit.png" ));
    JMenuItem eMenuItem = new JMenuItem( "Exit", icon );
    eMenuItem.setMnemonic( KeyEvent.VK_X );
    eMenuItem.setToolTipText( "Exit application" );
    eMenuItem.addActionListener( new ActionListener() 
    {
      public void actionPerformed( ActionEvent event ) 
      {
        System.exit( 0 );
      } 
    });
    file.add( eMenuItem );

    // add File menu
    menubar.add( file );

    // set frame attributes
    setJMenuBar( menubar );
    setTitle( "Basic menu" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  public static void main( String[] args ) 
  {
    MenuBasic ex = new MenuBasic();
    ex.setVisible( true );
  }
}

