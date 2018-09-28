package postal.fisan.com.postal.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import postal.fisan.com.postal.R;
import postal.fisan.com.postal.model.Entregas;

public class EntregasAdapter extends ArrayAdapter<Entregas> {
    private final Context contexto;
    private final ArrayList<Entregas> entregas;


    public EntregasAdapter(@NonNull Context context, @NonNull ArrayList<Entregas> objects) {
        super(context,0, objects);
        this.contexto = context;
        this.entregas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;

        if (entregas != null){
            LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.lista_entregas, parent, false);

            TextView localEntrega = (TextView) view.findViewById(R.id.lblLocalEntrega);
            TextView endereco = (TextView) view.findViewById(R.id.lblEndereco);
            TextView cep = (TextView) view.findViewById(R.id.lblCEP);
            TextView hora = (TextView) view.findViewById(R.id.lblHoraInicio);
            ImageView imagestatus = (ImageView) view.findViewById(R.id.imageView_status);

            Entregas entrega = entregas.get(position);
            localEntrega.setText(entrega.getLocalEntrega());
            endereco.setText(entrega.getEndereco());
            cep.setText(entrega.getCep());
            hora.setText(entrega.getHoraInicio());
            int sta = entrega.getStatus();
            switch (sta){
                case 0: imagestatus.setImageResource(R.drawable.boxboxopenxxxhdpi);
                break;
                case 1: imagestatus.setImageResource(R.drawable.boxboxativo2xxxhdpi);
                break;
            }
        }
        return view;
    }
}
