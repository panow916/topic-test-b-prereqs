package main;

import java.util.Arrays;

public class ArrayBackedQueue<T> implements SimpleQueue<T> {

  private static final int DEFAULT_CAPACITY = 10;

  private T[] elements;
  private int headIndex;
  private int tailIndex;
  private int size;

  public ArrayBackedQueue() {
    elements = (T[]) new Object[DEFAULT_CAPACITY];
    headIndex = 0;
    tailIndex = 0;
    size = 0;
  }

  @Override
  public void enqueue(T t) {
    if (size == DEFAULT_CAPACITY) {
      throw new FullQueueException("the queue - she is full!");
    } else {
      elements[tailIndex] = t;
      tailIndex = (tailIndex + 1) % DEFAULT_CAPACITY;
      size++;
    }
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new EmptyQueueException("no way, man");
    } else {
      size--;
      T comingOut = elements[headIndex];
      elements[headIndex] = null;
      headIndex = (headIndex + 1) % DEFAULT_CAPACITY;
      return comingOut;
    }
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return String.format("%s H:%d T:%d", Arrays.toString(elements), headIndex, tailIndex);
  }
}
