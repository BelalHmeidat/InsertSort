public class DoubleLinkedList {
    private DoubleNode first;
    private DoubleNode last;
    private int size;

    public DoubleLinkedList() {
        first = last = null;
        size = 0;
    }

    public DoubleNode getFirst(){
        if (size <= 0){
            return null;
        }
        return first;
    }

    public DoubleNode getLast(){
        if (size <= 0){
            return null;
        }
        return last;

    }

    public int getSize(){
        return this.size;
    }

    public void addFirst(Object element){
        if (size == 0){
            this.first = this.last = new DoubleNode(element);
            this.size = 1;
            return;
        }
        DoubleNode node = new DoubleNode(element);
        node.next = this.first;
        //node.prev is already null;
        this.size++;
        this.first = node;
        return;
    }

    public void addLast (Object elemnet){
//        if (this.size < 0){
//            System.out.println("NO");
//            return;
//        }
//        LnNode node = new LnNode(elemnet);
        if (this.size == 0){
            this.first = this.last = new DoubleNode(elemnet);
            this.size = 1;
            return;
        }
        if (size == 1){
            DoubleNode node = new DoubleNode(elemnet);
            this.last = node;
            this.first.next = this.last;
            this.last.prev = this.first;
            this.size++;
            return;
        }
        // LnNode current = this.first;
        // for (int i = 0; i < size; i++){
        //     current = current.next;
        // }
        // current = node;
        // this.last = current;

        DoubleNode newNode = new DoubleNode(elemnet);
        newNode.prev = this.last;
//        newNode.next is already null;
        this.last.next = newNode;
        this.last = newNode;
        this.size++;
        return;

    }
    public boolean removeFirst(){
        if (size <= 0){
            System.out.println("NO");
            return false;
        }
        if (size == 1) {
            last = first = null;
            size = 0;
            return true;
//            System.out.println(first);
//            System.out.println(last);
        }
        if (size == 2){
            first = last;
            first.next = null;
            last.prev = null;
            size--;
            return true;
        }
//        first.next.prev = null;
        first = first.next;
        first.prev = null;
        size--;
        return true;
    }

    public boolean removeLast(){
        if (size <= 0 ){
            System.out.println("NO");
            return false;

        }
        last.prev.next = null;
        DoubleNode nwNode = last.prev;
        last.prev = null;
        last = nwNode;
        if (size == 1){
//            first = last = null;
            System.out.println(first);
            System.out.println(last);
        }
        size--;
        return true;
    }
    //Not used
    public void add (Object element, int index){
        if (size <= 0 || index >= size || index < 0){
            System.out.println("NO");
            return;
        }
        if (index == 0){
            addFirst(element);
            return;
        }
        if (index == size - 1){
            addLast(element);
            return;
        }
        DoubleNode current = new DoubleNode();
        current = first;
        for (int i =0; i != index; i++){
            current = current.next;
        }
        DoubleNode newNode = new DoubleNode();
        newNode.prev = current;
        current.next = newNode;
        newNode.data = element;
        size++;
        return;

    }
    //Not used
    public void remove (int index){
        if (size <= 0 || index >= size || index < 0){
            System.out.println("NO");
            return;
        }
        if (index == 0){
            removeFirst();
            return;
        }
        if (index == size - 1){
            removeLast();
            return;
        }
        DoubleNode current = new DoubleNode();
        current = first;
        for (int i = 0; i != index; i ++){
            current = current.next;
        }
        DoubleNode removedNode = current.next;
        current.next = removedNode.next;
        removedNode.next.prev = current;
        removedNode.next = null;
        removedNode.prev = null;
        size--;
        return;

    }
    public static DoubleLinkedList appendList(DoubleLinkedList list, DoubleLinkedList list2){

        list.last.next = list2.first;
        list2.first.prev = list.last;
        list.last = list2.last;
        list.size += list2.size;
        return list;
     }

    //  public void insertSort (){
    //     // LnList tmp = new LnList();
    //     // tmp = this.copy();
    //     LnNode current = this.getFirst();
    //     LnNode next = this.getFirst().next;

    //     for (int i = 1; i < this.size; i++){
    //         int key = array[i];
    //         int j = i - 1;
    //         while (j >= 0 && array[j] > key){
    //             array[j + 1] = array[j];
    //             j--;
    //         }
    //         array[j + 1] = key;
            

            
    //     }

    // }
    private static void swap(Object value1, Object value2) {
        Object temp = value1;
        value1 = value2;
        value2 = temp;
    }

     public DoubleLinkedList copy(){
        DoubleLinkedList copy = new DoubleLinkedList();
        DoubleNode current = first;
        for (int i = 0; i < this.size; i++){
            copy.addLast(current.data);
            current = current.next;
        }
        return copy;
    }

    public void print(){
        DoubleNode current = first;
        for (int i = 0; i < size; i++){
            System.out.println(current.data);
            current = current.next;
        }
    }
}