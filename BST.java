class node {
    int data;
    node left, right;

    public node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class BST {
    node root;

    public BST(int item) {
        root = new node(item);
    }
    public void displayInOrder() {
        displayrec(root);
    }
    private void displayrec(node root){
        if(root.left != null){
            displayrec(root.left);
        }
        System.out.println(root.data);
        if (root.right !=null){
            displayrec(root.right);
        }
    }
    public void add(int item){
        addrec(root, item);
    }
    private void addrec(node root, int item){
        if(root.left == null &&  item < root.data ){
            root.left = new node(item);
            return;
        }
        if(root.right == null  && item > root.data ){
            root.right = new node(item);
            return;
        }
        if (item<root.data){
            addrec(root.left, item);
        }
        if (item>root.data){
            addrec(root.right, item);
        }
    }

    public static void main(String[] args){
        BST tree = new BST(20);
        tree.add(10);
        tree.add(5);
        tree.add(30);
        tree.add(15);
        tree.add(25);
        tree.add(35);
        tree.add(40);
        tree.displayInOrder();
    }
}

