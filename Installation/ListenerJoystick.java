import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;


public class ListenerJoystick {

	public static void main(String args[]) throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Listen Example ... started.");

        
        final GpioController gpio = GpioFactory.getInstance();
        
        

        GpioPinDigitalInput myButton1 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02,             // PIN NUMBER
                                                                     "MyButton1",                   // PIN FRIENDLY NAME (optional)
                                                                     PinPullResistance.PULL_DOWN); // PIN RESISTANCE (optional)
        
        GpioPinDigitalInput myButton2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_04,            // PIN NUMBER
                													 "MyButton2",                   // PIN FRIENDLY NAME (optional)
                													 PinPullResistance.PULL_DOWN); // PIN RESISTANCE (optional)
        
        GpioPinDigitalOutput myLed1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,   // PIN NUMBER
                                                                   "My LE1",           // PIN FRIENDLY NAME (optional)
                                                                   PinState.LOW);      // PIN STARTUP STATE (optional)       
        
        GpioPinDigitalOutput myLed2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03,   // PIN NUMBER
                                                                   "My LED2",           // PIN FRIENDLY NAME (optional)
                                                                   PinState.LOW);      // PIN STARTUP STATE (optional)
       
        
        myLed1.setShutdownOptions(new Boolean(true), PinState.LOW, PinPullResistance.OFF);
        myLed2.setShutdownOptions(new Boolean(true), PinState.LOW, PinPullResistance.OFF);

        myLed1.pulse(1000);
        myLed2.pulse(2000);
        
     
        
        myButton1.addListener(new ListenerJoystick1());
        myButton2.addListener(new ListenerJoystick2());
        
        myButton1.addTrigger(new GpioSyncStateTrigger(myLed1));
        myButton2.addTrigger(new GpioSyncStateTrigger(myLed2));
        
        while (true) {
            Thread.sleep(500);
        }
 }

    
    
    public static class ListenerJoystick1 implements GpioPinListenerDigital {
        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event1) {
            // display pin state on console
            System.out.println(" --> GPIO PIN STATE CHANGE: " + event1.getPin() + " = "
                    + event1.getState());
        }
    }
    
    public static class ListenerJoystick2 implements GpioPinListenerDigital {
        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event2) {
            // display pin state on console
            System.out.println(" --> GPIO PIN STATE CHANGE: " + event2.getPin() + " = "
                    + event2.getState());
        }
    }
}
