package Combinatoriek_Practical_Assignment;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Medard van Leeuwe s4530608
 * @author Nick Nibbeling s4616146
 * @author Niels van Drueten s4496604
 *
 * @version 1.1
 * @date 16 october 2016
 */
public class Derangements {

    private ArrayList<Integer> oplossing;  //ArrayList met de oplossing.
    private ArrayList<Integer> ongebruikt; // ArrayList met de ongebruikte integers.
    private int oplossingen;

    public Derangements(int n) {
        this.oplossing = fillOplossing(n);
        this.ongebruikt = fillOngebruikt(n);
        this.oplossingen = 0;
    }

    public void start(int plaatsNr) {
        recursion(plaatsNr);
        System.out.println(oplossingen + " derangements.");
    }

    public void visualize() {
        for (int i = 0; i < 14; i++) {
            System.out.println(i + ": " + countDerangements(i) + " derangements");
        }
    }

    public void recursion(int plaatsNr) {
        if (plaatsNr >= oplossing.size()) {
            print(oplossing);
            oplossingen++;
        }
        for (int i = 0; i < oplossing.size(); i++) {
            if (ongebruikt.get(i) != plaatsNr + 1 && ongebruikt.get(i) != 0) {
                oplossing.set(plaatsNr, ongebruikt.get(i));
                ongebruikt.set(i, 0);
                recursion(plaatsNr + 1);
                ongebruikt.set(i, oplossing.get(plaatsNr));
                oplossing.set(plaatsNr, 0);  //
            }
        }
    }

    private int countDerangements(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        } else {
            return (n - 1) * (countDerangements(n - 1) + countDerangements(n - 2));
        }
    }

    private ArrayList<Integer> fillOplossing(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(0);
        }

        return array;
    }

    private ArrayList<Integer> fillOngebruikt(int n) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            array.add(i + 1);
        }
        return array;
    }

    private void print(ArrayList<Integer> oplossing) {
        String result = "{";
        for (int i = 0; i < oplossing.size(); i++) {

            if (i == oplossing.size() - 1) {
                result += oplossing.get(i) + "}";
            } else {
                result += oplossing.get(i) + ",";
            }
        }
        System.out.println(result);
    }

    private void printSB(ArrayList<Integer> oplossing) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Integer i : oplossing) {
            sb.append(i + ",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        System.out.println(sb);
    }
}
