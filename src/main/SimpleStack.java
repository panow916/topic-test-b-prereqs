package main;

public interface SimpleStack<T> {

  void push(T t);

  T pop();

  boolean isEmpty();

  T peek();
}
