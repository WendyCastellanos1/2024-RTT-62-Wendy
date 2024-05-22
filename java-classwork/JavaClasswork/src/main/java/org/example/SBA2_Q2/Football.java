package org.example.SBA2_Q2;

import java.text.DecimalFormat;

public class Football implements Sport {

    private int[] playerIds;        //declare

    //constructor
    public Football() {
        playerIds = new int[12];        //create
        //loop
        for ( int pos = 1; pos < playerIds.length; pos++ ) {
            playerIds[pos] = 1;                                 //set as default
        }
        System.out.println("A new football team has been formed");
    }

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
    //new method for football
    public void playerTransfer(int fee, int id){

            if( playerIds[id] == -1) {
                System.out.println("Player has already retired");
            }else {
                //playerIds[id] = -1;  //if not working on SABA, try adding this back
                System.out.println("Player with id: " + id + " has been transferred with a fee of " + fee);
            }
    }
}
