package com.example.vishaldeepsingh.vsafe.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vishaldeepsingh.vsafe.R;

public class NotificationActivity extends AppCompatActivity {
    private static final int notificationID = 0;
    Button ClickMeBtn;
    private NotificationManager mNotificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
      /*  ClickMeBtn = (Button) findViewById(R.id.ClickMeBtn);
        ClickMeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Notify("New Message", "you've recieved new message");
            }

        });    */
        displayNotification();
    }
    protected void displayNotification() {
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this);

        mBuilder.setContentTitle("Updation Avaliable!..");
        mBuilder.setContentText("Connect to Play store");
        mBuilder.setTicker("New Message from V safe");
        mBuilder.setSmallIcon(R.drawable.ok);
        mBuilder.setNumber(1);

        NotificationCompat.InboxStyle inboxStyle=new NotificationCompat.InboxStyle();
        String[] events = new String[6];
        events[0] = new String("Keep on checking for updates");
      //  events[1] = new String("how are you?");
        //events[2] = new String("I am fine...");
        //events[3] = new String("how about you...");
        //events[4] = new String("how your training?");
        //events[5] = new String("All is well...");
        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Update Avaialable!..");

        // Moves events into the big view
        for (int i=0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }
        mBuilder.setStyle(inboxStyle);

		   /* Creates an explicit intent for an Activity in your app */
        Intent resultIntent = new Intent(this, NotificationView.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationView.class);

		   /* Adds the Intent that starts the Activity to the top of the stack */
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		   /* notificationID allows you to update the notification later on. */
        mNotificationManager.notify(notificationID, mBuilder.build());
    }



    private void Notify(String notificationTittle, String notificationMessage) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification = new Notification(R.drawable.ok1,
                "New Message", System.currentTimeMillis());

        Intent notificationIntent = new Intent(this, NotificationView.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
      // notification.setLatestEventInfo(getApplicationContext(), notificationTittle,
             //   notificationMessage, pendingIntent);
        notificationManager.notify(9999, notification);

    }



}

