package Alogs.GFGDaily;
/* 
Fact Digit Sum

A(X) for positive integer X is the sum of factorials of its digits. For example, A(154) = 1! + 5! + 4!= 145.
Given a number N, find the minimum number X such that A(X) = N. You have to return a list of digits which represent the number X.

Example 1:

Input: N = 40321
Output: 18
Explanation: A(18)=1!+ 8! =40321 
Note that A(80) and A(81) are also 
40321, But 18 is the smallest 
number.
Example 2:

Input: N = 5040
Output: 7
Explanation: A(7) = 7! = 5040.
Your Task:
You don't need to read or print anything. Your task is to complete the function FactDigit() which takes N as input parameter and returns a list of digits which represent the number X.

Expected Time Complexity: O(X) where X ≤ 106
Expected Space Complexity: O(X)

Constraints:
1 ≤ N ≤ 109

 */
import java.util.ArrayList;

public class FactorialDigitSum {

    public static void main(String[] args) {
        factDigit(40321).forEach(i -> System.out.print(i));
        System.out.println();
        factDigit(5040).forEach(i -> System.out.print(i));
    }

    static ArrayList<Integer> factDigit(int N) {

        ArrayList<Integer> result = new ArrayList<>();
        int[] fact = new int[10];
        fact[0] = 1;
        for (int i = 1; i < 10; i++) {
            fact[i] = fact[i - 1] * i;
        }

        for (int i = 9; i >= 1; i--) {
            while (fact[i] <= N) {
                N -= fact[i];
                result.add(0, i);
            }
        }
        return result;
    }
}
