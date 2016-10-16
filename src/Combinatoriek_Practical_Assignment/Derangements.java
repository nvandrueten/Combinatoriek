package Combinatoriek_Practical_Assignment;

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

    private ArrayList<Integer> solutions;  //ArrayList met de oplossing.
    private ArrayList<Integer> unused; // ArrayList met de ongebruikte integers.
    private int counter;

    public Derangements(int n) {
        this.solutions = fillSolutions(n);
        this.unused = fillUnused(n);
        this.counter = 0;
    }

    public void start() {
        recursion(0);
    }

    public void visualize() {
        for (int i = 0; i < 23; i++) {
            System.out.println(i + ": " + countDerangements(i) + " derangements");
        }
    }

    private void recursion(int plaatsNr) {
        if (plaatsNr >= solutions.size()) {
            print(solutions);
            counter++;
        }
        for (int i = 0; i < solutions.size(); i++) {
            if (unused.get(i) != plaatsNr + 1 && unused.get(i) != 0) {
                solutions.set(plaatsNr, unused.get(i));
                unused.set(i, 0);
                recursion(plaatsNr + 1);
                unused.set(i, solutions.get(plaatsNr));
                solutions.set(plaatsNr, 0);  //
            }
        }
    }

    private long countDerangements(int n) {
        if (n == 0) {
            return 1L;
        }
        if (n == 1) {
            return 0L;
        } else {
            return (n - 1) * (countDerangements(n - 1) + countDerangements(n - 2));
        }
    }

    private ArrayList<Integer> fillSolutions(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(0);
        }

        return array;
    }

    private ArrayList<Integer> fillUnused(int n) {
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
    
    public int getCounter(){
        return counter;
    }
}
