import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.NodeAlreadyExistsException;

public class App {

    private static String PRINT_TREE_COMMAND = "print";
    private static String INSERT_COMMAND = "insert";
    private static String REMOVE_COMAND = "remove";
    private static String EXIT_COMMAND = "exit";
    private static String IN_ORDER_COMMAND = "in_order";
    private static String PRE_ORDER_COMMAND = "pre_order";
    private static String POST_ORDER_COMMAND = "post_order";
    private static String HELP_COMMAND = "help";

    public static void main(String[] args) throws Exception {
        printMenu();
        BinarySearchTree bstree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        while (true) {
            scanner.useDelimiter("\\n");
            System.out.print("> ");
            String command = scanner.next();
            command = command.toLowerCase();

            if (App.EXIT_COMMAND.equals(command)) {
                System.out.println("Hasta la próxima :)");
                break;
            } else if (App.HELP_COMMAND.equals(command)) {
                App.printCommands();
            } else if (App.PRINT_TREE_COMMAND.equals(command)) {
                App.printTree(bstree);
            } else if (App.INSERT_COMMAND.equals(command)) {
                App.insert(bstree, scanner);
            } else if (App.REMOVE_COMAND.equals(command)) {
                App.remove(bstree, scanner);
            } else if (App.IN_ORDER_COMMAND.equals(command)) {
                App.inOrder(bstree);
            } else if (App.PRE_ORDER_COMMAND.equals(command)) {
                App.preOrder(bstree);
            } else if (App.POST_ORDER_COMMAND.equals(command)) {
                App.postOrder(bstree);
            } else {
                System.out.println("No se encuentra el comando: " + command);
                App.printCommands();
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=====================================");
        System.out.println("      Bienvenido a ***BSTree***      ");
        System.out.println("=====================================");
        App.printCommands();
    }

    public static void printCommands() {
        System.out.println("Comandos disponibles:");
        System.out.println("+ " + App.PRINT_TREE_COMMAND + " - Imprimir el árbol binario");
        System.out.println("+ " + App.INSERT_COMMAND + " - Insertar nuevo nodo");
        System.out.println("+ " + App.REMOVE_COMAND + " - Eliminar nodo");
        System.out.println("+ " + App.PRE_ORDER_COMMAND + " - pre orden");
        System.out.println("+ " + App.IN_ORDER_COMMAND+ " - in orden");
        System.out.println("+ " + App.POST_ORDER_COMMAND + " - post orden");
        System.out.println("+ " + App.EXIT_COMMAND + " - Salir de BSTress.");
        System.out.println("+ " + App.HELP_COMMAND + " - Ver la lista de comandos.");
    }

    public static void printTree(BinarySearchTree tree) {
        System.out.println("=====================================");
        System.out.println("           BSTree, nodos.            ");
        System.out.println("=====================================");

        if (tree.getSize() == 0) {
            System.out.println("El árbol se encuentra vacío.");
            return;
        }

        tree.print();
    }

    public static void insert(BinarySearchTree tree, Scanner scanner) {
        System.out.print("Número del nodo: ");
        try {
            int value = scanner.nextInt();
            tree.add(value);
            System.out.println("Se ha insertado un nuevo nodo.");
        } catch (InputMismatchException e) {
            System.out.println("No se ha podido leer el número.");
            return;
        } catch (NodeAlreadyExistsException e) {
            System.out.println("El nodo con el valor " + e.getNodeValue() + " ya existe.");
        }
    }

    public static void remove(BinarySearchTree tree, Scanner scanner) {
        System.out.print("Número del nodo: ");

        int value = scanner.nextInt();

        if (!tree.nodeExists(value)) {
            System.out.println("El nodo con valor " + value + " no existe.");
            return;
        }

        try {
            tree.remove(value);
            System.out.println("Se ha eliminado el nodo " + value + ".");
        } catch (InputMismatchException e) {
            System.out.println("No se ha podido leer el número.");
        }
    }

    public static void inOrder(BinarySearchTree tree) {
        if (tree.getSize() == 0) {
            System.out.println("El árbol se encuentra vacío.");
            return;
        }
        tree.inOrder();
    }

    public static void preOrder(BinarySearchTree tree) {
        if (tree.getSize() == 0) {
            System.out.println("El árbol se encuentra vacío.");
            return;
        }
        tree.preOrder();
    }

    public static void postOrder(BinarySearchTree tree) {
        if (tree.getSize() == 0) {
            System.out.println("El árbol se encuentra vacío.");
            return;
        }
        tree.postOrder();
    }
}
