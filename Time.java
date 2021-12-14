package 스인재살인사건;

import java.util.concurrent.TimeUnit;

public class Time {
	
	public void timelate(int second) {
		try {
			TimeUnit.SECONDS.sleep(second);
		} catch (Exception e) {

		}
	}
}
