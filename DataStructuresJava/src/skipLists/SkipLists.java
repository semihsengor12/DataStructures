package skipLists;
import java.util.Random;

public class SkipLists {
	
	private SkipListNode head; // top-left dummy head
	    private int maxLevel;
	    private double p;
	    private Random rand;

	    
	public SkipLists(int maxlevel, double p) {
		this.maxLevel = maxlevel;
        this.p = p;
        this.rand = new Random();
        head = new SkipListNode(-1);
        SkipListNode current = head;
        for (int i = 1; i < maxLevel; i++) {
            SkipListNode newLevelHead = new SkipListNode(-1);
            newLevelHead.bottom = current;
            current.top = newLevelHead;
            current = newLevelHead;
        }
        head = current;
	}    
	private int randomLevel() {
        int lvl = 1;
        while (lvl < maxLevel && rand.nextDouble() < p) {
            lvl++;
        }
        return lvl;
    }
	
	
	public void insert(int value) {
        SkipListNode[] update = new SkipListNode[maxLevel];
        SkipListNode current = head;

        // Find positions at each level
        for (int i = maxLevel - 1; i >= 0; i--) {
            while (current.next != null && current.next.value < value) {
                current = current.next;
            }
            update[i] = current;
            if (current.bottom != null) current = current.bottom;
        }

        int newLevel = randomLevel();
        SkipListNode below = null;

        for (int i = 0; i < newLevel; i++) {
            SkipListNode newNode = new SkipListNode(value);

            // horizontal links
            newNode.next = update[i].next;
            if (update[i].next != null) update[i].next.prev = newNode;
            update[i].next = newNode;
            newNode.prev = update[i];

            // vertical links
            newNode.bottom = below;
            if (below != null) below.top = newNode;

            below = newNode;
        }
    }
	public boolean search(int value) {
        SkipListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.value <= value) {
                current = current.next;
            }
            if (current.value == value) return true;
            current = current.bottom;
        }
        return false;
    }
	
	public void delete(int value) {
        SkipListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.value < value) {
                current = current.next;
            }
            if (current.next != null && current.next.value == value) {
                SkipListNode toDelete = current.next;
                current.next = toDelete.next;
                if (toDelete.next != null) toDelete.next.prev = current;
            }
            current = current.bottom;
        }
    }

	public int searchClosest(int value) {
	    SkipListNode current = head;

	    while (current != null) {
	        while (current.next != null && current.next.value <= value) {
	            current = current.next;
	        }
	        if (current.value == value) {
	            return current.value; // tam eşleşme
	        }
	        current = current.bottom; // alt seviyeye in
	    }


	    SkipListNode bottomNode = head;
	    while (bottomNode.bottom != null) bottomNode = bottomNode.bottom; // en alt head
	    while (bottomNode.next != null && bottomNode.next.value <= value) {
	        bottomNode = bottomNode.next; // en yakın node
	    }

	    return bottomNode.value;
	}
	public void printBottomLevel() {
        SkipListNode current = head;
        while (current.bottom != null) current = current.bottom;
        current = current.next; // skip dummy head
        System.out.print("Bottom level: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
	    
	    
	    
	    
}
