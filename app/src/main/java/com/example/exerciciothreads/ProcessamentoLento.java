package com.example.exerciciothreads;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class ProcessamentoLento extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processamento_lento);

        textView = (TextView) findViewById(R.id.txt_status);
    }

    public void processar(View view) {
        textView.setText("Processando...");
        executarAlgoDemorado();
//        textView.setText(R.string.finalizado);
    }

    private void executarAlgoDemorado() {
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(15000);
//                textView.setText(R.string.finalizado);
//            }
//        };
//
//        Thread t = new Thread(r);
//
//        t.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(15000);

                 runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(R.string.finalizado);
                    }
                });

            }
        }).start();
    }
}
