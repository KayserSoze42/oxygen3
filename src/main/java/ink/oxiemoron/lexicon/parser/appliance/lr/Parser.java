package ink.oxiemoron.lexicon.parser.appliance.lr;

import ink.oxiemoron.colexicon.lingua.IUPACSyntaxError;
import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.lateral.basic.Tokens;
import ink.oxiemoron.lexicon.lexer.appliance.basic.Lexer;
import ink.oxiemoron.lexicon.parser.approach.ParserApproach;
import ink.oxiemoron.lexicon.reverbs.ast.*;

public class Parser implements ParserApproach<AST> {

    private Token currentToken;
    private Lexer lexer;

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

        while (isNextToken(Tokens.Location) || isNextToken(Tokens.Multiplier) || isNextToken(Tokens.Radical)) {

            tree.addKid(rStructureTree());

        }

        if (isNextToken(Tokens.Root)) {

            tree.addKid(rRoot());

        } else {

            throw new IUPACSyntaxError(currentToken, Tokens.Root);

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

        if (currentToken != null) {

//            System.out.println(currentToken);

        }

    }


}

