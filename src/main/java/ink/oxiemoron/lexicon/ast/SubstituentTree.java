package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class SubstituentTree extends AST{

    public SubstituentTree() {

        System.out.println(">>>SUBSTITUENT tree const");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitSubstituentTree(this);
    }
}
