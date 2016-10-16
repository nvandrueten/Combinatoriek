package Combinatoriek_Practical_Assignment;

import java.util.Scanner;

/**
 * @author Medard van Leeuwe s4530608
 * @author Nick Nibbeling s4616146
 * @author Niels van Drueten s4496604
 *
 * @version 1.1
 * @date 16 october 2016
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given a positive integer n, visualize all the derangements of the set {1,2,3,...,n}.");
        System.out.println("Perform some analysis that shows for which values of n it is no longer possible ");
        System.out.println("to visualize all these derangements.");
        System.out.print("n: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("n cannot be negative.");
        } else if (n == 0) {
            System.out.println("{}");
            System.out.println("1 derangement.");
        } else {
            Derangements d = new Derangements(n);
            d.start(0);
            System.out.println(d.getCounter() + " derangements.");
            System.out.print("visualize derangements? [y/n]: ");
            char c = scanner.next().charAt(0);
            switch (c) {
                case 'y':
                    d.visualize();
                    break;
                case 'n':
                    break;
                default:
                    System.out.println("Wrong answer");
            }
        }
    }
}
