package com.example.aplicacion_turimos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Principal1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal1);
        //Referencia al Toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        TabLayout tl = (TabLayout) findViewById(R.id.tablayout);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            int position = tab.getPosition();
            switch (position){
                case 0:
                    //llamar al fragmento trasporte
                    Transporte t = new Transporte();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,t).commit();
                    break;
                case 1:
                    //llamar al fragmento mapa
                    Mapa m = new Mapa();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,m).commit();
                    break;
            }
                /* Incorporamos el menu lateral */
                NavigationView nav = (NavigationView) findViewById(R.id.nav);
                nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //Recuperar la opcion del menu
                        int id = item.getItemId();//Recuperar el id de la opcion seleccionada
                        if (id == R.id.op3) {
                            Toast.makeText(getApplicationContext(), "vas al hoteles o hostales", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Principal1.this, Hotelesohostales.class);
                            startActivity(intent);

                        } else if (id==R.id.op4) {
                            Toast.makeText(getApplicationContext(),"vas a al restaurantes",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Principal1.this, Restaurante.class);
                            startActivity(intent);
                        } else if (id==R.id.op5) {
                            Toast.makeText(getApplicationContext(),"vas a los lugares turisticos", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Principal1.this, Lugaresturisticos.class);
                            startActivity(intent);
                        }
                        else if (id==R.id.op6) {
                        Toast.makeText(getApplicationContext(),"vas a los paquetes turisticos", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Principal1.this, Paquetesturisticos.class);
                            startActivity(intent);
                    }
                        else if (id==R.id.op7) {
                    Toast.makeText(getApplicationContext(),"vas a los Lugares para divertirse en copiapo", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Principal1.this, Lugaresparadivertirseencopiapo.class);
                            startActivity(intent);
                }
                        return false;
                    }
                });



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        DrawerLayout dl = (DrawerLayout) findViewById(R.id.principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        dl.addDrawerListener(toggle);
        toggle.syncState();

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (dl.isDrawerOpen(GravityCompat.START)){
                  dl.closeDrawer(GravityCompat.START);
              }
              else{
                  dl.openDrawer((int) Gravity.START);
              }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Incorporar el menu dentro de la activity
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();//Recuperar el id de la opcion seleccionada
        if (id==R.id.op1){
            Toast.makeText(this,"vas al perfil", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.op2) {
            Toast.makeText(this,"vas a la info",Toast.LENGTH_SHORT).show();

        } else if (id==R.id.op3) {
            Toast.makeText(this,"vas a la configuracion", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
