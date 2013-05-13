import javax.swing.JOptionPane;

public class ComputeBMI  
{
  public static void main( String[] args )
  {
    // get user input 
    String weightString = 
    JOptionPane.showInputDialog( "Enter your weight in pounds (E.g., 126.5):" ); 

    String heightString   = 
    JOptionPane.showInputDialog( "Enter your height in inches (E.g., 62 inches):" ); 

    // type conversions
    double weight = Double.parseDouble( weightString );
    int    height = Integer.parseInt( heightString );

    // metric conversion 
    double weightInKg = weight / 2.2;
    double heightInMeters = height * 2.54 / 100;

    // calculations 
    // formula: BMI = weightInKg / heightInMeters^2
    double bmi = weightInKg / ( heightInMeters * heightInMeters );
    String status = "";
    if( bmi < 18.5 )      status = "Underweight";
    else if( bmi < 25.0 ) status = "Normal";
    else if( bmi < 30   ) status = "Overweight";
    else                  status = "Obese";

    // display output
    String output = "Your BMI is: " + bmi + "\n"
    + "Your weight status is: " + status;
    JOptionPane.showMessageDialog( null, 
                                   output, 
                                   "Body Mass Index",  
                                   JOptionPane.INFORMATION_MESSAGE ); 
  }
}
