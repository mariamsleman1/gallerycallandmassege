package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class newActivity extends AppCompatActivity {
 EditText phonenumber,phonenumbercall,sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        connect();
    }

    private void connect() {
        phonenumber=findViewById(R.id.editTextPhone);
        phonenumbercall=findViewById(R.id.editTextPhone2);
        sms=findViewById(R.id.editTextTextPersonName);
}

    public void call(View view) {
        String phonenumbers=phonenumbercall.getText().toString();

        if(!checkphonenum(phonenumbers)){
            Toast.makeText(this, "phone number is not correct", Toast.LENGTH_SHORT).show();
            return;}

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phonenumbers, null));
        startActivity(intent);

        }




    private boolean checkphonenum(String phonenumber) {

        if (phonenumber.matches("\\d{10}"))
            return true;
            // validating phone number with -, . or spaces
        else if (phonenumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
            return true;
            // validating phone number with extension length from 3 to 5
        else if (phonenumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
            return true;
            // validating phone number where area code is in braces ()
        else if (phonenumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
            return true;
            // Validation for India numbers
        else if (phonenumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
            return true;
        else if (phonenumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
            return true;

        else if (phonenumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
            return true;
            // return false if nothing matches the input
        else
            return false;
    }


    public void sms(View view) {
        String phonenumbers = phonenumber.getText().toString();
        String smss = sms.getText().toString();
        if(phonenumbers.trim().isEmpty()||smss.trim().isEmpty()){
    Toast.makeText(this, "somthing is fail", Toast.LENGTH_SHORT).show();
}
        if (!checkphonenum(phonenumbers)) {
            Toast.makeText(this, "phone number is not correct", Toast.LENGTH_SHORT).show();
            return;}

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("sms_body", "");
        Uri data = Uri.parse("sms:");
        intent.setData(data);
        startActivity(intent);
        }
    private void sendSMS(String phoneNumber, String message)
    {
        System.out.println("SEND MESSAGE");
    }




}