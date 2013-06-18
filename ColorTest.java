import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

// repeatedly asks the user to select the colour displayed in the word, given a
// colour word
// - NOT WORKING YET
public class ColorTest extends JFrame 
{
  private static String[] cwords = {"Red", "Black", "Yellow", "Green", "Blue", "Purple"};
  private Color[] colours = {Color.RED, Color.BLACK, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
  private int     numQuestions;
  private JLabel  instruction;
  private JLabel  question;
  private JPanel  answers; 
  private Random  generator;
  private JPanel  panel; 

  private JLabel genQuestion()
  {
    int    idx  = generator.nextInt( colours.length );
    JLabel word = new JLabel( cwords[ idx ] ); 

    idx = generator.nextInt( colours.length ); 
    word.setForeground( colours[ idx ] ); 
    word.setFont( new Font( "Comic Sans MS", Font.BOLD, 60 ));

    return word;
  } 

  private JPanel genAnswers()
  {
    int              i; 
    JPanel           radioPanel = new JPanel( new GridLayout( 0, 1 ));
    int              numAnswers = cwords.length;
    JRadioButton[]   ans = new JRadioButton[ cwords.length ];
    MyButtonListener listener = new MyButtonListener(); 
    ButtonGroup      group = new ButtonGroup();

    // put each cword as a button, add to group, add to panel
    for( i=0; i<numAnswers; i++ )
    {
      ans[ i ] = new JRadioButton( cwords[ i ] );
      ans[ i ].setActionCommand( cwords[ i ] );
      ans[ i ].addActionListener( listener ); 
      group.add( ans[ i ] ); 
      radioPanel.add( ans[ i ] ); 
    }

    return radioPanel;
  } 

  public JPanel getNextQuestion()
  {
    JPanel panel = new JPanel( new BorderLayout() );
    panel.setBorder( new EmptyBorder( new Insets( 20, 20, 20, 20 )));
    question     = genQuestion(); 
    answers      = genAnswers(); 
    panel.add( instruction, BorderLayout.NORTH );
    panel.add( question,    BorderLayout.CENTER );
    panel.add( answers,     BorderLayout.SOUTH ); 
    return panel; 
  }

  public ColorTest()
  {
    // initialize privates 
    instruction  = new JLabel( "What is the colour of the word?" );
    numQuestions = 4; 
    generator    = new Random();
    question     = genQuestion(); 
    answers      = genAnswers(); 

    // setup basic panel 
    panel = new JPanel( new BorderLayout() );
    panel.setBorder( new EmptyBorder( new Insets( 20, 20, 20, 20 )));

    // add components 
    panel.add( instruction, BorderLayout.NORTH );
    panel.add( question,    BorderLayout.CENTER );
    panel.add( answers,     BorderLayout.SOUTH ); 
    add( panel ); 

    // set frame attributes
    setBackground( Color.WHITE );
    setTitle( "Colour Test" );
    setSize( 300, 300 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  class MyButtonListener implements ActionListener
  {
    public void actionPerformed( ActionEvent e )
    {
      System.out.println( "button pressed: " + e.getActionCommand() );
      if( numQuestions > 0 )
      {
        Container pane = getContentPane();
        pane.remove( panel );
        JPanel panel = getNextQuestion(); 
        pane.add( panel );
        pane.validate();
        numQuestions--; 
      }
    }

    public void itemStateChanged( ItemEvent e ) 
    {
      System.out.println( e.getItem() + " is now " 
      + (( e.getStateChange() == ItemEvent.SELECTED ) ? "selected" : "unselected" ));
    }

  //public void stateChanged( ChangeEvent e ) { System.out.println( e.getSource() ); }
  }

  public static void main( String[] args )
  {
    ColorTest ex = new ColorTest();
    ex.setVisible( true );
  }
}
