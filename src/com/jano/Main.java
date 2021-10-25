package com.jano;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        getAppInfo();

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("enter number: ");
            String input = scan.nextLine();
            System.out.print("enter input base: ");
            int inputBase = scan.nextInt();
            System.out.print("enter output base: ");
            int outputBase = scan.nextInt();

            if (inputBase == outputBase) {
                System.out.println("result: " + input);
            } else {
                int inputConversion = toDecimal(input, inputBase);
                Converter converter = new Converter();
                System.out.println("result: " + converter.convert(inputConversion, outputBase));
            }
            System.out.println("Convert Again? [Y or N]");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next().toUpperCase();
            if (answer.equals("Y")) {
                continue;
            } else if (answer.equals("N")) {
                return;
            } else {
                return;
            }
        }
    }

    public static void getAppInfo(){
        System.out.println("N-Base Converter");
        System.out.println("Please provide ONE integer number, enter it numeral system base and provide base of the numeral system to convert to. ");
        System.out.println("note: range of the numeral system [2 -> 36] ");
    }

    public static int toDecimal(String input, int base) {
        return Integer.parseInt(input, base);
    }
}

class Converter {
    private static final char[] symbols = new char[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'};

    public String convert(int num, int base) {
        return convert(num, base, 0, "" );
    }

    private String convert(int num, int base, int position, String result) {
        if (num < Math.pow(base, position + 1)) {
            return symbols[(num / (int)Math.pow(base, position))] + result;
        } else {
            int remainder = (num % (int)Math.pow(base, position + 1));
            return convert(num - remainder, base, position + 1, symbols[remainder / (int)(Math.pow(base, position))] + result);
        }
    }
}
