package com.example.sendmessagebutterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.sendmessagebutterknife.POJO.Message;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Esta clase recibe un mensaje de un usuario y lo muestra en pantalla
 *  <p>Conceptos aprendidos</p>
 *      <ul>
 *          <li>Recepcion de mensajes mediante la clase android.content.Intent</li>
 *      </ul>
 *
 *      //TODO 1, Recoger el Intent.
 */
public class ViewMessageActivity extends AppCompatActivity {

    @BindView(R.id.txvViewMessage)
    TextView txvViewMessage;
    @BindView(R.id.txvViewUser)
    TextView txvViewUser;
    Message mensaje;
    static final String TAG = "ViewMessageActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        //Vincular el id de las vistas en el XML con las clases View
        ButterKnife.bind(this);

        mensaje = (Message)getIntent().getExtras().getSerializable("message");



        txvViewMessage.setText(mensaje.getMessage());

        String viewUser=String.format(getResources().getString(R.string.txvViewUser), mensaje.getUser());
        txvViewUser.setText(viewUser);




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"SendMessage: OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"SendMessage: OnResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"SendMessage: OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"SendMessage: OnStop");
    }

}
