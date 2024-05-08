package LinkedLists;

public class LinkedLists {
   Node head;
   LinkedLists(){
       head=null;
   }
   class Node{
       int data;
       Node next;
       Node(int data){
           this.data=data;
           this.next=null;
       }
   }

    void add(int data){
       Node newNode = new Node(data);

       if(head==null){
           head=newNode;
           return;
       }
       Node temp=head;
       while(temp.next!=null){
           temp=temp.next;
       }
       temp.next=newNode;


   }
    void rev(){
       Node prev=null;
       Node curr=head;
       Node next;
       while(curr!=null){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
       }
       head=prev;


   }
   private int len(Node curr,int len){
        if(curr==null){
            return len;
        }
        return len(curr.next,++len);
   }

   public int len(){
       return len(head,0);
   }


    void getMid(){
       Node tempSlow=head;
       Node tempFast=head;
       System.out.println();
       while(tempFast!=null && tempFast.next!=null){
           tempFast=tempFast.next.next;
           tempSlow=tempSlow.next;

       }
       System.out.println(tempSlow.data);
   }

   void delete(int data){
       Node temp=head;
       while(temp.next.data!=data){
           temp=temp.next;

       }
       temp.next=temp.next.next;

   }


    void print(){
       Node temp=head;
       System.out.println();
       while(temp!=null){
           System.out.print(temp.data+" ");
           temp=temp.next;
       }

   }

    public static void main(String[] args) {
        LinkedLists ll = new LinkedLists();
        LinkedLists ll2 = new LinkedLists();




        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.print();
//        ll.delete(4);
//        ll.print();
//        ll.rev();
//        ll.print();
//        ll.getMid();
        ll2.add(10);
        ll2.add(20);
        ll2.add(30);
        ll2.add(40);
        ll2.add(50);
        ll2.add(60);
        ll2.print();

        System.out.println(ll.len());

    }
}
