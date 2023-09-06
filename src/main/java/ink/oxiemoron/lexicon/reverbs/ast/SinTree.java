package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

import java.util.ArrayList;

public class SinTree extends AST {

    public SinTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitSinTree(this);
    }
}
