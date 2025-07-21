public class Trail { // Параметры поезда

    public int trailWeght; // Вес поезда
    public int locoWeight; // Вес локомотива
    public int weight; // Общий вес поезда

    public void inputValue(){ //Ввод данных поезда от пользователя



    }

    public int fullWeight(int trail, int loco) { // Расчёт полного веса поезда

        weight = trail + loco;

        return weight;

    }

}
