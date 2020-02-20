package com.udacity.spacechallenge;

public class Rocket implements SpaceShip {
    int rocketCost;
    int rocketWeight;
    int maxTotalWeight;
    double chanceOfLaunchExp;
    double chanceOfLandCrash;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if (item.getWeight() + rocketWeight > maxTotalWeight) {
            return false;
        }
        return true;
    }

    @Override
    public int carry(Item item) {
        rocketWeight += item.getWeight();
        return rocketWeight ;
    }
}
