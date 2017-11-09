package ilyatkachev.github.com.fragmentsservicesbrreceiverepam;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.services.MyService;

public class MainActivity extends AppCompatActivity {

    private View mOpenAuthActivityBtn;
    private View mStartServiceBtn;
    private EditText mFirstTimerEdit;
    private EditText mSecondTimerEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mFirstTimerEdit = (EditText) findViewById(R.id.first_timer_edit);
        mSecondTimerEdit = (EditText) findViewById(R.id.second_timer_edit);

        mOpenAuthActivityBtn = findViewById(R.id.open_auth_btn);
        mOpenAuthActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View pView) {
                createAuthActivity();
            }
        });

        mStartServiceBtn = findViewById(R.id.start_service_btn);
        mStartServiceBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View pView) {
                PendingIntent pi;
                Intent intent;

                pi = createPendingResult(Constants.TASK1_KEY, null, 0);
                intent = new Intent(MainActivity.this, MyService.class).putExtra(Constants.TIMER_KEY, Integer.valueOf(mFirstTimerEdit.getText().toString()))
                        .putExtra(Constants.PINTENT_KEY, pi);
                startService(intent);

                pi = createPendingResult(Constants.TASK2_KEY, null, 0);
                intent = new Intent(MainActivity.this, MyService.class).putExtra(Constants.TIMER_KEY, Integer.valueOf(mSecondTimerEdit.getText().toString()))
                        .putExtra(Constants.PINTENT_KEY, pi);
                startService(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Constants.SERVICE_FINISH_STATUS) {
            int result = data.getIntExtra(Constants.RESULT_KEY, 0);
            switch (requestCode) {
                case Constants.TASK1_KEY:
                    //some action
                    break;
                case Constants.TASK2_KEY:
                    //another action
                    break;
            }
        }
    }

    private void createAuthActivity() {
        Intent intent = new Intent(this, AuthorizationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
