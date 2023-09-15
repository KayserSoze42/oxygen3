package ink.oxiemoron.lexicon.reverbs.ast.constructa.gen;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class SteerrTree extends AST {

    private Element element;

    public SteerrTree() {
    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitSteerrTree(this);
    }

    public void setElement(Token tolkien) {
        element = tolkien.getElement();
    }

    public Element getElement() {
        return element;
    }
}
