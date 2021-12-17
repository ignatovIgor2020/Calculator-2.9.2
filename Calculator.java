
import java.util.Scanner;

/*
 * Testovoe zadanie 2.9.2
 * Calculator
 * Ignatov Igor
 */
public class Calculator {
    public static void main(String[] args) {
        //block ob`yavleniya i iniciilizacii peremennuch
        int firstResult = 0;
        int secondResult = 0;
        char command = ' ';
        int firstNumber = 0;
        char firstOperator = ' ';
        int secondNumber = 0;
        int thirdNumber = 0;
        char SecondOperator = ' ';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Project calculator. Task 2.9.2");
        // tsickle dlya povtornoi rabotu calculyatora
        while (true) {
            firstNumber = getInputInt(scanner, "pervoe");
            firstOperator = getInputOperand(scanner);
            secondNumber = getInputInt(scanner, "vtoroe");
            firstResult = math(firstNumber, secondNumber, firstOperator);
            System.out.println("Resultat vuchisleniya pervoi paru chisel: " + firstResult);

            thirdNumber = getInputInt(scanner, "tretie");
            SecondOperator = getInputOperand(scanner);
            secondResult = math(firstResult, thirdNumber, SecondOperator);
            System.out.println("Resultat vuchisleniya vtoroi paru chisel: " + secondResult);
            command = controlOperator(scanner);
            if (command == 's')
                return;
            else if (command == 'C')
                continue;
        }
    }

    // metod dlya vvoda operatora ot polsovatelya
    // pomimo chteniya operatora proveryaet pravilnost` vvoda i povtoryaet vvod zanovo
    public static char controlOperator(Scanner scanner) {
        char operator = ' ';
        do {
            System.out.println("");
            System.out.println("Vvedite simvol 'C' dlya povtornogo vuchisliniya ili 's' dlay vuchoda is programmu");
            operator = scanner.next().charAt(0);
            if (!checkAcceptableCommand(operator))
                System.out.println("Vvedena nevernaya comanda!");
            else if (operator == 's')
                System.out.println("Vuchod is programmu. GoodBye");
        } while (!checkAcceptableCommand(operator));
        return operator;
    }

    // metod proverka sootvetstviya dopustimush simvolov v comande
    public static boolean checkAcceptableCommand(char command) {
        if ((command == 's') || (command == 'C'))
            return true;
        else
            return false;
    }

    // metod matmaticheskie operacii s vvedennumi chislami
    public static int math(int firstValue, int secondValue, char operator) {
        int returnValue = 0;
        switch (operator) {
            case '+' -> returnValue = addition(firstValue, secondValue);
            case '-' -> returnValue = subtraction(firstValue, secondValue);
            case '*' -> returnValue = multiplier(firstValue, secondValue);
            case '/' -> returnValue = division(firstValue, secondValue);
        }
        return returnValue;
    }

    // metod chteniya chisla vvedennogo polzovatelem
    public static int getInputInt(Scanner scanner, String numberName) {
        System.out.println("Vvedite " + numberName + " chislo");
        int inputNumber = scanner.nextInt();
        System.out.println("Vvedennoe " + numberName + " chislo: " + inputNumber);
        return inputNumber;
    }

    // metod chteniya operatora is consoli ot polzovatelya
    // proverka vvedennogo operatora i povtornui vvod pri oshibke
    public static char getInputOperand(Scanner scanner) {
        char operator = ' ';
        String operatorStr = new String();
        do {
            System.out.println("Vvedite operand");
            operator = scanner.next().charAt(0);
            if (!chekAcceptableOperand(operator))
                System.out.println("Vveden nevernui operand!");
            else {
                switch (operator) {
                    case '+' -> operatorStr = "slozheniya";
                    case '-' -> operatorStr = "vuchitaniya";
                    case '*' -> operatorStr = "ymnozheniya";
                    case '/' -> operatorStr = "deleniya";
                }
                System.out.println("Vvedena operaciya " + operatorStr);
            }
        } while (!chekAcceptableOperand(operator));
        return operator;
    }

    // motod proverki dopustimogo operatora calculatora
    public static boolean chekAcceptableOperand(char chekingOperand) {
        if ((chekingOperand == '*') || (chekingOperand == '/') || (chekingOperand == '-') || (chekingOperand == '+'))
            return true;
        else
            return false;
    }

    // metod slozhenie dvych chisel
    public static int addition(int a, int b) {
        int returnValue = 0;
        returnValue = a + b;
        return returnValue;
    }

    // metod vuchitanie
    public static int subtraction(int fromValue, int deductibleValue) {
        int returnValue = 0;
        returnValue = fromValue - deductibleValue;
        return returnValue;
    }

    // metod ymnozheniya chisel
    public static int multiplier(int a, int b) {
        int returnValue = 0;
        returnValue = a * b;
        return returnValue;
    }

    // metod deleniya chisel
    public static int division(int mainValue, int devider) {
        int returnValue = 0;
        returnValue = mainValue / devider;
        return returnValue;
    }
}
