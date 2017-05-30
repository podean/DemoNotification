package com.example.potran.demonotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int requestCode = 123;
    int notificationID = 888;

    Button btnNotify1, btnNotify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify1 = (Button) findViewById(R.id.buttonNotify1);

        btnNotify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);

                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, requestCode,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                //Build notification
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);

                // Notification sound
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                // Heads-up Notification
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                // A good to have id, in case you want to cancel it
                // programmatically later on
                notificationManager.notify(notificationID,n);
                finish();
            }
        });

    }
}
