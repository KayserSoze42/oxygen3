package ink.oxiemoron.lexicon.reverbs.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class ComparrTree extends AST{

    public ComparrTree() {

    }

    @Override
    public Object accept(ASTVisiteur visiteur){
        return visiteur.visitComparrTree(this);
    }
}
