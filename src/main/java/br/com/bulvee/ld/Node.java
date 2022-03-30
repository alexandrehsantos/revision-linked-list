package br.com.bulvee.ld;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Node {

    private Object item;
    private Node nextItem;

    public Node getNextItem() {
        return nextItem;
    }

    public void setNextItem(Node nextItem) {
        this.nextItem = nextItem;
    }

    public Object getItem() {
        return item;
    }
}
