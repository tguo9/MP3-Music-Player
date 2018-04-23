public class MP3LinkedList {
	
	private Node head;
	private Node tail;
	private int count;

	public MP3LinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	public Node add(MP3File mp3) {

        if (head == null) {
            Node cur = new Node(mp3);
            head = cur;
            count++;
            return head;
        }
    	
    	Node temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        Node newNode = new Node(mp3);
        temp.setNext(newNode);
        newNode.setNext(null);
        count++;
        return head;
    }

	public int find(MP3File target) {

		Node cur = head;

		int index = 0;

		while(cur != null) { 

			if(cur.getData().getTitle().compareTo(target.getTitle()) > 0) {
				index++;
			}

			cur = cur.getNext();
		}

		return index;
	}

	public void set(MP3File data, int index) {

		Node current = head;
		int countIndex = 0;

		while(countIndex < index && current != null) {
			countIndex++;
			current = current.getNext();
		}

		if(countIndex == index && current != null) {
			current.setData(data);
		}
	}

	public String toString() {

		String result = "";

		Node current = head;

		while(current != null) {
			result += current.getData() + " \n";
			current = current.getNext();

		}
		return result;
	}
}