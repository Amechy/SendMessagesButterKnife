package com.example.sendmessagebutterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sendmessagebutterknife.POJO.Message;


/**
 * Esta clase envia un mensaje de un usuario a otro
 *
 * @author Alejandro Mechiné
 *
 *
 * <p>Conceptos aprendidos</p>
 * <ul>
 *      <li>Concepto de context</li>
 *      <li>Paso de parámetros mediante el objeto @see android.os.Bundle </li>
 *      <li>Paso de mensajes entre dos actividades mediante la clase @see android.content.Intent </li>
 *
 * </ul>
 * @Version 2.0
 */
public class SendMessageActivity extends AppCompatActivity {


    private EditText etxMessage;
    private EditText etxUser;
    private Button btnOk;
    private static final String TAG = "SendMessageActivity";

    private Message mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        etxMessage = (EditText) findViewById(R.id.etxMessage);
        etxUser = (EditText) findViewById(R.id.etxUser);



        btnOk = (Button) findViewById(R.id.btnOk);
        //1. Registrar un Listenner o escuchador OnClickListener
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mensaje = new Message(etxMessage.getText().toString(),etxUser.getText().toString());
                //1.Recoger el mensaje
                //etxMessage.getText().toString();
                //2. Crear un objeto bundle y añadir el mensaje

                Bundle bundle = new Bundle();
                bundle.putSerializable("message", mensaje);
                //bundle.putString("message", etxMessage.getText().toString());
                //bundle.putString("user", etxUser.getText().toString());
                //3. Crear un objeto Intent
                Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);//Tiene como destinatario un activity: Explicito; sabemos cual es el destinarario. Implicito; no sabemnos cual es el destinatario
                intent.putExtras(bundle);
                //4. Iniciar la Activity ViewMessage
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessage: OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessage: OnResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessage: OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessage: OnStop");
    }


    /* public void getOnClick (View view)
    {
        switch (view.getId()){
            case R.id.btnOk:

                //1.Recoger el mensaje
                //etxMessage.getText().toString();
                //2. Crear un objeto bundle y añadir el mensaje
                Bundle bundle = new Bundle();
                bundle.putString("message",etxMessage.getText().toString());
                bundle.putString("user",etxUser.getText().toString());
                //3. Crear un objeto Intent
                Intent intent = new Intent(SendMessageActivity.this,ViewMessageActivity.class);//Tiene como destinatario un activity: Explicito; sabemos cual es el destinarario. Implicito; no sabemnos cual es el destinatario
                intent.putExtras(bundle);
                //4. Iniciar la Activity ViewMessage
                startActivity(intent);
                break;
        }
    }*/
}
