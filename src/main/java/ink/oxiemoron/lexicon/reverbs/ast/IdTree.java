package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class IdTree extends AST{

    private Element element;

    public IdTree(Token tolkien) {
        element = tolkien.getElement();
    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitIdTree(this);
    }

    public Element getElement() {
        return element;
    }
}
