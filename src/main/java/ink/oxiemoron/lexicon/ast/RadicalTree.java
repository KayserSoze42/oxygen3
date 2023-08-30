package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.lateral.Element;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class RadicalTree extends AST{

    private Element element;

    public RadicalTree(Token tolkien) {

        element = tolkien.getElement();
//        System.out.println(">>>>RADICAL {" + element + "}");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitRadicalTree(this);
    }

    public Element getElement() {
        return element;
    }

}
