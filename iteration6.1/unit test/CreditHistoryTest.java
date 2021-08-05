import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class CreditHistoryTest {
	
	// the following three methods tests the addRating method
	@Test
	public void test_addRating_negativeSix() {
		CreditHistory c = new CreditHistory();
		c.addRating(-6);
		ArrayList<Integer> ratingsList = c.getRatings();
		assertEquals("tried to add -6, the ratings list should be empty", true, ratingsList.isEmpty());
	} 

	
	@Test
	public void test_addRating_positiveSix() {
		CreditHistory c = new CreditHistory();
		c.addRating(6);
		ArrayList<Integer> ratingsList = c.getRatings();
		assertEquals("tried to add 6, the ratings list should be empty", true, ratingsList.isEmpty());
		
	}


	@Test
	public void test_addRating_validRatingFive() {
		CreditHistory c = new CreditHistory();
		c.addRating(5);
		ArrayList<Integer> ratingsList = c.getRatings();
		int rating = ratingsList.get(0);
		assertEquals("tried to add 5 to ratings, the ratings list should contain 5", 5, rating);
	
	}

	@Test
        public void test_addRating_validRatingNegativeFive() {
                CreditHistory c = new CreditHistory();
                c.addRating(-5);
                ArrayList<Integer> ratingsList = c.getRatings();
                int rating = ratingsList.get(0);
                assertEquals("tried to add -5 to ratings, the ratings list should contain -5", -5, rating);

	}


	// the following test tests the getRatings method
	@Test
	public void test_getRatings() {
		CreditHistory c = new CreditHistory();
		c.addRating(1);
		c.addRating(2);
		ArrayList<Integer> ratingsList = c.getRatings();
		boolean inOrder = false;
		
		if (ratingsList.isEmpty()) {
			assertEquals("getRatings should not be empty", false, ratingsList.isEmpty());
		}	
		int firstEntry = ratingsList.get(0);
		int secondEntry = ratingsList.get(1);
		
		if ((firstEntry == 1) && (secondEntry == 2)) {
			inOrder = true;
		}
		assertEquals("getRatings should return 1, 2 in order", true, inOrder);
	
	}



	// the following test tests the trimRatings method
	@Test
	public void test_trimRatings() {
		CreditHistory c = new CreditHistory();
		// add 11 entries from -5 to 5
		for (int x = -5; x <= 5; x++) {
			c.addRating(x);
		}
		// the list should be trimmed to the last 10 entries with trimRatings()
		c.trimRatings();
		ArrayList<Integer> actualRatings = c.getRatings();

		// create a list that should contain the expected ratings
		ArrayList<Integer> expectedRatings = new ArrayList<Integer>();
		for (int x = -4; x <= 5; x++) {
			expectedRatings.add(x);
		}
		assertEquals("the trimRatings method should return the last 10 entries", true, expectedRatings.equals(actualRatings));

	}


	// the following method tests numOfRatings method
	public void test_numOfRatings() {
	CreditHistory c = new CreditHistory();
	c.addRating(1);
	c.addRating(2);
	c.addRating(3);
	c.addRating(4);

	assertEquals("expected the number of ratings to be 4", 4, c.numOfRatings());
	
	}








}
