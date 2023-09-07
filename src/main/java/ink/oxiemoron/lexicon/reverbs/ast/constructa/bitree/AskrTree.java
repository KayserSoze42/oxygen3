package ink.oxiemoron.lexicon.reverbs.ast.constructa.bitree;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class AskrTree extends AST {

    public AskrTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitAskrTree(this);
    }
}
