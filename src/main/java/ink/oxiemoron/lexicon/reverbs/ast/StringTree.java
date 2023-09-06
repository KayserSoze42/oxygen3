package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class StringTree extends AST{


    private Element element;

    public StringTree(Token tolkien) {
        element = tolkien.getElement();
    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitStringTree(this);
    }
    public Element getElement() {
        return element;
    }
}
