package uk.nhs.nhsbsa.ccchs.config.env;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Robo {
	
	
	public static void clickViaRobot() {
		
	Robot robot;
	try {
		robot = new Robot();
		
		int BUTTON1_MASK=InputEvent.BUTTON1_DOWN_MASK;
		
		robot.mouseMove(1142, 203);
		//robot.mouseMove(1380, 82);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		//robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(1000);
		
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}

}
