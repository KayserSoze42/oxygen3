package ink.oxiemoron.lexicon.reverbs.ast.constructa.form;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class DesDeclTree extends AST {

    public DesDeclTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitDesDeclTree(this);
    }

}
