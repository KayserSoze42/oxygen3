package ink.oxiemoron.lexicon.parser.appliance.lr;

import ink.oxiemoron.colexicon.lingua.IUPACSyntaxError;
import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.colexicon.metils.Pile;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.lateral.basic.Tokens;
import ink.oxiemoron.lexicon.lexer.appliance.basic.Lexer;
import ink.oxiemoron.lexicon.parser.approach.ParserApproach;
import ink.oxiemoron.lexicon.reverbs.ast.abstracta.AST;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.bitree.AllocrTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.bitree.AskrTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.bitree.ComparrTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.form.*;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.gen.IdTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.gen.SteerrTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.gen.StringTree;
import ink.oxiemoron.lexicon.reverbs.ast.constructa.oxy.*;

public class Parser implements ParserApproach<AST> {

    private Token currentToken;
    private Lexer lexer;

    private boolean eos = false;
    private Pile<Token> keepdPile;
    private Token keepTolkien;

    public Parser(String source) throws OxyParserException {

        try {
            lexer = new Lexer(source);
            scan(); // ch is the next character to process

        } catch (OxyLexerException olé) {

            System.out.println(olé.getMessage());
            throw new OxyParserException("rip too");
        }
    }

    public Lexer getLex() {
        return lexer;
    }

    @Override
    public AST execute() throws OxyParserException {

        try {
            return rForm();
        } catch (IUPACSyntaxError ise) {

            ise.printStackTrace();
            throw new OxyParserException("IUPAC Syntax Error: " + currentToken);

        }

    }

    public AST rForm() throws IUPACSyntaxError {
        AST tree = new FormTree();
        AST desDeclTree = rDesDeclTree();

        keepdPile = new Pile<>();

        if (lookAheadForCompound() || isNextToken(Tokens.String)) {

            do {
                keepdPile.push(currentToken);
                scan();
            } while (lookAheadForCompound() || isNextToken(Tokens.String));

        }

        while (!eos) {

            if (isNextToken(Tokens.Allotr)) {

                rDesDeclTree().addKid(rAllocrTree());

            }

            if (isNextToken(Tokens.Greatr) || isNextToken(Tokens.Lessr)) {

                rDesDeclTree().addKid(rComparrTree());

            }

            if (isNextToken(Tokens.Askr)) {

                tree.addKid(rAskrTree());
            }

        }

        return tree;
    }

    public AST rDesDeclTree() throws IUPACSyntaxError {
        AST tree = new DesDeclTree();

        return tree;
    }

    public AST rSinDeclTree() throws IUPACSyntaxError {
        AST tree = new SinDeclTree();

        return tree;
    }

    public AST rPredicaTree() throws IUPACSyntaxError {
        AST tree = new PredicaTree();

        return tree;
    }

    public AST rAllocrTree() throws IUPACSyntaxError {

        AST tree = new AllocrTree();

        while (keepTolkien != null) {
            if (isNextToken(Tokens.Location) || isNextToken(Tokens.Multiplier) || isNextToken(Tokens.Radical) || isNextToken(Tokens.Root)) {
                tree.addKid(rSinTree().addKid(rCompoundTree()));
            } else if (isNextToken(Tokens.String)) {
                tree.addKid(rSinTree().addKid(rId()));
            }
        }


        tree.addKid(rSteerr());

        if (isNextToken(Tokens.Location) || isNextToken(Tokens.Multiplier) || isNextToken(Tokens.Radical) || isNextToken(Tokens.Root)) {
            tree.addKid(rDesTree().addKid(rCompoundTree()));
        } else if (isNextToken(Tokens.String)) {
            tree.addKid(rDesTree().addKid(rString()));
        }

        return tree;
    }

    public AST rComparrTree() throws IUPACSyntaxError {

        AST tree = new ComparrTree();


        tree.addKid(rSteerr());

        if (isNextToken(Tokens.Location) || isNextToken(Tokens.Multiplier) || isNextToken(Tokens.Radical) || isNextToken(Tokens.Root)) {
            tree.addKid(rDesTree().addKid(rCompoundTree()));
        }

        if (isNextToken(Tokens.String)) {
            tree.addKid(rDesTree().addKid(rId()));
        }

        return tree;
    }

