package ink.oxiemoron.lexicon.visiteurs;

import ink.oxiemoron.lexicon.ast.AST;

public abstract class ASTVisiteur {

    public void visitKids(AST tree) {
        for (AST kid : tree.getKids()) {
            kid.accept(this);
        }
        return; // unnecessary, like me.. hah..
    }

    public abstract Object visitFormTree(AST tree);
    public abstract Object visitStructureTree(AST tree);

    public abstract Object visitSubstituentTree(AST tree);

    public abstract Object visitLocationTree(AST tree);

    public abstract Object visitMultiplierTree(AST tree);

    public abstract Object visitRadicalTree(AST tree); // Even if i'm wrong.. funny name..

    public abstract Object visitRootTree(AST tree);

    // Ok, now we have the "basics", let's turn them "visible"

    // Abracadabra!

    // Well, I've done all I can do.

}
