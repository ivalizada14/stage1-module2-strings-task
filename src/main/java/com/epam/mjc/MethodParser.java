package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] splitBySpace = signatureString.split("\\W");
        String accessModifier = "", returnType = "", methodName = "";
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        if(splitBySpace[0] == "public" || splitBySpace[0] == "private" || splitBySpace[0] == "protected")
        {
            accessModifier = splitBySpace[0];
            returnType = splitBySpace[1];
            methodName = splitBySpace[2];
            for(int i = 3; i<splitBySpace.length-1;i+=3)
            {
                arguments.add(new MethodSignature.Argument(splitBySpace[i], splitBySpace[i+1]));
            }
        }
        else
        {
            returnType = splitBySpace[0];
            methodName = splitBySpace[1];
            for(int i = 2; i<splitBySpace.length-1; i+=3)
            {
                arguments.add(new MethodSignature.Argument(splitBySpace[i], splitBySpace[i+1]));
            }
        }
        MethodSignature methodSignature = new MethodSignature(methodName, arguments);
        methodSignature.setReturnType(returnType);
        if(accessModifier!="")
            methodSignature.setAccessModifier(accessModifier);
        return methodSignature;
    }
}
