public class Main {
    public static void main(String[] args) {
        // MyLinkedList list = new MyLinkedList(null);
        SearchTree list = new SearchTree(null);

        //String stringData = "Brisbane Darwin Adelaide Melbourne Canberra Curtis Sydney Perth Darwin";
        //String stringData = "15 07 03 11 02 05 09 13 01 04 06 08 10 12 14 22 18 27 17 19 16 20 21 23 30 26 24 25 29 28";
        String stringData = "5 7 3 9 8 2 1 0 4 6";
        String[] data = stringData.split(" ");
        for (String s : data) {
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
        list.removeItem(new Node("5"));
        list.traverse(list.getRoot());
    }
}