    public AST rAskrTree() throws IUPACSyntaxError {
        AST tree = new AskrTree();


        expect(Tokens.Askr);

        return tree;
    }

    public AST rDesTree() throws IUPACSyntaxError {
        AST tree = new DesSideTree();

        return tree;
    }

    public AST rSinTree() throws IUPACSyntaxError {
        AST tree = new SinSideTree();

        return tree;
    }

    public AST rSteerr() throws IUPACSyntaxError {

        AST tree = new SteerrTree(currentToken);
        scan();
        return tree;

    }

    public AST rCompoundTree() throws IUPACSyntaxError {
        AST tree = new CompoundTree();

        while (isNextToken(Tokens.Location) || isNextToken(Tokens.Multiplier) || isNextToken(Tokens.Radical)) {

            tree.addKid(rStructureTree());

        }

        if (isNextToken(Tokens.Root)) {

            tree.addKid(rRoot());

        } else {

            if (eos) {
                throw new IUPACSyntaxError(keepdPile.pop(), Tokens.Root);
            }
        }

        scan();



        if (isNextToken(Tokens.Semicolon)) {

            expect(Tokens.Semicolon);

        }

        return tree;


    }

    public AST rStructureTree() throws IUPACSyntaxError {

        AST tree = new StructureTree();

        // Nothing for noe, we shall see shell

        tree.addKid(rSubstituentTree());

        return tree;
    }

    public AST rSubstituentTree() throws IUPACSyntaxError {

        boolean radicalNeed = false;
        boolean multiNeed = false;

        AST tree = new SubstituentTree();

        if (isNextToken(Tokens.Location)) {

            if (!radicalNeed) {radicalNeed = true;}
            if (!multiNeed) {multiNeed = true;}

            do {

                tree.addKid(rLocationTree());

                if (isNextToken(Tokens.Comma)) {

                    expect(Tokens.Comma);

                }

                if (isNextToken(Tokens.Dash)) {

                    expect(Tokens.Dash);

                }

            } while (isNextToken(Tokens.Location));
        }

        if (isNextToken(Tokens.Multiplier)) {

            if (!radicalNeed) {radicalNeed = true;}


            tree.addKid(rMultiplierTree());

            if (multiNeed) {multiNeed = false;}

        } else {

            if (multiNeed) {throw new IUPACSyntaxError(currentToken, Tokens.Multiplier);}

        }

        if (isNextToken(Tokens.Radical)) {

            tree.addKid(rRadical());

            if (radicalNeed) {radicalNeed = false;}

        } else {
            if (radicalNeed) {throw new IUPACSyntaxError(currentToken, Tokens.Radical);}
        }

        return tree;

    }

    public AST rLocationTree() throws IUPACSyntaxError {

        AST tree = new LocationTree(currentToken);
        scan();
        return tree;
    }

    public AST rMultiplierTree() throws IUPACSyntaxError{

        AST tree = new MultiplierTree(keepdPile.pop());
        scan();
        return tree;
    }

    public AST rRadical() throws IUPACSyntaxError {

        AST tree = new RadicalTree(currentToken);
        scan();
        return tree;
    }

    public AST rRoot() throws IUPACSyntaxError {
        AST tree = new RootTree(currentToken);
        scan();
        return tree;
    }

    public AST rString() throws IUPACSyntaxError {
        AST tree = new StringTree(currentToken);
        scan();
        return tree;
    }

    public AST rId() throws IUPACSyntaxError {
        AST tree = new IdTree(currentToken);
        scan();
        return tree;
    }

    private boolean lookAheadForCompound() {
        if (isNextToken(Tokens.Location)|| isNextToken(Tokens.Multiplier) || isNextToken(Tokens.Radical) || isNextToken(Tokens.Root)) {
            return true;
        }
        return false;
    }

    private boolean isNextToken(Tokens type) {

        if ((currentToken == null) || (currentToken.getElement().getType()) != type) {

            return false;
        }

        return true;

    }

    private void expect(Tokens type) throws IUPACSyntaxError {

        if (isNextToken(type)) {
            scan();
            return;
        }
        throw new IUPACSyntaxError(currentToken, type);

    }

    public void scan() {

        currentToken = lexer.getNextToken();

        if (currentToken == null) {

            eos = true;

        }

    }


}

