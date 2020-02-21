package com.udacity.spacechallenge;

/**
 * Rocket responsible for creation of generic rocket upon implementation of SpaceShip interface,
 * by defining final methods canCarry and carry the max amount of cargo.
 */
class Rocket implements SpaceShip {
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

    /**
     * Method canCarry checks if there is loading weight available on the rocket.
     *
     * @param item to be loaded.
     * @return true if there is space available, false if not enough space.
     */
    @Override
    public final boolean canCarry(Item item) {
        return item.getWeight() + rocketWeight <= maxTotalWeight;
    }

    /**
     * Method carry adds weight of the item to total weight of the rocket.
     *
     * @param item loaded.
     * @return total weight of the rocket and cargo loaded in [kg]
     */
    @Override
    public final int carry(Item item) {
        rocketWeight += item.getWeight();
        return rocketWeight;
    }
}
