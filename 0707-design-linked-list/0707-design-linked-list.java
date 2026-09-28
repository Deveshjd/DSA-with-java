class MyLinkedList {

    private static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    Node head = null;
    Node tail = null;
    int current_size = 0;

    public MyLinkedList() {

    }
    
    public int get(int index) {
        if(index<0 || index >= current_size) return -1;

        Node temp = head;
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        if(current_size == 0){
            tail = head;
        }
        current_size += 1;
    }
    
    public void addAtTail(int val) {
        if(current_size == 0) addAtHead(val);
        else{
            tail.next = new Node(val);
            tail = tail.next;
            current_size += 1;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > current_size) return;
        else if(index == 0) addAtHead(val);
        else if(index == current_size) addAtTail(val);
        else{
            Node newNode = new Node(val);
            Node temp = head;
            for(int i = 0; i<index-1; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            current_size += 1;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= current_size)
            return;
        else if(current_size == 1){
            head = null;
            tail = null;
        }
        else if(index == 0){
            head = head.next;
            if(head == null) tail = null;
        }
        else{
            Node temp = head;
            for(int i = 0; i<index-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(index == current_size-1) tail = temp;
        }
        current_size -= 1;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */