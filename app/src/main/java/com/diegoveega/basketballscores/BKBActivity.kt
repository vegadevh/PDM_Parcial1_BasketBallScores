package com.diegoveega.basketballscores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.diegoveega.basketballscores.ViewModel.ScoreViewModel
import kotlinx.android.synthetic.main.activity_bkb.*

class BKBActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bkb)

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

    fun addOneTeamA(v: View) {
        displayScore(
            tv_score_team_a,
            ++scoreViewModel.scoreTeamA
        )
    }

    fun addOneTeamB(v: View) {
        displayScore(
            tv_score_team_b,
            ++scoreViewModel.scoreTeamB
        )
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    }

    fun Final(v: View) {
        /*
        scoreViewModel.scoreTeamA = 0
        scoreViewModel.scoreTeamB = 0

        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )

        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
        */
    }

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }
}
