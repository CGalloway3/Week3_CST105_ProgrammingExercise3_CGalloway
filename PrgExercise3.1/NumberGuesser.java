package programmingexercise3;

//This is my own work. Chad Galloway
/**  Program: Number Guesser
*    File: NumberGuesser.java
*    Summary: Let the user guess a number between 1 and 10000, giving them hints as they guess.
*    Author: Chad Galloway
*    Date: December 16, 2017
**/


import java.util.Scanner;

public class NumberGuesser {

     public static void main(String[] args) {
        // Initialize variables
        int number = (int)(Math.random() * 10000) + 1; // Number the user must guess
        int lowerLimit = 1; // Lower number in the range user must guess
        int upperLimit = 10000; // Upper number in the range user must guess
        int guessCounter = 0; // Number of times the user has guessed
        int guess = 0; // The last entered guess of the user
        boolean gaveHintOne = false; // Was hint already given?
        String evenOdd = ""; //Determine if number is even or odd.
        String guessAnswer = ""; // The reply from the system about the users guess (Higher, Lower, or Correct)
        Scanner inputScanner = new Scanner(System.in); // Input scanner recieving the users guess
        
        // Set up game
        System.out.println("Welcome to the great number guessing game!!");
        if ( number % 2 == 0 )
            evenOdd = "even";
        else 
            evenOdd = "odd";
       
        // Begin looping structure
        do {
            // Prompt for users guess
            System.out.print("\nPlease, enter a guess between " + lowerLimit + " and " + upperLimit + ": ");
            guess = inputScanner.nextInt();
            
            // Process users guess
            if (lowerLimit <= guess && guess <= upperLimit){  // if guess is in range continue processing, else re-guess          
                guessCounter++;
                if ( guess != number ){ // If user did not guess correctly set up a hint.
                    if ( guess > number ){ // guess too high hint
                        guessAnswer = "Lower";
                        upperLimit = guess - 1;
                    }
                    else { // guess too low hint
                        guessAnswer = "Higher";
                        lowerLimit = guess + 1;
                    }
                    // Display hint to user.
                    System.out.println("The number is \"" + guessAnswer + ".\" Please, guess again.");
                }
                else { // correct guess
                    guessAnswer = "Correct";
                }
            }
            else{ // guess not in range.
                System.out.println("Your guess was out of the propper range. Please, guess again.");
            }
            
            // Hint code added to assist user in guessing.
            if (guessCounter >= 10 && !gaveHintOne){
                System.out.println("\nYou have taken " + guessCounter + " tries and you deserve a little hint.");
                System.out.println("The number you are trying to guess is " + evenOdd + ".");
                gaveHintOne = true;
            }
            
        } while (guessAnswer != "Correct");
        
        System.out.println("Your guess of " + guess + " was correct. It took you " + guessCounter + " tries.");
     } 

}
