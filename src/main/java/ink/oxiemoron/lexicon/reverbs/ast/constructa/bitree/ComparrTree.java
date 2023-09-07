package ink.oxiemoron.lexicon.reverbs.ast.constructa.bitree;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class ComparrTree extends AST {

    public ComparrTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur){
        return visiteur.visitComparrTree(this);
    }
}
