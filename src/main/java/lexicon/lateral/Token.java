package lexicon.lateral;

public class Token {

    private String element;

    private int left;
    private int right;

    public Token (int left, int right, String element) {
        this.left = left;
        this.right = right;
        this.element = this.element;
    }

    @Override
    public String toString() {
        return this.element;
    }

    public String getElement() {
        return this.element;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

}
