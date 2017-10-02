package com.example.sendmessagebutterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sendmessagebutterknife.POJO.Message;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


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

    @BindView(R.id.etxMessage)
    EditText etxMessage;
    @BindView(R.id.etxUser)
    EditText etxUser;
    @BindView(R.id.btnOk)
    Button btnOk;
    static final String TAG = "SendMessageActivity";

    Message mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        //Vincular el id de las vistas en el XML con las clases View
        ButterKnife.bind(this);
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



     @OnClick(R.id.btnOk)
     public void getOnClick (View view)
    {
        switch (view.getId()){
            case R.id.btnOk:

                mensaje = new Message(etxMessage.getText().toString(),etxUser.getText().toString());

                //1. Crear un objeto bundle y añadir el mensaje.

                Bundle bundle = new Bundle();
                bundle.putSerializable("message", mensaje);

                //2. Crear un objeto Intent
                Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);//Tiene como destinatario un activity: Explicito; sabemos cual es el destinarario. Implicito; no sabemnos cual es el destinatario
                intent.putExtras(bundle);
                //3. Iniciar la Activity ViewMessage
                startActivity(intent);
                break;
        }
    }
}
