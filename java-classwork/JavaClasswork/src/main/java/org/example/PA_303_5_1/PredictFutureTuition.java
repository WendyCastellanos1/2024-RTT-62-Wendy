package org.example.PA_303_5_1;


/*Suppose the tuition for a university is $10,000 for the current year
and increases by 7 percent every year.
❑ In how many years will the tuition be doubled?
Year Tuition
0 $10,000
1 tuition = 1.07 * tuition
… tuition = 1.07 * tuition
… tuition = 1.07 * tuition
… …
? $20,000 or more
MODIFICATION: I added a "chart" to show the progression of the cost increase by elapsed year.
*/

public class PredictFutureTuition {

    public static void main(String[] args) {

        final double TUITION_GROWTH_MULTIPLIER = 1.07;
        double tuitionBase = 10000;                 //current year's tuition, starting point
        double tuitionTemp = tuitionBase;           //working variable scoped to Main method
        int years = 0;                              //for clarity

        //print first line of the calculation progression
        System.out.println("\nWhen day 1 of year 1 begins, tuition is  $"
                + Math.round(tuitionBase)
                + "  Start year 1...\n");

        //loop to applya 7% annual increas, compounding to base tuition (until tuition doubles)
        while (tuitionTemp < tuitionBase * 2) {

            tuitionTemp = tuitionTemp * TUITION_GROWTH_MULTIPLIER;
            years = years + 1;

            //print year over year progression of calculation
            System.out.println("After year " + years
                    + " elapsed, tuition is now \t $"
                    + Math.round(tuitionTemp)
                    + "\t Start year " + (years + 1)
                    + "....");
        }

        //print summary message
        System.out.println("At an annually compounding rate of increase of 7%, "
                + "the tuition (more than) doubles in "
                + years
                + " *elapsed* years for a new price of $"
                + Math.round(tuitionTemp)
                + " at the beginning of year "
                + (years + 1)
                + ".");
    }
}
