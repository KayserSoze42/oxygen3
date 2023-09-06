package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class CompTree extends AST{

    public CompTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitCompTree(this);
    }
}
