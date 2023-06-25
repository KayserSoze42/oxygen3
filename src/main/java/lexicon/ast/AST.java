package lexicon.ast;

import java.util.ArrayList;

public abstract class AST {
    protected ArrayList<AST> kids;
    protected int nodeNumber;
    protected AST decoration;
    protected String label;

    static int nodeCounter = 0;

    public AST() {

        kids = new ArrayList<AST>();
        nodeCounter++;
        nodeNumber = nodeCounter;

    }

    public void setDecoration(AST tree) {
        decoration = tree; // 3?
    }

    public AST getDecoration() {
        return decoration;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public AST getKid(int index) {

        if ((index <= 0) || (index > kidCount())){
            return null;
        }
        return kids.get(index - 1); // One before the index?
    }

    public int kidCount() { // watch?v=mWWAC5ZMKeM
        return kids.size();
    }

    // We accept no visitors at this point. Thank you, come again later.

}
