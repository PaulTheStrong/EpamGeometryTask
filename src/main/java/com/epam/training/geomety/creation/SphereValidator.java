package com.epam.training.geomety.creation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SphereValidator {

    public static final String VALID_STRING_PATTERN = "(-?(0|([1-9][0-9]*))\\.?[0-9]* ){3}(-?(0|([1-9][0-9]*))\\.?[0-9]*)";

    public boolean validate(String line) {
        Pattern validPattern = Pattern.compile(VALID_STRING_PATTERN);
        Matcher validStringMatcher = validPattern.matcher(line);
        return validStringMatcher.matches();
    }
}
