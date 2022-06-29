public class StepTracker {

    MonthData[] monthToData;

    int stepsGoal = 10000;
    Converter converter = new Converter();

    public StepTracker() {
        monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
            monthToData[i].monthName = monthToData[i].monthNames[i];
            for (int j = 0; j < monthToData[i].day.length;j++) {
                monthToData[i].day[j] = 0;
            }
            }
    }

    void printAllSteps(int month) {

        System.out.println(monthToData[month].monthName);
        for (int i = 0; i < monthToData[month].day.length; i++) {// Длина
            System.out.println("День " + (i + 1) + ". Пройдено " + monthToData[month].day[i] + " шагов.");
        }

    }

    void sumSteps(int month) {
        for (int i = 0; i < monthToData[month].day.length; i++) {// Длина
            monthToData[month].sumSteps = monthToData[month].day[i] + monthToData[month].sumSteps;

        }
        System.out.println("Общее количество шагов за " + monthToData[month].monthName + " " + monthToData[month].sumSteps + " шагов.");
    }

    void saveSteps(int month, int day, int stepPerDay) {
        monthToData[month].day[day - 1] = stepPerDay;
        System.out.println("Количество шагов успешно сохранено! " + monthToData[month].monthName + ". День " + day + ". " + monthToData[month].day[day + -1] + " шагов.");
           }

    void findMaxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month].day.length; i++) {// Длина
            if (monthToData[month].day[i] > maxSteps) {
                maxSteps = monthToData[month].day[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в " + monthToData[month].monthName + " - " + maxSteps + " шагов.");
    }

    void averageSteps(int month) {
        double averageStep = monthToData[month].sumSteps % monthToData[month].day.length;// Длина
        System.out.println("Среднее количество шагов за " + monthToData[month].monthName + " - " + averageStep + " шагов.");
    }

    void distanceBySteps(int month) {
        monthToData[month].distance = converter.stepSmToKm(monthToData[month].sumSteps);
        System.out.println("Пройденная дистанция за " + monthToData[month].monthName + " - " + monthToData[month].distance +" км.");
        }
    void caloriesBySteps(int month) {
        monthToData[month].caloriesByStep = converter.calorieByStepToKiloCalorie(monthToData[month].sumSteps);
        System.out.println("Количество сожжённых килокалорий за " + monthToData[month].monthName + " - " + monthToData[month].caloriesByStep +" Ккал.");
    }
    void seriesOfGoal(int month){
        int daysWhenGoal = 0;
        for (int i = 0; i < monthToData[month].day.length; i++) {// Длина
            if (monthToData[month].day[i] >= stepsGoal) {
                daysWhenGoal = daysWhenGoal + 1;
            }
        }
        System.out.println("Лучшая серия за " + monthToData[month].monthName + " - "+ daysWhenGoal + " дней.");
    }
    void changeGoal(int newStepGoal) {
        stepsGoal = newStepGoal;
        System.out.println("Значение целевого количества шагов успешно изменено и равняется " + stepsGoal + " шагов.");
    }

}




