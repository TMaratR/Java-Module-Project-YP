import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String name;
        int speed;
        Race race = new Race();

        System.out.println("Введите название и скорость 3-х автомобилей.");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Название авто №" + i);
            name = scanner.next();

            while (true) {
                System.out.println("Введите скорость авто №" + i + " (от 0 до 250)");

                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Ошибка! \nЗначение скорости должно быть от 0 до 250.");

                    }
                } else {
                    scanner.next();
                    System.out.println("Ошибка! \nВведите целочисленное значение скорости.");

                }
            }
            Car car = new Car(name, speed);
            race.whoNewLeader(car);
        }

        System.out.println("Победу одерживает: " + race.raceLeader);
    }
}

class Car {
    String name;
    int speed;

    public Car (String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    String raceLeader = "";
    int leaderDistance = 0;

    public void whoNewLeader(Car car) {
        int distance = 24 * car.speed;
        if (distance > leaderDistance) {
            raceLeader = car.name;
            leaderDistance = distance;
        }
    }
}