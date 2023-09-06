package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class AllocrTree extends AST{


    public AllocrTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitAllocrTree(this);
    }
}
