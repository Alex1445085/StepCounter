public class Converter {

    int smPerStep = 75;    // сантиметров в шаге
    int caloPerStep = 50;  // - калорий в шаге

    Converter() {
    }

    double calculateDist(int allSteps) {

        allSteps = allSteps * smPerStep / 1000;  // пройдено шагов * 100
        double res = (double) allSteps / 100;
        return res;
    }

    double calculateKalo(int allSteps) {

        allSteps = allSteps * caloPerStep / 100; // сожжено килокалорий * 10  res;
        double res = (double) allSteps / 10;
        return res;
    }
}
