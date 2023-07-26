package ink.oxiemoron.lexicon.lateral;

import ink.oxiemoron.lexicon.lateral.regex.Regex;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRegex {

    private static final Pattern multiplierPattern = Pattern.compile(Regex.MULTIPLIER.pattern);
    private static final Pattern radicalPattern = Pattern.compile(Regex.RADICAL.pattern);
    private static final Pattern rootPattern  = Pattern.compile(Regex.ROOT.pattern);

    @Test
    public void test_MULTIPLIER_withValid_match() {
        final String[] validMultipliers = new String[]{
                "mono", "di", "tri", "tetra", "penta", "hexa", "hepta", "octa", "nona", "deca"
        };

        for (String validMultiplier: validMultipliers) {
            assertTrue(multiplierPattern.matcher(validMultiplier).matches());
        }
    }

    @Test
    public void test_MULTIPLIER_withInvalid_noMatch() {
        final String[] validMultipliers = new String[]{
                "mano", "da", "tree", "tetrapack", "pentakill", "hexx", "7even", "octarina", "NaN", "childs"
        };

        for (String validMultiplier: validMultipliers) {
            assertFalse(multiplierPattern.matcher(validMultiplier).matches());
        }
    }

    @Test
    public void test_RADICAL_withValid_match() {
        final String[] validMultipliers = new String[]{
                "methyl", "ethyl", "propyl", "butyl", "pentyl", "hexyl", "heptyl", "octyl", "nonyl", "decyl"
        };

        for (String validMultiplier: validMultipliers) {
            assertTrue(radicalPattern.matcher(validMultiplier).matches());
        }
    }

    @Test
    public void test_RADICAL_withInvalid_noMatch() {
        final String[] validMultipliers = new String[]{
                "mano", "da", "tree", "tetrapack", "pentakill", "hexx", "7even", "octarina", "NaN", "childs"
        };

        for (String validMultiplier: validMultipliers) {
            assertFalse(radicalPattern.matcher(validMultiplier).matches());
        }
    }

    @Test
    public void test_ROOT_withValid_match() {
        final String[] validMultipliers = new String[]{
                "methane", "ethane", "propane", "butane", "pentane", "hexane", "heptane", "octane", "nonane", "decane"
        };

        for (String validMultiplier: validMultipliers) {
            assertTrue(rootPattern.matcher(validMultiplier).matches());
        }
    }

    @Test
    public void test_ROOT_withInvalid_noMatch() {
        final String[] validMultipliers = new String[]{
                "mano", "da", "tree", "tetrapack", "pentakill", "hexx", "7even", "octarina", "NaN", "childs"
        };

        for (String validMultiplier: validMultipliers) {
            assertFalse(rootPattern.matcher(validMultiplier).matches());
        }
    }

}
