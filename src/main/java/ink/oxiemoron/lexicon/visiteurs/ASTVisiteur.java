package ink.oxiemoron.lexicon.visiteurs;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;

public abstract class ASTVisiteur {

    public void visitKids(AST tree) {
        for (AST kid : tree.getKids()) {
            kid.accept(this);
        }
        return; // unnecessary, like me.. hah..
    }

    // -------

    public abstract Object visitFormTree(AST tree);

    public abstract Object visitDesDeclTree(AST tree);

    public abstract Object visitSinDeclTree(AST tree);

    public abstract Object visitPredicaTree(AST tree);

    // ------
    public abstract Object visitSteerrTree(AST tree);

    public abstract Object visitMarkrrTree(AST tree);

    // -------
    public abstract Object visitAllocrTree(AST tree);

    public abstract Object visitComparrTree(AST tree);

    public abstract Object visitAskrTree(AST tree);

    public abstract Object visitDesSideTree(AST tree);

    public abstract Object visitSinSideTree(AST tree);

    // -------

    public abstract Object visitStringTree(AST tree);

    public abstract Object visitIdTree(AST tree);

    public abstract Object visitCompoundTree(AST tree);

    // -------

    public abstract Object visitStructureTree(AST tree);

    public abstract Object visitSubstituentTree(AST tree);

    public abstract Object visitLocationTree(AST tree);

    public abstract Object visitMultiplierTree(AST tree);

    public abstract Object visitRadicalTree(AST tree); // Even if i'm wrong.. funny name..

    public abstract Object visitRootTree(AST tree);

    // -------

    // Ok, now we have the "basics", let's turn them "visible"

    // Abracadabra!

    // Well, I've done all I can do.

}
