package com.example.mypc.i_tour.FragMent;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mypc.i_tour.R;

/**
 * Created by MyPC on 08/15/2017.
 */

public class Fragment_About extends Fragment {
    private String email = "duy26395@gmail.com";
    EditText body;
    EditText subject;
    EditText recipient;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about, container,false);
        subject = (EditText)view.findViewById(R.id.nameabout);
//        recipient = (EditText)view.findViewById(R.id.nameabout);
        body = (EditText)view.findViewById(R.id.textabout);
        Button send = (Button)view.findViewById(R.id.sendabout);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
        return view;
    }

    private void sendEmail() {
//        String[] recipients = {recipient.getText().toString()};
//        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("duy26395@gmail.com"));
//        email.setType("message/rfc822");
//
//        email.putExtra(Intent.EXTRA_EMAIL, recipients);
//        email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
//        email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
//
//        try {
//            startActivity(Intent.createChooser(email, "Choose an email client from..."));
//        } catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(getActivity(), "No email client installed.", Toast.LENGTH_LONG).show();
//
//        }
        Log.i("Send email", "");
        String[] TO = {"Duy26395@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("Duy26395@gmail.com"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT,body.getText().toString());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
//        Intent email = new Intent(Intent.ACTION_SEND);
//        email.setType("plain/text");
//        String to = "duy26395@gmail.com";
//        String subject1 = subject.getText().toString();
//        String message = body.getText().toString();
//        email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
//        //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
//        //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
//        email.putExtra(Intent.EXTRA_SUBJECT, subject1);
//        email.putExtra(Intent.EXTRA_TEXT, message);
//
//        //need this to prompts email client only
//
//
//        startActivity(Intent.createChooser(email, "Choose an Email client :"));
//
    }
}


