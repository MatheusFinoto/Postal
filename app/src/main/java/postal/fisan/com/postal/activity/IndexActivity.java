package postal.fisan.com.postal.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

import postal.fisan.com.postal.R;
import postal.fisan.com.postal.fragment.HomeFragment;
import postal.fisan.com.postal.fragment.PerfilFragment;
import postal.fisan.com.postal.modal.Entregas;


public class IndexActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private HomeFragment homeFragment;
    private PerfilFragment perfilFragment;

    private Entregas entregas;

    private ArrayList<Entregas> ent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.m_bottombar);
        frameLayout = (FrameLayout) findViewById(R.id.m_frame);

        homeFragment = new HomeFragment();
        perfilFragment = new PerfilFragment();

        setFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.item_home:
                        setFragment(homeFragment);
                        return  true;
                    case  R.id.item_rotas:
                        return  true;
                    case  R.id.item_perfil:
                        setFragment(perfilFragment);
                        return  true;
                    default: return false;
                }
            }
        });
    }

    private void setFragment(android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.m_frame, fragment);
        fragmentTransaction.commit();
    }


}
