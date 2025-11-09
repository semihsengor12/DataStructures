package treeDataStructure;
import tries.*;
import skipLists.*;
public class Main {

	public static void main(String[] args) {
		
	        SkipLists sl = new SkipLists(4, 0.5);
	        sl.insert(10);
	        sl.insert(20);
	        sl.insert(30);
	        sl.insert(15);
	        sl.insert(25);

	        sl.printBottomLevel(); // Bottom level: 10 15 20 25 30
	        System.out.println(sl.search(15)); // true
	        System.out.println(sl.search(100)); // false

	        sl.delete(20);
	        sl.printBottomLevel();
	}

}
