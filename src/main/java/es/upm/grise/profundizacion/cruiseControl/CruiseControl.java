//UNIVERSIDAD DE LAS FUERZAS ARMADAS - ESPE
//César Luis Galarza Villalva
//Sangolquí, 22th January, 2026

package es.upm.grise.profundizacion.cruiseControl;

public class CruiseControl {
    
    @SuppressWarnings("unused")
    private Speedometer speedometer;
    private Integer speedSet;
    private Integer speedLimit;

    /*
     * Constructor
     */
    public CruiseControl(Speedometer speedometer) {
        this.speedometer = speedometer;
        this.speedSet = null;
        this.speedLimit = null;
    }
    
    
    
    /*
     * Method to code / test
     */
    public void setSpeedSet(int speedSet) throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
        if (speedSet <= 0) {
            throw new IncorrectSpeedSetException("SpeedSet must be strictly positive.");
        }
        
        if (this.speedLimit != null && speedSet > this.speedLimit) {
            throw new SpeedSetAboveSpeedLimitException("SpeedSet cannot exceed the established SpeedLimit.");
        }
        
        this.speedSet = speedSet;
    }
    
    

    /*
     * Other setters & getters
     */
    public Integer getSpeedLimit() {
        
        return speedLimit;
        
    }

    public void setSpeedLimit(Integer speedLimit) {
        
        this.speedLimit = speedLimit;
        
    }

    public Integer getSpeedSet() {
        
        return speedSet;
        
    }

}