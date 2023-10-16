package yatzy;

/**
 * The Yatzy class provides methods to calculate scores for various Yatzy
 * categories.
 */
public class YatzyResult {

	/**
	 * Calculate the chance score for the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of all dice in the roll.
	 */
	public static int chance(RollOfDice roll) {
		return roll.sumOfRoll();
	}

	/**
	 * Calculate the Yatzy score for the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return 50 if it's a Yatzy, otherwise 0.
	 */
	public static int yatzy(RollOfDice roll) {
		return roll.isYatzy() ? 50 : 0;
	}

	/**
	 * Calculate the score for ones in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of ones in the roll.
	 */
	public static int ones(RollOfDice roll) {
		return roll.getValueOfNumber(1);
	}

	/**
	 * Calculate the score for twos in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of twos in the roll.
	 */
	public static int twos(RollOfDice roll) {
		return roll.getValueOfNumber(2);
	}

	/**
	 * Calculate the score for threes in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of threes in the roll.
	 */
	public static int threes(RollOfDice roll) {
		return roll.getValueOfNumber(3);
	}

	/**
	 * Calculate the score for fours in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of fours in the roll.
	 */
	public static int fours(RollOfDice roll) {
		return roll.getValueOfNumber(4);
	}

	/**
	 * Calculate the score for fives in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of fives in the roll.
	 */
	public static int fives(RollOfDice roll) {
		return roll.getValueOfNumber(5);
	}

	/**
	 * Calculate the score for sixes in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of sixes in the roll.
	 */
	public static int sixes(RollOfDice roll) {
		return roll.getValueOfNumber(6);
	}

	/**
	 * Calculate the score for a pair in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of the highest pair in the roll, doubled.
	 */
	public static int scorePairs(RollOfDice roll) {
		return roll.findFirstValueGreaterThan(2) * 2;
	}

	/**
	 * Calculate the score for two pairs in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of the two pairs, doubled, or 0 if not two pairs are present.
	 */
	public static int twoPairs(RollOfDice roll) {
		int numberOfPairs = roll.getNumberOfElementGreaterOrEqual(2);
		return numberOfPairs == 2 ? roll.getSumOfElementGreaterOrEqual(2) * 2 : 0;
	}

	/**
	 * Calculate the score for four of a kind in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of the highest four of a kind, quadrupled.
	 */
	public static int fourOfAKind(RollOfDice roll) {
		return roll.findFirstValueGreaterThan(4) * 4;
	}

	/**
	 * Calculate the score for three of a kind in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of the highest three of a kind, tripled.
	 */
	public static int threeOfAKind(RollOfDice roll) {
		return roll.findFirstValueGreaterThan(3) * 3;
	}

	/**
	 * Calculate the score for a small straight in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return 15 if it's a small straight, otherwise 0.
	 */
	public static int smallStraight(RollOfDice roll) {
		return roll.isSmallStraight() ? 15 : 0;
	}

	/**
	 * Calculate the score for a large straight in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return 20 if it's a large straight, otherwise 0.
	 */
	public static int largeStraight(RollOfDice roll) {
		return roll.isLargeStraight() ? 20 : 0;
	}

	/**
	 * Calculate the score for a full house in the given roll of dice.
	 *
	 * @param roll The roll of dice.
	 * @return The sum of a full house, or 0 if not a full house is present.
	 */
	public static int fullHouse(RollOfDice roll) {
		int twoSum = roll.getSumOfElementEquals(2);
		int threeSum = roll.getSumOfElementEquals(3);
		return (twoSum > 0 && threeSum > 0) ? (twoSum * 2 + threeSum * 3) : 0;
	}
}
