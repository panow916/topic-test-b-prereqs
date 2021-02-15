package main;

import java.util.Arrays;

public class ArrayBackedStack<T> implements SimpleStack<T> {

  private static final int DEFAULT_CAPACITY = 10;

  private T[] elements;
  private int size;

  @SuppressWarnings("unchecked")
  public ArrayBackedStack() {
    elements = (T[]) new Object[DEFAULT_CAPACITY];
    size = 0;
  }

  @Override
  public void push(T t) {
    if (size == DEFAULT_CAPACITY) {
      throw new FullStackException("Urp. I'm full.");
    } else {
      elements[size] = t;
      size++;
    }
  }

  @Override
  public T pop() {
    if (size == 0) {
      throw new EmptyStackException("Nope nope nope.");
    } else {
      size--;
      T popped = elements[size];
      elements[size] = null;
      return popped;
    }
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == DEFAULT_CAPACITY;
  }

  @Override
  public T peek() {
    if (size == 0) {
      throw new EmptyStackException("Nope nope nope.");
    } else {
      return elements[size];
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(elements) + " size: " + size;
  }
}
