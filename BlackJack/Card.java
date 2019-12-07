package BlackJack;


/**
 * This class represent a card object
 * 
 * @author Hagay Enoch
 * @version 30.11.2019 
 */
public class Card {
	private final String face;// face of card("Ace", "Deuce",...)
	private final String suit;// suit of card("Hearts", "Diamonds",...)
	private final String cards[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
	          "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };//array of card's names
			
	
	/**
	 * two-argument constructor initializes card's face and suit
	 */
	public Card(String cardFace,String cardSuit) {
		this.face = cardFace;
		this.suit = cardSuit;
	}
	
	/**
	 * Return the value of the card in blackJack game
	 * @return the value of the card in blackJack game
	 */
	public int blackJackValue() {
		int i;
		for (i = 0; !(getFace().equals(cards[i])) ; i++) {}
		if( i <= 9) // this is a normal card
			return i+1;
		else // royal card
			return 10;
	}
	
	/**
	 * Return the face of the card
	 * @return the face of the card
	 */
	public String getFace() {
		return face;
	}
	
	/**
	 * Return string representation of Card
	 * @return string representation of Card
	 */
	public String toString() {
		return face+ " of " + suit;
	}
} // end class Card
