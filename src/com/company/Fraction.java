package com.company;

public class Fraction {

    private int numerator;
    private int denominator;
    private static int total_numerator;
    private static int total_denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public static void mistake(int denominator_first, int denominator_second) {
        if (denominator_first == 0 && denominator_second == 0) {
            throw new ArithmeticException("Так нельзя, вы делите на ноль");
        }
    }

    public static void sum(Fraction fraction1, Fraction fraction2) {
        total_denominator = fraction1.denominator * fraction2.denominator;
        fraction1.numerator *= fraction2.denominator;
        fraction2.numerator *= fraction1.denominator;
        total_numerator = fraction1.numerator + fraction2.numerator;
    }

    public void sum(Fraction fraction1) {
        total_denominator = this.denominator * fraction1.denominator;
        this.numerator *= fraction1.denominator;
        fraction1.numerator *= this.denominator;
        total_numerator = this.numerator + fraction1.numerator;
    }

    public static void antisum(Fraction fraction1, Fraction fraction2) {
        total_denominator = fraction1.denominator * fraction2.denominator;
        fraction1.numerator *= fraction2.denominator;
        fraction2.numerator *= fraction1.denominator;
        total_numerator = fraction1.numerator - fraction2.numerator;
    }

    public void antisum(Fraction fraction1) {
        total_denominator = this.denominator * fraction1.denominator;
        this.numerator *= fraction1.denominator;
        fraction1.numerator *= this.denominator;
        total_numerator = fraction1.numerator - this.numerator;
    }

    public static void umnojenie(Fraction fraction1, Fraction fraction2) {
        total_numerator = fraction1.numerator * fraction2.numerator;
        total_denominator = fraction1.denominator * fraction2.denominator;

    }

    public void umnojenie(Fraction fraction1) {
        total_numerator = this.numerator * fraction1.numerator;
        total_denominator = this.denominator * fraction1.denominator;
    }

    public static void delenie(Fraction fraction1, Fraction fraction2) {
        total_numerator = fraction1.numerator * fraction2.denominator;
        total_denominator = fraction1.denominator * fraction2.numerator;
    }

    public void delenie(Fraction fraction1) {
        total_numerator = fraction1.numerator * this.denominator;
        total_denominator = fraction1.denominator * this.numerator;
    }

    public static void final_fraction() {
        for (int i = 1; i < 999999; i++) {
            if (total_denominator % i == 0 && total_numerator % i == 0) {
                total_numerator = total_numerator / i;
                total_denominator = total_denominator / i;
            }
        }
        for (int i = 1; i < 999999; i++) {
            if (total_denominator % i == 0 && total_numerator % i == 0) {
                total_numerator = total_numerator / i;
                total_denominator = total_denominator / i;
            }
        }
    }

    public static void FractionToCorrctForm() {
        if (total_numerator > 0 && total_denominator > 0) {
            System.out.println("Ваша дробь равна (=) " + total_numerator + "/" + total_denominator);
        }
        else if (total_numerator < 0 && total_denominator < 0) {
            total_numerator *= -1;
            total_denominator *= -1;
            System.out.println("Ваша дробь равна (=) " + total_numerator + "/" + total_denominator);
        }
        else if ((total_numerator > 0 && total_denominator < 0)) {
            total_numerator *= -1;
            total_denominator *= -1;
            System.out.println("Ваша дробь равна (=) " + total_numerator + "/" + total_denominator);
        }
        else if (total_numerator < 0 && total_denominator > 0) {
            System.out.println("Ваша дробь равна (=)" + total_numerator + "/" + total_denominator);
        }
        else if (total_numerator == 0 && total_denominator > 0 || total_denominator < 0)
            System.out.println("Ваша дробь равна (=) 0");
        else if (total_denominator == 0) {
            System.out.println("Ваша дробь не определена, вы делите на ноль");
        }
    }

    public static void choice(String answer, String answer2, Fraction fraction1, Fraction fraction2) {
        switch (answer) {
            case "сложение":
                if (answer2.equals("1")) {
                    fraction2.sum(fraction1);
                    final_fraction();
                    FractionToCorrctForm();
                }
                if (answer2.equals("2")) {
                    sum(fraction1, fraction2);
                    final_fraction();
                    FractionToCorrctForm();
                }
                if (!(answer2.equals("1") || answer2.equals("2"))) {
                    System.out.println("вы ввели неправильное значение");
                }
                break;
            case "вычитание":
                if (answer2.equals("1")) {
                    fraction2.antisum(fraction1);
                    final_fraction();
                    FractionToCorrctForm();

                }
                if (answer2.equals("2")) {
                    antisum(fraction1, fraction2);
                    final_fraction();
                    FractionToCorrctForm();

                }
                if (!(answer2.equals("1") || answer2.equals("2"))) {
                    System.out.println("вы ввели неправильное значение");
                }
                break;
            case "умножение":
                if (answer2.equals("1")) {
                    fraction2.umnojenie(fraction1);
                    final_fraction();
                    FractionToCorrctForm();

                }
                if (answer2.equals("2")) {
                    umnojenie(fraction1, fraction2);
                    final_fraction();
                    FractionToCorrctForm();

                }
                if (!(answer2.equals("1") || answer2.equals("2"))) {
                    System.out.println("вы ввели неправильное значение");
                }
                break;
            case "деление":
                if (answer2.equals("1")) {
                    fraction2.delenie(fraction1);
                    final_fraction();
                    FractionToCorrctForm();

                }
                if (answer2.equals("2")) {
                    delenie(fraction1, fraction2);
                    final_fraction();
                    FractionToCorrctForm();

                }
                if (!(answer2.equals("1") || answer2.equals("2"))) {
                    System.out.println("вы ввели неправильное значение");
                }
                break;
            default:
                System.out.println("Вы не ввели ни одно из ключевых слов, попробуйте снова");
        }
    }
}
