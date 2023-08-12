package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.lateral.Element;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class RootTree extends AST{

    private Element element;

    public RootTree(Token tolkien) {

        element = tolkien.getElement();
        System.out.println(">ROOT tree {" + element + "}");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitRootTree(this);
    }

    public Element getElement() {
        return element;
    }

}
