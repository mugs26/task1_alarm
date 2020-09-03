package com.example.task1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.mobizent.myapplication.R;

import static android.content.Context.NOTIFICATION_SERVICE;



public class AlarmAdapter extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        MediaPlayer mediaPlayer=null;
        if(!main_menu.flag) {
             mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
            mediaPlayer.start();
            showNotification(context, "Alarm", "welcome", mediaPlayer);
        }else{
            if(mediaPlayer!=null)
            {mediaPlayer.stop();

            }

        }




    }

    public void showNotification(Context context, String title, String body,MediaPlayer mediaplayer) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }


      //  RemoteViews remoteViews=new RemoteViews(context.getPackageName(), R.layout.activity_main);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(body);
            //    .setContent(remoteViews);



        notificationManager.notify(notificationId, mBuilder.build());
    }

    public void CustomNotification(Context context) {
      /*  RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.customnotification);
        String strtitle = getString(R.string.customnotificationtitle);
        String strtext = getString(R.string.customnotificationtext);
        Intent intent = new Intent(this, NotificationView.class);
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.logosmall)
                .setTicker(getString(R.string.customnotificationticker))
                .setAutoCancel(true) .setContentIntent(pIntent)
                .setContent(remoteViews);
        remoteViews.setImageViewResource(R.id.imagenotileft,R.drawable.ic_launcher);
        remoteViews.setImageViewResource(R.id.imagenotiright,R.drawable.androidhappy);
        remoteViews.setTextViewText(R.id.title,getString(R.string.customnotificationtitle));
        remoteViews.setTextViewText(R.id.text,getString(R.string.customnotificationtext));
        // Create Notification Manager
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(0, builder.build());*/
    }



}
