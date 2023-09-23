/**
 * SortedLinkedList represents a sorted singly-linked list
 * that does not allow duplicate elements
 * Elements are sorted in ascending order
 */
public class SortedLinkedList {
    private int length;
    private NodeType head;
    private NodeType currentPos;
    /**
    * Initialize a sorted linked list object
    */
    public SortedLinkedList(){
        length=0;
        head=null;
        currentPos=null;
    }
    /**
     * Return length of linked list (number of nodes). 
     * @return Length of linked list
     */
    public int getLength(){
	int length=0;
        NodeType current =head;
        //get number of nodes in list 
        while (current != null){
            length++;
            current=current.getNext();
        }
        return length;
    }
    /**
     * Insert item into list
     * @param item Item to be inserted
     */
    public void insertItem(ItemType item){
        NodeType newNode= new NodeType(item);
        //Inserting first element
        if(head ==null){
            this.head=newNode;
            return;
        }
        //Inserting at the Beginning
        if(item.compareTo(head.getInfo())<0){
            newNode.setNext(head);
            head=newNode;
            return;
        }
        NodeType current=head;
        NodeType prev=null;

        while(current !=null && item.compareTo(current.getInfo())>= 0){
            prev=current;
            current=current.getNext();
        }
        if(item.compareTo(prev.getInfo())==0){
            System.out.print("\nItem already exists");
            return;
        }
        prev.setNext(newNode);
        newNode.setNext(current);
      }
    /**
     * Deletes element from sorted linked list if it contains an item
     * equal to item parameter
     * @param item item to be deleted
     */
    public void deleteItem(ItemType item){
        NodeType current= head;
        NodeType prev=null;
        //deleting from an empty list
        if(current==null){
         System.out.print("\nYou cannot delete from an empty list");
         return;  
        }
        while(current !=null&& item.compareTo(current.getInfo())!=0){
            prev=current;
            current=current.getNext();
        }
        if(current !=null){
            //Deleting first element 
            if(prev==null){
                head=current.getNext();
                length--;
            }
            else{
                prev.setNext(current.getNext());
                length--;
            }
        }
            //Attempt to delete non existing item
            else{
                System.out.print("\nThe item is not present in the list.");
            }
        }
    /**
     * Searches linked list for item equal to parameter item 
     * @param item Item to be searched for 
     * @return index Index of item or -1 if not found 
     */
    public int searchItem(ItemType item){
        int index=1;
        NodeType current=head;
        while(current!=null&&item.compareTo(current.getInfo()) !=0){
          current=current.getNext();
          index++; 
        }
        if(current==null){
            System.out.print("Item not found in the list.");
            return -1;
        }
        else{
            System.out.print("Item found at index "+index);
            return index;
        }

    }
    /**
     * @return next item on list, or null if list is empty or the end 
     * has been reached
     */
    public ItemType getNextItem(){
        if(head ==null){
            System.out.println("The list is empty");
            currentPos=null;
            return null;
        }
        else{
            if(currentPos==null){
                currentPos=head;
            }
            else if(currentPos.getNext()==null){
                System.out.print("\nThe end of the list has been reached.");
                currentPos=head;//Reset to beginning
            }
            else{
                currentPos = currentPos.getNext();
            }
            return currentPos.getInfo();
        }
    }
    /**
     * Merge two sorted lists into a single sorted list
     * @param list Sorted linked list that will be merged
     * @return A single sorted linked list containing elements from both lists
     */
    public SortedLinkedList mergeList(SortedLinkedList list){
        SortedLinkedList mergedList=new SortedLinkedList();
        NodeType current1=this.head;
        NodeType current2= list.head;
        //Compare elements from both lists
        while(current1!=null&& current2 !=null){
            if(current1.getInfo().compareTo(current2.getInfo())<=0){
                mergedList.insertItem(current1.getInfo());
                current1=current1.getNext();
            }
            else{
                mergedList.insertItem(current2.getInfo());
                current2=current2.getNext();
            }
            //Add rest of elements from first list
            while(current1!=null){
                mergedList.insertItem(current1.getInfo());
                current1=current1.getNext();
            }
            //Add rest of elements from second list
            while(current2!=null){
                mergedList.insertItem(current2.getInfo());
                current2=current2.getNext();
            }
        }
        return mergedList;
    }/**
      *Deletes alternate nodes and Modifies original list
      */
    public void deleteAlternateNode(SortedLinkedList list){
        if(head==null || head.getNext()==null){
            return;
        }
        NodeType current=head;
        NodeType prev=null;
        int count=0;
        while(current!=null){//iterate over list
            if(count%2==1){//if count is odd
                prev.setNext(current.getNext());
                length--;
            }
            else{//if count is even move pointer to current node
                prev=current;
            }
	    //move to next node and imcrmement count
            current=current.getNext();
            count++;
        }//loop processes each node once so time complexity is O(N)
    }
    public SortedLinkedList intersection(SortedLinkedList list){
        SortedLinkedList intersectionList = new SortedLinkedList();
        NodeType node1 = this.head;
        NodeType node2 = list.head;

    while (node1 != null && node2 != null) {
        if (node1.getInfo().compareTo(node2.getInfo()) == 0) {
            intersectionList.insertItem(node1.getInfo());
            node1 = node1.getNext();
            node2 = node2.getNext();
        } else if (node1.getInfo().compareTo(node2.getInfo()) < 0) {
            node1 = node1.getNext();
        } else {
            node2 = node2.getNext();
        }
    }//O(n+m) where n and m are lengths of the two lists

    return intersectionList;
    }
    /**
     * Initialize current position to null
     */
    public void resetList(){
        currentPos=null;
        System.out.print("Iterator is reset.");
    }
    /**
     * Prints list its contents
     */
    public void printList(){
        NodeType temp=head;
        while(temp!=null){
            System.out.print(temp.getInfo().getValue()+" ");
            temp=temp.getNext();
        }
    }

}
