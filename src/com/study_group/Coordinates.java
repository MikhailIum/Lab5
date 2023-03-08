package com.study_group;

/**
 * Coordinates of the group
 */
public class Coordinates {
    private final double x;
    private final long y;

    public Coordinates(double x, long y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    /**
     * Making a string of all the fields
     * @return String
     */
    public String get_params(){
        return x + "," + y;
    }
}