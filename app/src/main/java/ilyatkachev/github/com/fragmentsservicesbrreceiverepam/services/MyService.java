package ilyatkachev.github.com.fragmentsservicesbrreceiverepam.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ilyatkachev.github.com.fragmentsservicesbrreceiverepam.Constants;

public class MyService extends Service {

    ExecutorService es;

    @Override
    public void onCreate() {
        super.onCreate();
        es = Executors.newFixedThreadPool(2);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent pIntent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int time = intent.getIntExtra(Constants.TIMER_KEY, 1);
        PendingIntent pi = intent.getParcelableExtra(Constants.PINTENT_KEY);

        MyRun mr = new MyRun(time, startId, pi);
        es.execute(mr);
        return super.onStartCommand(intent, flags, startId);
    }

    class MyRun implements Runnable {

        int time;
        int startId;
        PendingIntent pi;

        public MyRun(int time, int startId, PendingIntent pi) {
            this.time = time;
            this.startId = startId;
            this.pi = pi;
        }

        public void run() {
            try {
                TimeUnit.SECONDS.sleep(time);
                Intent intent = new Intent().putExtra(Constants.RESULT_KEY, time);
                pi.send(MyService.this,Constants.SERVICE_FINISH_STATUS, intent);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
            stopSelfResult(startId);
        }

    }
}
