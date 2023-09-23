public class ItemType{
private int value;

/**
 * Default constructor. Initializes value to 0.
 */ 
public ItemType(){
    this.value=0;
}
/**
 * Constructor with value
 * @param value Value to initialize
 */
public ItemType(int value){
    this.value=value;
}

public void initialize(int num){
    value=num;
}

public int getValue(){
    return value;
}
/**
 * Compares ItemType with another ItemType
 * Returns value of the instance variable
 * @param item
 * @return -1 if ItemType is less than item,
 * 0 if equal, and 1 if ItemType is greater than
 */
public int compareTo(ItemType item){
    if(value< item.getValue()){
        return -1;//less than
    }
    else if(value>item.getValue()){
        return 1;//greater than
    }
    else{
        return 0;//equal to  
    }
}


public void print(){
    System.out.print(value);
}
} 
