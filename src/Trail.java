import java.util.Scanner;

public class Trail { // Параметры поезда

        public int trailWeght; // Вес поезда
        public int locoWeight; // Вес локомотива
        public int fullWeight; // Общий вес поезда
        public boolean trailStatus; // Провереяем гружёный состав либо порожний

    public void inputValue(){ //Ввод данных поезда от пользователя

        Scanner input = new Scanner(System.in);
        System.out.print("Введите вес поезда : ");
        trailWeght = input.nextInt();
        System.out.print("\nВведите вес локомотива : ");
        locoWeight = input.nextInt();
        System.out.print("\nСостав: true)гружёный, false)порожний : ");
        trailStatus = input.nextBoolean();

    }

    public int calcWeight() { // Расчёт полного веса поезда

        inputValue();
        fullWeight = trailWeght + locoWeight;
        System.out.println("\nОбщий вес поезда : " + fullWeight);

        return fullWeight;

    }

}
