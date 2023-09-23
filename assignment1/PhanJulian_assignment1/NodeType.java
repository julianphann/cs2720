/**
 * NodeType class illustrates a node in a singly-linked list
 * Each node contains an info field to store data
 * and next field to reference next node in linked list
 */
public class NodeType {
    /**
     * Data stored in node
     */
    public ItemType info;
    /**
     * Reference to next node in linked list
     */
    public NodeType next;
    public NodeType(ItemType info){
        this.info=info;
        this.next=null;
    }
    /**
     * Gets data stored in node
     * @return Data stored in node
     */
    public ItemType getInfo(){
        return info;
    }
    /**
     * Gets reference to the next node in linked list
     * @return A reference to the next node 
     */
    public NodeType getNext(){
        return next;
        }

    /**
     * Sets data stored in node
     * @param info the data to be stored in node
     */
    public void setInfo(ItemType info){
        this.info=info;
    }
    /**
     * Sets reference to the next node in linked list
     * @param next A reference to next node
     */
    public void setNext(NodeType next){
        this.next=next;
    }
    
}
