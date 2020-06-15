package calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
public class CalculatorActionListener implements ActionListener{
 String value1, value2;
 String operator;
 private JTextField textField;
 public CalculatorActionListener(JTextField textField) {
  this.textField = textField;
 }
 @Override
 public void actionPerformed(ActionEvent e) {
  System.out.println("ActionEvent: " + e.getActionCommand());
  switch (e.getActionCommand()) {
  
  case "0":
  case "1":
  case "2":
  case "3":
  case "4":
  case "5":
  case "6":
  case "7":
  case "8":
  case "9":
  textField.setText(textField.getText()+ e.getActionCommand() );
  break;
  
  case "+":
  case "-":
  case "x":
  case "/":
  case "%":
   value1 = textField.getText();
   textField.setText("");
   operator = e.getActionCommand();
   break;
   
  case"=":
   value2 = textField.getText();
   int results= compute(value1, value2, operator);
   textField.setText(results + "");
   break;
   
   
  case"C":
   value1 ="";
   value2 ="";
   operator ="";
   textField.setText("");
   break;
  
  }
 }
 private int compute(String value1, String value2, String operator) {
  
  int operand1 = Integer.parseInt(value1);
  int operand2 = Integer.parseInt(value2);
  int result=0;
  
  switch(operator){
  
  case "+":
   result = operand1 + operand2;
   break;
   
   
  case "-":
   result = operand1 - operand2;
   break;
  case "x":
   result = operand1 * operand2;
   break;
  case "/":
   result = operand1 / operand2;
   break;
   
  case "%":
   result = operand1 % operand2;
   break;
   
  
  }
  
  return result;
 }
}