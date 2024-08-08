                            
import java.util.ArrayList;
import java.util.List;

public class LemonadeCHange {
    
    // Function to find whether each customer can 
    // be provided with correct change
    public static boolean lemonadeChange(List<Integer> bills) {
        
        // Initialize a counter
        // for $5 bills
        int five = 0; 
        
        // Initialize a counter
        // for $10 bills
        int ten = 0;   
        
        // Iterate through each customer's bill
        for(int i = 0; i < bills.size(); i++){
            
            // If the customer's
            // bill is $5
            if(bills.get(i) == 5){
                
                // Increment the
                // count of $5 bills
                five++;  
            }
            
            // If the customer's
            // bill is $10
            else if(bills.get(i) == 10){
                
                // Check if there are $5
                // bills available to give change
                if(five > 0){
                     // Use one $5 bill
                     // to give change
                    five--; 
                    // Receive one $10 bill
                    ten++;   
                }
                
                // If no $5 bill
                // available, return false
                else return false;  
            }
            
            // If the customer's
            // bill is $20
            else {
                // Check if there are both
                // $5 and $10 bills
                // available to give change
                if(five > 0 && ten > 0){
                     // Use one $5 bill
                    five--; 
                    // Use one $10 bill
                    ten--;   
                }
                // If there are not enough $10 bills,
                // check if there are at least
                // three $5 bills available
                else if (five >= 3){
                    // Use three $5 bills
                    // to give change
                    five -= 3;  
                }
                // If unable to give
                // change, return false
                else return false;  
            }
        }
        
        // Return true if all customers
        // are served with correct change
        return true;  
    }

    public static void main(String[] args) {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);
        
        System.out.print("Queues of customers: ");
        for(int bill : bills){
            System.out.print(bill + " ");
        }
        System.out.println();
        
        boolean ans = lemonadeChange(bills);
        if(ans)
            System.out.println("It is possible to provide change for all customers.");
        else
            System.out.println("It is not possible to provide change for all customers.");
    }
}
                            
                        