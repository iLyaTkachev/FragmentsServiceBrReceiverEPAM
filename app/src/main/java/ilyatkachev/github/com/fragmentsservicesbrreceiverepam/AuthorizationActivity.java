package ilyatkachev.github.com.fragmentsservicesbrreceiverepam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AuthorizationActivity extends AppCompatActivity {

    private View mOpenFragmentsActivityBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        initView();
    }

    private void initView() {
        mOpenFragmentsActivityBtn = findViewById(R.id.fragment_btn1);
        findViewById(R.id.fragment_btn1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View pView) {
                createFragmentsActivity();
            }
        });
    }

    private void createFragmentsActivity() {
        Intent intent = new Intent(this, FragmentsActivity.class);
        startActivity(intent);
    }
}
