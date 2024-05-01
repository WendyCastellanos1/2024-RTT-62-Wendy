public class AssignmentOperatorsDemos {
    public static void main(String[] args) {
        //  Assigning Primitive Values
        int j, k;
        j = 10; // j gets the value 10.
        j = 4;  //j gets the value 5. The previous value is overwritten.
        k = j = 10; // (k = (j=10))
        System.out.println("j is : " + j);
        System.out.println("k is : " + k);
    }
}
