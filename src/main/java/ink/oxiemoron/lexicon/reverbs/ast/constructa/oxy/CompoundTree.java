package ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class CompoundTree extends AST {

    public CompoundTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitCompoundTree(this);
    }
}
