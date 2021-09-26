public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree bstree = new BinarySearchTree();
        bstree.add(50);
        bstree.add(35);
        bstree.add(40);
        bstree.add(45);
        bstree.add(41);
        bstree.add(34);
        bstree.add(10);
        bstree.add(67);
        bstree.add(63);
        bstree.add(78);
        bstree.add(77);
        bstree.add(76);
        bstree.add(64);
        bstree.add(65);
        bstree.add(100);
        
        bstree.print();
        bstree.preOrder(bstree.root);
        System.out.println();
        bstree.inOrder(bstree.root);
        System.out.println();
        bstree.postOrder(bstree.root);
        System.out.println();
    }
}
