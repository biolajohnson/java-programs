import java.util.*;

/* linked list container */
public class NodeLinkedList {
    LinkedListNode head;
    LinkedListNode tail;
    StringBuilder sb;

    /* default constructors */
    public NodeLinkedList() {
        this.head = null;
        this.tail = null;
        this.sb = new StringBuilder();
    }

    /* customed constructors */
    public NodeLinkedList(LinkedListNode item) {
        this.head = item;
        this.tail = this.head;
        this.sb = new StringBuilder();
    }

    /* to push an item to the end of the linkedlist */
    public void pushToTail(LinkedListNode item) {
        if (this.tail == null) {
            this.head = item;
            this.tail = this.head;
        } else {
            this.tail.next = item;
            this.tail = this.tail.next;
        }
    }

    /* to push an item to the beginning of the linkedlist */
    public void pushToHead(LinkedListNode item) {
        if (this.tail == null) {
            item.next = head;
            this.head = item;
            this.tail = head;
        } else {
            item.next = this.head;
            this.head = item;
        }
    }

    /* to remove an item from the end of the list */
    public void popTail() {
        if (this.head == null) {
            return;
        }
        if (this.head == this.tail) {
            this.popHead();
        } else {
            LinkedListNode curr = this.head;
            while (curr.next != this.tail) {
                curr = curr.next;
            }
            curr.next = null;
            this.tail = curr;
        }
    }

    /* to remove an item from the beginning of the list */
    public void popHead() {
        if (this.head == null) {
            return;
        } else if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
    }

    public String toString() {
        sb.setLength(0);
        LinkedListNode curr = this.head;
        if (this.head == null) {
            return "<null>";
        }
        while (curr.next != null) {
            sb.append(curr + "->");
            curr = curr.next;
        }
        sb.append(curr);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your shopping list, what items will you like to add? ");
        Scanner scanner = new Scanner(System.in);
        NodeLinkedList list = new NodeLinkedList();
        while (scanner.hasNext()) {
            String entry = scanner.nextLine();
            String[] tokens = entry.split(" ");
            if (tokens[0].equals("done")) {
                break;
            } else if (tokens.length < 2 && !(tokens[0].equals("popHead") || tokens[0].equals("popTail"))) {
                System.out.println(
                        "Invalid command. Enter one of the following \npushHead <item>\npushTail <item>\npopTail \npopHead");
                continue;
            }
            String cmd = tokens[0];
            String value;
            LinkedListNode item = null;
            if (tokens.length > 1) {
                value = tokens[1];
                item = new LinkedListNode(value);
            }
            switch (cmd) {
                case "pushHead":
                    list.pushToHead(item);
                    System.out.println(list);
                    break;
                case "pushTail":
                    list.pushToTail(item);
                    System.out.println(list);
                    break;
                case "popHead":
                    list.popHead();
                    System.out.println(list);
                    break;
                case "popTail":
                    list.popTail();
                    System.out.println(list);
                    break;
                default:
                    break;
            }

        }
        scanner.close();
    }
}

/* linked list node */
class LinkedListNode {
    String val;
    LinkedListNode next;

    public LinkedListNode(String str) {
        this.val = str;
        this.next = null;
    }

    public String toString() {
        return this.val;
    }
}
