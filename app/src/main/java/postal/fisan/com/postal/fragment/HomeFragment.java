package postal.fisan.com.postal.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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


    public HomeFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.lv_itens);
        mbuttom = view.findViewById(R.id.btn_add);

        ent = new ArrayList<>();

        entregas = new Entregas();
        entregas.setLocalEntrega("Casa do Matheus");
        entregas.setEndereco("Rua do centro 435");
        entregas.setCep("14700,050");
        entregas.setHoraInicio("11:50");
        entregas.setStatus(0);
        ent.add(entregas);

        entregas = new Entregas();
        entregas.setLocalEntrega("Casa do Luis");
        entregas.setEndereco("Rua do centro 435");
        entregas.setCep("14700,050");
        entregas.setHoraInicio("11:50");
        entregas.setStatus(0);
        ent.add(entregas);

        adapter = new EntregasAdapter(getActivity(), ent);
        listView.setAdapter(adapter);

        mbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getContext(), AddEntregaActivity.class);
               startActivity(intent);
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


}
