
package Game;

import java.awt.*;
import javax.swing.*;

public class CountdownTimer extends JProgressBar {
    private javax.swing.Timer timer;
    private int countdownValue;
    private final int originalCountdownValue = 40;
    private TimeFinishListener finishListener;

    public CountdownTimer() {
        super(0, 40);

        setStringPainted(true);
        setPreferredSize(new Dimension(245, 40));
        Font font = new Font("Ravie", 0, 20);
        setFont(font);
        // Đặt màu chữ
        Color textColor = new Color(55, 217, 104);
        setForeground(textColor);

        // Đặt màu nền
        Color backgroundColor = new Color(2, 191, 187);
        setBackground(backgroundColor);
        this.countdownValue = originalCountdownValue;
//----------------------------------------------------------------
        timer = new javax.swing.Timer(1000, e -> {
            Color over;
            if (countdownValue > 0) {
                if (countdownValue <= 10) {
                    over = Color.red;
                    setForeground(over);
                }
                else if (countdownValue <= 30) {
                    over = new Color(180, 172, 0);
                    setForeground(over);
                }
                setValue(countdownValue);
                setString(Integer.toString(countdownValue--));
            } else {
                setString("Time's up!");
                finishListener.onTimerFinish();
                timer.stop();
            }

        });

        startCountdown();
    }

    public void startCountdown() {
        setValue(countdownValue);
        setString(Integer.toString(countdownValue));
        timer.start();
    }
    
    public void setFinishListener(TimeFinishListener listener) {
        this.finishListener = listener;
    }
    
    public void resetAndStart() {
        countdownValue = originalCountdownValue; // Reset the countdown value
        setString(Integer.toString(countdownValue)); // Update the display
        setValue(countdownValue);
        timer.restart(); // Restart the timer
    }
    
    public void stopTime(){
        timer.stop();
    }

}