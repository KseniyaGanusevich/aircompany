package airport;

import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author Vitali Shulha
 * @version 1.1
*/

public class Airport {
    private final List<? extends Plane> planes;

    public List<PassengerPlane> getPassengerPlane() {
        List<PassengerPlane> passengerPlane = new ArrayList<>();
        for (Plane plane : planes)
        {
            if (plane instanceof PassengerPlane)
            {
                passengerPlane.add((PassengerPlane) plane);
            }
        }
        return passengerPlane;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane)
            {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity()
    {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes)
        {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity())
            {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes()
    {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes()
    {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes)
        {
            if (militaryPlane.getType() == MilitaryType.BOMBER)
            {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes()
    {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes)
        {
            if (plane instanceof ExperimentalPlane)
            {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance()
    {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed()
    {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public void sortByMaxLoadCapacity()
    {
        planes.sort(Comparator.comparingInt(Plane::getMinLoadCapacity));
    }

    public List<? extends Plane> getPlanes()
    {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport.Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport(List<? extends Plane> planes)
    {
        this.planes = planes;
    }
}
