package com.diegoveega.basketballscores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.diegoveega.basketballscores.Room.Entities.Partido
import com.diegoveega.basketballscores.ViewModel.DataBaseViewModel
import com.diegoveega.basketballscores.ViewModel.ScoreViewModel
import kotlinx.android.synthetic.main.activity_bkb.*

class BKBActivity : AppCompatActivity() {

    private lateinit var EquipoAName: EditText
    private lateinit var EquipoBName: EditText
    private lateinit var EquipoAScore: TextView
    private lateinit var EquipoBScore: TextView

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bkb)

        val viewmodel = ViewModelProviders.of(this).get(DataBaseViewModel::class.java)


        EquipoAName = findViewById(R.id.EquipoA_name)
        EquipoBName = findViewById(R.id.EquipoB_name)
        EquipoAScore = findViewById(R.id.tv_score_team_a)
        EquipoBScore = findViewById(R.id.tv_score_team_b)

        val button = findViewById<Button>(R.id.btn_Fin)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(EquipoAName.text) || TextUtils.isEmpty(EquipoBName.text) || TextUtils.isEmpty(
                    EquipoAScore.text
                ) || TextUtils.isEmpty(EquipoBScore.text)
            ) {
                //setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val EquipoNameA = EquipoAName.text.toString()
                val EquipoNameB = EquipoBName.text.toString()
                val PuntosEquipoA = EquipoAScore.text.toString()
                val PuntosEquipoB = EquipoBScore.text.toString()

                viewmodel.insertPartido(Partido(EquipoNameA, EquipoNameB, PuntosEquipoA.toInt(), PuntosEquipoB.toInt(),Fav = false))

                Toast.makeText(this, "Se creo el libro correctamente", Toast.LENGTH_SHORT).show()

            }
            finish()
        }

        bt_team_a_1.setOnClickListener {
            displayScore(
                tv_score_team_a,
                ++scoreViewModel.scoreTeamA
            )
        }

        bt_team_b_1.setOnClickListener {
            displayScore(
                tv_score_team_b,
                ++scoreViewModel.scoreTeamB
            )
        }

        bt_team_a_2.setOnClickListener {
            scoreViewModel.scoreTeamA += 2
            displayScore(
                tv_score_team_a,
                scoreViewModel.scoreTeamA
            )
        }

        bt_team_b_2.setOnClickListener{
            scoreViewModel.scoreTeamB += 2
            displayScore(
                tv_score_team_b,
                scoreViewModel.scoreTeamB
            )
        }

        bt_team_a_3.setOnClickListener {
            scoreViewModel.scoreTeamA += 3
            displayScore(
                tv_score_team_a,
                scoreViewModel.scoreTeamA
            )
        }

        bt_team_b_3.setOnClickListener {
            scoreViewModel.scoreTeamB += 3
            displayScore(
                tv_score_team_b,
                scoreViewModel.scoreTeamB
            )
        }


        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )

        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )

    }

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }
}
