package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class CompoundTree extends AST{

    public CompoundTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitCompoundTree(this);
    }
}
