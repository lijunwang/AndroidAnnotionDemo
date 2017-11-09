package think.anew.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import think.anew.com.myapplication.annotation.BindView;
import think.anew.com.myapplication.annotation.InjectView;
import think.anew.com.myapplication.annotation.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.tv)
    TextView tv;

    @BindView(R.id.bt)
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectView.init(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.setText("Mr.Wang");
    }

    @OnClick(R.id.bt)
    void onBtClick(){
        Toast.makeText(this, "bt is clicked ...", Toast.LENGTH_SHORT).show();
    }
}
