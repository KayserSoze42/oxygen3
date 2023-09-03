package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
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
