package com.farhad.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegexDemoTest {

    @Test
    public void escaping_Characters_Test() {

        String text;

        // Escaping Characters
        String regex = "H\\.llo";
        text = "Hallo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H.llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void any_character_Test() {

        String text;

        String regex = "H.llo";
        text = "Hfllo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H4llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H_llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Hllo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void Matching_Any_of_a_Set_of_Characters_Test() {

        String text;

        // Matching Any of a Set of Characters
        String regex = "H[ae]llo";

        text = "Hello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Hallo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Hollo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void Matching_a_Range_of_Characters_Test() {

        String text;

        // Matching a Range of Characters
        String regex = "H[a-e]llo";
        text = "Hello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Hfllo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void matchingBasicTest() {

        String text;

        String regex = "H\\[llo";
        text = "Hello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H[llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
        regex = "H[\\[\\]]llo";
        text = "H[llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H]llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void matching_digits_Test() {

        String text;

        // Matching Digits
        String regex = "H\\dllo";
        text = "H5llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Hello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void matching_Non_digits_Test() {

        String text;

        // Matching Non-digits
        String regex = "H\\Dllo";
        text = "Hfllo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H6llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void matching_word_characters_Test() {

        String text;

        // Matching Word Characters
        String regex = "H\\wllo";
        text = "Hfllo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H6llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H#llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void matching_non_word_characters_Test() {

        String text;

        // Matching Non-word Characters
        String regex = "H\\Wllo";
        text = "Hfllo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H6llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H#llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void end_Of_Line_Test() {

        String text;

        // End of Line (or String)
        String regex = "llo$";
        text = "Hfllo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H6llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H#llo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "H#lo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void beginning_of_Line_Test() {

        String text;

        // Beginning of Line (or String)
        String regex = "^Hel";
        text = "Hel45";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void word_Boundaries_Test() {

        String text;

        // Word Boundaries
        String regex = "\\b";
        text = "Hello";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            log.info("{}:  Found match at: [ {} to {} ]", text, matcher.start(), matcher.end());
        }
        text = "He l45";
        matcher = Pattern.compile(regex).matcher(text);
        ;
        while (matcher.find()) {
            log.info("{}:  Found match at: [ {} to {} ]", text, matcher.start(), matcher.end());
        }

        log.info("");
    }

    @Test
    public void non_word_Boundaries_Test() {

        String text;

        // Non-word Boundaries

        String regex = "\\B";
        text = "Mary had a little lamb";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            log.info("{}:  Found match at: [ {} to {} ]", text, matcher.start(), matcher.end());
        }

        log.info("");
    }

    @Test
    public void quantifiers_Test() {

        String text;

        // Quantifiers * + {n}

        String regex = "He*llo";
        text = "Hllo";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Hello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Heeeeello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");

        regex = "He{2}llo";
        text = "Heello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Hello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");

        regex = "He{2,4}llo";
        text = "Heello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Hello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Heeello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "Heeeeeello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        log.info("");
    }

    @Test
    public void logical_Operators_Test() {

        String text;

        // Logical Operators `and` (implicit) . `or` (|)
        String regex = "[Hh][Ee].*";
        text = "HE123ABc";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));
        text = "hE1ABccccccccdddddd";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");

        regex = "[Hh][Ee].*|Hi|Hello";
        text = "Hello";
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN  `{}`", regex, text,
                (Pattern.matches(regex, text) ? "matched!" : "Not matched!"));

        log.info("");
    }

    @Test
    public void split_Test() {

        String text;

        String regex = "sep";
        text = "A sep Text sep With SEp Many sep Separators";
        Pattern pattern = Pattern.compile(regex);
        String[] elements = pattern.split(text);
        ;
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN Splited To `{}`", regex, text, elements);

        log.info("");

        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        elements = pattern.split(text);
        log.info("GIVEN `{}` AS Pattern, WHEN `{}` Requested, THEN Splited To `{}`", regex, text, elements);

        log.info("");
    }

    @Test
    public void lookingAt_Test() {

        String text;

        // lookingAt
        String regex = "Hello";
        text = "Hello farhad !";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        log.info("GIVEN `{}` AS Pattern, WHEN matche FOR `{}` Requested, THEN  `{}`", regex, text, matcher.matches());
        log.info("GIVEN `{}` AS Pattern, WHEN lookingAt For`{}` Requested, THEN  `{}`", regex, text,
                matcher.lookingAt());

        log.info("");
    }

    @Test
    public void group_Test() {

        // The group with number 0 is always the whole regular expression.
        String regex = "(be)";
        String text =  "to be or not to be again to be or to be or not to be";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            log.info("Found match : {}", matcher.group(1));
            // log.info("Found match at: [ {} to {} ]", matcher.start(), matcher.end());
        }
    }

    @Test
    public void multi_group_Test() {

        // The group with number 0 is always the whole regular expression.
        // The ? means "match as small a number of characters as possible".
        String regex = "(be) (.+?) ";
        String text =  "to be or not to be again to be or to be or not to be";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            log.info("Found match : {} {}", matcher.group(1), matcher.group(2));
            // log.info("Found match at: [ {} to {} ]", matcher.start(), matcher.end());
        }
    }


    @Test
    public void nested_group_Test() {

        // When groups are nested inside each other, they are numbered based on when the left paranthesis of the group is met. 
        // Thus, group 1 is the big group. Group 2 is the group with the expression `be` inside. Group 3 is the group with the 
        // expression .+? inside. 
        String regex = "((be) (.+?)) ";
        String text =  "to be or not to be again to be or to be or not to be";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            log.info("Found match :<{}> <<{}> <{}>>", matcher.group(1), matcher.group(2), matcher.group(3));
            // log.info("Found match at: [ {} to {} ]", matcher.start(), matcher.end());
        }
    }

    @Test
    public void replace_Test() {
        // replaceAll() + replaceFirst()
        String text = 
                "John writes about this, and John Doe writes about that," 
                +
                " and John Wayne writes about everything.";
        String regex =  "((John) (.+?)) ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        log.info("replaceAll: {}", matcher.replaceAll("Joe Blocks "));

        log.info("replaceFirst: {}", matcher.replaceFirst("Joe Blocks "));
    }

    @Test
    public void append_Test() {
        // appendReplacement() + appendTail()        
        String text = 
                "John writes about this, and John Doe writes about that," 
                +
                " and John Wayne writes about everything.";
        String regex =  "((John) (.+?)) ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, "Joe Blocks ");
                log.info("{}", stringBuffer.toString());
        }
        matcher.appendTail(stringBuffer);
        log.info("- {}", stringBuffer.toString());
    
    }   

    @Test
    public void append1_Test() {
        // appendReplacement() + appendTail()        
        String text = 
                "John writes about this, and John Doe writes about that," 
                +
                " and John Wayne writes about everything.";
        String regex =  "((John) (.+?)) ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();
        if( matcher.find() ) {
            matcher.appendReplacement(stringBuffer, "Joe Blocks ");
            log.info("{}", stringBuffer.toString());
        }
        matcher.appendTail(stringBuffer);
        log.info("- {}", stringBuffer.toString());
    
    }   

    @Test
    public void begining_of_line_test() {
        String lines = "Line 1\nLine 2\nLine3\nLine 4 \n";

        {
            // Matcher find() + start() + end()
            Pattern pattern = Pattern.compile("^");
            Matcher matcher = pattern.matcher(lines);
            while (matcher.find()) {
                log.info("Found match at: [ {} to {} ]", matcher.start(), matcher.end());
            }
        }

        {
            String googleUrl = "https://google.com";
            Pattern pattern = Pattern.compile("^https://");
            Matcher matcher = pattern.matcher(googleUrl);
            while (matcher.find()) {
                log.info("Found match at: [ {} to {} ]", matcher.start(), matcher.end());
            }
        }

        {
            String regex = ".*https://.*";
            String googleUrl = "https://google.com";
            boolean matched = Pattern.matches(regex, googleUrl);
            log.info("matched? {}", matched);
        }
    }

    @Test
    public void matcher_Find_Test() {

        String regex = "is";
        String text = "This is the text which is to be searched " +
                "for occurrences of the word 'is'.";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
            log.info("Found: {} at: [ {} to {} ]", count, matcher.start(), matcher.end());
        }
    }
}
