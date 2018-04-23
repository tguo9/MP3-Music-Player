public class Node {
		
	private MP3File data;
	private Node next;

	public Node(MP3File data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node(MP3File data) {
		this(data, null);
	}

	public MP3File getData() {
		return this.data;
	}

	public void setData(MP3File data) {
		this.data = data;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}