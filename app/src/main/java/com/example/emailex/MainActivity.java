package com.example.emailex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText to,subject,message;
    Button sendemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to = (EditText)findViewById(R.id.editTextTo);
        subject = (EditText)findViewById(R.id.editTextSubject);
        message = (EditText)findViewById(R.id.editTextMessage);
        sendemail = (Button)findViewById(R.id.buttonSend);

        sendemail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                String To = to.getText().toString();
                String Sub = subject.getText().toString();
                String Message = message.getText().toString();

                Intent send = new Intent(Intent.ACTION_SEND);
                send.putExtra(Intent.EXTRA_EMAIL,new String[]{To});
                send.putExtra(Intent.EXTRA_SUBJECT,Sub);
                send.putExtra(Intent.EXTRA_TEXT,Message);

                send.setType("message/rfc822");

                startActivity(Intent.createChooser(send,"Choose Your Application"));










            }
        });



    }
}
