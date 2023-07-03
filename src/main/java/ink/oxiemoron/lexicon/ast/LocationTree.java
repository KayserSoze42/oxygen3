package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.lateral.Element;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class LocationTree extends AST{

    private Element element;

    public LocationTree(Token tolkien) {
        this.element = tolkien.getElement();
    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitLocationTree(this);
    }

    public Element getElement() {
        return element;
    }

}
