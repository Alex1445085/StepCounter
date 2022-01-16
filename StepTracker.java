import java.util.HashMap;
import java.util.ArrayList;
public class StepTracker {
    int limitStep = 10000;
    HashMap<Integer, ArrayList<Integer>> stepMap = new HashMap<>();
    ArrayList<Integer> steps = new ArrayList<>();
    Converter convert = new Converter();
    StepTracker() {
        stepMap = new HashMap<>();
        for (int mon = 0; mon < 12; mon++) {
            steps = new ArrayList<>();
            for (int dat = 0; dat < 30; dat++) {
                steps.add(0);
            }
            stepMap.put(mon, steps);
        }
    }

    void stepAdd(int month, int date, int stepToSet) {
        ArrayList<Integer> stepInMonth = new ArrayList<>();
        date--;
        stepInMonth = stepMap.get(month - 1);
        stepInMonth.remove(date);
        stepInMonth.add(date, stepToSet);
        stepMap.put(month - 1, stepInMonth);
        getSteps(month, stepInMonth);
    }

    void statistic(int month) {
        ArrayList<Integer> stepInMonth = new ArrayList<>();
        // month--;
        stepInMonth = stepMap.get(month - 1);
        int sumSteps = 0, maxSteps = 0, bestSerie = 0, serieLength = 0;   //, vol = 0
        double distance = 0, caloriesOff = 0;
        for ( int vol : stepInMonth)  {
            sumSteps = sumSteps + vol;
            if (maxSteps < vol) {
                maxSteps = vol;
            }
            if (vol > limitStep) {    // true - идет подсчет дней с шагами > цели
                serieLength++;
            } else {
                if ((serieLength > 0) && (bestSerie < serieLength)) {
                    bestSerie = serieLength;
                    serieLength = 0;
                }
            }
        }
      //  distance = distance = sumSteps * 75 / 1000;
      //  caloriesOff = sumSteps * 50 / 1000;
        getSteps(month, stepInMonth);
        System.out.println("Общее количество пройденных шагов за " + month + "-й месяц  : " + sumSteps);
        System.out.println("Максимальное количество шагов за день - " + maxSteps);
        System.out.println("Среднее количество шагов - " + (sumSteps / stepInMonth.size()));
        System.out.println("Пройденная дистанция - " + convert.dist(sumSteps)/100 + "км");
        System.out.println("Сожжено килокалорий - " + convert.kalo(sumSteps)/10);
        System.out.println("Лучшая серия - " + bestSerie + " дней, когда число шагов превышало поставленную цель");

    }

    void changeLimitStep(int lim) {
        limitStep = lim;
        if (lim < 1) {
            System.out.println("Так не бывает!");
        } else {
            System.out.println("Новая цель - " + limitStep + " шагов каждый день!");
        }
    }

    void getSteps(int month, ArrayList<Integer> stepInMonth) {
        System.out.println("В месяце " + month + ":");
      //  for (int i = 0; i < steps.size(); i++) {
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
