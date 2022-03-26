package edu.vsu.ru;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\Сергей\\Desktop\\Учёба\\ТаскиВторойСем\\Task1\\src\\edu\\vsu\\ru\\data";
        String path2 = "C:\\Users\\Сергей\\Desktop\\Учёба\\ТаскиВторойСем\\Task1\\src\\edu\\vsu\\ru\\newfile";

        ITC[] itcArr = ITC.CSVToItc(path); // Создаю массив объектов, в котором буду хранить коды(префиксы), названия направлений и цену

        int[] arrSeconds = CsvToArr(path); // Создаю массив целых чисел для длительности звонка в секундах

        double[] endPrice = ITC.currentValueCall(itcArr, arrSeconds); // Высчитываю тариф


        System.out.println("Цена звонка: "+Arrays.toString(endPrice));
        
        ITC.ItcToCsv(path2, itcArr); // Запись класса ITC в newfile

    }

    public static int getLineCount(String fileName) throws IOException {
        int lines = 0;
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }
    public static int[] CsvToArr(String path) throws IOException {
        String line;
        String[] strings;
        int countLine = getLineCount(path);
        int[] arr = new int[countLine];
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            for (int i = 0; i < countLine; i++) {
                line = br.readLine();
                strings = line.split(",");

                int durationInSeconds = Integer.parseInt(strings[2]);


                arr[i] = durationInSeconds;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;

    }
}
