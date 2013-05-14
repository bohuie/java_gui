import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*; 

public class MenuPopup extends JFrame
{
  private JPopupMenu menu;
  private Toolkit    tkit;

  public MenuPopup( String title )
  { 
    super( title );

    // initialize private vars
    menu = new JPopupMenu();
    tkit = getToolkit();

    // create items in popup menu
    JMenuItem mitemBeep = new JMenuItem( "Beep" ); 
    mitemBeep.addActionListener( new ActionListener()
    {
      public void actionPerformed( ActionEvent e )
      { 
        tkit.beep();
      } 
    });
    JMenuItem mitemCloz = new JMenuItem( "Close" ); 
    mitemCloz.addActionListener( new ActionListener()
    {
      public void actionPerformed( ActionEvent e )
      { 
        System.exit( 0 );
      } 
    });

    // add items to menu 
    menu.add( mitemBeep );
    menu.add( mitemCloz );

    // make this popup menu actually popup when left button is clicked
    // if want to change to right button, do BUTTON3 
    this.addMouseListener( new MouseAdapter()
    {
      @Override
      public void mouseReleased( MouseEvent e )
      {
        // pop it up at the (x,y) location where we actually clicked on the app
        if( e.getButton() == MouseEvent.BUTTON1 )
          menu.show( e.getComponent(), e.getX(), e.getY() );
      } 
    });

    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    MenuPopup ex = new MenuPopup( "JPopupMenu Demo" );
    ex.setVisible( true );
  }
}
