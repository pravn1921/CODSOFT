import java.util.Scanner;

public class NumberGame {
	
	// Method to generate random number and return the value
	private static int generateRandomNumber(int min, int max) {
		// formula to generate random number between specific range
		return (int) (Math.random() * (max - min + 1) + min); 
	}
	 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);

		int chances = 7; // number of chances to guess the random number
		int score = 0; // setting initial score as 0
		boolean continuePlaying = true; 
		int round=1; // rounds until player wish to play
		
		System.out.println("The Number Game");
		System.out.println(chances + " Chances to Guess the number and Win the Game");

		while (continuePlaying) {
			int random = generateRandomNumber(1, 100); // calling method to get random number
			boolean guess = false;
			System.out.println("Round: "+round);
			
			for (int i = 0; i < chances; i++) {
				System.out.println("Chance " + (i + 1) + " - Enter the Guess:");
				int value = sc.nextInt();

				// conditions to check whether the guess is equal,high or low to predicted value
				if (value == random) {
					guess = true;
					score+=100;
					System.out.println("Congrats!!..Correct Guess.");
					break;
				} 
				else if (value > random) {
					System.out.println("Too High.");
				} 
				else { 
					System.out.println("Too Low.");
				}
			}

			if (guess == false) {
				System.out.println("Oops!!..You ran out of Chances.");
				System.out.println("The number is " + random);
			}
			System.out.println("Do you wish to continue(y/n)");
			String wish = sc.next();
			System.out.println();
			
			// condition to check the wish of the player y=true, n=false
			if(wish.equals("y")) { 
				continuePlaying=true;
				round++; // incrementing round if 'y'
			}
			else {
				continuePlaying=false;
			}
		}
		System.out.println("Game Over...Hope you had fun..");
		//Displaying the final score of the player
		System.out.println("Your Score: " + score); 
	}
} 
