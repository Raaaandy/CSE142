import java.util.*;
import java.io.*;

public class QuestionsGame {
    // TODO: Your Code Here
    private QuestionNode qNode;
    private Scanner console;

    private static class QuestionNode {
        public String text;
        public QuestionNode left;
        public QuestionNode right;

        public QuestionNode(String question) {
            this.text = question;
            left = null;
            right = null;
        }

        public QuestionNode(String question, QuestionNode left, QuestionNode right) {
            this.text = question;
            this.left = left;
            this.right = right;
        }
    }


    public QuestionsGame() {
        this.qNode = new QuestionNode("computer");
        this.console = new Scanner(System.in);

    }

    public void read(Scanner input) {
        this.qNode = newTree(input);
    }

    private QuestionNode newTree(Scanner input) {
        if(!input.nextLine().equals("A:")) {
            return new QuestionNode(input.nextLine(), newTree(input), newTree(input));
        } else {
            return new QuestionNode(input.nextLine());
        }
    }


    public void write(PrintStream output) {
        write(output, qNode);
    }

    private void write(PrintStream output, QuestionNode root) {
        if(root.left != null && root.right != null) {
            output.println("Q:");
            write(output, root.left);
            write(output, root.right);
        } else {
            output.println("A:");
        }
        output.println(root.text);

    }

    public void askQuestions() {
        qNode = askQuestions(qNode);
    }

    private QuestionNode askQuestions(QuestionNode root) {
        //non-leaf
        if(root.left != null && root.right != root) {
            if(yesTo(root.text)) {
                root.left = askQuestions(root.left);
            } else {
                root.right = askQuestions(root.right);
            }
        } else {
            //leaf
            if(yesTo(root.text)) {
                System.out.println("I got it!");
            } else {
                System.out.println("And what is the answer for your object?");
                String answer = console.nextLine();
                System.out.println("Please give me a yes/no question that");
                System.out.println("distinguishes between your object");
                System.out.println("and mine--> ");
                String question = console.nextLine();
                if(yesTo("And what is the answer for your object?")) {
                    root = new QuestionNode(question, new QuestionNode(answer), root);

                } else {
                    root = new QuestionNode(question, root, new QuestionNode(answer));
                }
            }
        }
        return root;
    }







    // Do not modify this method in any way
    // post: asks the user a question, forcing an answer of "y" or "n";
    //       returns true if the answer was yes, returns false otherwise
    private boolean yesTo(String prompt) {
        System.out.print(prompt + " (y/n)? ");
        String response = console.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please answer y or n.");
            System.out.print(prompt + " (y/n)? ");
            response = console.nextLine().trim().toLowerCase();
        }
        return response.equals("y");
    }


}