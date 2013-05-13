import javax.swing.JOptionPane;

public class WelcomeInMessageDialogBox
{
  public static void main( String[] args )
  {
    JOptionPane.showMessageDialog( null, 
                                   "Welcome to Java Programming!",    // message
                                   "Message",                         // heading
                                   JOptionPane.INFORMATION_MESSAGE ); // icon
   
    JOptionPane.showMessageDialog( null, "Welcome also!" ); 

    String userInput = JOptionPane.showInputDialog( "Enter your name:" ); 

    System.out.println( "You entered " + userInput );

    userInput = JOptionPane.showInputDialog( null,
                                             "Enter your name:",          // message
                                             "Question",                  // heading
                                             JOptionPane.QUESTION_MESSAGE ); // icon

    System.out.println( "You entered " + userInput );

    int response = JOptionPane.showConfirmDialog( null, "Do you like this?" );

    if( response == JOptionPane.YES_OPTION ) 
      System.out.println( "You do? That's great!" ); 
    else if( response == JOptionPane.NO_OPTION ) 
      System.out.println( "That's too bad. Maybe next time?" );
    else if( response == JOptionPane.CANCEL_OPTION ) 
      System.out.println( "Why cancel?" );

  }
}
