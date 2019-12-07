package BlackJack;


import java.security.SecureRandom;
import java.util.*;

/**
 *  DecckOfCard class represents a deck of playing cards.
 * @author Hagay Enoch
 *  @version 30.11.2019
 *
 */
public class DeckOfCards {
	private ArrayList<Card> deck; // list of Card objects
	private final int ZERO = 0; // index of next Card to be dealt
	private final int NUMBER_OF_CARDS = 52; // constant number of Cards
	private SecureRandom randomNumbers; // random number generator
	 
	// constructor fills deck of Cards
	public DeckOfCards(){
		String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
	          "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
	    String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
	 
	    deck = new ArrayList<Card>( NUMBER_OF_CARDS ); // create a list of Card objects
	    randomNumbers = new SecureRandom(); // create random number generator
	 
	    // populate deck with Card objects
	    for ( int count = 0; count <NUMBER_OF_CARDS; count++ ) 
	    	deck.add(count, new Card( faces[ count % 13 ], suits[ count / 13 ] ));
	    } // end DeckOfCards constructor
	
	// shuffle deck of Cards with one-pass algorithm 
	public void shuffle(){
		// after shuffling, dealing should start at the head of the list
		
	    // for each Card, pick another random Card and swap them
	    for ( int first = 0; first < deck.size(); first++ ) {
	    	// select a random number between 0 and 51 
	        int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
	           
	        // swap current Card with randomly selected Card
	        Card temp = deck.get(first);        
	        deck.set(first ,  deck.get(second));   
	        deck.set(second, temp);
	        } // end for
	    } // end method shuffle
	  
	// deal one Card
	public Card dealCard(){
		// determine whether Cards remain to be dealt
	    if ( ZERO < deck.size())
	    	return deck.remove(ZERO); 
	    else        
	        return null; // return null to indicate that all Cards were dealt
	    } // end method dealCard
} // end class DeckOfCards
