package edu.vsu.ru;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ITC {
    String direction_code;
    String direction_name;
    int price;

    public ITC(String direction_code, String direction_name, int price) {
        this.direction_code = direction_code;
        this.direction_name = direction_name;
        this.price = price;
    }


    public String getDirection_code() {
        return direction_code;
    }

    public String getDirection_name() {
        return direction_name;
    }

    public int getPrice() {
        return price;
    }

    public static double[] currentValueCall(ITC[] arrItc, int[] arrDuration) {
        double[] calculatePriceCallMass = new double[arrItc.length];


        for (int i = 0; i < arrItc.length; i++) {
            if (arrDuration[i] < 6 && arrDuration[i] >= 0) {
                calculatePriceCallMass[i] = 0;
            } else if (arrDuration[i]<60 && arrDuration[i]>=0) {
                calculatePriceCallMass[i] = arrItc[i].price;
            } else calculatePriceCallMass[i] = Math.round((arrDuration[i] / 60.0) * arrItc[i].price);


        }

        return calculatePriceCallMass;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public void deleteCode() {

        direction_code = "";
    }

    public void deleteName() {
        direction_name = "";
    }

    public void changeName(String newDirection_name) {
        direction_name = newDirection_name;

    }


    public static ITC[] CSVToItc(String path) throws IOException {
        String line;
        String[] strings;
        int countLine = Main.getLineCount(path);
        Random random = new Random();

        ITC[] itcs = new ITC[countLine];

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            for (int i = 0; i < countLine; i++) {
                line = br.readLine();
                strings = line.split(",");

                String number = strings[0];

                String[] prefix = number.split(" ");

//                itcs[i].direction_code = prefix[1];
//
//                itcs[i].direction_name = strings[1];
//
//                itcs[i].price = random.nextInt(200);

                itcs[i] = new ITC(prefix[1], strings[1], random.nextInt(400));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itcs;

    }
    public static void ItcToCsv(String path, ITC[] itcs) throws IOException {
        FileWriter nFile = new FileWriter(path);

        for (int i = 0; i< itcs.length; i++){
            nFile.write(itcs[i].direction_name+",");
            nFile.write(itcs[i].direction_code+",");
            nFile.write(String.valueOf(itcs[i].price));
            nFile.write("\n");
        }

        nFile.close();

    }

}
