package ink.oxiemoron.lexicon.reverbs.ast.constructa.form;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class DesSideTree extends AST {

    public DesSideTree() {

    }

    @Override
    public Object accept (ASTVisiteur visiteur) {
        return visiteur.visitDesSideTree(this);
    }

}
