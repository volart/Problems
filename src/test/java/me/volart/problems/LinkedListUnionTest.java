package me.volart.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class LinkedListUnionTest {

  private LinkedListUnion<Integer> linkedListUnion;

  @BeforeEach
  public void beforeEach() {
    linkedListUnion = new LinkedListUnion<>();
  }

  @Test
  public void testLinkedListUnion_FirstNotNullSecondNull_FirstAsResult() {
    LinkedList<Integer> first = generateSortedLinkedList(5);
    LinkedList<Integer> result = linkedListUnion.unionSortedLinkedList(first, null);
    assertEquals(first, result);
  }

  @Test
  public void testLinkedListUnion_FirstNullSecondNotNull_SecondAsResult() {
    LinkedList<Integer> second = generateSortedLinkedList(4);
    LinkedList<Integer> result = linkedListUnion.unionSortedLinkedList(null, second);
    assertEquals(second, result);
  }

  @Test
  public void testLinkedListUnion_FirstNullSecondNull_Null() {
    LinkedList<Integer> result = linkedListUnion.unionSortedLinkedList(null, null);
    assertNull(result);
  }

  @Test
  public void testLinkedListUnion_FirstNotNullSecondNotNull_SortedUnion() {
    LinkedList<Integer> first = generateSortedLinkedListWithStep(1, 3);
    LinkedList<Integer> second = generateSortedLinkedListWithStep(2, 4);
    LinkedList<Integer> result = linkedListUnion.unionSortedLinkedList(first, second);

    List<Integer> expList = List.of(1, 2, 2, 3, 3, 4, 5);
    LinkedList<Integer> expected = new LinkedList<>(expList);

    assertEquals(expected, result);
  }

  @Test
  public void testLinkedListUnion_FirstNotNullSecondNotNullSameNumbers_SortedUnion() {
    List<Integer> firstList = List.of(1, 2, 4);
    LinkedList<Integer> first = new LinkedList<>(firstList);

    List<Integer> secondList = List.of(1, 3, 4);
    LinkedList<Integer> second = new LinkedList<>(secondList);

    LinkedList<Integer> result = linkedListUnion.unionSortedLinkedList(first, second);

    List<Integer> expList = List.of(1, 1, 2, 3, 4, 4);
    LinkedList<Integer> expected = new LinkedList<>(expList);

    assertEquals(expected, result);
  }

  public LinkedList<Integer> generateSortedLinkedList(int length) {
    LinkedList<Integer> list = new LinkedList<>();
    int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
    for (int i = 1; i <= length; i++) {
      list.addFirst(i * randomNum);
    }
    return list;
  }

  public LinkedList<Integer> generateSortedLinkedListWithStep(int step, int length) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      list.addLast(i + step);
    }
    return list;
  }
}
