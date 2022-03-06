package com.company;

import java.util.Scanner;

import static com.company.Fraction.choice;
import static com.company.Fraction.mistake;
import static com.company.FromString.actions;

public class Main {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Каким методом вы хотите получить значение (1. обычным методом. 2. с помощью строк)");
            String answer0 = in.nextLine();

        if (answer0.equals("обычным методом")||answer0.equals("с помощью строк")) {
            switch (answer0) {
                case "обычным методом":
                    System.out.println("Введите числитель первой дроби: ");
                    int numerator_first = in.nextInt();
                    System.out.println("Введите знаменатель первой дроби: ");
                    int denominator_first = in.nextInt();
                    System.out.println("Введите числитель второй дроби: ");
                    int numerator_second = in.nextInt();
                    System.out.println("Введите знаменатель второй дроби: ");
                    int denominator_second = in.nextInt();

                    Scanner inc = new Scanner(System.in);

                    System.out.println("какую операцию вы хотите выполнить (сложение, вычитание, умножение, деление)");
                    String answer = inc.nextLine();
                    System.out.println("каким методом вы хотите найти результат, введите 1 или 2 в зависимости от кол-ва аргументов");
                    String answer2 = inc.nextLine();


                    Fraction fraction1 = new Fraction(numerator_first, denominator_first);
                    Fraction fraction2 = new Fraction(numerator_second, denominator_second);

                    mistake(denominator_first, denominator_second);
                    choice(answer, answer2, fraction1, fraction2);
                    inc.close();
                case "с помощью строк":
                    System.out.println("Введите строчное выражение без пробелов");
                    String exp = in.nextLine();
                    actions(exp);
            }
        }
        else System.out.println("вы неправильно ввели метод, попробуйте еще раз");
            in.close();
        } catch (Exception type) {
            System.out.println("Кажется вы неправильно ввели данные для подсчета значений, попробуйте снова");
        }
    }
}