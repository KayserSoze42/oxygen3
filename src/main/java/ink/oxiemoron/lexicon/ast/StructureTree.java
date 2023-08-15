package ink.oxiemoron.lexicon.ast;

import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class StructureTree extends AST { // ?: has left the structure..

    public StructureTree() {

        System.out.println(">>STRUCTURE");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitStructureTree(this);
    }


}
