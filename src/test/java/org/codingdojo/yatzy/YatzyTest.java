package org.codingdojo.yatzy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class YatzyTest {
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        2, 3, 4, 5, 1, 15
        3, 3, 4, 5, 1, 16
        """, useHeadersInDisplayName = true)
    void chanceScoresSumOfAllDice(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.chance();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        4, 4, 4, 4, 4, 50
        6, 6, 6, 6, 6, 50
        6, 6, 6, 6, 3, 0
        """, useHeadersInDisplayName = true)
    void yatzyScoresFifty(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.yatzy();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        1, 2, 3, 4, 5, 1
        1, 2, 1, 4, 5, 2
        6, 2, 2, 4, 5, 0
        1, 2, 1, 1, 1, 4
        """, useHeadersInDisplayName = true)
    void onesScoresSumOfOnes(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.ones();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        1, 2, 3, 2, 6, 4
        2, 2, 2, 2, 2, 10
        """, useHeadersInDisplayName = true)
    void twosScoresSumOfTwos(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.twos();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        1, 2, 3, 2, 3, 6
        2, 3, 3, 3, 3, 12
        """, useHeadersInDisplayName = true)
    void threesScoresSumOfThrees(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.threes();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        4, 4, 4, 5, 5, 12
        4, 4, 5, 5, 5, 8
        4, 5, 5, 5, 5, 4
        """, useHeadersInDisplayName = true)
    void foursScoresSumOfFours(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.fours();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        4, 4, 4, 5, 5, 10
        4, 4, 5, 5, 5, 15
        4, 5, 5, 5, 5, 20
        """, useHeadersInDisplayName = true)
    void fivesScoresSumOfFives(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.fives();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        4, 4, 4, 5, 5, 0
        4, 4, 6, 5, 5, 6
        6, 5, 6, 6, 5, 18
        """, useHeadersInDisplayName = true)
    void sixesScoresSumOfSixes(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.sixes();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        3, 4, 3, 5, 6, 6
        5, 3, 3, 3, 5, 10
        5, 3, 6, 6, 5, 12
        """, useHeadersInDisplayName = true)
    void onePairScoresSumOfPair(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.onePair();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        3, 3, 5, 4, 5, 16
        3, 3, 5, 5, 5, 16
        """, useHeadersInDisplayName = true)
    void twoPairsScoresSumOfTwoPairs(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.twoPairs();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        3, 3, 3, 4, 5, 9
        5, 3, 5, 4, 5, 15
        3, 3, 3, 3, 5, 9
        """, useHeadersInDisplayName = true)
    void threeOfAKindScoresSumOfThreeOfAKind(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.threeOfAKind();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        3, 3, 3, 3, 5, 12
        5, 5, 5, 4, 5, 20
        3, 3, 3, 3, 3, 12
        """, useHeadersInDisplayName = true)
    void fourOfAKndScoresSumOfFourOfAKind(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.fourOfAKind();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        1, 2, 3, 4, 5, 15
        2, 3, 4, 5, 1, 15
        1, 2, 2, 4, 5, 0
        """, useHeadersInDisplayName = true)
    void smallStraightScoresSumOfSmallStraight(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.smallStraight();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        6, 2, 3, 4, 5, 20
        2, 3, 4, 5, 6, 20
        1, 2, 2, 4, 5, 0
        """, useHeadersInDisplayName = true)
    void largeStraightScoresSumOfLargeStraight(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.largeStraight();
        
        assertThat(score).isEqualTo(expectedScore);
    }
    
    @ParameterizedTest
    @CsvSource(textBlock = """
        dice1, dice2, dice3, dice4, dice5, expectedScore
        6, 2, 2, 2, 6, 18
        2, 3, 4, 5, 6, 0
        """, useHeadersInDisplayName = true)
    void fullHouseScoresSumOfFullHouse(int dice1, int dice2, int dice3, int dice4, int dice5, int expectedScore) {
        Yatzy yatzy = new Yatzy(dice1, dice2, dice3, dice4, dice5);
        
        int score = yatzy.fullHouse();
        
        assertThat(score).isEqualTo(expectedScore);
    }
}
