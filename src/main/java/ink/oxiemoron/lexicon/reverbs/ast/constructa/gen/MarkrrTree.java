package ink.oxiemoron.lexicon.reverbs.ast.constructa.gen;

import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.visiteurs.ASTVisiteur;

public class MarkrrTree extends AST {

    private Element element;

    public MarkrrTree(Token tolkien) {
        element = tolkien.getElement();
    }

    @Override
    public Object accept(ASTVisiteur visiteur){
        return null;
    }
}
