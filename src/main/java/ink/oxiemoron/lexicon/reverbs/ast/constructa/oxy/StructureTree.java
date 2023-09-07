package ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class StructureTree extends AST { // ?: has left the structure..

    public StructureTree() {

//        System.out.println(">>STRUCTURE");

    }

    public Object accept(ASTVisiteur visiteur) {
        return visiteur.visitStructureTree(this);
    }


}
