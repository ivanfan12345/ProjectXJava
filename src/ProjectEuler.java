import IvanPackages.IvanUtils;
import IvanPackages.TreeNode;

import java.math.BigInteger;
import java.util.*;
import java.lang.String;

import static java.lang.System.out;

/**
 * Created by IFAN on 9/17/16.
 */



public class ProjectEuler {

    /*
    Project Euler 25: What is the first term in the Fibonacci sequence to contain 1000 digits?


    BigInteger sum = BigInteger.valueOf(0);
    for(int i = 2; i < 5000; i++) {
    if (isPrim(i)) {
        sum = sum.add(BigInteger.valueOf(i));
        }
    }


    */
    public BigInteger bigIvanFibonacci(int nth) {
        BigInteger result = null, nMinus1, nMinus2;
        String resultStr;
        nMinus1 = new BigInteger("0");
        nMinus2 = new BigInteger("1");
        if(nth == 0){
            System.out.println("F(0):" + nMinus1.toString() + " Length: 0");
        }
        if(nth == 1){
            System.out.println("F(1):" + nMinus2.toString() + " Length: 1");
        }
        else{
            System.out.println("F(0):" + nMinus1.toString() + " Length: 0");
            System.out.println("F(1):" + nMinus2.toString() + " Length: 1");

            for(int i = 2; i< nth ; i++) {
                result = nMinus1.add(nMinus2);
                resultStr = result.toString();
                nMinus2 = nMinus1;
                nMinus1 = result;
                //System.out.println(nMinus1);
                //System.out.println(nMinus2);
                System.out.println("F(" + i + "):" + resultStr + " Length: " + resultStr.length());

            }
        }








       return result;
    }
}
