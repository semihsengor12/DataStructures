package skipLists;

public class SkipListNode {
	int value;
	SkipListNode next, prev, top, bottom;
	public SkipListNode(int value) {
		next = prev  = top =  bottom = null;
		this.value = value;
	}
}
