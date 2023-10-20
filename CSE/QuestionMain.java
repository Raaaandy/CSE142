// This program plays the question guessing game with a user.  It reads the
// old tree from a file if the user wants to.  It always writes its result
// to a file in case the user wants to use that tree the next time.

import java.io.*;
import java.util.*;

public class QuestionMain {

    public static void main(String[] args) {

        String a = "110011110";
        Scanner scan = new Scanner(a);
        String b = scan.next();
        if(b.length() > 0) {
            System.out.println("has something" + b.length());
        }

    }


}