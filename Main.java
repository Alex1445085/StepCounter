import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StepTracker step = new StepTracker();
        while (true) {
            printMenu();
            String menuChoise = scan.next();
            if (menuChoise.equals("0")) {
                System.out.println("Программа завершена.");
                return;
            } else if (menuChoise.equals("1")) {
                System.out.println("В каком месяце изменим количество шагов :");
                System.out.println("1 - январь, 2 - февраль, ... , 12 - декабрь.");
                int monthAdd = scan.nextInt();
                if ((monthAdd < 1) || (monthAdd > 12)) {
                    System.out.println("Такого месяца не бывает!");
                } else {
                    System.out.println("Какого числа?");
                    int dateAdd = scan.nextInt();
                    if ((dateAdd < 1) || (dateAdd > 30)) {
                        System.out.println("Такого числа нет в этом месяце!");
                    } else {
                        System.out.println("Сколько шагов?");
                        int stepToSet = scan.nextInt();
                        if (stepToSet < 0) {
                            System.out.println("Так не бывает!");
                        } else {
                            step.stepAdd(monthAdd, dateAdd, stepToSet);
                        }
                    }
                }
            } else if (menuChoise.equals("2")) {
                System.out.println("За какой месяц смотрим статистику?");
                System.out.println("1 - январь, 2 - февраль, ... , 12 - декабрь.");
                int month = scan.nextInt();
                if ((month < 1) || (month > 12)) {
                    System.out.println("Такого месяца не бывает!");
                } else {
                    step.statistic(month);
                }
            } else if (menuChoise.equals("3")) {
                System.out.println("Введите новую цель по количеству шаеов в день:");
                int newLimitStep = scan.nextInt();
                step.changeLimitStep(newLimitStep);
            } else {
                System.out.println("Такой команды пока нет.");
            }
        }
    }
    public static void printMenu(){
        System.out.println("Что вы хотите сделать:");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - напечатать статистику за определённый месяц");
        System.out.println("3 - изменить цель по количеству шагов в день");
        System.out.println("0 - выйти из приложения");
    }
}