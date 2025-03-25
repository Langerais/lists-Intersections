import java.util.HashSet;


//TODO: Make return type = ListNode[], in case there are multiple intersections;
public class Main {
    public static void main(String[] args) {

        // Test Case 1
        ListNode A1 = new ListNode(3);
        ListNode A2 = new ListNode(7);
        ListNode A3 = new ListNode(8);
        ListNode A4 = new ListNode(10);
        A1.next = A2;
        A2.next = A3;
        A3.next = A4;

        ListNode B1 = new ListNode(99);
        ListNode B2 = new ListNode(1);
        ListNode B3 = new ListNode(8);
        ListNode B4 = new ListNode(26);
        B1.next = B2;
        B2.next = B3;
        B3.next = B4; // Intersection at node with value 8

        // Test Case 2
        ListNode C1 = new ListNode(1);
        ListNode C2 = new ListNode(3);
        ListNode C3 = new ListNode(5);
        ListNode C4 = new ListNode(7);
        ListNode C5 = new ListNode(9);
        C1.next = C2;
        C2.next = C3;
        C3.next = C4;
        C4.next = C5;

        ListNode D1 = new ListNode(2);
        ListNode D2 = new ListNode(4);
        ListNode D3 = new ListNode(6);
        D1.next = D2;
        D2.next = D3;
        D3.next = C4; // Intersection at node with value 7

        // Test Case 3
        ListNode E1 = new ListNode(10);
        ListNode E2 = new ListNode(20);
        ListNode E3 = new ListNode(30);
        ListNode E4 = new ListNode(40);
        E1.next = E2;
        E2.next = E3;
        E3.next = E4;

        ListNode F1 = new ListNode(100);
        F1.next = E3; // Intersection at node with value 30

        // Test Case 4
        ListNode G1 = new ListNode(5);
        ListNode G2 = new ListNode(10);
        ListNode G3 = new ListNode(15);
        ListNode G4 = new ListNode(20);
        ListNode G5 = new ListNode(25);
        G1.next = G2;
        G2.next = G3;
        G3.next = G4;
        G4.next = G5;

        ListNode H1 = new ListNode(100);
        ListNode H2 = new ListNode(200);
        H1.next = H2;
        H2.next = G3; // Intersection at node with value 15

        // Test Case 5
        ListNode I1 = new ListNode(1);
        ListNode I2 = new ListNode(2);
        ListNode I3 = new ListNode(3);
        ListNode I4 = new ListNode(4);
        ListNode I5 = new ListNode(5);
        I1.next = I2;
        I2.next = I3;
        I3.next = I4;
        I4.next = I5;

        ListNode J1 = new ListNode(9);
        ListNode J2 = new ListNode(10);
        J1.next = J2;
        J2.next = I3; // Intersection at node with value 3

        //printList(A1, B1); // Intersection at node 8
        //printList(C1, D1); // Intersection at node 7
        //printList(E1, F1); // Intersection at node 30
        //printList(G1, H1); // Intersection at node 15
        //printList(I1, J1); // Intersection at node 3

        ListNode answerNode = findIntersectionHashSet(A1, B1);

        if (answerNode == null) {
            System.out.println("No Intersections found!");
        } else {
            System.out.println("Intersection is: " + answerNode.value);
        }

    }

    public static ListNode findIntersectionHashSet(ListNode head1, ListNode head2){

        printList(head1, head2);

        ListNode node1 = head1;
        HashSet<Integer> uniqueNodes = new HashSet<Integer>();
        while (node1 != null){
            uniqueNodes.add(node1.value);
            node1 = node1.next;
        }

        ListNode node2 = head2;
        while (node2 != null){
            if(uniqueNodes.contains(node2.value)) { return node2; }
            node2 = node2.next;
        }

        return null;
    }

    public static ListNode findIntersectionsDoublePointer(ListNode head1, ListNode head2){
        printList(head1, head2);
        ListNode node1 = head1;
        ListNode node2 = head2;

        // Traverse both lists
        while (node1 != node2) {
            // Move pointerA to the head of listB once it reaches the end of listA
            node1 = (node1 == null) ? head2 : node1.next;
            // Move pointerB to the head of listA once it reaches the end of listB
            node2 = (node2 == null) ? head1 : node2.next;
        }

        return node1;
    }

    // Utility function to print the lists
    public static void printList(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        System.out.println("List 1:");
        while (temp1 != null) {
            System.out.print(temp1.value + " -> ");
            temp1 = temp1.next;
        }
        System.out.println("null");

        System.out.println("List 2:");
        while (temp2 != null) {
            System.out.print(temp2.value + " -> ");
            temp2 = temp2.next;
        }
        System.out.println("null");
        System.out.println();
    }

}