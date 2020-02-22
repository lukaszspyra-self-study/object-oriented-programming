package com.udacity.spacechallenge;

/**
 * Creates the specific rocket U1 with default parameters:
 * rocketCost, rocketWeight, maxTotalWeight (rocket and cargo).
 */
public class U1 extends Rocket {

    public U1() {
        rocketCost = 100;
        rocketWeight = 10000;
        maxTotalWeight = 18000;
    }

    /**
     * Method checks if launch of the U1 rocket will be successful or not,
     * depending on chanceOfLaunchExplosion probability.
     *
     * @return True if launch successful, false if not.
     */
    @Override
    public boolean launch() {
        chanceOfLaunchExp = 0.05 * ((double) rocketWeight / maxTotalWeight);
        return !(chanceOfLaunchExp > Math.random());
    }

    /**
     * Method checks if landing of the U1 rocket will be successful or not,
     * depending on chanceOfLandCrash probability.
     *
     * @return True if launch successful, false if not.
     */
    @Override
    public boolean land() {
        chanceOfLandCrash = 0.01 * ((double) rocketWeight / maxTotalWeight);
        return !(chanceOfLandCrash > Math.random());
    }
}
