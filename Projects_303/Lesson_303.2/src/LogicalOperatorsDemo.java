public class LogicalOperatorsDemo {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;
        System.out.println("x & y : " + (x & y));
        System.out.println("x && y : " + (x && y));
        System.out.println("x | y : " + (x | y));
        System.out.println("x || y : " + (x || y));
        System.out.println("x ^ y : " + (x ^ y)); //xOR - 0,0 or 1,1 false, any 0,1 true
        System.out.println("!x : " + (!x));
    }
}
