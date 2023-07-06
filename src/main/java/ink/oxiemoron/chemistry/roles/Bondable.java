package ink.oxiemoron.chemistry.roles;

public interface Bondable {

     int valency = 1; // a single electron (the functioneer behind the function..) is bondable by itself, am i wrong?

    default void bond() {

        for (int i=0; i < valency; i++) {
            // bondin'
        }

    }

}
