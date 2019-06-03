package com.diegoveega.basketballscores

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegoveega.basketballscores.Adapter.PartidoListAdapter
import com.diegoveega.basketballscores.Interface.ComuFrag

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ListPartidosFragment.OnFragmentInteractionListener,DetailPartidoFragment.OnFragmentInteractionListener, ComuFrag {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var listaFragment = ListPartidosFragment()
    var detalleFragment = DetailPartidoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(findViewById<FrameLayout>(R.id.ContenedorFragments) != null){
            if(savedInstanceState != null){
            }
            supportFragmentManager.beginTransaction().replace(R.id.ContenedorFragments, listaFragment).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.fl_lista, listaFragment).commit();
        }
/*
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PartidoListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
*/
    }
    override fun EnviarPartido(EquipoNameA: String, EquipoNameB: String, PuntosEquipoA: Int, PuntosEquipoB: Int) {
        val bundle  = Bundle()

        bundle.putString("Equipo", EquipoNameA)
        bundle.putInt("Puntaje", PuntosEquipoA)
        bundle.putString("Equipo", EquipoNameB)
        bundle.putInt("Equipo", PuntosEquipoB)

        detalleFragment.arguments = bundle

        val fragmento : Fragment? = supportFragmentManager.findFragmentById(R.id.fl_detalle)
        if (findViewById<FrameLayout>(R.id.ContenedorFragments)== null){
            if (fragmento is DetailPartidoFragment){
                val fragmento2:Fragment? = supportFragmentManager.findFragmentByTag("fragdetalle")
                supportFragmentManager.beginTransaction().remove(fragmento2!!).commit()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fl_detalle,detalleFragment,"fragdetalle").addToBackStack(null).commitAllowingStateLoss()
            Log.i("Aja:","Aja")
        }
        else{
            val bundle  = Bundle()

            bundle.putString("Equipo", EquipoNameA)
            bundle.putInt("Puntaje", PuntosEquipoA)
            bundle.putString("Equipo", EquipoNameB)
            bundle.putInt("Equipo", PuntosEquipoB)

            detalleFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.ContenedorFragments, detalleFragment).addToBackStack(null).commit()

        }

    }
}
