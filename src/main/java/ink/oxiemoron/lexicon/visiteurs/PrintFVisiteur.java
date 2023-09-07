package ink.oxiemoron.lexicon.visiteurs;

import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.gen.IdTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.gen.SteerrTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.gen.StringTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy.LocationTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy.MultiplierTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy.RadicalTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy.RootTree;

public class PrintFVisiteur extends ASTVisiteur{

    private int indepth = 0;

    private void printf(int number) {

        StringBuffer buffy = new StringBuffer();

        for (int i=0; i < number; i++) {

            buffy.append(' ');

        }

        System.out.print(buffy);

    }

    public void print (String string, AST tree) {

        int number = tree.getNodeNumber();
        AST decoration = tree.getDecoration();

        int decorationNumber = (decoration == null) ? -1 : decoration.getNodeNumber();
        String spacey = "";

        if (number < 100) { spacey += " "; }
        if (number < 10) { spacey += " "; }

        System.out.print(number + ":" + spacey);

        printf(indepth);

        if (decorationNumber != -1) {
            string += "           Dec: " + decorationNumber; // dexd
        }

        String labella = tree.getLabel();

        if (labella != null) {
            string += "  Label: " + labella;
        }

        System.out.println(string);

        indepth += 2;
        visitKids(tree);
        indepth -= 2;

    }


    @Override
    public Object visitFormTree(AST tree) {
        print("FormTree", tree);
        return null;
    }

    @Override
    public Object visitDesDeclTree(AST tree) {
        print("DesDeclTree", tree);
        return null;
    }

    @Override
    public Object visitSinDeclTree(AST tree) {
        print("SinDeclTree", tree);
        return null;
    }

    @Override
    public Object visitPredicaTree(AST tree) {
        print("PredicaTree", tree);
        return null;
    }

    @Override
    public Object visitMarkrrTree(AST tree) {
        print("MarkrrTree", tree);
        return null;
    }

    @Override
    public Object visitSteerrTree(AST tree) {
        print("Steerr {" + ((SteerrTree)tree).getElement() + "}", tree);
        return null;
    }

    @Override
    public Object visitStringTree(AST tree) {
        print("String {" + ((StringTree)tree).getElement() + "}", tree);
        return null;
    }

    @Override
    public Object visitAllocrTree(AST tree) {
        print("AllocrTree", tree);
        return null;
    }

    @Override
    public Object visitComparrTree(AST tree) {
        print("ComparrTree", tree);
        return null;
    }

    @Override
    public Object visitAskrTree(AST tree) {
        print("AskrTree", tree);
        return null;
    }

    @Override
    public Object visitDesSideTree(AST tree) {
        print("DesTree", tree);
        return null;
    }

    @Override
    public Object visitSinSideTree(AST tree) {
        print("SinTree", tree);
        return null;
    }

    @Override
    public Object visitCompoundTree(AST tree) {
        print("CompoundTree", tree);
        return null;
    }

    @Override
    public Object visitIdTree(AST tree) {
        print("Id {" + ((IdTree)tree).getElement() + "}", tree);
        return null;
    }

    @Override
    public Object visitStructureTree(AST tree) {
        print("StrucTree:", tree);
        return null;
    }

    @Override
    public Object visitSubstituentTree(AST tree) {
        print("SubsTree:", tree);
        return null;
    }

    @Override
    public Object visitLocationTree(AST tree) {
        print("Location {" + ((LocationTree)tree).getElement() + "}", tree);
        return null;
    }

    @Override
    public Object visitMultiplierTree(AST tree) {
        print("Multiplier {" + ((MultiplierTree)tree).getElement() + "}", tree);
        return null;
    }

    @Override
    public Object visitRadicalTree(AST tree) {
        print("Radical {" + ((RadicalTree)tree).getElement() + "}", tree);
        return null;
    }

    @Override
    public Object visitRootTree(AST tree) {
        print("Root {" + ((RootTree)tree).getElement() + "}", tree);
        return null;
    }

}
