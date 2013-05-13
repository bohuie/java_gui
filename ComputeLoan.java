import javax.swing.JOptionPane;

public class ComputeLoan 
{
  public static void main( String[] args )
  {
    // get user input 
    String annualRateString = 
    JOptionPane.showInputDialog( "Enter yearly interest rate (E.g., 8.25):" ); 

    String numYearsString = 
    JOptionPane.showInputDialog( "Enter number of years of loan (E.g., 5):" ); 

    String loanAmountString = 
    JOptionPane.showInputDialog( "Enter loan amount (E.g., 10000.50):" ); 

    // type conversions
    double annualRate = Double.parseDouble( annualRateString );
    int    numYears   = Integer.parseInt( numYearsString );
    double loanAmount = Double.parseDouble( loanAmountString );

    // calculations 
    double monthlyRate = annualRate / 12;  // div number of months in one year
    monthlyRate = monthlyRate / 100;       // convert into percentage

    double monthlyPayment = 
    loanAmount * monthlyRate / ( 1 - 1 / Math.pow( 1 + monthlyRate, numYears * 12 ));
    double totalPayment = monthlyPayment * 12 * numYears;

    // formatting  
    monthlyPayment = ( int )( monthlyPayment * 100 ) / 100.0;
    totalPayment   = ( int )( totalPayment * 100 ) / 100.0;

    // calculations 
    String output = "Your monthly payment is " 
    + String.format( "%-10.2f", monthlyPayment ) 
    + "\n" + "Your total payment is " 
    + String.format( "%-10.2f", totalPayment );
    JOptionPane.showMessageDialog( null, output );
  }
}
