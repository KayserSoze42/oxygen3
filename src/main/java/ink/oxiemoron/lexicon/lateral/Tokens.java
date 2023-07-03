package ink.oxiemoron.lexicon.lateral;

public enum Tokens {
    Error,Location,Comma,Dash,Multiplier,Radical,Root // LGBTQWERTY+ aka Live and let love
    // Not sure if there should be a generic functional group type/kind abstraction instead of triple As,
    // Will see when we start compilin' (to what?!)


    // restructured a bit
    // not sure if everything can classify as a radical

    //   1,2-dimethylpropane and 1,2-dimethylpropane accessories


    //                 |structure|
    //         |structure| left / kid numero uno
    // |Location 1[l:0, r:0]| |Comma ,[l:1, r:1]| |Location 2[l:2, r:2]| |Dash -[l:3, r:3]| |Multiplier di[l:4, r:5]| |Radical methyl[l:6, r:11]|

    //         |structure| and right / the "other" kid
    // |Radical propane[l:12, r:18]|

    // This should be the parse tree as I see and understand
}
