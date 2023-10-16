import static org.junit.Assert.assertEquals;
import static yatzy.YatzyFunction.*;

import org.junit.Test;

import yatzy.RollOfDice;

public class YatzyTest {

	@Test
	public void testChance() {
		assertEquals(15, Chance.getScore(new RollOfDice(2, 3, 4, 5, 1)));
		assertEquals(16, Chance.getScore(new RollOfDice(3, 3, 4, 5, 1)));
		assertEquals(16, Chance.getScore(new RollOfDice(3, 4, 1, 2, 6)));
	}

	@Test
	public void testYatzy() {
		assertEquals(50, Yatzy.getScore(new RollOfDice(4, 4, 4, 4, 4)));
		assertEquals(50, Yatzy.getScore(new RollOfDice(1, 1, 1, 1, 1)));
		assertEquals(50, Yatzy.getScore(new RollOfDice(6, 6, 6, 6, 6)));
		assertEquals(0, Yatzy.getScore(new RollOfDice(6, 6, 6, 6, 3)));
	}

	@Test
	public void testOnes() {
		assertEquals(1, Ones.getScore(new RollOfDice(1, 2, 3, 4, 5)));
		assertEquals(2, Ones.getScore(new RollOfDice(1, 2, 1, 4, 5)));
		assertEquals(0, Ones.getScore(new RollOfDice(6, 2, 2, 4, 5)));
		assertEquals(4, Ones.getScore(new RollOfDice(1, 2, 1, 1, 1)));
	}

	@Test
	public void testTows() {
		assertEquals(4, Twos.getScore(new RollOfDice(1, 2, 3, 2, 6)));
		assertEquals(10, Twos.getScore(new RollOfDice(2, 2, 2, 2, 2)));
	}

	@Test
	public void testThrees() {
		assertEquals(6, Threes.getScore(new RollOfDice(1, 2, 3, 2, 3)));
		assertEquals(12, Threes.getScore(new RollOfDice(2, 3, 3, 3, 3)));
	}

	@Test
	public void testFours() {
		assertEquals(12, Fours.getScore(new RollOfDice(4, 4, 4, 5, 5)));
		assertEquals(8, Fours.getScore(new RollOfDice(4, 4, 5, 5, 5)));
		assertEquals(4, Fours.getScore(new RollOfDice(4, 5, 5, 5, 5)));
	}

	@Test
	public void testFives() {
		assertEquals(10, Fives.getScore(new RollOfDice(4, 4, 4, 5, 5)));
		assertEquals(15, Fives.getScore(new RollOfDice(4, 4, 5, 5, 5)));
		assertEquals(20, Fives.getScore(new RollOfDice(4, 5, 5, 5, 5)));
	}

	@Test
	public void testSixes() {
		assertEquals(0, Sixes.getScore(new RollOfDice(4, 4, 4, 5, 5)));
		assertEquals(6, Sixes.getScore(new RollOfDice(4, 4, 6, 5, 5)));
		assertEquals(18, Sixes.getScore(new RollOfDice(6, 5, 6, 6, 5)));
		assertEquals(0, Sixes.getScore(new RollOfDice(1, 2, 3, 4, 5)));
		assertEquals(18, Sixes.getScore(new RollOfDice(6, 6, 6, 1, 2)));
	}

	@Test
	public void testScorePairs() {
		assertEquals(6, ScorePairs.getScore(new RollOfDice(3, 4, 3, 5, 6)));
		assertEquals(10, ScorePairs.getScore(new RollOfDice(5, 3, 3, 3, 5)));
		assertEquals(12, ScorePairs.getScore(new RollOfDice(5, 3, 6, 6, 5)));
		assertEquals(8, ScorePairs.getScore(new RollOfDice(3, 3, 4, 4, 2)));
		assertEquals(4, ScorePairs.getScore(new RollOfDice(1, 1, 1, 2, 2)));
	}

	@Test
	public void testTwoPairs() {
		assertEquals(16, TwoPairs.getScore(new RollOfDice(3, 3, 5, 4, 5)));
		assertEquals(16, TwoPairs.getScore(new RollOfDice(3, 3, 5, 5, 5)));
		assertEquals(14, TwoPairs.getScore(new RollOfDice(3, 3, 4, 4, 2)));
		assertEquals(6, TwoPairs.getScore(new RollOfDice(1, 1, 2, 2, 3)));
		assertEquals(0, TwoPairs.getScore(new RollOfDice(1, 2, 3, 4, 5)));
	}

	@Test
	public void testThreeOfAKind() {
		assertEquals(9, ThreeOfAKind.getScore(new RollOfDice(3, 3, 3, 4, 5)));
		assertEquals(15, ThreeOfAKind.getScore(new RollOfDice(5, 3, 5, 4, 5)));
		assertEquals(9, ThreeOfAKind.getScore(new RollOfDice(3, 3, 3, 3, 5)));
		assertEquals(9, ThreeOfAKind.getScore(new RollOfDice(3, 3, 3, 3, 3)));
	}

	@Test
	public void testFourOfAKind() {
		assertEquals(12, FourOfAKind.getScore(new RollOfDice(3, 3, 3, 3, 5)));
		assertEquals(20, FourOfAKind.getScore(new RollOfDice(5, 5, 5, 4, 5)));
		assertEquals(16, FourOfAKind.getScore(new RollOfDice(4, 4, 4, 4, 2)));
	}

	@Test
	public void testSmallStraight() {
		assertEquals(15, SmallStraight.getScore(new RollOfDice(1, 2, 3, 4, 5)));
		assertEquals(15, SmallStraight.getScore(new RollOfDice(2, 3, 4, 5, 1)));
		assertEquals(0, SmallStraight.getScore(new RollOfDice(1, 2, 2, 4, 5)));
	}

	@Test
	public void testLargeStraight() {
		assertEquals(20, LargeStraight.getScore(new RollOfDice(6, 2, 3, 4, 5)));
		assertEquals(20, LargeStraight.getScore(new RollOfDice(2, 3, 4, 5, 6)));
		assertEquals(0, LargeStraight.getScore(new RollOfDice(1, 2, 2, 4, 5)));
		assertEquals(20, LargeStraight.getScore(new RollOfDice(2, 3, 4, 5, 6)));
		assertEquals(0, LargeStraight.getScore(new RollOfDice(1, 2, 3, 4, 5)));
	}

	@Test
	public void testFullHouse() {
		assertEquals(18, FullHouse.getScore(new RollOfDice(6, 2, 2, 2, 6)));
		assertEquals(0, FullHouse.getScore(new RollOfDice(2, 3, 4, 5, 6)));
		assertEquals(7, FullHouse.getScore(new RollOfDice(1, 1, 1, 2, 2)));
		assertEquals(12, FullHouse.getScore(new RollOfDice(2, 2, 2, 3, 3)));
		assertEquals(0, FullHouse.getScore(new RollOfDice(2, 2, 3, 3, 4)));
	}
}
