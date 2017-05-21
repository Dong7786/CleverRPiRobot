package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227
 **********************************************************************************************/
import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class CleverRobot extends IRobotAdapter {
	Sonar sonar = new Sonar();

	public CleverRobot(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		CleverRobot rob = new CleverRobot(base);
		rob.setup();
		while (rob.loop()) {
		}
		rob.shutDown();

	}

	private void setup() throws Exception {
		// for (;;) {
		// driveDirect(1000, 1000);
		// Thread.sleep(1000);
		// driveDirect(-1000, 1000);
		// Thread.sleep(355);
		//
		// }
	}

	private boolean loop() throws Exception {
		readSensors(100);
		driveDirect(1000, 1000);
		// Thread.sleep(10000);
		if (isBumpLeft()) {
			driveDirect(-1000, -1000);

			driveDirect(-1000, 0);

			Thread.sleep(710);
			driveDirect(1000, 1000);
		} else if (isBumpRight()) {
			driveDirect(-1000, -1000);

			driveDirect(-1000, 0);

			Thread.sleep(710);
			driveDirect(1000, 1000);
		} else if (isLightBump()) {
			driveDirect(-1000, -1000);

			driveDirect(-1000, 0);

			Thread.sleep(710);
			driveDirect(1000, 1000);
		}

		return true;
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}
