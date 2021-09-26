public class BinarySearchTree {
    public Node root;

    private int size;

    public int getSize() {
        return size;
    }

    public void add(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            ++this.size;
            return;
        }

        Node parentNode = null;
        Node actualNode = this.root;

        while (actualNode != null) {
            parentNode = actualNode;
            if (value < actualNode.getValue()) {
                actualNode = actualNode.getLeft();
            } else {
                actualNode = actualNode.getRight();
            }
        }

        Node newNode = new Node(value);
        if (parentNode.getValue() > newNode.getValue()) {
            parentNode.setLeft(newNode);
        } else {
            parentNode.setRight(newNode);
        }

        ++this.size;
    }

    public void print() {
        this.print(this.root);
    }

    public void print(Node fromNode) {
        if (fromNode.getRight() != null) {
            this.print(fromNode.getRight(), true, "");
        }

        printNode(fromNode);

        if (fromNode.getLeft() != null) {
            this.print(fromNode.getLeft(), false, "");
        }
    }

    private void print(Node node, boolean isRight, String indent) {
        if (node.getRight() != null) {
            print(node.getRight(), true, indent + (isRight ? "        " : " |      "));
        }

        System.out.print(indent);

        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }

        System.out.print("----- ");
        this.printNode(node);

        if (node.getLeft() != null) {
            print(node.getLeft(), false, indent + (isRight ? " |      " : "        "));
        }
    }

    public void printNode(Node node) {
        System.out.println(node.getValue());
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " ");
        this.preOrder(node.getLeft());
        this.preOrder(node.getRight());
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        this.inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        this.inOrder(node.getRight());
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        this.postOrder(node.getLeft());
        this.postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }
}
