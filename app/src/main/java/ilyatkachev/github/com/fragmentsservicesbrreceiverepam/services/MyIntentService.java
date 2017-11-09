package ilyatkachev.github.com.fragmentsservicesbrreceiverepam.services;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.Constants;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyApp");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent pIntent) {

        int time = pIntent.getIntExtra(Constants.TIMER_KEY, 1);
        final PendingIntent pi = pIntent.getParcelableExtra(Constants.PINTENT_KEY);

        try {
            TimeUnit.SECONDS.sleep(time);
            Intent intent = new Intent().putExtra(Constants.RESULT_KEY, time);
            pi.send(MyIntentService.this, Constants.SERVICE_FINISH_STATUS, intent);
        } catch (InterruptedException | PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }
}
