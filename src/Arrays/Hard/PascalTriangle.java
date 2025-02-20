package Arrays.Hard;

//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//Example 1:
//
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Example 2:
//
//Input: numRows = 1
//Output: [[1]]
//
//
//Constraints:
//
//1 <= numRows <= 30

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows : ");
        int n = sc.nextInt();
        System.out.println("Pascal Triangle is printed below : ");
        List<List<Integer>> pascalTriangle = generate(n);

        for (List<Integer> integers : pascalTriangle) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> generate(int numRows) {
        List<Integer> currRow;
        List<Integer> previousRow = new ArrayList<>();
        List<List<Integer>> pascalTriangleRows = new ArrayList<>();

        for(int i = 1; i <= numRows; i++){
            currRow = new ArrayList<>();
            if(i == 1){
                currRow.add(1);
                previousRow = currRow;
                pascalTriangleRows.add(currRow);
            }
            else if(i == 2){
                currRow.add(1);
                currRow.add(1);
                previousRow = currRow;
                pascalTriangleRows.add(currRow);
            }
            else{
                for(int j = 1; j <= i; j++){
                    if(j == 1 || j == i){
                        currRow.add(1);
                    }
                    else{
                        int newEle = previousRow.get(j - 1) + previousRow.get(j - 2);
                        currRow.add(newEle);
                    }
                }
                pascalTriangleRows.add(currRow);
                previousRow = currRow;
            }
        }
        return pascalTriangleRows;
    }
}

