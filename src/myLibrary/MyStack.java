package myLibrary;
import java.util.NoSuchElementException;
import java.util.EmptyStackException;
public class MyStack<T> {
    private static class StackNode<T> {
        private T data;

        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    private StackNode<T> top;

    private void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    private T pop(){
        if (top == null) throw new NoSuchElementException();
        T data = top.getData();

        top = top.next;

        return data;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
