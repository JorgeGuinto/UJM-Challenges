public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem item) {
        this.root = item;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    public boolean addItem (ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0){
                 if (currentItem.next() != null){
                     currentItem = currentItem.next();
                 } else {
                     currentItem.setNext(newItem).setPrevious(currentItem);
                     return true;
                 }
            } else if (comparison > 0){
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    public boolean removeItem (ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if (comparison == 0){
                //Founded
                if (currentItem == this.root){
                    //Root
                    this.root = currentItem.next();
                } else if (currentItem.next() == null){
                    //Last
                    currentItem.previous().setNext(null);
                } else {
                    //Other
                    currentItem.previous().setNext(currentItem.next());
                    currentItem.next().setPrevious(currentItem.previous());
                }
                return true;
            } else if (comparison < 0){
                currentItem = currentItem.next();
            } else {
                // Ya nos pasamos así que no está
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        } //else {
        while (root != null){
            System.out.println(root.getValue());
            root = root.next();
        }
    }
}