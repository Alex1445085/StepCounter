public class Converter {
    int smPerStep = 75;    // сантиметров в шаге
    int caloPerStep = 50;  // - калорий в шаге
    Converter() {
    }

    double dist(int allSteps) {
        return allSteps * smPerStep / 1000;  // пройденное расстояние км * 100
    }
    double kalo(int allSteps) {
        return allSteps * caloPerStep / 100; // сожжено килокалорий * 10
    }

}
