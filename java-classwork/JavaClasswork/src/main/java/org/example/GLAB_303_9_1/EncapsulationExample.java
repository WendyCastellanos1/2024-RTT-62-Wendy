package org.example.GLAB_303_9_1;

public class EncapsulationExample {

    public static void main(String[] args) {

        //instantiate a new human object
        HumanBeing h1 = new HumanBeing();

        // using setters of HumanBeing, assign values to the private variables in the object
        h1.setHeight(1.65f);
        h1.setWeight(68);
        h1.setBmi(calculateBmi(h1));

        //using getters of HumanBeing, retrieve the values held in the private fields within the object
        System.out.println("Person has " + h1.getWeight() + " kgs and is " + h1.getHeight()
                        + "meters in height, which results in BMI of " + h1.getBmi());
    }
        //utility method to calculate and return BMI
        public static float calculateBmi(HumanBeing h1){
            return h1.getWeight() / (h1.getHeight() * h1.getHeight());
    }
}
