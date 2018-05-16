/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
        // Create 3 Cards to test
        Card card1 = new Card("5", "Clubs", 5);
        Card card2 = new Card("Queen", "Spades", 12);
        Card card3 = new Card("Queen", "Spades", 12);

        // Test toString
        System.out.println(card1.toString());

        // Test matches (Expected Output True)
        System.out.println(card2.matches(card3));

        // Test matches (Expected Output False)
        System.out.println(card1.matches(card2));
	}
}
