package com.example.mgonzalezlorenzo.simonexamen;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer sndblue,sndred,sndgreen,sndyellow;
    Button btnGreen, btnYellow, btnRed, btnBlue, start;


    TimerTask timerTarea;
    Timer timer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sndblue = MediaPlayer.create(this, R.raw.sonidoblue);
        sndred = MediaPlayer.create(this, R.raw.sonidored);
        sndgreen = MediaPlayer.create(this, R.raw.sonidogreen);
        sndyellow = MediaPlayer.create(this, R.raw.sonidoyellow);

        start = (Button) findViewById(R.id.empezar);
        btnBlue = (Button) findViewById(R.id.blueB);
        btnRed = (Button) findViewById(R.id.redB);
        btnGreen = (Button) findViewById(R.id.greenB);
        btnYellow = (Button) findViewById(R.id.yellowB);

    }
    ArrayList userColors = new ArrayList();
    ArrayList simonColors = new ArrayList();

    protected static int cont=0;

    void start(View j){

        cont=0;
        startTimer();


    }

    void blueEvent(View a){


        userColors.add(0);
        btnBlue.setBackgroundColor(Color.BLUE);
        final long changeTime = 200L;
        btnBlue.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnBlue.setBackgroundColor(Color.parseColor("#136CF1"));
                sndblue.start();
            }
        }, changeTime);
        cont++;
        check();

    }

    void redEvent(View r){


        userColors.add(1);
        btnRed.setBackgroundColor(Color.RED);
        final long changeTime = 200L;
        btnRed.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnRed.setBackgroundColor(Color.parseColor("#CD3813"));
                sndred.start();
            }
        }, changeTime);
        cont++;
        check();

    }

    void greenEvent(View ve){


        userColors.add(2);
        btnGreen.setBackgroundColor(Color.GREEN);

        final long changeTime = 200L;
        btnGreen.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnGreen.setBackgroundColor(Color.parseColor("#1EA307"));
                sndgreen.start();
            }
        }, changeTime);
        cont++;
        check();

    }

    void yellowEvent(View a){


        userColors.add(3);
        btnYellow.setBackgroundColor(Color.YELLOW);
        final long changeTime = 200L;
        btnYellow.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnYellow.setBackgroundColor(Color.parseColor("#D4E113"));
                sndyellow.start();
            }
        }, changeTime);

        cont++;
        check();

    }



    public void startTimer(){
        timer = new Timer();
        simonDecides();
        timer.schedule(timerTarea, 0, 1000);
    }
    public void stopTimer(){
        if (timer !=null){
            timer.cancel();
            timer= null;
        }
    }
    void simonDecides(){
        timerTarea = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int numero= random();
                        simonColors.add(numero);

                        if (numero == 0) {
                            btnBlue.setBackgroundColor(Color.BLUE);

                            btnBlue.postDelayed(new Runnable() {
                                public void run() {
                                    btnBlue.setBackgroundColor(Color.parseColor("#136CF1"));
                                    sndblue.start();
                                }
                            }, 500);

                        }

                        if (numero == 1) {
                            btnRed.setBackgroundColor(Color.RED);

                            btnRed.postDelayed(new Runnable() {
                                public void run() {
                                    btnRed.setBackgroundColor(Color.parseColor("#CD3813"));
                                    sndred.start();
                                }
                            }, 500);


                        }
                        if (numero == 2) {
                            btnGreen.setBackgroundColor(Color.GREEN);

                            btnGreen.postDelayed(new Runnable() {
                                public void run() {
                                    btnGreen.setBackgroundColor(Color.parseColor("#1EA307"));
                                    sndgreen.start();
                                }
                            }, 500);

                        }
                        if (numero == 3) {
                            btnYellow.setBackgroundColor(Color.YELLOW);

                            btnYellow.postDelayed(new Runnable() {
                                public void run() {
                                    btnYellow.setBackgroundColor(Color.parseColor("#D4E113"));
                                    sndyellow.start();
                                }
                            }, 500);


                        }
                        cont++;
                        if(cont==4){
                            stopTimer();
                            cont=0;
                        }

                    }
                });

            }
        };


    }

    void check(){
        if(cont==4) {
            String simonElect = simonColors.toString();
            String userElect = userColors.toString();

            //Condiciones de final de partida

            if (simonElect.equalsIgnoreCase(userElect)) {
                //creo un intent para enviar una variable a la clase secundaria

                Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                String nulo = null;
                intent.putExtra("condicion",nulo); //le asigno el valor nulo para comparar en la otra clase
                startActivity(intent);


            } else {
                Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                intent.putExtra("condicion","asdf"); //le asigno un String cualquiera para comparar
                startActivity(intent);
            }

        }
    }
    public int random(){

        return (int) Math.floor(Math.random()*4);
    }
}
