package estruturadados.arvores;

class RedBlackNode<T extends Comparable<T>> {

    /** Possible color for this node */
    public static final int BLACK = 0;

    /** Possible color for this node */
    public static final int RED = 1;

    // the key of each node
    public T key;

    /** Parent of node */
    RedBlackNode<T> parent;

    /** Left child */
    RedBlackNode<T> left;

    /** Right child */
    RedBlackNode<T> right;

    // the number of elements to the left of each node
    public int numLeft = 0;

    // the number of elements to the right of each node
    public int numRight = 0;

    // the color of a node
    public int color;

    RedBlackNode() {

        this.color = RedBlackNode.BLACK;
        this.numLeft = 0;
        this.numRight = 0;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // Constructor which sets key to the argument.
    RedBlackNode(final T key) {

        this();
        this.key = key;
    }
}// end class RedBlackNode
