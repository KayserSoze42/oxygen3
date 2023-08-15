package ink.oxiemoron.lexicon.parser.lr;

import ink.oxiemoron.colexicon.lingua.IUPACSyntaxError;
import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyParserException;
import ink.oxiemoron.lexicon.ast.*;
import ink.oxiemoron.lexicon.lateral.Token;
import ink.oxiemoron.lexicon.lateral.Tokens;
import ink.oxiemoron.lexicon.lexer.Lexer;

public class Parser {

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


        do {

            tree.addKid(rStructureTree());

        } while (isNextToken(Tokens.Location) || isNextToken(Tokens.Multiplier) || isNextToken(Tokens.Radical));

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

        // Nothing for noe, we shall se shell

        tree.addKid(rSubstituentTree());

        return tree;
    }

    public AST rSubstituentTree() throws IUPACSyntaxError {

        AST tree = new SubstituentTree();

        if (isNextToken(Tokens.Location)) {

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

            expect(Tokens.Multiplier);

        }

        if (isNextToken(Tokens.Radical)) {

            tree.addKid(rRadical());

        }

        return tree;

    }

    public AST rLocationTree() throws IUPACSyntaxError {

        AST tree = new LocationTree(currentToken);
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

