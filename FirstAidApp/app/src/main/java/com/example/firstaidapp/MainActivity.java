package com.example.firstaidapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText FirstInput;
    private EditText SecondInput;

    private TextView firstTop, secTop, thirdTop, fourthTop;

    private TextView descript_First, descript_Sec, descript_Third, descript_Fourth;

    private String[] med_cat= {"Physical Injuries", "Medication", "Allergies", "Phobias"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTop = (TextView) findViewById(R.id.firstTop);
        secTop = (TextView) findViewById(R.id.secTop);
        thirdTop = (TextView) findViewById(R.id.thirdTop);
        fourthTop = (TextView) findViewById(R.id.fourthTop);

        descript_First = (TextView) findViewById(R.id.descript_first);
        descript_Sec = (TextView) findViewById(R.id.descript_sec);
        descript_Third = (TextView) findViewById(R.id.descript_third);
        descript_Fourth =(TextView) findViewById(R.id.descript_fourth);

        notificationManager= NotificationManagerCompat.from(this);
   //     FirstInput = findViewById(R.id.firstInput);
   //     SecondInput = findViewById(R.id.second_Input);
        set_list();
        // receive next push notification


    }

    public void sendChannel1 (View v){
        String firstInput = FirstInput.getText().toString();
        String secondInput = SecondInput.getText().toString();

        Notification notification = new NotificationCompat.Builder(this,notiClass.Channel_1_ID)
                .setSmallIcon(R.drawable.ic_accessibility_black_24dp)
                .setContentTitle(firstInput)
                .setContentText(secondInput)
                .build();

        notificationManager.notify(1,notification);
    }

    public void sendChannel2 (View v){
        String firstInput = FirstInput.getText().toString();
        String secondInput = SecondInput.getText().toString();

        Notification notification = new NotificationCompat.Builder(this,notiClass.Channel_2_ID)
                .setSmallIcon(R.drawable.ic_accessibility_black_24dp)
                .setContentTitle(firstInput)
                .setContentText(secondInput)
                .build();

        notificationManager.notify(2,notification);
    }

    private void set_list(){

        String[] listname={};
        String all_symp="";

        firstTop.setText(med_cat[0]);
        secTop.setText(med_cat[1]);
        thirdTop.setText(med_cat[2]);
        fourthTop.setText(med_cat[3]);

        if(listname.length==0){
            descript_First.setText("No "+ med_cat[0]+" :)");
            descript_Sec.setText("No "+ med_cat[1]+" :)");
            descript_Third.setText("No "+ med_cat[2]+" :)");
            descript_Fourth.setText("No "+ med_cat[3]+" :)");
            return;
        }

        for(int i=0; i<listname.length;i++){
            //supposed to be double for loop to go through 2 lists
            all_symp=all_symp.concat(listname[i]+ " ");
        }

        descript_First.setText(all_symp);
        descript_Sec.setText(all_symp);
        descript_Third.setText(all_symp);
        descript_Fourth.setText(all_symp);
    }

}
