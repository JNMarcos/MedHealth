package com.example.jn.medhealth;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by MarcosInacio on 25/10/2016.
 */

public class UnidadeDeSaudeActivity extends AppCompatActivity
        implements UnidadeDeSaudeListFragment.AoClicarNaUnidadeDeSaude,
        AdapterView.OnItemClickListener{

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle; //Abertura e fechamento do menu lateral

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unidadedesaude);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                R.string.app_name, R.string.app_name){
            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                supportInvalidateOptionsMenu(); //Reconstroem as ações da action bar
            }
            public  void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);//Setamos o toggle no mDrawerLayout

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(//preencherá a list view
                this, android.R.layout.simple_list_item_1, //e exibirá as opções do menu
                getResources().getStringArray(R.array.opcoes)); //lateral
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(this);
        if(savedInstanceState == null){
            exibirItem(0); //exibe a primeira opção do menu na primeira execução
        }
    }

    @Override
    public void onItemClick(AdapterView parent, View view,
                            int position, long id){
        exibirItem(position); //exibimos a tela pela posição que clicarmos
    }

    //carregamos o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_saude, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //só podemos ter um menu aberto
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        atualizarTitulo(drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    //sincronizamos o estado da Toolbar com o do mDrawerToogle
    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    //verifica se clicamos no menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void exibirItem(int position){
        String selecionado = mDrawerList.getItemAtPosition(position).toString();
        Fragment fragment = PrimeiroNivelFragment.novaInstancia(selecionado);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment)
                .commit();
        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    private void atualizarTitulo(boolean drawerIsOpen){
        if(drawerIsOpen){
            mToolbar.setTitle(R.string.app_name);
        }
        else{
            int posicaoAtual = mDrawerList.getCheckedItemPosition();
            String opcaoAtual = mDrawerList.getItemAtPosition(posicaoAtual).toString();
            mToolbar.setTitle(opcaoAtual);
        }
    }


    public void clicouNaUnidadeDeSaude(UnidadeDeSaude unidadeDeSaude){
        if(isTablet()){
            UnidadeDeSaudeDetalheFragment fragment =
                    UnidadeDeSaudeDetalheFragment.novaInstancia(unidadeDeSaude);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe, fragment,
                    UnidadeDeSaudeDetalheFragment.TAG_DETALHE);
            ft.commit();
        }
                Intent it = new Intent(this, UnidadeDeSaudeDetalheActivity.class);
        it.putExtra(UnidadeDeSaudeDetalheActivity.EXTRA_UNIDADEDESAUDE, unidadeDeSaude);
        startActivity(it);
    }
    private boolean isTablet(){
        return findViewById(R.id.detalhe) != null;
    }
}
