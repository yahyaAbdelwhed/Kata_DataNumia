package yatzy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * This class represents a set of dice used to play a game of Yatzy.
 */
public class RollOfDice {

    private List<Integer> dice;

    /**
     * Constructor for the RollOfDice class.
     *
     * @param diceRoll An array of integers representing the values of the dice.
     */
    public RollOfDice(int... diceRoll) {
        this.dice = Arrays.stream(diceRoll).boxed().sorted().collect(Collectors.toList());
    }

    /**
     * Calculate and return the sum of the dice values.
     *
     * @return The sum of the dice values.
     */
    public int sumOfRoll() {
        return this.dice.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * Calculate and return a Map sorted in reverse order of occurrences of
     * dice values.
     *
     * @return A sorted Map of dice value occurrences.
     */
    private Map<Integer, Integer> getOccurrenceReversedOrder() {
        Map<Integer, Integer> counts = this.dice.stream()
                .collect(Collectors.toMap(diceRoll -> diceRoll, diceRoll -> 1, Integer::sum));
        Map<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(counts);
        return sortedMap;
    }

    /**
     * Check if the roll is a Yatzy (all dice values are identical).
     *
     * @return true if it's a Yatzy, otherwise false.
     */
    public boolean isYatzy() {
        return getOccurrenceReversedOrder().values().stream().anyMatch(count -> count == 5);
    }

    /**
     * Calculate the total value of a specific number of dice.
     *
     * @param number The dice number for which to calculate the value.
     * @return The total value of dice with that number.
     */
    public int getValueOfNumber(int number) {
        return getOccurrenceReversedOrder().getOrDefault(number, 0).intValue() * number;
    }

    /**
     * Find the first dice value greater than or equal to a given value.
     *
     * @param value The minimum value being searched for.
     * @return The first dice value greater than or equal to the given value, or
     *         0 if no value is found.
     */
    public int findFirstValueGreaterThan(int value) {
        return getOccurrenceReversedOrder().entrySet().stream().filter(entry -> entry.getValue() >= value)
                .map(Map.Entry::getKey).findFirst().orElse(0);
    }

    /**
     * Check if the dice form a small straight (1, 2, 3, 4, 5).
     *
     * @return true if it's a small straight, otherwise false.
     */
    boolean isSmallStraight() {
        return this.dice.equals(Arrays.asList(1, 2, 3, 4, 5));
    }

    /**
     * Check if the dice form a large straight (2, 3, 4, 5, 6).
     *
     * @return true if it's a large straight, otherwise false.
     */
    boolean isLargeStraight() {
        return this.dice.equals(Arrays.asList(2, 3, 4, 5, 6));
    }

    /**
     * Calculate the sum of dice that have an occurrence equal to a given value.
     *
     * @param param The number of occurrences being searched for.
     * @return The sum of dice with the specified occurrence.
     */
    int getSumOfElementEquals(int param) {
        return getOccurrenceReversedOrder().entrySet().stream().filter(entry -> entry.getValue() == param)
                .map(Map.Entry::getKey).mapToInt(Integer::intValue).sum();
    }

    /**
     * Calculate the sum of dice that have an occurrence greater than or equal to a
     * given value.
     *
     * @param param The minimum number of occurrences being searched for.
     * @return The sum of dice with an occurrence greater than or equal to the
     *         specified value.
     */
    int getSumOfElementGreaterOrEqual(int param) {
        return getOccurrenceReversedOrder().entrySet().stream().filter(entry -> entry.getValue() >= param)
                .map(Map.Entry::getKey).mapToInt(Integer::intValue).sum();
    }

    /**
     * Count the number of dice that have an occurrence greater than or equal to a
     * given value.
     *
     * @param param The minimum number of occurrences being searched for.
     * @return The number of dice with an occurrence greater than or equal to the
     *         specified value.
     */
    int getNumberOfElementGreaterOrEqual(int param) {
        return (int) getOccurrenceReversedOrder().entrySet().stream().filter(entry -> entry.getValue() >= param)
                .count();
    }
}
