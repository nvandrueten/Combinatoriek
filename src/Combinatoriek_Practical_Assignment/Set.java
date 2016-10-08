/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combinatoriek_Practical_Assignment;

import java.util.ArrayList;

/**
 *
 * @author niels
 * @date 8 October 2016.
 * @version 1.0
 * 
 */

public class Set {
    
    private ArrayList<Integer> set;
    
    
    public Set(int n){
        this.set = new ArrayList<>();
        fillArray(n);
        System.out.println(set.get(0));
        System.out.println(set.get(1));
        System.out.println(set.get(2));
        showArray();
    }
    
    private void fillArray(int n){
        for(int i = 1; i <= n; i++ ) {
            set.add(i);
        }
    }
    
    private void showArray(){
        String result = "";
        for(int i = 1; i <= set.size(); i++){
            if( i == 1 ){
                result += "{" + i + ",";
            }
            else if ( i == set.size() ){
                result += i + "}";
            }
            else {
                result += "" + i + ",";
            }
        }
        result += "\n";
        System.out.println(result);
    }
}
