package baseSystem;

    public class CustomLinkedList<T> {
    private Node<T> head;
    private int size;
    
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
     }


    public CustomLinkedList() {
        head = null;
        size = 0;
      }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
      }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of the list: " + index);
  }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

        public int size() {
        return size;
    }

      public boolean isEmpty() {
        return size == 0;
    }

        public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of the list: " + index);
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }
    
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Not possible to peek.");
        }
        return head.getData();
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Not possible to poll.");
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }
    }
