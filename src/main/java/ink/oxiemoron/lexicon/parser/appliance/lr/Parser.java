package ink.oxiemoron.lexicon.parser.appliance.lr;

import ink.oxiemoron.colexicon.lingua.IUPACSyntaxError;
import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.colexicon.lingua.OxySyntaxError;
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

        } catch (OxySyntaxError ose) {
            ose.printStackTrace();
            throw new OxyParserException("OXY Syntax Error: " + currentToken);
        }

    }

    public AST rForm() throws IUPACSyntaxError, OxySyntaxError {
        AST tree = new FormTree();

        while (true) {
            try {
                tree.addKid(rSinDeclTree());
            } catch (Exception eh) {
                break;
            }

            try {
                tree.addKid(rSinPredicaTree());
            } catch (Exception eh) {
                break;
            }
        }

        if (isNextToken(Tokens.Semicolon)) {

        }

        while (true) {
            try {
                tree.addKid(rDesDeclTree());
            } catch (Exception eh) {
                break;
            }

            try {
                tree.addKid(rSinPredicaTree());
            } catch (Exception eh) {
                break;
            }
        }


        return tree;
    }


    public AST rSinDeclTree() throws IUPACSyntaxError, OxySyntaxError {
        AST prima, secunda;

        prima = rId();


        return prima;
    }

    public AST rDesDeclTree() throws IUPACSyntaxError, OxySyntaxError {
        AST tree = new DesDeclTree();

        return tree;
    }

    public AST rSinPredicaTree() throws IUPACSyntaxError, OxySyntaxError {
        AST tree = new PredicaTree();

        return tree;
    }

    public AST rDesPredicaTree() throws IUPACSyntaxError, OxySyntaxError {
        AST tree = new PredicaTree();

        return tree;
    }
    public AST rAllocrTree() throws IUPACSyntaxError, OxySyntaxError {
        AST tree = new AllocrTree();

        if (lookAheadForCompound()) {


        } else if (isNextToken(Tokens.String)) {
            ;
        }

        return tree;
    }


    public AST rSteerr() throws OxySyntaxError {
        AST tree = new SteerrTree(currentToken);
        scan();
        return tree;
    }

    public AST rCompoundTree() throws IUPACSyntaxError, OxySyntaxError {
        AST tree = new CompoundTree();

        return tree;
    }

    public AST rLocation() throws IUPACSyntaxError {
        AST tree = new LocationTree(currentToken);
        scan();
        return tree;
    }

    public AST rMultiplier() throws IUPACSyntaxError {
        AST tree = new MultiplierTree(currentToken);
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
        if (isNextToken(Tokens.Location) || isNextToken(Tokens.Multiplier) || isNextToken(Tokens.Radical) || isNextToken(Tokens.Root) ||
                isNextToken(Tokens.Dash) || isNextToken(Tokens.Comma)) {
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

