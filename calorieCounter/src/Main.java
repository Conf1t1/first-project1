import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        MonthData monthData = new MonthData();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Введите номер месяца от 0 до 11");

                for (int i = 0; i < monthData.monthNames.length; i++) {
                    System.out.println(i + " - " + monthData.monthNames[i]);
                }
                int month = scanner.nextInt();
                if (month > 11) {
                    System.out.println("Нет такого месяца");
                    break;
                } else if (month < 0) {
                    System.out.println("Нет такого месяца");
                    break;
                }
                System.out.println("Введите номер дня от 1 до 30");
                int day = scanner.nextInt();
                if (day > 30) {
                    System.out.println("Нет такого дня");
                    break;
                } else if (day < 1) {
                    System.out.println("Нет такого дня");
                    break;
                }
                System.out.println("Введите количество пройденных шагов");
                int stepPerDay = scanner.nextInt();
                if (stepPerDay < 0) {System.out.println("Значение не может быть отрицательным");
                    break;
                }
                stepTracker.saveSteps(month,day,stepPerDay);
            } else if (userInput == 2) {
                System.out.println("Введите месяц от 0 до 11");
                for (int i = 0; i < monthData.monthNames.length; i++) {
                    System.out.println(i + " - " + monthData.monthNames[i]);
                }
                int month = scanner.nextInt();
                if (month > 11) {
                    System.out.println("Нет такого месяца");
                    break;
                } else if (month < 0) {
                    System.out.println("Нет такого месяца");
                    break;
                } else {
                    printMenu2();
                    int userInput2 = scanner.nextInt();
                    if (userInput2 > 7) {
                        System.out.println("Нет такой функции");
                        break;
                    } else if (userInput2 < 1) {
                        System.out.println("Нет такой функции");
                        break;
                    }
                    if (userInput2 == 1){
                        stepTracker.printAllSteps(month);
                    } else if (userInput2 == 2) {
                        stepTracker.sumSteps(month);
                    } else if (userInput2 == 3) {
                        stepTracker.findMaxSteps( month);
                    } else if (userInput2 == 4) {
                        stepTracker.averageSteps( month);
                    } else if (userInput2 == 5) {
                        stepTracker.distanceBySteps(month);
                    } else if (userInput2 == 6) {
                        stepTracker.caloriesBySteps(month);
                    } else if (userInput2 == 7) {
                        stepTracker.seriesOfGoal(month);
                    } else {
                        System.out.println("Нет такой команды");
                    }
                }

                } else if (userInput == 3) {
                    System.out.println("Целевое количество шагов равняется " + stepTracker.stepsGoal);
                    System.out.println("Введите новое целевое количество шагов");
                    int newStepGoal = scanner.nextInt();
                    if (newStepGoal < 0) {
                        System.out.println("Значение не может быть отрицательным");
                        break;
                    }
                    stepTracker.changeGoal(newStepGoal);
                                    }
                printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
                userInput = scanner.nextInt(); // повторное считывание данных от пользователя
            }
            System.out.println("Программа завершена");
        }


    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");

    }
    public static void printMenu2(){
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Количество пройденных шагов по дням");
        System.out.println("2 - Общее количество шагов за месяц");
        System.out.println("3 - Максимальное пройденное количество шагов в месяце");
        System.out.println("4 - Среднее количество шагов");
        System.out.println("5 - Пройденная дистанция (в км)");
        System.out.println("6 - Количество сожжённых килокалорий");
        System.out.println("7 - Лучшая серия");

            }
}