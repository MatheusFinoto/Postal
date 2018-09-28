package postal.fisan.com.postal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import postal.fisan.com.postal.R;
import postal.fisan.com.postal.model.Entregas;

public class AddEntregaActivity extends AppCompatActivity {
    private EditText txtLocEntrega, txtEnd, txtCEP;
    private Button btnSalva;

    private Entregas entregas;
    private ArrayList<Entregas> ent;

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entrega);
        txtLocEntrega = findViewById(R.id.txtLocEntrega);
        txtEnd = findViewById(R.id.txtEnd);
        txtCEP = findViewById(R.id.txtCEP);
        btnSalva = findViewById(R.id.btn_salvaEntrega);

        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");

        Date data = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();

        final String hora_atual = dateFormat_hora.format(data_atual);

        btnSalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*if (!ende.equals("")){*/
                ent = new ArrayList<>();

                entregas = new Entregas();

                entregas.setLocalEntrega(txtLocEntrega.getText().toString());
                entregas.setEndereco(txtEnd.getText().toString());
                entregas.setCep(txtCEP.getText().toString());
                entregas.setHoraInicio(hora_atual);
                entregas.setStatus(0);
                ent.add(entregas);

                Intent intent = new Intent(AddEntregaActivity.this, MainActivity.class);

                startActivity(intent);

                /*}else{
                    Toast.makeText(AddEntregaActivity.this, "Adicionar um Endereço", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

    }
}
