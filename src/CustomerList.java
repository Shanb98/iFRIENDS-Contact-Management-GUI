public class CustomerList {
    private Node first;
    public void add(Customer customer){
        Node n1=new Node(customer);
        if(first==null){
            first=n1;
        }else{
            Node lastNode=first;
            while(lastNode.next!=null){
                lastNode=lastNode.next;
            }
            lastNode.next=n1;
        }
    }
    private boolean isValidIndex(int index){
        return index>=0 && index<=size();
    }
    public void add(int index, Customer customer){
        Node n1=new Node(customer);
        if(isValidIndex(index)){
            if(index==0){
                n1.next=first;
                first=n1;
            }else{
                Node temp=first;
                for(int i=0; i<index-1; i++){
                    temp=temp.next;
                }
                n1.next=temp.next;
                temp.next=n1;
            }
        }
    }
    public void set(int index, Customer customer) {
        Node currentNode = first;
        int currentIndex = 0;

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        if (currentNode != null) {
            currentNode.customer = customer;
        }
    }
    public void remove(int index){
        if(isValidIndex(index)){
            if(index==0){
                first=first.next;
            }else{
                Node temp=first;
                for(int i=0; i<index-1; i++){
                    temp=temp.next;
                }
                temp.next=temp.next.next;
            }
        }
    }
    public void remove(Customer customer){
        remove(indexOf(customer));
    }

    public int indexOf(Customer customer){
        Node temp=first;
        int index=-1;
        while(temp!=null){
            index++;
            if(temp.customer.equals(customer)){
                return index;
            }
            temp=temp.next;
        }return -1;
    }
    public Customer[] toArray(){
        Customer[] customerArray=new Customer[size()];
        Node temp=first;
        for(int i=0; temp!=null; i++){
            customerArray[i]=temp.customer;
            temp=temp.next;
        }
        return customerArray;
    }
    public boolean contains(Customer customer){
        return indexOf(customer)!=-1;
    }
    public Customer get(int index){
        if(isValidIndex(index)){
            if(index==0){
                return first.customer;
            }else{
                Node temp=first;
                for(int i=0; i<index; i++){
                    temp=temp.next;
                }
                return temp.customer;
            }
        }return null;
    }
    public void printList(){
        System.out.println(toString());
    }
    public String toString(){
        String list="[";
        Node temp=first;
        while(temp!=null){
            list+=temp.customer+", "; //temp.customer.toString()
            temp=temp.next;
        }
        return isEmpty()? "[empty]":list+"\b\b]";
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        int count=0;
        Node temp=first;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public void sort(int index) {
        int n = size();
        if (n <= 1) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = first;
            Node previous = null;

            for (int i = 0; i < n - 1; i++) {
                Node next = current.next;
                int comparisonResult;
                if (index == 1) {
                    comparisonResult = current.customer.getName().compareTo(next.customer.getName());
                }
                else if (index==2){
                    comparisonResult = current.customer.getSalary().compareTo(next.customer.getSalary());
                }
                else {
                    comparisonResult = current.customer.getBday().compareTo(next.customer.getBday());
                }
                if (comparisonResult > 0) {
                    if (previous == null) {
                        first = next;
                    } else {
                        previous.next = next;
                    }
                    current.next = next.next;
                    next.next = current;
                    previous = next;
                    swapped = true;
                } else {
                    previous = current;
                    current = next;
                }
            }
        } while (swapped);
    }

    public void sortbday() {
        int n = size();
        if (n <= 1) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = first;
            Node previous = null;

            for (int i = 0; i < n - 1; i++) {
                Node next = current.next;
                int comparisonResult = comparisonResult = current.customer.getBday().compareTo(next.customer.getBday());

                if (comparisonResult > 0) {
                    if (previous == null) {
                        first = next;
                    } else {
                        previous.next = next;
                    }
                    current.next = next.next;
                    next.next = current;
                    previous = next;
                    swapped = true;
                } else {
                    previous = current;
                    current = next;
                }
            }
        } while (swapped);
    }

    //------------Inner class----------------
    private class Node{
        private Customer customer;
        private Node next;
        Node(Customer customer){this.customer=customer;}
    }
    //--------------------------------------
}
