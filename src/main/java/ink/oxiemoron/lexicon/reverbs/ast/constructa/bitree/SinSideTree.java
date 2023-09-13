package ink.oxiemoron.lexicon.reverbs.ast.constructa.bitree;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class SinSideTree extends AST {

    public SinSideTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitSinSideTree(this);
    }
}
