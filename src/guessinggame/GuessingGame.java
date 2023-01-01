package guessinggame;
/* Java game “Guess a Number” that allows user to guess a random number that has been generated.
* It is a good way to learn about JOptionPanes of the javax.swing library
* */
import javax.swing.*;
import java.util.Random;


public class GuessingGame {
    public static void main(String[] args) {
        int response;
        do {
            play();
            response = JOptionPane.showConfirmDialog(null,"Do you want to play again?",
                    null,JOptionPane.YES_NO_OPTION);
        } while (response == 0); // 0 for YES and 1 for NO
    }

    public static void play(){
        Random r = new Random();
        int computerNumber = r.nextInt(99)+1;
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;

        while (userAnswer != computerNumber)
        {
            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100", "Guessing Game", JOptionPane.QUESTION_MESSAGE);
            // Response is only null when you try to close the JOptionPane window
            if (response == null) {
                break;
            } else {
                try {
                    userAnswer = Integer.parseInt(response);
                } catch(Exception NumberFormatException) {
                    JOptionPane.showMessageDialog(null, "Your guess is invalid\nYou can only enter numbers between 1 and 100.");
                    continue;
                }
                JOptionPane.showMessageDialog(null, determineGuess(userAnswer, computerNumber, count));
                count++;
            }
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count){
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid\nYou can only enter numbers between 1 and 100.";
        }
        else if (userAnswer == computerNumber ){
            return "Correct!\nTotal Guesses: " + count;
        }
        else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        }
        else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
        else {
            return "This should never happen";
        }
    }
}