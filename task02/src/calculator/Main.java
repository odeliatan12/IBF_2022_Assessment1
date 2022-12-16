package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome.");
        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator();
        

        while(true){

            System.out.print(">");
            String line = sc.nextLine();
            String[] array = line.split(" ");
            
            Double $last = calculator.getValue();
            if (array[1].equals("+")){
                if(array[0].equals("$last")){
                    calculator.addition($last, Double.parseDouble(array[2]));
                } else if(array[2].equals("$last")){
                    calculator.addition(Double.parseDouble(array[0]), $last);
                } else if (array[0].equals("$last") && array[2].equals("$last")){
                    calculator.addition($last, $last);
                } else {
                    calculator.addition(Double.parseDouble(array[0]), Double.parseDouble(array[2]));
                }
            } else if(array[1].equals("-")){
                if(array[0].equals("$last")){
                    calculator.minus($last, Double.parseDouble(array[2]));
                } else if(array[2].equals("$last")){
                    calculator.minus(Double.parseDouble(array[0]), $last);
                } else if (array[0].equals("$last") && array[2].equals("$last")){
                    calculator.minus($last, $last);
                } else {
                    calculator.minus(Double.parseDouble(array[0]), Double.parseDouble(array[2]));
                }
            } else if(array[1].equals("/")){
                if(array[0].equals("$last")){
                    calculator.divide($last, Double.parseDouble(array[2]));
                } else if(array[2].equals("$last")){
                    calculator.divide(Double.parseDouble(array[0]), $last);
                } else if (array[0].equals("$last") && array[2].equals("$last")){
                    calculator.divide($last, $last);
                } else {
                    calculator.divide(Double.parseDouble(array[0]), Double.parseDouble(array[2]));
                }
            } else if(array[1].equals("*")){
                if(array[0].equals("$last")){
                    calculator.multiply($last, Double.parseDouble(array[2]));
                } else if(array[2].equals("$last")){
                    calculator.multiply(Double.parseDouble(array[0]), $last);
                } else if (array[0].equals("$last") && array[2].equals("$last")){
                    calculator.multiply($last, $last); 
                } else {
                    calculator.multiply(Double.parseDouble(array[0]), Double.parseDouble(array[2]));
                }
            } else {
                System.out.println("Invalid operation.");
            }
            
            if(array.length == 0 && array[0].equals("exit")){
                System.out.println("bye bye");
            } 
        }
        
    }

}
