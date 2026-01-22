//UNIVERSIDAD DE LAS FUERZAS ARMADAS - ESPE
//César Luis Galarza Villalva
//Sangolquí, 22th January, 2026

//JUnit test class for CruiseControl with StandAlone

//The JUnit.jar need be added in a new folder "lib" to aprove
//Without that, calling theme make worse failures

package es.upm.grise.profunduzacion.cruiseController;
//Because the call faling, we need to improve with import
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//For the @BeforeEach in the original code, its necessary 
//to import another library that not know before
import org.junit.jupiter.api.BeforeEach;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedSetException;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;

class CruiseControlTest {
    
    private CruiseControl cruiseControl;

    @BeforeEach
    public void setUp() {
        // Se pasa null como Speedometer ya que no se utiliza en la lógica actual (Standalone test)
        cruiseControl = new CruiseControl(null);
    }

    @Test
    public void smokeTest() {
        assertNotNull(cruiseControl, "La instancia de CruiseControl no debería ser nula");
    }
    
    @Test
    public void testSetSpeedSet_ValidValue() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
        int expectedSpeed = 50;
        cruiseControl.setSpeedSet(expectedSpeed);
        assertEquals(expectedSpeed, cruiseControl.getSpeedSet());
    }

    @Test
    public void testSetSpeedSet_NegativeValue_ThrowsException() {
        assertThrows(IncorrectSpeedSetException.class, () -> cruiseControl.setSpeedSet(-10));
    }

    @Test
    public void testSetSpeedSet_ZeroValue_ThrowsException() {
        assertThrows(IncorrectSpeedSetException.class, () -> cruiseControl.setSpeedSet(0));
    }

    @Test
    public void testSetSpeedSet_AboveSpeedLimit_ThrowsException() {
        cruiseControl.setSpeedLimit(100);
        assertThrows(SpeedSetAboveSpeedLimitException.class, () -> cruiseControl.setSpeedSet(120));
    }

    @Test
    public void testSetSpeedSet_WithinSpeedLimit_Success() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
        cruiseControl.setSpeedLimit(100);
        cruiseControl.setSpeedSet(90);
        assertEquals(90, cruiseControl.getSpeedSet());
    }
}