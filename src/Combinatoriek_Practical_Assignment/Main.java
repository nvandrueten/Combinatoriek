
package Combinatoriek_Practical_Assignment;

import java.util.Scanner;

/**
 * @author Medard van Leeuwe    s4530608
 * @author Nick Nibbeling       s4616146
 * @author Niels van Drueten    s4496604
 * 
 * @version 1.0
 * @date 14 october 2016
 */
public class Main {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n: ");
        int n = scanner.nextInt();
        
        if (n > 10) System.out.println("n te groot");
        if (n < 0)  System.out.println("n is kleiner dan 0");
        
        
        
        Derangements d = new Derangements(0);
        d.start(0);
    }
    
}
