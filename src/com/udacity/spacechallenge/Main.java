package com.udacity.spacechallenge;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        ArrayList<Item> itemsPhase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> itemsPhase2 = simulation.loadItems("phase-2.txt");

        ArrayList<U1> phase1_U1rockets = simulation.loadU1(itemsPhase1);
        ArrayList<U1> phase2_U1rockets = simulation.loadU1(itemsPhase2);
        System.out.print("Total budget required for 2 phases, using U1 rockets: ");
        System.out.println(simulation.runSimulation(phase1_U1rockets) + simulation.runSimulation(phase2_U1rockets));

        ArrayList<U2> phase1_U2rockets = simulation.loadU2(itemsPhase1);
        ArrayList<U2> phase2_U2rockets = simulation.loadU2(itemsPhase2);
        System.out.print("Total budget required for 2 phases, using U2 rockets: ");
        System.out.println(simulation.runSimulation(phase1_U2rockets) + simulation.runSimulation(phase2_U2rockets));
    }
}
