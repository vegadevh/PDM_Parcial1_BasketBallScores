package com.diegoveega.basketballscores

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegoveega.basketballscores.Adapter.PartidoListAdapter
import com.diegoveega.basketballscores.Interface.ComuFrag
import com.diegoveega.basketballscores.ViewModel.DataBaseViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ListPartidosFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ListPartidosFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ListPartidosFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    var actividad = Activity()
    var Comu = object : ComuFrag {
        override fun EnviarPartido(
            EquipoNameA : String,
            EquipoNameB: String,
            PuntosEquipoA:Int,
            PuntosEquipoB:Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vista = inflater.inflate(R.layout.fragment_list_partidos,container,false)
        val viewmodel = ViewModelProviders.of(this).get(DataBaseViewModel::class.java)
        val recyclerView = vista.findViewById<RecyclerView>(R.id.partidosRV)
        val fab = vista.findViewById<Button>(R.id.fab)

        val adapter = context?.let { PartidoListAdapter(it) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewmodel.allPartidos.observe(this, Observer{partidos ->
            partidos?.let{adapter?.setOnClickListener(object :View.OnClickListener{
                override fun onClick(v: View?) {
                    Comu.EnviarPartido(partidos.get(recyclerView.getChildAdapterPosition(v!!)).EquipoNameA,
                    partidos.get(recyclerView.getChildAdapterPosition(v)).EquipoNameB,
                    partidos.get(recyclerView.getChildAdapterPosition(v)).PuntosEquipoA,
                    partidos.get(recyclerView.getChildAdapterPosition(v)).PuntosEquipoB)
                }})}
        })

        viewmodel.allPartidos.observe(this,Observer{ partidos ->
            Log.d("partidos", "- - - - - - - - - - - - - -")
            for(repo in partidos){
                Log.d("Lista de repos", repo.Id_Partido.toString())

            }
        })

        viewmodel.allPartidos.observe(this, Observer { partidos->
            partidos?.let {
                adapter?.setPartidos(partidos)
            }
        })

        fab.setOnClickListener {
            val intent = Intent(context, BKBActivity::class.java)
            startActivity(intent)
        }

        // Inflate the layout for this fragment
        return vista
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            this.actividad = context as Activity
            Comu = this.actividad as ComuFrag
        }
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other ComuFrag]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListPartidosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListPartidosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
