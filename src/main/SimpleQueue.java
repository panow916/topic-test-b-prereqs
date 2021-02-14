package main;

public interface SimpleQueue<T> {

  void enqueue(T t);

  T dequeue();

  boolean isEmpty();

  int size();
}
