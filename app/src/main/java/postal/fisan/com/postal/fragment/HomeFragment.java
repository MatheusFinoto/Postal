package postal.fisan.com.postal.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import postal.fisan.com.postal.activity.AddEntregaActivity;
import postal.fisan.com.postal.adapter.EntregasAdapter;
import postal.fisan.com.postal.modal.Entregas;


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

    public HomeFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.lv_itens);
        mbuttom = view.findViewById(R.id.btn_add);


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
                entregas = new Entregas();

                entregas.setLocalEntrega("Matheus");
                entregas.setEndereco("Casa do Matheus");
                entregas.setCep("14700050   ");
                entregas.setHoraInicio(hora_atual);
                entregas.setStatus(0);
                ent.add(entregas);

                adapter = new EntregasAdapter(getContext(), ent);
                listView.setAdapter(adapter);
                /*Intent intent = new Intent(getContext(), AddEntregaActivity.class);
                startActivity(intent);*/
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
