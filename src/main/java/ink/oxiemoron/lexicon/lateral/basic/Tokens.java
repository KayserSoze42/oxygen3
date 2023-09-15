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
    UnoQuote, // '
    DuoQuote, // "
    StartPar, // (
    EndPar, // )
    StartBra, // [
    EndBra, // ]
    Allotr, // = <-
    Addr, // +
    Equalr, // ==
    Greatr, // >
    Lessr, // <
    Askr, // ?

    Comma, // ,
    Dash, // -

    // Types:

    // Basic tokens
    Numerical,
    String,

    // Compound tokens
    Location,
    Multiplier,
    Radical,
    Root, // hmm
    Alkane,
    Alkene,
    Alkyne,

}
