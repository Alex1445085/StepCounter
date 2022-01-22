import java.util.HashMap;
import java.util.ArrayList;

public class StepTracker {
    int limitStep = 10000;
    HashMap<Integer, ArrayList<Integer>> stepLists;
    ArrayList<Integer> steps = new ArrayList<>();
    Converter convert = new Converter();

    StepTracker() {
        stepLists = new HashMap<>();
        for (int mon = 0; mon < 12; mon++) {
            steps = new ArrayList<>();
            for (int dat = 0; dat < 30; dat++) {
                steps.add(0);
            }
            stepLists.put(mon, steps);
        }
    }

    void stepAdd(int month, int date, int stepToSet) {
        steps = new ArrayList<>();
        date--;
        steps = stepLists.get(month - 1);
        steps.remove(date);
        steps.add(date, stepToSet);
        stepLists.put(month - 1, steps);
        getSteps(month, steps);
    }

    void statistic(int month) {

        steps = new ArrayList<>();
                steps = stepLists.get(month - 1);
        int sumSteps = 0, maxSteps = 0, bestSerie = 0, serieLength = 0;
        for ( int vol : steps)  {
            sumSteps = sumSteps + vol;
            if (maxSteps < vol) {
                maxSteps = vol;
            }
            if (vol > limitStep) {    // true - идет подсчет дней с шагами > цели
                serieLength++;
                if (bestSerie < serieLength) {
                    bestSerie = serieLength;
                }
            } else {
                serieLength = 0;
            }
        }

        getSteps(month, steps);
        System.out.println("Общее количество пройденных шагов за " + month + "-й месяц  : " + sumSteps);
        System.out.println("Максимальное количество шагов за день - " + maxSteps);
        System.out.println("Среднее количество шагов - " + (sumSteps / steps.size()));
        System.out.println("Пройденная дистанция - " + (convert.calculateDist(sumSteps))+ "км");
        System.out.println("Сожжено килокалорий - " + convert.calculateKalo(sumSteps));
        System.out.println("Лучшая серия - " + bestSerie + " дней, когда число шагов превышало поставленную цель");

    }

    void changeLimitStep(int lim) {

        if (lim < 1) {
            System.out.println("Так не бывает!");
        } else {
            limitStep = lim;
            System.out.println("Новая цель - " + limitStep + " шагов каждый день!");
        }
    }

    void getSteps(int month, ArrayList<Integer> stepInMonth) {

        System.out.println("В месяце " + month + ":");
        for (int i = 0; i < stepInMonth.size(); i++) {
            System.out.print((i + 1) + " день: " + stepInMonth.get(i));
            if (i < (stepInMonth.size() - 1)) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
            if ((i + 1) % 10 == 0) System.out.println();
        }
    }
}
