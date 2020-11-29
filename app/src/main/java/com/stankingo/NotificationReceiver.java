package com.stankingo;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationReceiver extends BroadcastReceiver {
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 101;
    private static String CHANNEL_ID = "Пара началась";

    @Override
    public void onReceive(Context context, Intent intent) {
        // Build notification based on Intent
        notificationManager = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Intent resultIntent = new Intent(context, MainAudi.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, pending);

//        Notification notificationBuilder = new NotificationCompat.Builder(context.getApplicationContext(), CHANNEL_ID)
//                .setSmallIcon(R.mipmap.logo_stankin_sircl)
//                .setContentTitle("Чувак, началась пара")
//                .setContentText("пара такая то, каб такой то")
//                .setAutoCancel(true);
        // Show notification
//        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(42, notificationBuilder);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context.getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.mipmap.logo_stankin_sircl)
                        .setContentTitle(intent.getStringExtra("title"))
                        .setContentText(intent.getStringExtra("text"))
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.mipmap.logo_stankin_sircl, "Построить путь", resultPendingIntent)
                        .setAutoCancel(true);

        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, notificationBuilder.build());

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void scheduleNotification(Context context, long time, String title, String text) {

        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("title", title);
        intent.putExtra("text", text);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, resultPendingIntent);

//        Intent intent = new Intent(context, NotificationReceiver.class);
//        intent.putExtra("title", title);
//        intent.putExtra("text", text);
//        PendingIntent pending = PendingIntent.getBroadcast(context, 42, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        // Schdedule notification
//        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, pending);
    }

    public static void cancelNotification(Context context, String title, String text) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("title", title);
        intent.putExtra("text", text);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        // Cancel notification
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.cancel(resultPendingIntent);
    }

    public static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}
