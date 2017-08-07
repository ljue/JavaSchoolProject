package com.jvschool.util.Attributes;

public class FilterAttribute {

    private double costFROM;
    private double costTO;
    private int flyTimeFROM;
    private int flyTimeTO;
    private int distanceFROM;
    private int distanceTO;
    private String category;

    public FilterAttribute() {
        this.costFROM = 0;
        this.costTO = 99999;
        this.flyTimeFROM = 0;
        this.flyTimeTO = 999;
        this.distanceFROM = 0;
        this.distanceTO = 9999;
    }

    public FilterAttribute(double costFROM, double costTO, int flyTimeFROM, int flyTimeTO, int distanceFROM, int distanceTO) {
        this.costFROM = costFROM;
        this.costTO = costTO;
        this.flyTimeFROM = flyTimeFROM;
        this.flyTimeTO = flyTimeTO;
        this.distanceFROM = distanceFROM;
        this.distanceTO = distanceTO;
    }

    public double getCostFROM() {
        return costFROM;
    }

    public void setCostFROM(double costFROM) {
        this.costFROM = costFROM;
    }

    public double getCostTO() {
        return costTO;
    }

    public void setCostTO(double costTO) {
        this.costTO = costTO;
    }

    public int getFlyTimeFROM() {
        return flyTimeFROM;
    }

    public void setFlyTimeFROM(int flyTimeFROM) {
        this.flyTimeFROM = flyTimeFROM;
    }

    public int getFlyTimeTO() {
        return flyTimeTO;
    }

    public void setFlyTimeTO(int flyTimeTO) {
        this.flyTimeTO = flyTimeTO;
    }

    public int getDistanceFROM() {
        return distanceFROM;
    }

    public void setDistanceFROM(int distanceFROM) {
        this.distanceFROM = distanceFROM;
    }

    public int getDistanceTO() {
        return distanceTO;
    }

    public void setDistanceTO(int distanceTO) {
        this.distanceTO = distanceTO;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
