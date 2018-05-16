import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

		// Check that 2 cards are selected, then return whether they add to 11
		if (selectedCards.size() == 2) {
			return containsPairSum11(selectedCards);
		}

		// If 3 cards are selected, then return whether they are JQK
		else if (selectedCards.size() == 3) {
			return containsJQK(selectedCards);
		}

	    // If none of the above, then return false
	   	return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

		List<Integer> sampleSelectedCards = new ArrayList<Integer>();

		for(int i = 0; i < cards.length; i++)
		{
			// Add a card to sample cards if it exists in the cards array (basically the cards on the table)
			if (cards[i] != null)
			sampleSelectedCards.add(new Integer(i));
		}

		// Check the cards are either 11 or JQK
		return containsPairSum11(sampleSelectedCards) || containsJQK(sampleSelectedCards);
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

		// Make sure there are 2 cards
		if (selectedCards.size() < 2) {
            return false;
        }

        for (int i = 0; i < selectedCards.size() - 1; i++) {
            for (int j = i + 1; j < selectedCards.size(); j++) {

				// Value of the first card
				int value1 = cardAt(selectedCards.get(i)).pointValue();

				// Value of the second card
				int value2 = cardAt(selectedCards.get(j)).pointValue();

				// Check if they sum to eleven
				if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 11) {
                    return true;
                }
            }
        }

		// Else return false
        return false;
    }

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

        if (selectedCards.size() < 3) {
			return false;
		}

        boolean J = false;
		boolean Q = false;
		boolean K = false;

        for (Integer i : selectedCards)
        {
            Card c = cards[i];

            // Check for J
            if (c.rank().equals("jack")) {
				J = true;
			}

            // Check for Q
            if (c.rank().equals("queen")) {
				Q = true;
			}

            // Check for K
            if (c.rank().equals("king")) {
				K = true;
			}
        }

        // Return true if J, Q, and K all exist
		if (J && Q && K){
			return true;
		}

		return false;
	}
}
