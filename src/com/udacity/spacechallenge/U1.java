package com.udacity.spacechallenge;

public class U1 extends Rocket {

    public U1() {
        rocketCost = 100;
        rocketWeight = 10000;
        maxTotalWeight = 18000;
    }

    @Override
    public boolean launch() {
        chanceOfLaunchExp = 5 % (rocketWeight / maxTotalWeight);
        if (chanceOfLaunchExp > Math.random()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean land() {
        chanceOfLandCrash = 1 % (rocketWeight / maxTotalWeight);
        if (chanceOfLandCrash > Math.random()) {
            return false;
        }
        return true;
    }
}
