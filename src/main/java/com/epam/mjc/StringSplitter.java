package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        String connectedDelimeters = "";
        String[] delimetersArray = (String[])delimiters.toArray();
        for(int i = 0; i< delimetersArray.length; i++)
        {
            connectedDelimeters += delimetersArray[i] + "|";
        }
        List<String> returnedList = new ArrayList<>();
        String[] splitStrings = source.split(connectedDelimeters);
        for(String splitString : splitStrings)
            returnedList.add(splitString);
        return  returnedList;

    }
}
