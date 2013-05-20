import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class PicturePuzzle extends JFrame // implements ActionListener
{
  private JPanel  centerPanel;
  private Image   source; 
  int[][]         pos; 
  int             width, height;
  private Image   img; 
  private JLabel  label;  
  private JButton button; 

  public PicturePuzzle()
  {
    // setup basic panel 
    centerPanel = new JPanel();
    centerPanel.setLayout( new GridLayout( 4, 4, 0, 0 ));

    // initialize privates 
    ImageIcon sid = new ImageIcon( "swim.JPG" );
    source = sid.getImage(); 
    width  = sid.getIconWidth();
    height = sid.getIconHeight();
    pos = new int[][] { {0, 1, 2},
                        {3, 4, 5},
                        {6, 7, 8},
                        {9, 10, 11}
                      };
    int maxRows = 4; 
    int maxCols = 3; 
    for( int row=0; row<maxRows; row++ )
    {
      for( int col=0; col<maxCols; col++ )
      {
        // create a blank spot 
        if( col == 2 && row == 3 )
        {
          label = new JLabel( "" );
          centerPanel.add( label );
        }
        else 
        {
          button = new JButton();
          // button.addActionListener( this );
          centerPanel.add( button );
          img = createImage( new FilteredImageSource( source.getSource(), 
                new CropImageFilter( col*width/maxCols, row*height/maxRows,
                ( width/maxCols )+1, height/maxRows )));
          button.setIcon( new ImageIcon( img ));
        }
      }
    }

    // add components 
    add( Box.createRigidArea( new Dimension( 0, 5 )), BorderLayout.NORTH );
    add( centerPanel, BorderLayout.CENTER );

    // set frame attributes
    setResizable( false );
    setTitle( "Example" );
    setSize( width+(maxCols*5), height+(maxRows*10) ); 
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    PicturePuzzle ex = new PicturePuzzle();
    ex.setVisible( true );
  }
}
