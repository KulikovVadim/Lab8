package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.Fraction.*;

public class FromString {
    public static void actions(String Operation) {
        Pattern ExpressionOfFractions = Pattern.compile("(-*\\d+)/(\\d+)([+*:-])\\s*(-*\\d+)/(\\d+)");
        Matcher Expression = ExpressionOfFractions.matcher(Operation);

        String Simvol;

        if (Expression.find()) {
            int FromStringNumeratorFirst = Integer.parseInt(Expression.group(1));
            int FromStringDenominatorFirst = Integer.parseInt(Expression.group(2));
            int FromStringNumeratorSecond = Integer.parseInt(Expression.group(4));
            int FromStringDenominatorSecond = Integer.parseInt(Expression.group(5));
            Fraction fraction1 = new Fraction(FromStringNumeratorFirst, FromStringDenominatorFirst);
            Fraction fraction2 = new Fraction(FromStringNumeratorSecond, FromStringDenominatorSecond);
            Simvol = Expression.group(3);
            switch (Simvol){
                case "+":
                    sum(fraction1, fraction2);
                    final_fraction();
                    FractionToCorrctForm();
                    System.out.println("(+)");
                    break;
                case "-":
                    antisum(fraction1, fraction2);
                    final_fraction();
                    FractionToCorrctForm();
                    System.out.println("(-)");
                    break;
                case "*":
                    umnojenie(fraction1, fraction2);
                    final_fraction();
                    FractionToCorrctForm();
                    System.out.println("(*)");
                    break;
                case ":":
                    delenie(fraction1, fraction2);
                    final_fraction();
                    FractionToCorrctForm();
                    System.out.println("(:)");
                    break;
            }
        } else {
            System.out.println("Вы ввели неправильные значения попробуйте снова");
        }
    }
}
