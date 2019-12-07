package BlackJack;


import javax.swing.JOptionPane;
/**
 * This class manage an interactive blackJack game with the user against the computer.
 * 
 * @author Hagay Enoch
 * @version 30.11.2019
 */
public class Main{
	final static String num[] = {"first","second","third","fourth","fifth","sixth","seventh",
			"eighth","ninth","tenth","eleventh","twelfth" }; 
	
	public static void main(String[] args) {
		int countUser  = 0; //  the number of cards of each player
		int countCom  = 0; //  the number of cards of each player
		int userSum = 0; // total sum of all card of the user
		int comSum = 0; // total sum of all card of the computer
		int numOfUserAces = 0 ; // total number of Aces of each player
		int numOfComAces = 0 ; // total number of Aces of each player
		DeckOfCards pack = new DeckOfCards(); // a DeckOfCards object represent the deck
		int val = 0; // represent the value of each card in the blackJack game
		int userInput = 0 ; // represent the user input, 'yes = 0', 'no = 1', 'cancel = 2'. 
		Card tmpCard; // card from the deck
		int turn = 0; // represent the turn - 'user turn = 0' , 'computer turn = 1'
		
		System.out.println("Hello! Welcome to the best BlackJack game ever! ");
		
		if((userInput = JOptionPane.showConfirmDialog(null, "Do you like to start the game?"))== 0) { // start the game
			
			pack.shuffle(); // shuffle the deck
			
			while( userInput == 0 || comSum < userSum ) { /* start loop, if its user turn or
			 computer turn and the computer sum is less than the user sum. */
				
				if(turn == 0 && countUser > 0) { // ask for input jast after each player get 1 card
					if (userSum == 21) { // best sum that the user can get.
						turn = 1; // end of user turn
						userInput = 1; //// change user input
					}
					else if(userSum < 21) // give the user a chance to get more cards just if the sum is less than 21
						userInput = JOptionPane.showConfirmDialog(null, "Hit again?");					
					else { // the total sum is greater than 21
						System.out.println("You loss.");
						return; // End game
					}
					
					if(userInput != 0) { // the user decide not to add any more cards
						turn = 1; // change turn to the computer
						System.out.println("");
					}
				}
				
				tmpCard = pack.dealCard(); // deal a card
				if( tmpCard == null) { // error dealing a card
					System.out.println("Sorry cannot deal cards!");
					return;
				}
				val = tmpCard.blackJackValue(); // transform the card to it's value  
				
				if( turn == 0) { // user turn
				
					if ( val == 1 && (userSum + 11) <= 21) 
					{ // checking if it is an Ace card and if we can add a value of 11 to the sum with out passing 21.
						userSum += 11; // it is an Ace card and its value is 11
						numOfUserAces++; // to remember that we added 11 of an ace
					}
					else
						userSum += val; // it is an Ace card and its value is 1
					
					if( userSum > 21 && numOfUserAces != 0) { //Changing values of Aces from 11 to 1
						userSum -= 10; // change the value of an ace from 11 to 1
						numOfUserAces--; // decrease the number of aces
					}
					
					System.out.println("Your "+ num[countUser++] + " card is- " + tmpCard + ", And your total sum is- " + userSum );
					if ( countUser == 1 )// just after the first turn of the user 
						turn = 1; // change turn to the computer
				}
				else { // computer turn

					if ( val == 1 && (comSum + 11) <= 21) 
					{ // checking if it is an Ace card and if we can add a value of 11 to the sum with out passing 21.
						comSum += 11; // it is an Ace card and its value is 11
						numOfComAces++; // to remember that we added 11 of an ace
					}
					else
						comSum += val; // it is an Ace card and its value is 1
					
					if( comSum > 21 && numOfComAces != 0) { //Changing values of Aces from 11 to 1
						comSum -= 10; // change the value of an ace from 11 to 1
						numOfComAces--; // decrease the number of aces
					}
					
					System.out.println("Computer "+ num[countCom++] + " card is- " + tmpCard + ", And its total sum is- " + comSum );
					if ( countCom == 1 ) { // just after the first turn of the computer 
						turn = 0; // change turn to the computer
						System.out.println("");
					}
				}
			}
				
			// winner Announcement
			System.out.println("\nYour total sum is- " + userSum + "\nComputer total sum is- " + comSum);
			if(userSum > comSum ||  comSum > 21)
				System.out.println("You win!");
			else if(comSum > userSum)
				System.out.println("Computer win!");
			else
				System.out.println("It's a tie!");		
		}		
	}
}