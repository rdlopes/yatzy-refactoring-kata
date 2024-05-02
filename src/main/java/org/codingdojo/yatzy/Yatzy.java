package org.codingdojo.yatzy;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Yatzy {
  
  private final Map<Integer, Integer> valuesCounted;
  
  public Yatzy(int d1, int d2, int d3, int d4, int d5) {
    valuesCounted = Stream.of(d1, d2, d3, d4, d5)
                          .collect(groupingBy(identity(), summingInt(value -> 1)));
  }
  
  public int chance() {
    return valuesCounted.entrySet()
                        .stream()
                        .mapToInt(valueCount -> valueCount.getKey() * valueCount.getValue())
                        .sum();
  }
  
  public int yatzy() {
    return valuesCounted.size() == 1
        ? 50
        : 0;
  }
  
  public int ones() {
    return sumOf(1);
  }
  
  public int twos() {
    return sumOf(2);
  }
  
  public int threes() {
    return sumOf(3);
  }
  
  public int fours() {
    return sumOf(4);
  }
  
  public int fives() {
    return sumOf(5);
  }
  
  public int sixes() {
    return sumOf(6);
  }
  
  public int onePair() {
    return bestValuesCountedMoreThan(2)
        .findFirst()
        .map(valueCount -> valueCount.getKey() * 2)
        .orElse(0);
  }
  
  public int twoPairs() {
    return bestValuesCountedMoreThan(2)
        .limit(2)
        .mapToInt(valueCount -> valueCount.getKey() * 2)
        .sum();
  }
  
  public int threeOfAKind() {
    return bestValuesCountedMoreThan(3)
        .findFirst()
        .map(valueCount -> valueCount.getKey() * 3)
        .orElse(0);
  }
  
  public int fourOfAKind() {
    return bestValuesCountedMoreThan(4)
        .findFirst()
        .map(valueCount -> valueCount.getKey() * 4)
        .orElse(0);
  }
  
  public int fullHouse() {
    var onePairScore = onePair();
    var threeOfAKindScore = threeOfAKind();
    
    return onePairScore > 0 && threeOfAKindScore > 0
        ? onePairScore + threeOfAKindScore
        : 0;
  }
  
  public int smallStraight() {
    return allValuesPresentExcept(6)
        ? 15
        : 0;
  }
  
  public int largeStraight() {
    return allValuesPresentExcept(1)
        ? 20
        : 0;
  }
  
  private int sumOf(int value) {
    return valuesCounted.getOrDefault(value, 0) * value;
  }
  
  private Stream<Map.Entry<Integer, Integer>> bestValuesCountedMoreThan(int count) {
    return valuesCounted.entrySet()
                        .stream()
                        .filter(valueCount -> valueCount.getValue() >= count)
                        .sorted(Map.Entry.<Integer, Integer>comparingByKey()
                                         .reversed());
  }
  
  private boolean allValuesPresentExcept(int missingValue) {
    return valuesCounted.size() == 5 && !valuesCounted.containsKey(missingValue);
  }
  
}



