package ink.oxiemoron.lexicon.visiteurs;

import ink.oxiemoron.lexicon.ast.AST;
import ink.oxiemoron.lexicon.ast.LocationTree;
import ink.oxiemoron.lexicon.ast.RadicalTree;
import ink.oxiemoron.lexicon.ast.RootTree;

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

        if (indepth != 0) {
            indepth = 0; // magikk, right...
        }

    }


    @Override
    public Object visitFormTree(AST tree) {
        print("FormTree", tree);
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
        print("Locaction {" + ((LocationTree)tree).getElement() + "}", tree);
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
