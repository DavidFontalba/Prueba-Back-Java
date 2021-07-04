package com.asteroids.api;
import java.util.Date;

public class Asteroid {
    String name;
    Float diameter;
    Float speed;
    Date approachDate;
    String planet;

    public Asteroid(String name, Float speed, Date approachDate, String planet, Float estimatedDiameterMin, Float estimatedDiameterMax) {
		this.name = name;
		this.speed = speed;
		this.approachDate = approachDate;
		this.planet = planet;
		this.diameter = calcDiameter(estimatedDiameterMin, estimatedDiameterMax);;
	}

    public Float calcDiameter(Float estimatedDiameterMin, Float estimatedDiameterMax) {
        return (estimatedDiameterMin + estimatedDiameterMax) / 2;
    }
}
