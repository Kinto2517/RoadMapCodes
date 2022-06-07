package com.company;

public class Casio_Fx_300es {

        public int add(int x, int y) {
            return x + y;
        }

        public int substract(int x, int y) {
            return x - y;
        }

        public int multiply(int x, int y) {
            return x * y;
        }

        public int divide(int x, int y) {

            if (y == 0) {
                System.out.println("Denominator cant be zero!");
                return 0;

            }
            return x / y;
        }

        public int pow (int x, int y) {
            return (int) Math.pow(x, y);
        }

        public int factorial(int x) {
            int toplam = 1;

            for (int i = 1; i <= x; i++) {
                toplam *= i;
            }
            return toplam;
        }

        public int mood(int x, int y) {
            return x % y;
        }

        public int abs(int x) {
            return Math.abs(x);
        }

        public String derivate(int factor, int degree) {

            System.out.println("İfade -> f(x) = " + factor + "x^" + degree);

            if (factor == 0) {
                return "f'(x) = 0";
            } else {
                return "f'(x)= " + (degree*factor) + "x^" + (degree-1);
            }
        }

        public String integral(int factor, int degree) {
            if ( degree != 0) {
                System.out.println("İfade -> f(x) = ʃ " + factor + "x^" + degree);
            } else
                System.out.println("İfade -> f(x) = ʃ " + factor);

            if (factor != 0) {
                return factor + "(x^" + (degree+1) + ")" + "/" + (degree+1);
            } else
                return "0";
        }
    }

