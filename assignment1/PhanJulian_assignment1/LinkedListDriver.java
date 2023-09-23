import java.util.Scanner;
import java.io.*;
public class LinkedListDriver {
  private SortedLinkedList list;
  
  public static void main (String[] args) throws IOException {
  SortedLinkedList list = new SortedLinkedList();
    //no file
    if(args.length!=1){
        System.out.println("No input file");
        return;
    }
   int num=0;
   try {
    Scanner scanner = new Scanner(new File(args[0])); //open file
            while(scanner.hasNextInt()) {//add each # to list individually then convert to int 
                num = scanner.nextInt();
                ItemType item = new ItemType(num);
                //System.out.println(num);
                //System.out.println(item.getValue());
                list.insertItem(item);//check on this

            }
   }
   catch(FileNotFoundException e){
    System.out.println("Unable to open file");//file doesn't exist
        return;
   }
    //Menu
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(n) - Print next iterator value");
        System.out.println("(r) - Reset iterator");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find intersection");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");

        Scanner keyboard = new Scanner(System.in);
        while(true){
            System.out.print("\nEnter a command: ");
            String user = keyboard.next();

            switch(user){
                case "q":
                System.out.print("Exiting the program...");
                    System.exit(0);
                    break;
                case "i":
                    System.out.print("Enter a number to insert: ");
                    int insertNum = keyboard.nextInt();
                    System.out.print("\nOriginal list: ");
                   list.printList();
                    list.insertItem(new ItemType(insertNum));
                    System.out.print("\nNew list: ");
                   list.printList();
                    break;
                case "d":
                    System.out.print("Enter a number to delete: ");
                    int deleteNum = keyboard.nextInt();
                    System.out.print("Original list: ");
                    list.printList();
                    list.deleteItem(new ItemType(deleteNum));
                    System.out.print("\nNew list: ");
                    list.printList();
                    break;
                case "s":
                    if (list.getLength() == 0) {
                        System.out.print("The list is empty. Cannot search.");
                    }
                    else {
                        System.out.print("Enter a number to search: ");
                        int searchNum = keyboard.nextInt();
                        list.searchItem(new ItemType(searchNum));
                    }
                break;
                case "m":
                    System.out.print("Enter the length of the new list: ");
                    int length = keyboard.nextInt();
                    SortedLinkedList list2 = new SortedLinkedList();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < length; i++) {
                        int enterNum = keyboard.nextInt();
                        ItemType tempItem = new ItemType(enterNum);
                        list2.insertItem(tempItem);
                    }
                    System.out.print("The list 1: ");
                    list.printList();
                    System.out.print("\nThe list 2: ");
                    list2.printList();
                    SortedLinkedList mergedList = list.mergeList(list2);
                    System.out.print("\nMerge List: ");
                   mergedList.printList();
                    break;
                case "t":
                    System.out.print("Enter the length of the new list: ");
                    length = keyboard.nextInt();
                    System.out.print("Enter the numbers: ");
                    SortedLinkedList list3 = new SortedLinkedList();
                    for (int i = 0; i < length; i++) {
                        int enterNum = keyboard.nextInt();
                        ItemType tempItem = new ItemType(enterNum);
                        list3.insertItem(tempItem);
                    }
                    System.out.print("The list 1: ");
                   list.printList();
                    System.out.print("\nThe list 2: ");
                    list3.printList();
                   SortedLinkedList intersection = list.intersection(list3);
                    System.out.print("\nIntersection of lists: ");
                   intersection.printList();
                    break;
                case "a":
                    System.out.print("Original list: ");
                   list.printList();
                    System.out.print("\nModified list: ");
                   list.deleteAlternateNode(list);
                   list.printList();
                    break;
                case "n":
                    ItemType nextItem = list.getNextItem();
                    if (nextItem != null) {
                        System.out.print("\nNext iterator value: " + nextItem.getValue());
                    }
                    break;
                case "r":
                    list.resetList();
                    break;
                case "p":
                    if (list.getLength() == 0) {
                        System.out.print("The list is empty");
                    } 
                    else {
                        System.out.print("The list is: ");
                        list.printList();
                    }
                    break;
                case "l":
                    System.out.print("The length of the list is: " + list.getLength());
                    break;
                default:
                    System.out.print("Invalid command, try again!");
                    break;
            }
            
        }
        
}
}
