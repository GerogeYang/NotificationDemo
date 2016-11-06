package com.tcl.notificationdemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("服务已开启");
        builder.setContentText("点击进行关闭");
        builder.setSmallIcon(R.drawable.notif);
        builder.setAutoCancel(true);

        Intent mainScreenIntent = new Intent(this, MainActivity.class);
        builder.setContentIntent(PendingIntent.getActivity(this, 0, mainScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT));

        Notification notification = builder.build();
        startForeground(1, notification);
        System.out.println("..............start service..........");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        System.out.println("..............stop service..........");
    }
}
