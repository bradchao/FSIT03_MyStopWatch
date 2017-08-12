package tw.brad.app.helloworld.mystepwatch;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private boolean isRunning;
    private Button left, right;
    private int i;
    private Timer timer;
    private ClockTask clockTask;
    private UIHandler handler;
    private TextView clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = (Button)findViewById(R.id.left);
        right = (Button)findViewById(R.id.right);
        clock = (TextView)findViewById(R.id.clock);
        timer = new Timer();
        handler = new UIHandler();
    }

    // Reset / lap
    public void doLeft(View view){
        if (isRunning){
            doLap();
        }else{
            doReset();
        }
    }
    // Start / Stop
    public void doRight(View view){
        isRunning = !isRunning;
        if (isRunning){
            right.setText("Stop");
            left.setText("Lap");
            doStart();
        }else{
            right.setText("Start");
            left.setText("Reset");
            doStop();
        }
    }

    private void doStart(){
        if (clockTask == null){
            clockTask = new ClockTask();
            timer.schedule(clockTask, 10, 10);
        }
    }
    private void doStop(){
        if (clockTask != null){
            clockTask.cancel();
            clockTask = null;
        }
    }
    private void doLap(){

    }
    private void doReset(){

    }

    @Override
    public void finish() {
        if (timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
        super.finish();
    }

    private class ClockTask extends TimerTask {
        @Override
        public void run() {
            i++;
            Message mesg = new Message();
            Bundle data = new Bundle();
            data.putInt("i", i);
            mesg.setData(data);
            handler.sendMessage(mesg);
        }
    }

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i = msg.getData().getInt("i");
            clock.setText("" + i);
        }
    }



}
