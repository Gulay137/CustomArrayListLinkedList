package baseSystem;

import java.util.Arrays;

    public class CustomArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;
    private int size;

      public CustomArrayList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

   
       public void add(T element) {
        if (size == data.length) {
            resizeArray();
        }
        data[size++] = element;
    }

    
      public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of the list: " + index);
        }
        return (T) data[index];
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

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

 
         public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

   
    private void resizeArray() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            builder.append(data[i]).append(", ");
        }
        builder.append(data[size - 1]).append("]");
        return builder.toString();
    }
}
