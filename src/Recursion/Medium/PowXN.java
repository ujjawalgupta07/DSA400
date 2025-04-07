package Recursion.Medium;

//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//
//
//
//Example 1:
//
//Input: x = 2.00000, n = 10
//Output: 1024.00000
//Example 2:
//
//Input: x = 2.10000, n = 3
//Output: 9.26100
//Example 3:
//
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
//
//
//Constraints:
//
//-100.0 < x < 100.0
//-231 <= n <= 231-1
//n is an integer.
//Either x is not zero or n > 0.
//-104 <= xn <= 104

public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // Convert n to a long integer to handle the edge case with Integer.MIN_VALUE
        long N = n;

        // If n is negative, take the reciprocal of x and make N positive
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        // If N is even, recursively compute the square of x^(N/2)
        if (N % 2 == 0) {
            return myPow(x * x, (int) (N / 2));
        }

        // If N is odd, recursively compute x^(N-1) and multiply it by x
        else {
            return x * myPow(x, (int) (N - 1));
        }
    }
}
