package br.com.bulvee.ld;

public class LinkedList<T> {
    private Node firstItem = null;
    private Node lastItem = null;

    private int totalItems = 0;

    public void add(T item) {

        Node newNode = new Node(item, null);
        this.lastItem.setNextNode(newNode);
        this.lastItem = newNode;
        this.totalItems++;
    }


    public void addFirst(T item) {
        Node newItem = new Node(item, firstItem);
        this.firstItem = newItem;

        if (this.totalItems == 0) {
            this.lastItem = newItem;
        }

        this.totalItems++;
    }

    public void add(int index, T item) {

        if (index == 0) {
            addFirst(item);
        } else if (index == this.totalItems) {
            add(item);
        } else {
            Node previusNode = this.getNode(index - 1);
            Node newNode = new Node(item, previusNode.getNextNode());
            previusNode.setNextNode(newNode);
            totalItems++;
        }
    }

    public void addLast(T item) {

        if (this.totalItems == 0) {
            this.addFirst(item);
        }

        Node newItem = new Node(item, null);
        this.lastItem.setNextNode(newItem);
        this.lastItem = newItem;

        this.totalItems++;
    }

    public T get(int index){
        return (T) this.getNode(index);
    }


    private Node getNode(int index) {

        if (!isIndexInUse(index)) {
            throw new IllegalArgumentException("This index does not exist.");
        }

        Node current = this.firstItem;

        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }

        return current;
    }


    private boolean isIndexInUse(int index) {
        return index >= 0 && index < totalItems;
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

            current = current.getNextNode();
        }

        builder.append("]");
        return builder.toString();
    }
}
