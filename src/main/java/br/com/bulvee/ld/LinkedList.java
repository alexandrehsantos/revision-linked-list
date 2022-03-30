package br.com.bulvee.ld;

public class LinkedList<T> {
    private Node firstItem = null;
    private Node lastItem = null;

    private int totalItems = 0;

    public void addFirst(T item) {
        Node newItem = new Node(item, firstItem);
        this.firstItem = newItem;

        if (this.totalItems == 0) {
            this.lastItem = newItem;
        }

        this.totalItems++;
    }

    public void add(int index, T item) {

    }

    public void addLast(T item) {

        if (this.totalItems == 0) {
            this.addFirst(item);
        }

        Node newItem = new Node(item, null);
        this.lastItem.setNextItem(newItem);
        this.lastItem = newItem;

        this.totalItems++;
    }

    public T get(int index) {

        Node current = this.firstItem;

        for(int i = 0; i < index; i++){
            current = current.getNextItem();
        }

        return (T)current.getItem();
    }

    public void remove(int index) {

    }

    public int size() {
        return totalItems;
    }

    public boolean contains(Object item) {
        return false;
    }

    @Override
    public String toString() {
        if (this.totalItems == 0) {
            return "[]";
        }

        Node current = firstItem;
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalItems; i++) {
            builder.append(current.getItem());
            builder.append(",");

            current = current.getNextItem();
        }

        builder.append("]");
        return builder.toString();
    }
}
