package com.wutong;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {
  public static void main(String[] args) {
    Queue2<String> qs = new Queue2<String>();
    qs.enqueue("h");
    qs.enqueue("e");
    qs.enqueue("l");
    qs.enqueue("l");
    qs.enqueue("o");
    for (String s :
      qs) {
      StdOut.println(s);
    }
  }


  private Item[] a;
  private int N;

  public FixedCapacityStack(int cap) {
    this.a = (Item[]) new Object[cap];
    this.N = 0;
  }

  private void resize(int len) {
    Item[] temp = (Item[]) new Object[len];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    if (N == a.length) resize(N * 2);
    a[N++] = item;
  }

  public Item pop() {
    Item item = a[--N];
    a[N] = null;
    if (N > 0 && N == a.length / 4) resize(N / 2);
    return item;
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = N;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      return a[--i];
    }

    public void remove() {

    }
  }
}

class Queue2<Item> implements Iterable<Item> {
  private Node<Item> first;
  private Node<Item> last;
  private int N;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public Queue2() {
    N = 0;
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  public void enqueue(Item item) {
    Node<Item> oldLast = last;
    last = new Node<Item>();
    last.next = null;
    last.item = item;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    N++;
  }

  public Item dequeue() {
    if (isEmpty()) return null;
    Item item = first.item;
    first = first.next;
    N--;
    if (isEmpty()) {
      last = null;
    }
    return item;
  }

  public Iterator<Item> iterator() {
    return new QueueToIterator<Item>(first);
  }

  private class QueueToIterator<Item> implements Iterator<Item> {
    private Node<Item> current;

    public QueueToIterator(Node<Item> current) {
      this.current = current;
    }

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }

    public void remove() {

    }
  }
}
