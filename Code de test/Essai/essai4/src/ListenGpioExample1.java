// START SNIPPET: listen-gpio-snippet


/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  ListenGpioExample.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  http://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2017 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import java.util.List;

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
// START SNIPPET: usage-import-snippet



/**
 * This example code demonstrates how to setup a listener
 * for GPIO pin state changes on the Raspberry Pi.
 *
 * @author Robert Savage
 */
public class ListenGpioExample1 {
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
        
     
        
        myButton1.addListener(new GpioUsageExampleListener1());
        myButton2.addListener(new GpioUsageExampleListener2());
        
        myButton1.addTrigger(new GpioSyncStateTrigger(myLed1));
        myButton2.addTrigger(new GpioSyncStateTrigger(myLed2));
        
        while (true) {
            Thread.sleep(500);
        }
 }

    
    
    public static class GpioUsageExampleListener1 implements GpioPinListenerDigital {
        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event1) {
            // display pin state on console
            System.out.println(" --> GPIO PIN STATE CHANGE: " + event1.getPin() + " = "
                    + event1.getState());
        }
    }
    
    public static class GpioUsageExampleListener2 implements GpioPinListenerDigital {
        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event2) {
            // display pin state on console
            System.out.println(" --> GPIO PIN STATE CHANGE: " + event2.getPin() + " = "
                    + event2.getState());
        }
    }
}