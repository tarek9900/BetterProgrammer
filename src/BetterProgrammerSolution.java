import java.util.*;

public class BetterProgrammerSolution {


    /*
        TASK 1
     */
    private static int getSumOfNumbers(String input){

         /*
          Please implement this method to
          return the sum of all integers found in the parameter String. You can assume that
          integers are separated from other parts with one or more spaces (' ' symbol).
          For example, s="12 some text 3  7", result: 22 (12+3+7=22)
         */

        //No java 8 support :'(
        //return Arrays.stream(s.split(" ")).filter((a) -> a.matches("\\d+"))
        //  .mapToInt(Integer::valueOf)
        //  .sum();

        int sum = 0;
        String strings[] = input.split("\\s+");

        for (String string : strings) {
            try{
                Integer n = Integer.parseInt(string);
                sum += n;
            }catch(Exception e ){
                // Do something else with strings
            }
        }
        return sum;
    }

    /*
        Task 2
    */
    private static boolean isPalindrome(String s) {
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */

        String clean = s.replaceAll("\\s+", "").toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }


    /*
        TASK 3
     */
    private static int getSumOfTwoClosestToZeroElements(int[] a) {
        /*
          Please implement this method to
          return the sum of the two elements closest to zero.
          If there are two elements equally close to zero like -2 and 2,
          consider the positive element to be "closer" to zero than the negative one.
         */

        int l, r, min_sum, sum, min_r;

        min_r = 1;
        min_sum = a[0] + a[1];

        for(l = 0; l < a.length - 1; l++)
        {
            for(r = l+1; r < a.length; r++)
            {
                sum = a[l] + a[r];
                if(Math.abs(min_sum) > Math.abs(sum))
                {
                    min_sum = sum;
                    min_r = r;
                }
            }
        }

        return a[min_r];
    }

    /*
        TASK 4
    */

    public static int countWaysToProduceGivenAmountOfMoney(int cents) {
        /*
          Please implement this method to
          return the number of different combinations of US coins
          (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c)
          which may be used to produce a given amount of money.

          For example, 11 cents can be produced with
          one 10-cent coin and one 1-cent coin,
          two 5-cent coins and one 1-cent coin,
          one 5-cent coin and six 1-cent coins,
          or eleven 1-cent coins.
          So there are four unique ways to produce 11 cents.
          Assume that the cents parameter is always positive.
         */

        int combinations[] = {1,5,10,25,50};

        int content[] = new int[cents+1];

        for (int i = 0; i < cents + 1; i++) {
            content[i] = 0;
        }

        content[0] = 1;

        for (int i = 0; i < combinations.length; i++) {
            for (int j = combinations[i]; j <= cents; j++) {
                content[j] += content[j - combinations[i]];
            }
        }

        return content[cents];
    }

    public static void main(String[] args) {

        System.out.println("Task 1: get sum of numbers from a String \n" +
                "Example String is: 12 some text 3  7 \n"+
                getSumOfNumbers("12 some text 3  7") + "\n");

        System.out.println("Task 2: get is palindrome \n" +
                "Example String is: abcba \n"+
                isPalindrome("abcba")+ "\n");

        int arr[] = {1, 60, -10, 70, -80, 85};
        System.out.println("Task 3: get Sum Of Two Closest To Zero Elements \n" +
                "Example:  "+  Arrays.toString(arr) + "\n"+
                getSumOfTwoClosestToZeroElements(arr)+ "\n");

        System.out.println("Task 4: produce a given amount of money \n" +
                "Example is: 11 \n"+
                countWaysToProduceGivenAmountOfMoney(11));

    }

}
