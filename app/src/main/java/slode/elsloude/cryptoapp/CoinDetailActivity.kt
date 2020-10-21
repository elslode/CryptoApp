package slode.elsloude.cryptoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coin_detail.*

@Suppress("DEPRECATION")
class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)
        viewModel = ViewModelProviders.of(this)[CoinViewModel::class.java]
        fromSymbol?.let {
            viewModel.getDetailInfo(it).observe(this, Observer {
                tvPrice.text = it.price.toString()
                tvPriceMinForDayCoin.text = it.lowDay.toString()
                tvPriceMaxForDayCoin.text = it.highday.toString()
                tvLastDeal.text = it.lastMarket.toString()
                tvTime.text = it.getFormattedTime()
                tvFromSymbol.text = it.fromSymbol.toString()
                tvToSymbol.text = it.tosymbol.toString()
                Picasso.get().load(it.getFullImageURL()).into(labelCoin)
            })
        }
    }

    companion object {
       private const val EXTRA_FROM_SYMBOL = "fSym "

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}


