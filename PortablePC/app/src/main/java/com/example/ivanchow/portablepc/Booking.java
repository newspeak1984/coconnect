package com.example.ivanchow.portablepc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Booking extends AppCompatActivity {
    TextView month;
    int monthnum;
    int daynum;
    ImageButton back;
    Button signout;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;

    List<String> list = new ArrayList<String>();

    String id;
    boolean check = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        setTitle("");

        month = (TextView)findViewById(R.id.month);

        month.setText(monthnum+"/"+daynum);

        back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent goBack = new Intent(Booking.this, MainActivity.class);
                startActivity(goBack);
            }
        });

        signout = (Button)findViewById(R.id.sign_out);
        signout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                FirebaseAuth.getInstance().signOut();
                Intent goBack = new Intent(Booking.this, MainActivity.class);
                startActivity(goBack);
            }
        });

        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 8:30-9:00";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 9:00-9:30";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 9:30-10:00";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 10:00-10:30";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 10:30-11:00";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 11:00-11:30";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 11:30-12:00";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 12:00-12:30";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 12:30-1:00";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button10 = (Button)findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 1:00-1:30";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button11 = (Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 1:30-2:00";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button12 = (Button)findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 2:00-2:30";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });

        button13 = (Button)findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                id = "Booked: " + monthnum + "/" + daynum + "/2017 at 2:30-2:45";
                for (String s: list){
                    if(s.equals(id)){
                        check = false;
                    }
                }
                if(check){
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                    list.add(id);
                    check = true;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error: Already Booked", Toast.LENGTH_LONG).show();
                }
                check = true;
            }
        });










    }
}
