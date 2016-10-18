package com.example.douglas.p1_01;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private Button botaoOk;
    private Button botaoLimpar;
    private EditText usuarioEditText;
    private EditText senhaEditText;
    private TextView resultadoTextView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = (EditText) findViewById(R.id.usuarioEditText);
        senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);

        botaoLimpar = (Button) findViewById(R.id.limparButton);
        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                limparButtonAction();
            }
        });

        botaoOk = (Button) findViewById(R.id.acessoButton);
        botaoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okButtonAction();
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void okButtonAction() {
        String usuarioInserido = usuarioEditText.getText().toString();
        String senhaInserida = senhaEditText.getText().toString();

        if (usuarioInserido.equalsIgnoreCase("admin@admin.com") &&
                senhaInserida.equals(senhaInserida)) {
            resultadoTextView.setText("Acesso Ok!");
        } else {
            resultadoTextView.setText("Acesso negado!");
        }
    }


    private void limparButtonAction() {
        usuarioEditText.setText(null);
        senhaEditText.setText(null);
        resultadoTextView.setText(null);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}


