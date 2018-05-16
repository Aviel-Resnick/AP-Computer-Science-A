/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	    String[] ranks = {"jack", "queen", "king"};
        String[] suits = {"blue", "red"};
        int[] pointValues = {11, 12, 13};

        Deck d1 = new Deck(ranks, suits, pointValues);
        Deck d2 = new Deck(ranks, suits, pointValues);
        Deck d3 = new Deck(ranks, suits, pointValues);


        // Test Methods
        System.out.println(d1.size());
        System.out.println(d2.isEmpty());
        System.out.println(d3.deal());

    }
}
