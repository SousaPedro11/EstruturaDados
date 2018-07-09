package estruturadados.arvores;

public class AVL {

    private Node root;

    private static class Node {

        private int key;

        private int balance;

        private int height;

        private Node left;

        private Node right;

        private Node parent;

        Node(final int key, final Node parent) {

            this.key = key;
            this.parent = parent;
        }
    }

    public boolean insert(final int key) {

        if (this.root == null) {
            this.root = new Node(key, null);
            return true;
        }

        Node n = this.root;
        while (true) {
            if (n.key == key) {
                return false;
            }

            final Node parent = n;

            final boolean goLeft = n.key > key;
            n = goLeft ? n.left : n.right;

            if (n == null) {
                if (goLeft) {
                    parent.left = new Node(key, parent);
                } else {
                    parent.right = new Node(key, parent);
                }
                this.rebalance(parent);
                break;
            }
        }
        return true;
    }

    private void delete(final Node node) {

        if ((node.left == null) && (node.right == null)) {
            if (node.parent == null) {
                this.root = null;
            } else {
                final Node parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                this.rebalance(parent);
            }
            return;
        }

        if (node.left != null) {
            Node child = node.left;
            while (child.right != null) {
                child = child.right;
            }
            node.key = child.key;
            this.delete(child);
        } else {
            Node child = node.right;
            while (child.left != null) {
                child = child.left;
            }
            node.key = child.key;
            this.delete(child);
        }
    }

    public void delete(final int delKey) {

        if (this.root == null) {
            return;
        }

        Node child = this.root;
        while (child != null) {
            final Node node = child;
            child = delKey >= node.key ? node.right : node.left;
            if (delKey == node.key) {
                this.delete(node);
                return;
            }
        }
    }

    private void rebalance(Node n) {

        this.setBalance(n);

        if (n.balance == -2) {
            if (this.height(n.left.left) >= this.height(n.left.right)) {
                n = this.rotateRight(n);
            } else {
                n = this.rotateLeftThenRight(n);
            }

        } else if (n.balance == 2) {
            if (this.height(n.right.right) >= this.height(n.right.left)) {
                n = this.rotateLeft(n);
            } else {
                n = this.rotateRightThenLeft(n);
            }
        }

        if (n.parent != null) {
            this.rebalance(n.parent);
        } else {
            this.root = n;
        }
    }

    private Node rotateLeft(final Node a) {

        final Node b = a.right;
        b.parent = a.parent;

        a.right = b.left;

        if (a.right != null) {
            a.right.parent = a;
        }

        b.left = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        this.setBalance(a, b);

        return b;
    }

    private Node rotateRight(final Node a) {

        final Node b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null) {
            a.left.parent = a;
        }

        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        this.setBalance(a, b);

        return b;
    }

    private Node rotateLeftThenRight(final Node n) {

        n.left = this.rotateLeft(n.left);
        return this.rotateRight(n);
    }

    private Node rotateRightThenLeft(final Node n) {

        n.right = this.rotateRight(n.right);
        return this.rotateLeft(n);
    }

    private int height(final Node n) {

        if (n == null) {
            return -1;
        }
        return n.height;
    }

    private void setBalance(final Node... nodes) {

        for (final Node n : nodes) {
            this.reheight(n);
            n.balance = this.height(n.right) - this.height(n.left);
        }
    }

    public void printBalance() {

        this.printBalance(this.root);
        System.out.println();
    }

    private void printBalance(final Node n) {

        if (n != null) {
            this.printBalance(n.left);
            System.out.printf("%s ", n.balance);
            this.printBalance(n.right);
        }
    }

    private void reheight(final Node node) {

        if (node != null) {
            node.height = 1 + Math.max(this.height(node.left), this.height(node.right));
        }
    }
}
