public class LinkedLists {
    Node head;
    public int size;
    public LinkedLists(){
        head = null;
        size = 0;
    }
    // append
    public void append(int data){
        Node newNode = new Node(data, null);
        if(head == null){
            head = newNode;
        } else {
            Node lastNode = head;
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
    }
    // removeFront
    public int removeFront(){
        int data = head.data;
        if(head == null){
            System.out.println("List is empty");
            return -1;
        } else {
            head = head.next;
        }
        return data;
    }
    // display
    public void display(){
        if (head != null){
            Node currentNode = head.next;
            while(currentNode != null){
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }
    // search
    public int search(int x){
        Node currentNode = head;
        while(currentNode != null){
            if (currentNode.data == x){
                return currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }
    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();
        list.append(1);
        list.append(3);
        list.append(4);
        list.append(7);
        System.out.println(list.removeFront());
        list.display();
        // System.out.println(list.search(7));
    }
}


