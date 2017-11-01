package ilyatkachev.github.com.fragmentsservicesbrreceiverepam;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.fragments.Fragment1;
import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {

    private View mOpenAuthActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mOpenAuthActivityBtn = findViewById(R.id.open_auth_btn);
        mOpenAuthActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View pView) {
                createAuthActivity();
            }
        });
    }

    private void createAuthActivity() {
        Intent intent = new Intent(this, AuthorizationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}
