package com.udacity.spacechallenge;

public class U2 extends Rocket {
    @Override
    public boolean launch() {
        chanceOfLaunchExp = 4 % (rocketWeight / maxTotalWeight);
        if (chanceOfLaunchExp > Math.random()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean land() {
        chanceOfLandCrash = 8 % (rocketWeight / maxTotalWeight);
        if (chanceOfLandCrash > Math.random()) {
            return false;
        }
        return true;
    }
}
