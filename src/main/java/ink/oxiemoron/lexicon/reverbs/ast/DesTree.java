package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class DesTree extends AST {

    public DesTree() {

    }

    @Override
    public Object accept (ASTVisiteur visiteur) {
        return visiteur.visitDesTree(this);
    }

}
