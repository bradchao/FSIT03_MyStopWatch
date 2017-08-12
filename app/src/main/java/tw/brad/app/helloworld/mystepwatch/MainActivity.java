package tw.brad.app.helloworld.mystepwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean isRunning;
    private Button left, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = (Button)findViewById(R.id.left);
        right = (Button)findViewById(R.id.right);

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

    }
    private void doStop(){

    }
    private void doLap(){

    }
    private void doReset(){

    }




}
