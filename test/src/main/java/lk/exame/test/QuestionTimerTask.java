package lk.exame.test;

import java.util.TimerTask;

public class QuestionTimerTask extends TimerTask{

	@Override
	public void run() {
		
        completeTask();
        
	}

	private void completeTask() {
        try {
          
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
