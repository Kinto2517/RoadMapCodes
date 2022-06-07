package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Casio_Fx_300es calc = new Casio_Fx_300es();

        System.out.println("1- Add\n2-Substract\n3-Multiply" +
                "\n4-Divide\n5-Pow" +
                "\n6-Factorial\n7-Mood\n" +
                "8-Abs\n" +
                "9-Deriative\n10-Integral");

        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int x,y;
        switch (choice) {
            case 1:
                System.out.print("First Number: ");
                x = sc.nextInt();
                System.out.print("Last Number: ");
                y = sc.nextInt();
                System.out.println(calc.add(x,y));
                break;

            case 2:
                System.out.print("First Number: ");
                x = sc.nextInt();
                System.out.print("Last Number: ");
                y = sc.nextInt();
                System.out.println(calc.substract(x,y));
                break;
            case 3:
                System.out.print("First Number: ");
                x = sc.nextInt();
                System.out.print("Last Number: ");
                y = sc.nextInt();
                System.out.println(calc.multiply(x,y));
                break;
            case 4:
                System.out.print("First Number: ");
                x = sc.nextInt();
                System.out.print("Last Number: ");
                y = sc.nextInt();
                System.out.println(calc.divide(x,y));
                break;
            case 5:
                System.out.print("Number: ");
                x = sc.nextInt();
                System.out.print("Power: ");
                y = sc.nextInt();
                System.out.println(calc.pow(x,y));
                break;
            case 6:
                System.out.print("Fact Number: ");
                x = sc.nextInt();
                System.out.println(calc.factorial(x));
                break;
            case 7:
                System.out.print("First Number: ");
                x = sc.nextInt();
                System.out.print("Mod: ");
                y = sc.nextInt();
                System.out.println(calc.mood(x,y));
                break;
            case 8:
                System.out.print("Absolute: ");
                x = sc.nextInt();
                System.out.println(calc.abs(x));
                break;
            case 9:
                System.out.print("factor: ");
                x = sc.nextInt();
                System.out.print("degree: ");
                y = sc.nextInt();
                System.out.println(calc.derivate(x,y));
                break;
            case 10:
                System.out.print("factor: ");
                x = sc.nextInt();
                System.out.print("degree: ");
                y = sc.nextInt();
                System.out.println(calc.integral(x,y));
                break;

            default:
                System.out.println("!!ERROR!!");
                break;
        }

    }
}

