package ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class RootTree extends AST {

    private Element element;

    public RootTree(Token tolkien) {

        element = tolkien.getElement();
//        System.out.println(">>ROOT {" + element + "}");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitRootTree(this);
    }

    public Element getElement() {
        return element;
    }

}
