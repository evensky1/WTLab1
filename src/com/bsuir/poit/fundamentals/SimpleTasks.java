package com.bsuir.poit.fundamentals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SimpleTasks {

    /**
     * <b>TASK 1<b/> <br/>
     * Вычислить значение выражения по формуле (все переменные принимают действительные значения).
     */
    private double equation(double x, double y) {

        double dividend = 1 + Math.pow(Math.sin(x + y), 2);
        double divisor = 2 + Math.abs(x - (2 * x) / (1 + Math.pow(x * y, 2)));

        return dividend / divisor + x;
    }

    /**
     * <b>TASK 2<b/> <br/>
     * Для данной области составить программу, которая печатает true, если точка с координатами (х,
     * у) принадлежит закрашенной области, и false — в противном случае.
     */
    private boolean belongsTo(double x, double y) {
        x = Math.abs(x);

        if (x <= 4 && y <= 5 && y >= -3) {
            return true;
        } else if (x > 4 && x <= 6 && y >= -3 && y <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * <b>TASK 3<b/> <br/>
     * Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
     * Результат представить в виде таблицы, первый столбец которой – значения аргумента, второй -
     * соответствующие значения функции F(x) = tg(x).
     */
    private void countTg(double a, double b, double h) {
        System.out.println("---------------------");
        System.out.println("|    x    |   F(x)  |");
        System.out.println("---------------------");
        for (double x = a; x <= b; x += h) {
            System.out.printf("|%8.3f | %8.3f|%n", x, Math.tan(x));
            System.out.println("---------------------");
        }
    }

    /**
     * <b>TASK 4<b/> <br/>
     * Задан целочисленный массив размерности N. Есть ли среди элементов массива простые числа? Если
     * да, то вывести номера этих элементов.
     */
    private void showPrimes(List<BigInteger> array) {
        array.stream()
            .filter(elem -> elem.isProbablePrime(100))
            .forEach(System.out::println);
    }

    /**
     * <b>TASK 5<b/> <br/>
     * Дана целочисленная таблица А[n]. Найти наименьшее число K элементов, которые можно выкинуть
     * из данной последовательности, так чтобы осталась возрастающая подпоследовательность.
     */
    private int countRedundant(int[] A) { //TODO: fix
        int temp = 1;
        int counter = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - temp]) {
                counter++;
                temp++;
            } else {
                temp = 1;
            }
        }
        return counter;
    }

    /**
     * <b>TASK 6<b/> <br/>
     * Даны действительные числа a1, a2, …, an. Получить следующую квадратную матрицу порядка n.
     */
    private double[][] createMatrix(double[] seq) {

        double[][] matrix = new double[seq.length][seq.length];

        for (int i = 0; i < seq.length; i++) {
            for (int j = i; j < seq.length + i; j++) {
                matrix[i][(j - i) % seq.length] = seq[j % seq.length];
            }
        }

        return matrix;
    }

    /**
     * <b>TASK 7<b/> <br/>
     * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по
     * возрастанию. Делается это следующим образом: сравниваются два соседних элемента ai и ai+1 .
     * Если ai <= ai+1, то продвигаются на один элемент вперед. Если ai > ai+1, то производится
     * перестановка и сдвигаются на один элемент назад. Составить алгоритм этой сортировки.
     */
    private double[] shellSort(double[] seq) {

        return seq;
    }

    /**
     * <b>TASK 8<b/> <br/>
     * Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= … <=an и b1 <=
     * b2 <= … <= bm. Требуется указать те места, на которые нужно вставлять элементы
     * последовательности b1 <= b2 <= … <= bm в первую последовательность так, чтобы новая
     * последовательность оставалась возрастающей.
     */
    private void insertions(double[] initSeq, double[] insertSeq) {
        for (int i = 0; i < insertSeq.length; i++) {
            int idx = findIndexOfEqualOrGreater(initSeq, insertSeq[i]);
            if (idx == -1) {
                System.out.println("А остальные -- в конец");
                return;
            } else if (idx == 0) {
                System.out.printf("%.1f перед %.1f %n", insertSeq[i], initSeq[i]);
            } else {
                System.out.printf("%.1f между %.1f и %.1f %n", insertSeq[i], initSeq[i - 1],
                    initSeq[i]);
            }
        }
    }

    //Demonstration
    public static void main(String[] args) {
        var simpleTasks = new SimpleTasks();

        //First task
        System.out.println(simpleTasks.equation(11.0, 12.0));

        //Second
        System.out.println(simpleTasks.belongsTo(-2.0, 2.0));

        //Third
        simpleTasks.countTg(-1.0, 10, 1);

        //Fourth
        var bigArray = new ArrayList<BigInteger>();
        for (int i = 0; i < 10; i++) {
            var val = BigInteger.valueOf((long) (Math.random() * 100));
            bigArray.add(val);
            System.out.print(val + " ");
        }
        System.out.println();

        simpleTasks.showPrimes(bigArray);

        //Fifth
        System.out.println(simpleTasks.countRedundant(new int[]{1, 2, 200, 3, 5, 76, 4, 32, 100}));

        //Sixth
        var mat =
            simpleTasks.createMatrix(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0});

        for (double[] row : mat) {
            for (double elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        //Seventh

        //Eighth
        simpleTasks.insertions(
            new double[]{1, 3, 4, 6, 7},
            new double[]{1, 2, 4, 5, 7, 21, 44, 52}
        );
    }

    //util
    private int findIndexOfEqualOrGreater(double[] arr, double key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= key) {
                return i;
            }
        }
        return -1;
    }
}
