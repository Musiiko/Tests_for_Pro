package homework13;

import java.util.NoSuchElementException;

public class List<T> {
    private Node first = new Node();
    private int size;

    public List() {
    }

    public List(T[] inputArray) {
        initLinkedList(inputArray);
    }

    private void initLinkedList(T[] inputArray) {
        int lengthInputArray = inputArray.length;

        if (lengthInputArray > 0) {
            elementToTheBeginList(inputArray[0]);
            if (lengthInputArray > 1) {
                for (int i = 1; i < inputArray.length; i++) {
                    elementToTheEndList(inputArray[i]);
                }
            }
        }
    }


    @Override
    public String toString() {
        Node givenElement = first.next;
        String result = "[";
        while ((givenElement) != null) {
            result += (givenElement.value);
            if (givenElement.next != null) {
                result += ", ";
            }
            givenElement = givenElement.next;
        }
        result += "]";
        return result;
    }

    public T getValue(int index) {
        return searchIndex(index).getValue();
    }

    private Node searchLastNode() {
        Node givenElement = first.next;
        while (true) {
            if (givenElement.next != null) {
                givenElement = givenElement.next;
            } else {
                return givenElement;
            }
        }
    }

    public void elementToTheEndList(T value) {
        Node node = new Node();

        node.value = value;

        if (this.first.next == null) {
            this.first.next = node;
        } else {
            searchLastNode().next = node;
        }

        size++;
    }

    public void elementToTheBeginList(T value) {
        Node node = new Node();

        node.value = value;
        if (first.next != null) {
            Node tempNOde = first.next;
            first.next = node;
            node.next = tempNOde;
        } else {
            first.next = node;
        }
        size++;
    }

    public void elementByIndex(T value, int index) {
        if (index >= 1) {
            Node node = new Node();
            node.value = value;
            Node tempNode = searchIndex(index - 1);
            node.next = tempNode.next;
            tempNode.next = node;
            size++;
        } else if (index == 0) {
            elementToTheBeginList(value);
        }
    }

    private Node searchIndex(int index) {
        int counter = 0;
        Node givenElement = first.next;

        if (index + 1 >= size) {
            throw new NoSuchElementException("No element"
                    + " index: " + index + " (length of list  " + size + ")");
        } else if (index < 0) {
            throw new NoSuchElementException("Index cannot be negative "
                    + "to reach index " + index);
        } else {
            while (true) {
                if (givenElement.next != null) {
                    if (counter == index) return givenElement;
                    givenElement = givenElement.next;
                    counter++;
                    if (counter == index) return givenElement;
                }
            }
        }
    }

    public void deleteFirstElement() {
        if (first.next == null) {
            System.out.println("List is empty");
        } else {
            first.next = first.next.next;
            size--;
        }
    }

    public void deleteLastElement() {
        if (size > 2) {
            searchIndex(getLength() - 2).next = null;
        } else if (size == 2) {
            searchIndex(0).next = null;
        } else {
            first = new Node();
        }
        size--;
    }

    public void deleteElementByIndex(int index) {
        int lengthOfList = getLength();

        if (index < 0 || index + 1 > lengthOfList) {
            throw new NoSuchElementException("Exception caught! You are delete"
                    + " element with index " + index + " but the size of list is " + size);
        }

        Node node = searchIndex(index - 1);
        node.next = node.next.next;
        size--;
    }

    public void inverseElements(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int currentLength = getLength();
        if ((max > currentLength - 1) || (min < 0) || (max == min)) {
            throw new NoSuchElementException("Wrong input. Size of list is " + size);
        } else {
            Node tempMin = searchIndex(min);
            Node tempMax = searchIndex(max);

            if (max == currentLength - 1) {
                deleteLastElement();
            } else {
                deleteElementByIndex(max);
            }

            if (min == 0) {
                deleteFirstElement();
            } else {
                deleteElementByIndex(min);
            }

            if (min == 0) {
                elementToTheBeginList(tempMax.getValue());
            } else {
                elementByIndex(tempMax.getValue(), min);
            }

            if (max + 1 == currentLength) {
                elementToTheEndList(tempMin.getValue());
            } else {
                elementByIndex(tempMin.getValue(), max);
            }
        }
    }

    public int getLength() {
        return size;
    }

    public boolean isEmptyList() {
        return size == 0;
    }

    private class Node {
        private T value;
        private Node next;

        public T getValue() {
            return value;
        }
    }

}