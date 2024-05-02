package org.codingdojo.yatzy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class YatzyTest {
    
    @Test
    void chanceScoresSumOfAllDice() {
        int expected = 15;
        int actual = Yatzy.chance(2, 3, 4, 5, 1);
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }
    
    @Test
    void yatzyScoresFifty() {
        int expected = 50;
        int actual = Yatzy.yatzy(4, 4, 4, 4, 4);
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }
    
    @Test
    void onesScoresSumOfOnes() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }
    
    @Test
    void twosScoreSumOfTwos() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }
    
    @Test
    void threesScoreSumOfThrees() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }
    
    @Test
    void foursScoreSumOfFours() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }
    
    @Test
    void fivesScoreSumOfFives() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }
    
    @Test
    void sixesScoreSumOfSixes() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }
    
    @Test
    void onePairScoresSumOfPairValues() {
        assertEquals(6, new Yatzy().onePair(3, 4, 3, 5, 6));
        assertEquals(10, new Yatzy().onePair(5, 3, 3, 3, 5));
        assertEquals(12, new Yatzy().onePair(5, 3, 6, 6, 5));
    }
    
    @Test
    void twoPairsScoreSumOfTwoPairsValues() {
        assertEquals(16, Yatzy.twoPairs(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.twoPairs(3, 3, 5, 5, 5));
    }
    
    @Test
    void threeOfAKindScoresSumOfThreeOfAKindValues() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
    }
    
    @Test
    void fourOfAKindSumOfFourOfAKindValues() {
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 3));
    }
    
    @Test
    void smallStraightScoresSumOfSmallStraightValues() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }
    
    @Test
    void largeStraightScoresSumOfLargeStraightValues() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }
    
    @Test
    void fullHouseScoresSumOfFullHouseValues() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
