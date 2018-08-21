package com.wutong;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class bsq {
  public static void main(String[] args) {
    // Stack
  }
}


class Queue1<Item> {
  private Node<Item> first;
  private Node<Item> last;
  private int n;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public Queue1() {
    this.first = null;
    this.last = null;
    this.n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void enqueue(Item item) {
    Node<Item> old = last;
    last = new Node<Item>();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      old.next = last;
    }
    n++;
  }

  public Item dequeue() {
    if (isEmpty()) {
      return null;
    }
    Item item = first.item;
    first = first.next;
    n--;
    if (isEmpty()) {
      this.last = null;
    }
    return null;
  }
}

class Stack1<Item> implements Iterable<Item>{
  private Node<Item> first;
  private int n;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public Stack1() {
    this.first = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    Node<Item> old = first;
    first = new Node<Item>();
    first.item = item;
    first.next = old;
    n++;
  }

  public Item pop() {
    if (isEmpty()) {
      return null;
    }
    Item item = first.item;
    first = first.next;
    n--;
    return item;
  }
  public Iterator<Item> iterator() {
    return new ListIterator<Item>(first);
  }

  // an iterator, doesn't implement remove() since it's optional
  private class ListIterator<Item> implements Iterator<Item> {
    private Node<Item> current;

    public ListIterator(Node<Item> first) {
      current = first;
    }

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}


class Bag1<Item> {
  private Node<Item> first;
  private int n;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public Bag1() {
    this.first = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void add(Item item) {
    Node<Item> old = first;
    first = new Node<Item>();
    first.item = item;
    first.next = old;
    n++;
  }
}






























