package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class FormTree extends AST {

    public FormTree() {

//        System.out.println(">FORM");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitFormTree(this);
    }

}
