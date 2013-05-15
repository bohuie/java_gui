import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class MenuToolbar2 extends JFrame
{
  public MenuToolbar2()
  {
    // create toolbars
    JToolBar toolbar1 = new JToolBar();
    JToolBar toolbar2 = new JToolBar();

    // arrange toolbars 
    JPanel panel = new JPanel();
    panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ));

    // create icons 
    ImageIcon iconn = new ImageIcon( getClass().getResource( "new.png" ));
    ImageIcon icono = new ImageIcon( getClass().getResource( "open.png" ));
    ImageIcon icons = new ImageIcon( getClass().getResource( "save.png" ));
    ImageIcon iconx = new ImageIcon( getClass().getResource( "exit.png" ));

    // put first three icons onto first toolbar
    JButton newButton  = new JButton( iconn );
    JButton openButton = new JButton( icono );
    JButton saveButton = new JButton( icons );
    toolbar1.add( newButton );
    toolbar1.add( openButton );
    toolbar1.add( saveButton );

    // put exit icon onto second toolbar 
    JButton exitButton = new JButton( iconx );
    toolbar2.add( exitButton );
    exitButton.addActionListener( new ActionListener() 
    {
      public void actionPerformed( ActionEvent event ) 
      {
        System.exit( 0 );
      }
    });

    // left align the toolbars (they appear in the panel's centre by default)
    toolbar1.setAlignmentX( 0 );
    toolbar2.setAlignmentX( 0 );

    // add toolbars to panel 
    panel.add( toolbar1 ); 
    panel.add( toolbar2 ); 

    // add panel to frame  
    add( panel, BorderLayout.NORTH );

    // set frame attributes  
    setTitle( "Two toolbars" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  { 
    MenuToolbar2 ex = new MenuToolbar2();
    ex.setVisible( true );
  }
}
