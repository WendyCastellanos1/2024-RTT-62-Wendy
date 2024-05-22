package org.example.SBA2_Q2;

import java.sql.SQLOutput;
import java.text.DecimalFormat;

public class Cricket implements Sport {

    //requirement
    private int[] playerIds;

    public Cricket() {
        //requirement: for 11 player IDs, 1 based array, need size of 12, position 0 is empty
        playerIds = new int[12];
        for( int pos = 1; pos < playerIds.length; pos++ ){
            playerIds[pos] = 1;
        }
        System.out.println("A new cricket team has been formed");
    }

    @Override
    public void calculateAvgAge(int[] age) {  //incoming array of ages

        double sum = 0;
        for ( int a : age ){

            sum = sum + a;
        }
        double avg = sum / age.length;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("The average age of the team is " + df.format(avg));
    }

    @Override
    public void retirePlayer(int id) {

        if( playerIds[id] == -1) {
            System.out.println("Player has already retired");
        }else{
            playerIds[id] = -1;
            System.out.println("Player with id: " + id + " has retired");
        }
    }


//test the code in the classes
    public static void main(String[] args) {

        Cricket c = new Cricket();
        int[] ages = {10,20,30,40, 50};
        c.calculateAvgAge(ages);    //to  avg the ages in the array

        c.retirePlayer(3);  //retires the active player
        c.retirePlayer(3);  //tests the else, bc already retired
    }
}