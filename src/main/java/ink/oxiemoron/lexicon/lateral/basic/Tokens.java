package ink.oxiemoron.lexicon.lateral.basic;

public enum Tokens {

    // Control flow tokens
    Error,

    PolyBlockInizio,
    PolyBlockFinizio,

    HalfSemiColon, // ;
    HalfFullColon, // :
    FullSemiColon, // ;;
    FullFullColon, // ::

    Larrow, // <-
    Rarrow, // ->

    UnoQuote, // '
    DuoQuote, // "

    StartPar, // (
    EndPar, // )
    StartBra, // [
    EndBra, // ]

    Allotr, // =
    Addr, // +
    Equalr, // ==
    Greatr, // >
    Grequlr, // >=
    Lessr, // <
    Lessqlr, // =<
    Askr, // ?

    Comma, // ,
    Dash, // -

    // Types:

    // Basic tokens
    Numerical,
    String,

    // Compound tokens
    Location, // hmda
    Multiplier,
    Radical,
    Root, // hmm
    Alkane,
    Alkene,
    Alkyne,

}
