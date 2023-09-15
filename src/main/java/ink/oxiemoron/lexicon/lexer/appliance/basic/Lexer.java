package ink.oxiemoron.lexicon.lexer.appliance.basic;

import ink.oxiemoron.colexicon.lingua.OxyLexerException;
import ink.oxiemoron.colexicon.lingua.OxyReaderException;
import ink.oxiemoron.colexicon.metils.Pile;
import ink.oxiemoron.lexicon.lateral.basic.Element;
import ink.oxiemoron.lexicon.lateral.basic.Reader;
import ink.oxiemoron.lexicon.lateral.basic.Token;
import ink.oxiemoron.lexicon.lateral.basic.Tokens;
import ink.oxiemoron.lexicon.lateral.basic.regex.Regex;
import ink.oxiemoron.lexicon.lexer.approach.LexerApproach;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lexer implements LexerApproach<Token> {

    // Ok, so the syntax is
    // 1, 3, 7-Trimethylpurine-2,6-dione
    // Location , Location , Location - Multiplier FunctionalGroup(s) - Location , Location - Base/Group
    // What can we do with this?

    // I am hoping to achieve something using only simple-bonded non-cyclic stuff, but let's see how far is that, eh?

    // So the idea so far is that we tokenize and parse the above-mentioned blob, but if there's our good old friend ";"**
    // after a string literal, well let's parse one more, eh?

    // 1, 3, 7-Trimethylpurine-2,6-dione ";" (6aR,9R)- N,N- diethyl- 7-methyl- 4,6,6a,7,8,9- hexahydroindolo- [4,3-fg] quinoline- 9-carboxamide
    // hopefully



    public static final Pattern ALKANE_PATTERN = Pattern.compile(
            String.format(
                    "(?<root>%s)?",
                    Regex.ALKANE.pattern
            )
    );

    public static final Pattern MULTI_PATTERN = Pattern.compile(
            String.format(
                    "(?<multiplier>%s)?(?<radical>%s)+%s",
                    Regex.MULTIPLIER.pattern,
                    Regex.RADICAL.pattern,
                    ALKANE_PATTERN
            )
    );
    public static final Pattern ALKENE_PATTERN = Pattern.compile(
            String.format(
                    ".*(?<root>%s)$",
                    Regex.ALKENE.pattern
            )
    );

    public static final Pattern ALKYNE_PATTERN = Pattern.compile(
            String.format(
                    ".*(?<root>%s)$",
                    Regex.ALKYNE.pattern
            )
    );

    private boolean eof;
    private char character;

    private int startPosition;
    private int endPosition;

    private Reader source;
    private StringBuilder bob;
    private Pile<Token> compoundPile = new Pile<>();

    public Lexer (String string) throws OxyLexerException {

        source = new Reader(string.toLowerCase());

        try {

            character = source.read();

        } catch(OxyReaderException ore) {

            ore.printStackTrace();
            throw new OxyLexerException("Reader error");

        }

        bob = new StringBuilder();

    }

    // ---------

    public Token newErrorToken(int left, int right, String badBody) {
        return new Token(left, right, Element.craft(badBody, Tokens.Error));
    }

    // ---------

    public Token newStringToken(int left, int right, String literal) {
        return new Token(left, right, Element.craft(literal, Tokens.String));
    }

    public Token newNumericalToken(int left, int right, String number) {
        return new Token(left, right, Element.craft(number, Tokens.Location));
    }

    // ---------

    public Token newAllotToken(int left, int right, String allotr) {
        return new Token(left, right, Element.craft(allotr, Tokens.Allotr));
    }

    public Token newEqualrToken(int left, int right, String equalr) {
        return new Token(left, right, Element.craft(equalr, Tokens.Equalr));
    }

    public Token newGreatrToken(int left, int right, String greatr) {
        return new Token(left, right, Element.craft(greatr, Tokens.Greatr));
    }

    public Token newLessrToken(int left, int right, String lessr) {
        return new Token(left, right, Element.craft(lessr, Tokens.Lessr));
    }

    public Token newAskrToken(int left, int right, String askr) {
        return new Token(left, right, Element.craft(askr, Tokens.Askr));
    }

    // ---------

    public Token newCommaToken(int left, int right, String comma) {
        return new Token(left, right, Element.craft(comma, Tokens.Comma));
    }

    public Token newDashToken(int left, int right, String dash) {
        return new Token(left, right, Element.craft(dash, Tokens.Dash));
    }

    public Token newMultiplierToken(int left, int right, String multiplier) {
        return new Token(left, right, Element.craft(multiplier, Tokens.Multiplier));
    }

    public Token newRadicalToken(int left, int right, String radical) {
        return new Token(left, right, Element.craft(radical, Tokens.Radical));
    }

    public Token newAlkaneToken(int left, int right, String alkane) {
        return new Token(left, right, Element.craft(alkane, Tokens.Alkane));
    }
    public Token newAlkeneToken(int left, int right, String alkene) {
        return new Token(left, right, Element.craft(alkene, Tokens.Alkene));
    }
    public Token newAlkyneToken(int left, int right, String alkyne) {
        return new Token(left, right, Element.craft(alkyne, Tokens.Alkyne));
    }

    public Token newRootToken(int left, int right, String root) {
        return new Token(left, right, Element.craft(root, Tokens.Root));
    }

    // ---------

    public Token newFullcolonToken(int left, int right, String fullColon) {
        return new Token(left, right, Element.craft(fullColon, Tokens.Fullcolon));
    }

    public Token newStartParToken(int left, int right, String startPar) {
        return new Token(left, right, Element.craft(startPar, Tokens.StartPar));
    }
    public Token newEndParToken(int left, int right, String endPar) {
        return new Token(left, right, Element.craft(endPar, Tokens.EndPar));
    }
    public Token newStartBraToken(int left, int right, String startBra) {
        return new Token(left, right, Element.craft(startBra, Tokens.StartBra));
    }
    public Token newEndBraToken(int left, int right, String endBra) {
        return new Token(left, right, Element.craft(endBra, Tokens.EndBra));
    }
    public Token newSemicolonToken(int left, int right, String semiColon) {
        return new Token(left, right, Element.craft(semiColon, Tokens.Semicolon));
    }

    public Token newPolyBlockInizio(int left, int right, String inizio) {
        return new Token(left, right, Element.craft(inizio, Tokens.PolyBlockInizio));
    }

    public Token newPolyBlockFinizio(int left, int right, String finizio) {
        return new Token(left, right, Element.craft(finizio, Tokens.PolyBlockFinizio));
    }
    // ---------

    public Token getNextToken(){

        if (!compoundPile.empty()) {
            return compoundPile.pop();
        }

        if (bob == null) {
            bob = new StringBuilder(); // for my best friend Lewd Block
        } else {
            bob.setLength(0);
        }

        if (eof) {
            return null;
        }

        try {
            while (Character.isWhitespace(character)) {
                character = source.read();
            }

        } catch (Exception eh) {
            eof = true;
            return getNextToken();
        }

        startPosition = source.getPosition();
        endPosition = startPosition - 1;

        if (Character.isDigit(character)) {

            try {

                do {

                    endPosition++;
                    bob.append(Character.toLowerCase(character));
                    character = source.read();

                } while (Character.isDigit(character));

            } catch (Exception eh) {

                eof = true;
            }

            return newNumericalToken(startPosition, endPosition, bob.toString());

        }

        if (character == '\\') {
            // escape route, lol
        }

        if (character == '(') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

                return newStartParToken(startPosition, endPosition, bob.toString());

            } catch (Exception eh) {
                eof = true;
            }

        }

        if (character == ')') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

                return newEndParToken(startPosition, endPosition, bob.toString());

            } catch (Exception eh) {
                eof = true;
            }

        }

        if (character == '~') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

                if (character == '[') {
                    endPosition++;
                    bob.append(character);
                    character = source.read();

                    return newPolyBlockInizio(startPosition, endPosition, bob.toString());
                }

            } catch (Exception eh) {
                eof = true;
            }

        }
        if (character == '[') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

                return newStartBraToken(startPosition, endPosition, bob.toString());

            } catch (Exception eh) {
                eof = true;
            }

        }

        if (character == ']') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

                if (character == '~') {
                    endPosition++;
                    bob.append(character);
                    character = source.read();

                    return newPolyBlockFinizio(startPosition, endPosition, bob.toString());
                }

            } catch (Exception eh) {
                eof = true;
            }

            return newEndBraToken(startPosition, endPosition, bob.toString());

        }

        if (character == ',') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {

                eof = true;
            }

            return newCommaToken(startPosition, endPosition, bob.toString());
        }

        if (character == '=') {

            try {

                endPosition++;
                bob.append(character);
                character = source.read();

                if (character == '=') {
                    endPosition++;
                    bob.append(character);
                    character = source.read();

                    return newEqualrToken(startPosition, endPosition, bob.toString());
                }

            } catch (Exception eh) {
                eof = true;
            }

            return newAllotToken(startPosition, endPosition, bob.toString());
        }

        if (character == '<') {

            try {

                endPosition++;
                bob.append(character);
                character = source.read();

                if (character == '-') {
                    endPosition++;
                    bob.append(character);
                    character = source.read();

                    return newAllotToken(startPosition,endPosition, bob.toString());
                }


            } catch (Exception eh) {
                eof = true;
            }

            return newLessrToken(startPosition, endPosition, bob.toString());

        }

        if (character == '>') {

            try {

                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {
                eof = true;
            }

            return newGreatrToken(startPosition, endPosition, bob.toString());

        }

        if (character == '?') {

            try {

                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {
                eof = true;
            }

            return newAskrToken(startPosition, endPosition, bob.toString());
        }

        if (character == ';') {

            try {
                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {

                eof = true;

                if (source.getPosition() >= source.getLength()) {
                    return newSemicolonToken(startPosition, endPosition, ";");
                }

                return newErrorToken(startPosition, endPosition, bob.toString());

            }

            return newSemicolonToken(startPosition, endPosition, bob.toString());
        }

        if (character == '-') {

            try {

                endPosition++;
                bob.append(character);
                character = source.read();

            } catch (Exception eh) {

                eof = true;

            }

            return newDashToken(startPosition, endPosition, bob.toString());

        }

        if (Character.isAlphabetic(character)) {


            try {

                if (Character.isAlphabetic(character)) {

                    do {
                        endPosition++;
                        bob.append(character);
                        character = source.read();

                    } while (Character.isLetterOrDigit(character));

                }

            } catch (Exception eh) {

                eof = true;
            }

            Matcher multiMatcher;

            multiMatcher = ALKANE_PATTERN.matcher(bob);




            multiMatcher = MULTI_PATTERN.matcher(bob);

            if (multiMatcher.matches()) {

                if (multiMatcher.group("root") != null) {

                    compoundPile.push(newAlkaneToken(
                            multiMatcher.start("root") + startPosition,
                            multiMatcher.end("root") + startPosition - 1,
                            multiMatcher.group("root")
                    ));

                }

                if (multiMatcher.group("radical") != null) {
                    compoundPile.push(newRadicalToken(
                            multiMatcher.start("radical") + startPosition,
                            multiMatcher.end("radical") + startPosition - 1,
                            multiMatcher.group("radical")
                    ));

                }

                if (multiMatcher.group("multiplier") != null) {
                    compoundPile.push(newMultiplierToken(
                            multiMatcher.start("multiplier") + startPosition,
                            multiMatcher.end("multiplier") + startPosition - 1,
                            multiMatcher.group("multiplier")
                    ));

                }

                return getNextToken();


            }

            multiMatcher = ALKENE_PATTERN.matcher(bob);

            if (multiMatcher.matches()) {
                return newAlkeneToken(
                        multiMatcher.start("root") + startPosition,
                        multiMatcher.end("root") + startPosition - 1,
                        multiMatcher.group("root")
                );
            }

            multiMatcher = ALKYNE_PATTERN.matcher(bob);

            if (multiMatcher.matches()) {
                return newAlkyneToken(
                        multiMatcher.start("root") + startPosition,
                        multiMatcher.end("root") + startPosition - 1,
                        multiMatcher.group("root")
                );
            }

            if (!bob.isEmpty()) {
                return newStringToken(startPosition, startPosition + bob.length(), bob.toString());
            }

        }

        if (compoundPile.empty()) {
            return null;
        } else {
            return getNextToken();
        }

    }

}
