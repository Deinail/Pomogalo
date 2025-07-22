import java.util.Scanner;

public class BrakesCalc {

    float Slope, needRatio, needHandBrakes, handBrakesCanStopped, lossWeight, manualAxes;
    int weight, handBrakes;

    public float[][] TableSlope = new float[][] { //Таблица кол-ва ручных тормозов и башмаков
       // Уклон,    башмаки, порожние башмаки/оси
            {0.0f,    0.2f,    0.4f},
            {0.002f,  0.2f,    0.4f},
            {0.004f,  0.2f,    0.4f},
            {0.006f,  0.2f,    0.4f},
            {0.008f,  0.2f,    0.6f},
            {0.010f,  0.3f,    0.8f},
            {0.012f,  0.4f,    1.0f},
            {0.014f,   0.4f,    1.2f},
            {0.016f,   0.5f,    1.4f},
            {0.018f,   0.6f,    1.6f},
            {0.020f,   0.6f,    1.8f},
            {0.022f,   0.7f,    2.0f},
            {0.024f,   0.8f,    2.2f},
            {0.026f,   0.8f,    2.4f},
            {0.028f,   0.9f,    2.6f},
            {0.030f,   1.0f,    2.8f},
            {0.032f,   1.0f,    3.0f},
            {0.034f,   1.1f,    3.2f},
            {0.036f,   1.2f,    3.4f},
            {0.038f,   1.2f,    3.6f},
            {0.040f,   1.3f,    3.8f}
    };

    public void inputSlope(){ // Ввод значений уклона от пользователя

        Scanner input = new Scanner(System.in);
        System.out.print("\nВведите уклон : ");
        Slope = input.nextFloat();
        System.out.print("\nВведите количество башмаков на локомотиве : ");
        handBrakes = input.nextInt();

    }

    public void calcManualAxes(int i){ // Считаем необходимое кол-во ручных осей
        handBrakesCanStopped = handBrakes / needRatio * 100;
        lossWeight = weight - handBrakesCanStopped;
        manualAxes = lossWeight * TableSlope[i][2] / 100 ;
        System.out.println("\nИспользуются все башмаки на локомотиве, необходимо ручных осей : " + manualAxes);

    }

    public void calcNeedHandbrakes(int i,int y){

            needRatio = TableSlope[i][y];
            needHandBrakes = weight * needRatio / 100;

            if (needHandBrakes > handBrakes) {

                calcManualAxes(i);
            }

            else
                System.out.println("Требуемое количество башмаков = " + needHandBrakes);

    }

    public void Calc () {  // Расчёт кол-ва ручных осей и башмаков

        Trail gruz = new Trail();
        weight = gruz.calcWeight();
        inputSlope();
        Slope/=1000;

        for(int i = 0, y = 1; i < TableSlope.length; i++) {

            if (Slope > 0.04) {
                System.out.println("\nВведены неверные данные уклона");
                break;
            }

            if (handBrakes<8) {
                System.out.println("\nВведены неверные данные количества башмаков");
                break;
            }

            if (!gruz.trailStatus)
                y = 2;

            if (Slope <= TableSlope[i][0]) {

                calcNeedHandbrakes(i, y);
                break;

            }

        }

    }

}

