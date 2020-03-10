package me.volart.problems;

import java.util.LinkedList;

/*
Задача: Напишите алгоритм объединения двух отсортированных связанных
списков и верните указатель на новый список.
Входные данные: l1, l2 — корневые узлы списков
Вывод: l3 — результирующий список
Пример: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/
public class LinkedListUnion<T extends Comparable<T>> {

  public LinkedList<T> unionSortedLinkedList(LinkedList<T> first, LinkedList<T> second) {
    if (first != null && second != null) {
      if (first.size() > second.size()) {
        return mergeSecondToFirst(first, second);
      } else {
        return mergeSecondToFirst(second, first);
      }
    } else if (first == null && second != null) {
      return second;
    } else if (first != null && second == null) {
      return first;
    }

    return null;
  }

  private LinkedList<T> mergeSecondToFirst(LinkedList<T> first, LinkedList<T> second) {
    int j = 0;
    for (T t : second) {
      if (first.get(j).compareTo(t) >= 0) {
        first.add(j, t);
        j++;
      }
      j++;
    }
    return first;
  }

}
