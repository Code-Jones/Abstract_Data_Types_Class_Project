package com.abstractdata;

import com.abstractdata.Util.MyQueue;
import com.abstractdata.Util.MyStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Scanner inFile;

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        MyQueue<String> errorsQ = new MyQueue<>();


        try {
            String fileName = args[0];
//            String fileName = ".\\sample2.xml";
            File file = new File(fileName);
            inFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int lineCounter = 0;
        while (inFile.hasNext()) {
            String line = inFile.nextLine().trim();
            lineCounter++;

            if (!checkForSyntaxErrors(line, lineCounter)) {
                errorsQ.add(line);
                continue;
            }
            if (isPrologTag(line)) {
                continue;
            }
            if (isStartTag(line)) {
                stack.push(line);
                continue;
            }

            String tag = getTagName(line);
            if (isEndTage(line)) {
                if (tag.equals(getTagName(String.valueOf(stack.peek())))) {
                    stack.pop();
                } else if (tag.equals(getTagName(String.valueOf(errorsQ.peek())))) {
                    errorsQ.remove();
                }
//                else if (stack.isEmpty()) {
//                    errorsQ.add(line);
//                }
            else {
                if (!line.matches(".*\\s.*") && line.charAt(1) == '/') {
                    continue;
//                    stack.pop();
                }
                }
            }
        }

        if (errorsQ.isEmpty()) {
            if (stack.isEmpty()) {
                while (stack.size() != 0) {
                    if (stack.peek() != null) {
                        System.out.println("Error Type : Not closed tag before : " + getTagName(String.valueOf(stack.pop())));
                    } else stack.pop();
                }
            }
            if (errorsQ.isEmpty()) {
                while (errorsQ.isEmpty()) {
                    System.out.println("Error Type : Not proper line : " + errorsQ.remove());
                }
            }
        } else {
            System.out.println("No errors to be seen.");
        }

    }





    private static String getTagName(String line) {
        if (isStartTag(line) || isSelfClosingTag(line)) {
            String[] ss = line.substring(1, line.length() - 1).split(" ");
            return ss[0];
        } else if (isEndTage(line)) {
            return line.substring(2, line.length() - 1);
        }
        return "Error";
    }

    private static boolean checkForSyntaxErrors(String line, int lineCounter) {
        // not bothering with prolog line because that's what it says in the assignment
        boolean good = true;
        if (checkIfNested(line)) {
            if (checkFirstLastTag(line)) {
                System.out.println("Error on line " + lineCounter + ": Error type : Syntax " + ": Bad nested tags : " + line.charAt(1) + " : " + line.charAt(line.length() - 2));
                good = false;
            }
            if (!checkForInnerTags(line, lineCounter)) {
                System.out.println("Error on line " + lineCounter + ": Error type : Syntax " + ": Inner tag issue");
                good = false;
            }
        } else {
            if (brackets(line)) {
                if (line.charAt(1) == '<' || line.charAt(line.length() - 2) == '>') {
                    System.out.println("Error on line " + lineCounter + ": Error type : Syntax " + ": Extra bracket");
                    good = false;
                }
            } else {
                System.out.println("Error on line " + lineCounter + ": Error type : Syntax " + ": Not closed brackets");
                good = false;
            }
        }
        return good;
    }



    private static boolean checkForInnerTags(String line, int lineCounter) {
        // should already be checking for brackets and if nested and first/last tag
        String sub = line.substring(3, line.length() - 4);
        if (sub.contains("<") || sub.contains("</")) {
            char tag = sub.charAt(sub.indexOf('<') + 1);
            if (sub.substring(sub.indexOf('>')).indexOf(tag) != -1) {
                System.out.println("Error on line " + lineCounter + ": Error type : Syntax " + ": Unclosed tag : " + tag);
                return false;
            }
        }
        return true;
    }

    private static boolean checkFirstLastTag(String line) {
        // should already be checking for brackets and if nested
        return line.charAt(1) != line.charAt(line.length() - 2);
    }

    private static boolean checkIfNested(String line) {
        return brackets(line) && Character.isLowerCase(line.charAt(1)) && Character.isLowerCase(line.charAt(line.length() - 2));
    }

    private static boolean isEndTage(String line) {
        return brackets(line) && line.charAt(1) == '/';
    }

    private static boolean isPrologTag(String line) {
        // Check if it's a prolog tag (i.e. <?xml version="1.0" encoding="UTF-8"?>)
        return brackets(line) && (line.charAt(1) == '?' && line.charAt(line.length() - 2) == '?');
    }

    private static boolean isSelfClosingTag(String line) {
        // Check if it's self closing (i.e. <tag />)
        return brackets(line) && line.charAt(1) != '/' && line.charAt(line.length() - 2) == '/';
    }

    private static boolean isStartTag(String line) {
        // Check if it's a starting tag (i.e. <tag>)
        final char c = line.charAt(line.length() - 2);
        return brackets(line) && line.charAt(1) != '/' && (c != '/' && c != '?');
    }

    private static boolean brackets(String line) {
        return line.charAt(0) == '<' && line.charAt(line.length() - 1) == '>';
    }
}

