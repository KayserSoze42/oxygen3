package ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

// 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonyl 1,2,3,4,5,6,7,8,9-nonanonylnonane;

public class LocationTree extends AST {

    private Element element;

    public LocationTree(Token tolkien) {

        element = tolkien.getElement();
//        System.out.println(">>>>LOCATION {" + element + "}");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitLocationTree(this);
    }

    public Element getElement() {
        return element;
    }

}
