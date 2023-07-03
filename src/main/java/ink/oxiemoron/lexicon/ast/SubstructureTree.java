package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class SubstructureTree extends AST { // ?: has left the structure..

    public SubstructureTree() {}

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitSubstructureTree(this);
    }


}
