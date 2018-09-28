package postal.fisan.com.postal.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import postal.fisan.com.postal.R;
import postal.fisan.com.postal.adapter.EntregasAdapter;
import postal.fisan.com.postal.model.Entregas;
import postal.fisan.com.postal.preferencias.CustomAplication;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Entregas> ent;
    private ArrayAdapter adapter;
    private ListView listView;
    private FloatingActionButton mbuttom;

    private Entregas entregas;
    private LinearLayout linearLayout;

    private EditText txtLocalEntrega, txtEndereco, txtCEP;
    private Button btnSalEntrega, btnCanEntrega;

    public HomeFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.lv_itens);
        mbuttom = view.findViewById(R.id.btn_add);
        txtLocalEntrega = view.findViewById(R.id.txtLocEntrega);
        txtEndereco = view.findViewById(R.id.txtEnd);
        txtCEP = view.findViewById(R.id.txtCEP);
        btnSalEntrega = view.findViewById(R.id.btn_salvaEntrega);
        btnCanEntrega= view.findViewById(R.id.btn_canEntrega);

        txtLocalEntrega.setVisibility(View.GONE);
        txtEndereco.setVisibility(View.GONE);
        txtCEP.setVisibility(View.GONE);
        btnSalEntrega.setVisibility(View.GONE);
        btnCanEntrega.setVisibility(View.GONE);

        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");

        Date data = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        Date data_atual = cal.getTime();

        final String hora_atual = dateFormat_hora.format(data_atual);

        ent = new ArrayList<>();

        mbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtLocalEntrega.setVisibility(View.VISIBLE);
                txtEndereco.setVisibility(View.VISIBLE);
                txtCEP.setVisibility(View.VISIBLE);
                btnSalEntrega.setVisibility(View.VISIBLE);
                btnCanEntrega.setVisibility(View.VISIBLE);
            }
        });

        btnSalEntrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtLocalEntrega.getText().toString().equals("") && !txtEndereco.getText().toString().equals("")) {

                    entregas = new Entregas();

                    entregas.setLocalEntrega(txtLocalEntrega.getText().toString());
                    entregas.setEndereco(txtEndereco.getText().toString());
                    entregas.setCep(txtCEP.getText().toString());
                    entregas.setHoraInicio(hora_atual);
                    entregas.setStatus(0);
                    ent.add(entregas);

                    adapter = new EntregasAdapter(getActivity(), ent);
                    listView.setAdapter(adapter);

                    txtLocalEntrega.setText("");
                    txtEndereco.setText("");
                    txtCEP.setText("");

                    txtLocalEntrega.setVisibility(View.GONE);
                    txtEndereco.setVisibility(View.GONE);
                    txtCEP.setVisibility(View.GONE);
                    btnSalEntrega.setVisibility(View.GONE);
                    btnCanEntrega.setVisibility(View.GONE);
                }else {
                    Toast.makeText(getContext(), "Digite um Local para entrega", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCanEntrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtLocalEntrega.setText("");
                txtEndereco.setText("");
                txtCEP.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "UM TOQUE CURTO", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Entregas entrega = ent.get(i);
                entrega.setStatus(1);
                Toast.makeText(getActivity(), "Finalizada", Toast.LENGTH_SHORT).show();
                adapter = new EntregasAdapter(getActivity(), ent);
                listView.setAdapter(adapter);
                return true;
            }
        });
        return view;
    }

    public void addEntrega() {
        ent = new ArrayList<>();

        entregas = new Entregas();

        entregas.setLocalEntrega("Matheus");
        entregas.setEndereco("Rua do centro 435");
        entregas.setCep("14700,050");
        entregas.setHoraInicio("11:50");
        entregas.setStatus(0);
        ent.add(entregas);

        adapter = new EntregasAdapter(getContext(), ent);
        listView.setAdapter(adapter);
    }
}
