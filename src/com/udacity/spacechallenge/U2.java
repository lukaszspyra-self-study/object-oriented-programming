package com.udacity.spacechallenge;

/**
 * Creates the specific rocket U2 with default parameters:
 * rocketCost, rocketWeight, maxTotalWeight (rocket and cargo).
 */
public class U2 extends Rocket {

    public U2() {
        rocketCost = 120;
        rocketWeight = 18000;
        maxTotalWeight = 29000;
    }

    /**
     * Method checks if launch of the U2 rocket will be successful or not,
     * depending on chanceOfLaunchExplosion probability.
     *
     * @return True if launch successful, false if not.
     */
    @Override
    public boolean launch() {
        chanceOfLaunchExp = 4 % ((double)rocketWeight / maxTotalWeight);
        if (chanceOfLaunchExp > Math.random()) {
            return false;
        }
        return true;
    }

    /**
     * Method checks if landing of the U2 rocket will be successful or not,
     * depending on chanceOfLandCrash probability.
     *
     * @return True if launch successful, false if not.
     */
    @Override
    public boolean land() {
        chanceOfLandCrash = 8 % ((double)rocketWeight / maxTotalWeight);
        if (chanceOfLandCrash > Math.random()) {
            return false;
        }
        return true;
    }
}
