package com.jvschool.util.Attributes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FilterAttribute {

    private double costFROM;
    private double costTO;
    private int flyTimeFROM;
    private int flyTimeTO;
    private int distanceFROM;
    private int distanceTO;
    private String category;
    private List<String> properties = new ArrayList<>();

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
    
}
