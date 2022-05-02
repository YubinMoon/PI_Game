package com.limeskin.pi_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.limeskin.pi_game.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // ID 가져오기 위한 바인딩
    private lateinit var numArray: Array<View> // 버튼 리스트
    private var str = "" // 출력 스트링
    private var score = 0 // 점수 겸 문자열 위치
    private val PI = // PI
        "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823066470938446095505822317253594081284811174502841027019385211055596446229489549303819644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412737245870066063155881748815209209628292540917153643678925903600113305305488204665213841469519415116094330572703657595919530921861173819326117931051185480744623799627495673518857527248912279381830119491298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051320005681271452635608277857713427577896091736371787214684409012249534301465495853710507922796892589235420199561121290219608640344181598136297747713099605187072113499999983729780499510597317328160963185950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171776691473035982534904287554687311595628638823537875937519577818577805321712268066130019278766111959092164201989"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 레이아웃 소스 가져오기
        setContentView(binding.root) // 가져온 소스 등록

        numArray = arrayOf( // 버튼 배열 등록
            binding.num0,
            binding.num1,
            binding.num2,
            binding.num3,
            binding.num4,
            binding.num5,
            binding.num6,
            binding.num7,
            binding.num8,
            binding.num9
        )
        for (v in numArray) {
            v.setOnClickListener(clickListener)
        }
        binding.scoreBoard.text = getString(R.string.score, score)
    }

    fun setBtn(nextBtn: Int) {
        for (i: Int in numArray.indices) {
            if (i == nextBtn) {
//                numArray[i].background =
            } else {
//                numArray[i].background = AppCompatResources.getDrawable(this, R.drawable.num_btn)
            }
        }
    }

    private val clickListener = View.OnClickListener { view ->
        for (i in numArray.indices) {
            if (view == numArray[i]) {
                if (i == PI[score].code - '0'.code) {
                    str += i.toString()
                    score += 1
                    setBtn(PI[score].code - '0'.code)
                    if (score == 1) {
                        str += '.'
                    }
                }
            }
        }
        binding.numDisplay.text = str
        binding.scoreBoard.text = getString(R.string.score, score)
        Handler(Looper.getMainLooper()).postDelayed({
            binding.scroll.scrollTo(binding.numDisplay.width, 0)
        }, 1)
    }
}
