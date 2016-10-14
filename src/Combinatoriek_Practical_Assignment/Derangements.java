package Combinatoriek_Practical_Assignment;

import java.util.ArrayList;

/**
 *
 * @author Medard van Leeuwe    s4530608
 * @author Nick Nibbeling       s4616146
 * @author Niels van Drueten    s4496604
 * 
 * @version 1.0
 * @date 14 october 2016
 */
public class Derangements {

    private ArrayList<Integer> oplossing;
    private ArrayList<Integer> ongebruikt; // ArrayList met de ongebruikte integers.

    public Derangements(int n) {
        this.oplossing = fillOplossing(n);
        this.ongebruikt = fillOngebruikt(n);
    }

    public void start(int plaatsNr) {
        //System.out.println(plaatsNr);
        //System.out.println(oplossing.size());
        if (plaatsNr >= oplossing.size())
            print(oplossing);
       
        for (int i = 0; i < oplossing.size(); i++) {

            if (ongebruikt.get(i) != plaatsNr + 1 && ongebruikt.get(i) != 0 ) {
                oplossing.set(plaatsNr, ongebruikt.get(i));
                ongebruikt.set(i, 0);
                start(plaatsNr+1);
                ongebruikt.set(i,oplossing.get(plaatsNr));
                oplossing.set(plaatsNr, 0);  //
            }
        }
    }

    private ArrayList<Integer> fillOplossing(int n) {
        ArrayList<Integer> oplossing = new ArrayList<>();
        for (int i = 0; i < n ; i++){
            oplossing.add(0);
        }
        
        return oplossing;
    }

    private ArrayList<Integer> fillOngebruikt(int n) {
        ArrayList<Integer> ongebruikt = new ArrayList<Integer>();
        
        for (int i = 0  ; i < n ; i++){
            ongebruikt.add(i+1);
        }
        
        return ongebruikt;
    }
    
    private void print(ArrayList<Integer> oplossing){
        String result = "{";
        for ( int i = 0; i < oplossing.size(); i++){
            
            if (i == oplossing.size() - 1){
                result += oplossing.get(i) + "}";
            }
            else {
            result += oplossing.get(i) + ",";
            }
        }
        System.out.println(result);
    }
}
