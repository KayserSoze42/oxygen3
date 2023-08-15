package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.lateral.Element;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class MultiplierTree extends AST{

    private Element element;

    public MultiplierTree(Token tolkien) {

        element = tolkien.getElement();
        System.out.println(">>>>MULTIPLIER {" + element + "}");

    }
    @Override
    public Object accept(ASTVisiteur visiteur) {
        return null;
    }

    public Element getElement() {return element;}
}
