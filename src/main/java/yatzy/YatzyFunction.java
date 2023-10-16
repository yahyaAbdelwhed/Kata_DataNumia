package yatzy;

import java.util.function.Function;

public enum YatzyFunction {
	Chance(YatzyResult::chance), Yatzy(YatzyResult::yatzy), Ones(YatzyResult::ones), Twos(YatzyResult::twos),
	Threes(YatzyResult::threes), Fours(YatzyResult::fours), Fives(YatzyResult::fives), Sixes(YatzyResult::sixes),
	ScorePairs(YatzyResult::scorePairs), TwoPairs(YatzyResult::twoPairs), ThreeOfAKind(YatzyResult::threeOfAKind),
	FourOfAKind(YatzyResult::fourOfAKind), SmallStraight(YatzyResult::smallStraight),
	LargeStraight(YatzyResult::largeStraight), FullHouse(YatzyResult::fullHouse);

	private final Function<RollOfDice, Integer> scoreFunction;

	YatzyFunction(Function<RollOfDice, Integer> scoreFunction) {
		this.scoreFunction = scoreFunction;
	}

	/**
	 * Calculate the score for the given roll of dice based on the category.
	 *
	 * @param roll The roll of dice.
	 * @return The score for the category based on the roll.
	 */
	public int getScore(RollOfDice roll) {
		return this.scoreFunction.apply(roll);
	}
}
