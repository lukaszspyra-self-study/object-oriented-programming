package com.udacity.spacechallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class simulation implementing the logic of operations to be carried out to transport all good to space.
 */
public class Simulation {

    /**
     * Method loading cargo list Items extracted from file.
     *
     * @param itemFilePath Path to file containing cargo in format (name=weight[kg])
     * @return ArrayList<Items> objects to be loaded on rockets.
     */
    public ArrayList<Item> loadItems(String itemFilePath) {
        File itemFile = new File(itemFilePath);
        Scanner readFile = null;
        ArrayList<Item> loadItems = new ArrayList<>();
        try {
            readFile = new Scanner(itemFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
        }
        assert readFile != null;
        while (readFile.hasNextLine()) {
            String[] items = readFile.nextLine().split("=");
            Item item = new Item(items[0], Integer.parseInt(items[1]));
            loadItems.add(item);
        }
        return loadItems;
    }

    /**
     * Method loading weight of Items to specific U1 rockets, creating new rockets until all cargo loaded.
     *
     * @param loadItems as ArrayList<Items>
     * @return
     */
    public ArrayList<U1> loadU1(ArrayList<Item> loadItems) {
        ArrayList<U1> u1List = new ArrayList<>();
        while (!loadItems.isEmpty()) {
            U1 u1 = new U1();
            for (int i = 0; i < loadItems.size(); i++) {
                if (u1.canCarry(loadItems.get(i))) {
                    u1.carry(loadItems.remove(i));
                }
            }
            u1List.add(u1);
        }
        return u1List;
    }

    /**
     * Method loading weight of Items to specific U2 rockets, creating new rockets until all cargo loaded.
     *
     * @param loadItems as ArrayList<Items>
     * @return
     */
    public ArrayList<U2> loadU2(ArrayList<Item> loadItems) {
        ArrayList<U2> u2List = new ArrayList<>();
        while (!loadItems.isEmpty()) {
            U2 u2 = new U2();
            for (int i = 0; i < loadItems.size(); i++) {
                if (u2.canCarry(loadItems.get(i))) {
                    u2.carry(loadItems.remove(i));
                }
            }
            u2List.add(u2);
        }
        return u2List;
    }

    /**
     * Method runSimulation checks the total budget required to send all cargo to space by the mean of particular rockets.
     *
     * @param rockets ArrayList<Rockets> which are required to carry all the cargo to space
     * @return Total cost of mission, considering probabilities of launch explosion and land crash.
     */
    public int runSimulation(ArrayList<? extends Rocket> rockets) {
        int totalBudget = 0;
        for (Rocket rocket : rockets) {
            while (!(rocket.launch() && rocket.land())) {
                totalBudget += rocket.rocketCost;
            }
            totalBudget += rocket.rocketCost;
        }
        return totalBudget;
    }
}
