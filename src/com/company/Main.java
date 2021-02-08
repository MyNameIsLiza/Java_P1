package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.DecimalFormat;

//Завдання 1. Написати програму - піднесення числа n до m-ую ступеня. Вхідні дані поступають з клавіатури. Результат виводиться на екран. Передбачити обробку помилок.
public class Main {

    public static void main(String[] args) {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String format = "0.";
            int xxx = 1;
            double c = 0;
            System.out.println("Введіть кількість знаків, які ви хочете бачити після коми");
            c = input_int(reader, c);
            for(int i = 0; i<c; i++) {format +="#";xxx*=10;}
            DecimalFormat df = new DecimalFormat(format);
            //System.out.println(df.format(0.0002222));


            double m = 0, n = 0;
            while (true) {
                double result;
                System.out.println("Введіть перше число");
                m = input_double(reader, m);
                System.out.println("Введіть друге число");
                n = input_double(reader, n);

                //if (m < 0 && n < 0) result = -Math.pow(m, n);
                //else result = Math.pow(m, n);
                result = Math.pow(m, n);
                if (Double.toString(m).endsWith(".0")) {
                    String mm = Double.toString(m).substring(0, Double.toString(m).length() - 2);
                    System.out.print(mm + " ^ ");
                } else System.out.print(m + " ^ ");
                if (Double.toString(n).endsWith(".0")) {
                    String nn = Double.toString(n).substring(0, Double.toString(n).length() - 2);
                    System.out.print(nn + " = ");
                } else System.out.print(n + " = ");

                String r;

                if (Double.toString(result).endsWith(".0")) {

                    r = Double.toString(result).substring(0, Double.toString(result).length() - 2);

                    System.out.println(r);

                } else if (Double.toString(result).equals("NaN")) {

                    if (Math.pow(-m, n) < (1. / xxx))
                        r = df.format(1. / xxx) + " * i";
                    else
                        r = df.format(Math.pow(-m, n)) + " * i";
                    r = r.replace(",",".");
                    System.out.println(r);
                } else {
                    //r = Double.toString(result);
                    if (result < (1. / xxx)) r = Double.toString(1. / xxx);
                    else {
                        r = df.format(result);
                        r = r.replace(",", ".");
                    }
                    System.out.println(r);
                }
            }

        } catch (IOException e) {
            System.out.println("QoQ");
        }
    }
    public static double input_double(BufferedReader reader, double m) throws IOException {
        String t = reader.readLine();
        try {
            m = Double.parseDouble(t);
        }catch (NumberFormatException e) {
            System.out.println("Невдача, введіть число ще раз");
            m = input_double(reader, m);
        }
        return m;
    }
    public static double input_int(BufferedReader reader, double m) throws IOException {
        String t = reader.readLine();
        try {
            m = Integer.parseInt(t);
            if(m<0){
                System.out.println("Невдача, кількість знаків після коми не може бути від`ємна,\n введіть число ще раз");
                m = input_int(reader, m);
            }
        }catch (NumberFormatException e) {
            System.out.println("Невдача, введіть число ще раз");
            m = input_int(reader, m);
        }
        return m;
    }


}
