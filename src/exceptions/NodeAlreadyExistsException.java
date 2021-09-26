package exceptions;

public class NodeAlreadyExistsException extends RuntimeException {

    private int nodeValue;

    public NodeAlreadyExistsException(int nodeValue) {
        super("Node with " + nodeValue + " already existes.");
        this.nodeValue = nodeValue;
    }

    public int getNodeValue() {
        return nodeValue;
    }
}
