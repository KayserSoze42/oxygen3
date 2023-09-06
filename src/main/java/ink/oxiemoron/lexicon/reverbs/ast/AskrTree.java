package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class AskrTree extends AST{

    public AskrTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitAskrTree(this);
    }
}
