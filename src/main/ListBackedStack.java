package main;

public class ListBackedStack<T> implements SimpleStack<T> {

  private LinkedList<T> elements;

  public ListBackedStack() {
    elements = new LinkedList<>();
  }

  @Override
  public void push(T t) {
    elements.prepend(t);
  }

  @Override
  public T pop() {
    return elements.remove(0);
  }

  @Override
  public boolean isEmpty() {
    return elements.isEmpty();
  }

  @Override
  public T peek() {
    return elements.get(0);
  }
}
