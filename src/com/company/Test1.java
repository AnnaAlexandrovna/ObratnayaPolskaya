package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test1 {

    ArrayList operation = new ArrayList();
    LinkedList leksem = new LinkedList ();
    String stringOfNumber = "";
    String stringOfOperation = "";
    String allSimbol = "";
    String firstSimbol = "";

    public String isNumber(String string) {

        allSimbol = string;
        if (allSimbol.length() != 0) {
            firstSimbol = allSimbol.substring(0, 1);

            if (firstSimbol.equals("1") || firstSimbol.equals("0") || firstSimbol.equals("2") || firstSimbol.equals("3") ||
                    firstSimbol.equals("4") || firstSimbol.equals("5")
                    || firstSimbol.equals("6") || firstSimbol.equals("7") || firstSimbol.equals("8") || firstSimbol.equals("9")) {

                stringOfNumber = stringOfNumber + firstSimbol;

                allSimbol = allSimbol.substring(1, allSimbol.length());
                if (allSimbol.length() != 0) {
                    firstSimbol = allSimbol.substring(0, 1);
                    isNumber(allSimbol);
                }
            }

            if (stringOfNumber.length() != 0) {
                leksem.add(stringOfNumber);
            }
            stringOfNumber = "";
            firstSimbol = "";
        }
        return allSimbol;
    }

    public String isOperation(String string) {

        allSimbol = string;
        if (allSimbol.length() != 0) {

            firstSimbol = allSimbol.substring(0, 1);

            if (firstSimbol.equals("+") || firstSimbol.equals("-")) {

                stringOfOperation = stringOfOperation + firstSimbol;

                allSimbol = allSimbol.substring(1, allSimbol.length());
                if (allSimbol.length() != 0) {
                    firstSimbol = allSimbol.substring(0, 1);

                    isOperation(allSimbol);
                }
            }

            if (stringOfOperation.length() != 0) {
                operation.add(stringOfOperation);
            }
            stringOfOperation = "";
            firstSimbol = "";
        }
        return allSimbol;
    }

    public void madeTwoArray(String string) {
        if (string.length() != 0) {
            string = isNumber(string);
            string = isOperation(string);
            int len1 = string.length();
            string = isNumber(string);
            int len2 = string.length();
            if (len1 !=0 && len1 == len2) {
                System.out.println("Извините, строка: " + string + " некорректна");
                string = "";
            }
            madeTwoArray(string);
        }
    }

    public String count (){
        String result = "Вычисление не выполнено";
        int opSize = operation.size();
        if (opSize!=0){
            for (int i = 0; i < opSize; i++) {
                if (leksem.size() != 0) {
                    if (leksem.size() >= 2) {
                        String operation1 = (String) operation.get(0);
                        operation.remove(0);
                        //2 символа для выполнения бинарной операции
                        int term1 = Integer.parseInt((String) leksem.get(0));
                        leksem.remove(0);
                        int term2 = Integer.parseInt((String) leksem.get(0));
                        leksem.remove(0);

                        if (operation1.equals("+")) {

                            int res = term1 + term2;
                            result = res + "";
                            leksem.add(0, result);
                        }
                        if (operation1.equals("-")) {

                            int res = term1 - term2;
                            result = res + "";
                            leksem.add(0, result);
                        }
                    } else {
                        result = "Недостаточно цифр для выполнения бинарной операции";
                        System.out.println("Недостаточно цифр для выполнения бинарной операции");
                    }

                } else {
                    result = "В строке не задано цифр";
                    System.out.println("В строке не задано цифр");
                }
            }
        } else {
            result = "В строке не задано операций";
            System.out.println("В строке не задано операций");
        }

        return result;
    }


}
