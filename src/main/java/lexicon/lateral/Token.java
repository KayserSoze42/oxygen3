package lexicon.lateral;

public class Token {

    private String symbol;

    private int left;
    private int right;

    public Token (int left, int right, String symbol) {
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

}
