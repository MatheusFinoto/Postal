package postal.fisan.com.postal.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import postal.fisan.com.postal.R;
import postal.fisan.com.postal.adapter.EntregasAdapter;
import postal.fisan.com.postal.modal.Entregas;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

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
        ent = new ArrayList<>();

        entregas = new Entregas();
        entregas.setLocalEntrega("Casa do Matheus");
        entregas.setEndereco("Rua do centro 435");
        entregas.setCep("14700,050");
        entregas.setHoraInicio("11:50");
        ent.add(entregas);

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listView = view.findViewById(R.id.lv_itens);
        mbuttom = view.findViewById(R.id.btn_add);

        mbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new EntregasAdapter(getActivity(), ent);
                listView.setAdapter(adapter);
            }
        });


        // Inflate the layout for this fragment


        return view;
    }

}
