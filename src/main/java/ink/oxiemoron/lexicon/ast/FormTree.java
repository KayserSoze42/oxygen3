package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class FormTree extends AST {

    public FormTree() {}

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitFormTree(this);
    }

}
