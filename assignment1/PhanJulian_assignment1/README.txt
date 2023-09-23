Name: Julian Phan
UGA email: jnp71386@uga.edu
##Compilation

to compile:
$ javac *.java -d bin

to run: 
$ java -cp bin LinkedListDriver input.txt 

mergeList:
-Initialize empty merged list
-initialize xurrent1 to head of list1
-initalize current2 to head of list2
-While loop compares elements from both lists that runs until current1 
and current 2 elements are inserted into mergelist
-Two while loops check if current1 and current2 are not null, thet are added to the mergedList.
-The mergeList is returned
complexity: O(N+M), where N and M are lengths of two lists.

intersect:
-Intialize empty intersection list
-initalize node1 as head of list1
-Initalize node2 as head of list2
-A while loop traverses through borth lists while both lists are not null(There are elements in both)
-if node1 and node2 are equal, (compareTo returns 0), element was found in both lists and will
be inserted into intersectionList.
-If node1 is less than value in node2, node1 advances to next element in list1.
-Else, node2 pointer advances to next element in list2
Complexity: O(N^2)
