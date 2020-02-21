package com.udacity.spacechallenge;

/**
 * Interface specifying methods for all Space ships.
 */
public interface SpaceShip {
    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    int carry(Item item);
}
