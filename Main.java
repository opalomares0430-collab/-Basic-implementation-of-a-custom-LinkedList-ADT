package module6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CustomLinkedList linkedList = new CustomLinkedList();

        try {

            File file = new File("numbers.txt");
            Scanner input = new Scanner(file);

            while (input.hasNextInt()) {
                linkedList.insert(input.nextInt());
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        System.out.println("Original List:");

        Iterator<Integer> iterator = linkedList.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        linkedList.delete(30);

        System.out.println("\nAfter deleting 30:");

        iterator = linkedList.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
