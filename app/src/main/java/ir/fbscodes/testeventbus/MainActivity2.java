package ir.fbscodes.testeventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void secondSubscribe(MyEvent myEvent) {
        TextView textView = findViewById(R.id.tvMain);
        textView.setText(myEvent.getMessage());
        List<String> colors = new ArrayList<>();
        colors.add("#ff0000");
        colors.add("#00ff00");
        colors.add("#0000ff");
        final int rand = new Random().nextInt(3);
        textView.setTextColor(Color.parseColor(colors.get(rand)));
        Snackbar.make(findViewById(R.id.activity2), myEvent.getMessage(), Snackbar.LENGTH_LONG).show();
    }
}