import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class PicturePuzzle extends JFrame implements ActionListener
{
  private JPanel  centerPanel;
  private Image   source; 
  int[][]         pos; 
  int             width, height;
  private Image   img; 
  private JLabel  label;  
  private JButton button; 
  final int       maxRows = 3; 
  final int       maxCols = 3; 

  public PicturePuzzle()
  {
    // setup basic panel 
    centerPanel = new JPanel();
    centerPanel.setLayout( new GridLayout( maxRows, maxCols, 0, 0 ));

    // initialize privates 
    ImageIcon sid = new ImageIcon( "swim.JPG" );
    source        = sid.getImage(); 
    width         = sid.getIconWidth();
    height        = sid.getIconHeight();
    pos           = new int[ maxRows ][ maxCols ];
    int count     = 0;
    for( int row=0; row<maxRows; row++ )
    {
      for( int col=0; col<maxCols; col++ )
      {
        // create position indices for each puzzle piece
        pos[ row ][ col ] = count; 
        count++; 
      }
    }
    for( int row=0; row<maxRows; row++ )
    {
      for( int col=0; col<maxCols; col++ )
      {
        // create a blank spot at bottom right corner
        if( col == (maxCols-1) && row == (maxRows-1) )
        {
          label = new JLabel( "" );
          centerPanel.add( label );
        }
        else 
        {
         // auto divide up source picture into smaller images and put them on buttons
          button = new JButton();
          button.addActionListener( this );
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

  // basically, swap the selected button image with blank label
  public void actionPerformed( ActionEvent e )
  {
    JButton button = ( JButton )e.getSource();
    Dimension size = button.getSize();

    // determine where the blank label is 
    int labelX      = label.getX();
    int labelY      = label.getY();

    // determine where this button is 
    int buttonX     = button.getX();
    int buttonY     = button.getY();
    int buttonPosX  = buttonX / size.width;
    int buttonPosY  = buttonY / size.height;
    int buttonIndex = pos[ buttonPosY ][ buttonPosX ];

    // determine what labelIndex is relative to the button
    // case 1. same col, button is above
    // example:  x b x 
    //           x l x 
    //           x x x 
    if( labelX == buttonX && ( labelY - buttonY ) == size.height ) 
    {
      int labelIndex = buttonIndex + maxCols;
      centerPanel.remove( buttonIndex );
      centerPanel.add( label,  buttonIndex );
      centerPanel.add( button, labelIndex );
      centerPanel.validate();
    }

    // case 2. same col, button is below
    // example:  x l x 
    //           x b x 
    //           x x x 
    if( labelX == buttonX && ( labelY - buttonY ) == -size.height ) 
    {
      int labelIndex = buttonIndex - maxCols;
      centerPanel.remove( labelIndex );
      centerPanel.add( button, labelIndex );
      centerPanel.add( label,  buttonIndex );
      centerPanel.validate();
    }

    // case 3. same row, button is to the left
    // example:  x x x 
    //           b l x 
    //           x x x 
    if( labelY == buttonY && ( labelX - buttonX ) == size.width ) 
    {
      int labelIndex = buttonIndex + 1;
      centerPanel.remove( buttonIndex );
      centerPanel.add( label,  buttonIndex );
      centerPanel.add( button, labelIndex );
      centerPanel.validate();
    }

    // case 4. same row, button is to the right
    // example:  x x x 
    //           x l b 
    //           x x x 
    if( labelY == buttonY && ( labelX - buttonX ) == -size.width ) 
    {
      int labelIndex = buttonIndex - 1;
      centerPanel.remove( buttonIndex );
      centerPanel.add( label,  labelIndex );
      centerPanel.add( button, labelIndex );
      centerPanel.validate();
    }

    // otherwise, user clicked on a button that is not adjacent to label
    // so don't do anything
  }

  public static void main( String[] args )
  {
    PicturePuzzle ex = new PicturePuzzle();
    ex.setVisible( true );
  }
}
