package ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class SubstituentTree extends AST {

    public SubstituentTree() {

//        System.out.println(">>>SUBSTITUENT");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitSubstituentTree(this);
    }
}
