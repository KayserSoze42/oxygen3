package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.lateral.Element;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class RootTree extends AST{

    private Element element;

    public RootTree(Token tolkien) {
        this.element = tolkien.getElement();
    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitRootTree(this);
    }

}
