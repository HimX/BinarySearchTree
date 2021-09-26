import exceptions.NodeAlreadyExistsException;

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

        if (parentNode.getValue() == value) {
            throw new NodeAlreadyExistsException(value);
        }

        Node newNode = new Node(value);
        newNode.setParent(parentNode);
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
        if (fromNode == null) {
            return;
        }

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

    public void preOrder() {
        this.preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " ");
        this.preOrder(node.getLeft());
        this.preOrder(node.getRight());
    }

    public void inOrder() {
        this.inOrder(this.root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        this.inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        this.inOrder(node.getRight());
    }

    public void postOrder() {
        this.postOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        this.postOrder(node.getLeft());
        this.postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public Node getNodeByValue(int value) {
        Node actualNode = this.root;

        while (actualNode != null && actualNode.getValue() != value) {
            if (value < actualNode.getValue()) {
                actualNode = actualNode.getLeft();
            } else {
                actualNode = actualNode.getRight();
            }
        }

        return actualNode;
    }

    public boolean nodeExists(int value) {
        return this.getNodeByValue(value) != null;
    }

    public Node remove(int value) {
        return this.remove(this.root, value);
    }

    /**
     * 
     * @param value
     * @return
     */
    private Node remove(Node actualNode, int value) {
        if (actualNode == null) {
            return null;
        }

        if (value < actualNode.getValue()) {
            this.remove(actualNode.getLeft(), value);
        } else if (value > actualNode.getValue()) {
            this.remove(actualNode.getRight(), value);
        } else {
            this.remove(actualNode);
        }

        return actualNode;
    }

    private Node remove(Node actualNode) {
        if (actualNode.getLeft() != null && actualNode.getRight() != null) {
            Node maxNode = this.getMax();
            actualNode.setValue(maxNode.getValue());
            this.swapNodes(maxNode, null);
        } else if (actualNode.getRight() != null) {
            this.swapNodes(actualNode, actualNode.getRight());
        } else if (actualNode.getLeft() != null) {
            this.swapNodes(actualNode, actualNode.getLeft());
        } else {
            this.swapNodes(actualNode, null);
        }

        return actualNode;
    }

    private Node swapNodes(Node nodeToReplace, Node newNode) {
        if (nodeToReplace.getParent() == null) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.getParent().getLeft()) {
            nodeToReplace.getParent().setLeft(newNode);
        } else {
            nodeToReplace.getParent().setRight(newNode);
        }

        if (newNode != null) {
            newNode.setParent(nodeToReplace.getParent());
        }

        return newNode;
    }

    public Node getMax() {
        return this.getMaxNode(this.root);
    }

    private Node getMaxNode(Node node) {
        if (node == null) {
            return null;
        }

        if (node.getRight() != null) {
            node = this.getMaxNode(node.getRight());
        }

        return node;
    }
}
