package ir.fbscodes.testeventbus;

import android.app.Application;

import org.greenrobot.eventbus.EventBus;

import java.util.Timer;
import java.util.TimerTask;

public class MyApp extends Application {
    private Timer timer = new Timer();
    @Override
    public void onCreate() {
        super.onCreate();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EventBus.getDefault().post(new MyEvent());
            }
        }, 3000, 3000);
    }
}
