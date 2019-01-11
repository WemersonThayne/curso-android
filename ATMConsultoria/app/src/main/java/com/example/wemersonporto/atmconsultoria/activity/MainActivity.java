package com.example.wemersonporto.atmconsultoria.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.wemersonporto.atmconsultoria.R;
import com.example.wemersonporto.atmconsultoria.fragment.ClienteFragment;
import com.example.wemersonporto.atmconsultoria.fragment.PrincipalFragment;
import com.example.wemersonporto.atmconsultoria.fragment.ServicosFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setPrincipalFragment();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal) {
            this.setPrincipalFragment();
        } else if (id == R.id.nav_servicos) {
            this.setServicosFragment();
        } else if (id == R.id.nav_clientes) {
            this.setClientesFragment();
        } else if (id == R.id.nav_contato) {
            this.enviarEmail();
        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(this, SobreActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setPrincipalFragment(){
        PrincipalFragment principalFragment = new PrincipalFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,principalFragment);
        fragmentTransaction.commit();
    }

    private void setServicosFragment(){
        ServicosFragment servicosFragment = new ServicosFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,servicosFragment);
        fragmentTransaction.commit();
    }

    private void setClientesFragment(){
        ClienteFragment clienteFragment = new ClienteFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer,clienteFragment);
        fragmentTransaction.commit();
    }



    public  void enviarEmail(){

        Intent email  = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"atmconsultoria@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo App");
        email.putExtra(Intent.EXTRA_TEXT,"Mensagem automática");
        email.setType("message/rfcc822");

        startActivity(Intent.createChooser(email,"Escolha o App de e-mail:"));


    }
}
