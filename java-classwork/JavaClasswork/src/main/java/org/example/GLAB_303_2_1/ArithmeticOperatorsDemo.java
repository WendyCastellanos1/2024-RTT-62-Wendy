package org.example.GLAB_303_2_1;

public class ArithmeticOperatorsDemo {

    public static void main(String[] args) {

        int x, y = 10, z = 5;
        x = y + z;
        System.out.println("+ operator resulted in " + x);

        x = y - z;
        System.out.println("- operator resulted in " + x);

        x = y * z;
        System.out.println("* operator resulted in " + x);

        x = y / z;
        System.out.println("/ operator resulted in " + x);

        /* modulus: operation returns zero if no remainder,
                otherwise returns the remainder
         e.g. if x%2 returns 0, then x is even bc no remainder.
         If mod.op returns other number, x is odd.
         for forming isEven or isOdd bool functions,
                remember that 0 resolves to false,
                non-zero numbers like 1,2,3, etc. resolve to true */
        x = y % z;
        System.out.println("% operator resulted in " + x);

        //postfix: use, then increment
        x = y++;
        System.out.println("Postfix ++ operator resulted in " + x);

        //prefix: increment first, then use
        x = ++z;
        System.out.println("Prefix ++ operator resulted in " + x);

        //Unary operator *toggles* the existing sign
        x = -y;
        System.out.println("Unary operator resulted in " + x);

        // Some examples of special cases
        // Integer.MAX_VALUE
        int tooBig = Integer.MAX_VALUE + 1; // 2147483648 which is Integer.MAX_VALUE
        System.out.println("tooBig becomes " + tooBig);

        // Integer.MIN_VALUE
        int tooSmall = Integer.MIN_VALUE - 1;; // -2147483648 which is Integer.MIN_VALUE
        System.out.println("tooSmall becomes " + tooSmall);

        //Infinity
        System.out.println(4.0 / 0.0); // Prints infinity
        System.out.println(-4.0/ 0.0); //Prints -infinity

        //Nan: Not a Number due to return of some undefined result
        System.out.println(0.0 / 0.0); // Prints: NaN

        /* result: bc 12 and 8 not cast to double in this floating point context,
            quotient is 1 by integer division. The value of d1 becomes 1.0. */
        double d1 = 12 / 8;

        //one operand is double...
        double d2 = 12.0F / 8; //result: 1.5

        System.out.println("d1 is " + d1);
        System.out.println("d2 is " + d2);
    }
}
