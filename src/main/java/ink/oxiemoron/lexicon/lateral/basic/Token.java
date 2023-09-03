package ink.oxiemoron.lexicon.lateral.basic;

public class Token {

    private Element element;

    private int left;
    private int right;

    public Token (int left, int right, Element element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }

    @Override
    public String toString() {

        StringBuilder bob = new StringBuilder();
        bob
                .append(element)
                .append("[l: ")
                .append(left)
                .append(", r: ")
                .append(right)
                .append("]");

        return bob.toString();
    }

    public Element getElement() {
        return element;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

}
