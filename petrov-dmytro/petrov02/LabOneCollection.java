package ua.lpnuai.oop.petrov02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class LabOneCollection implements Iterable<Object>, Serializable {

    private static final long serialVersionUID = 1L;
    private int COLLECTION_SIZE = 1;
    public String[] container = new String[COLLECTION_SIZE];
    private int currentSize = 0;

    private void resize(){
        if( container.length == currentSize){
            String[] arrayResize = new String[container.length *2];
            System.arraycopy(container, 0, arrayResize, 0, container.length);
            container = arrayResize;
        }



        if (container.length > currentSize){
            String[] arrayResize = new String[currentSize];
            System.arraycopy(container, 0, arrayResize, 0, currentSize);
            container = arrayResize;
        }
    }

    //    private void subtractSize(){
//        String[] arrayResize = new String[currentSize -1];
//        System.arraycopy(container, 0, arrayResize, 0, currentSize);
//        container = arrayResize;
//    }
    private void addSize(){
        String[] arrayResize = new String[currentSize +1];
        System.arraycopy(container, 0, arrayResize, 0, currentSize);
        container = arrayResize;
    }

    @Override
    public Iterator<Object> iterator() {
        return new LabOneIterator();
    }

    public String toString(){
        String wholeString = "{";

        for (int i = 0; i < currentSize; i++)
        {
            if ( i +1 == currentSize)
                wholeString += "[" +container[i] +"]";
            else
                wholeString += "[" +container[i] +"], ";
        }

        wholeString += "}";
        return wholeString;
    }

    public void add(String string){
        addSize();
        container[currentSize] = string;
        currentSize++;
        resize();
    }

    public void clear(){
//        container = null;
        String[] clearContainer = new String[COLLECTION_SIZE];
        container = clearContainer;
        currentSize = 0;
    }

    public boolean remove (String string){
        for (int i = 0; i < container.length; i++) {

            if (container[i].equals( string)) {

                for (int j = i; j < container.length - 1; j++) {
                    container[j] = container[j + 1];
                }

                container[currentSize - 1] = null;
                currentSize--;
                resize();
                return true;
            }
        }
        return false;
    }

    public Object[] toArray(){
        Object[] array = new Object[container.length];

        System.arraycopy(container, 0, array, 0, container.length);

        return array;
    }

    public int size(){
        return container.length;
    }

    public boolean contains( String string){

        for (int i = 0; i < currentSize; i++) {
            if ( container[i].equals(string))
                return true;
        }

        return false;
    }
    /*
                Code Test CHANGE THIS BEFORE SUBMIT
     */
    public boolean containsAll(LabOneCollection container){
        if (currentSize >= container.size())
        for (int i = 0; i < container.size(); i++) {
            for (int j = 0; j < currentSize; j++) {
                if (container.container[i].equals(this.container[j]))
                    break;
                if (j +1 == currentSize)
                    return false;
            }

        }
        else
            return false;

        return true;
    }
/*
            END
 */



    public void save(){
        try {
//            File collector = new File("/src/collector.txt");
//            Files.write(Paths.get("collector.txt"), this.container, StandardOpenOption.CREATE);
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\PC\\Dropbox\\Семестр 2\\OOP\\Java\\petrov-dmytro\\src\\ua\\lpnuai\\oop\\petrov02\\src\\save.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(this);
            outputStream.flush();
            outputStream.close();
            fileOutputStream.close();

            System.out.println("Collection was saved to /");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\PC\\Dropbox\\Семестр 2\\OOP\\Java\\petrov-dmytro\\src\\ua\\lpnuai\\oop\\petrov02\\src\\save.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            LabOneCollection collection = (LabOneCollection) objectInputStream.readObject();
            objectInputStream.close();
            this.container = collection.container;
            this.currentSize = collection.currentSize;
            this.resize();

            System.out.println();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    class LabOneIterator implements Iterator<Object>{

        private int current;

        public LabOneIterator(){
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < container.length;
        }

        @Override
        public String next() {
            if (this.hasNext())
                return container[current++];

            return null;
        }

        @Override
        public void remove() {
            current = 0;
        }
    }


}