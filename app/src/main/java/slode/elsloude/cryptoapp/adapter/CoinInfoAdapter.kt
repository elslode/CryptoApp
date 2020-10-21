package slode.elsloude.cryptoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*
import slode.elsloude.cryptoapp.R
import slode.elsloude.cryptoapp.pojo.CoinPriceInfo

class CoinInfoAdapter(private val context: Context) : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                val symbolsTemplate = context.resources.getString(R.string.symbol_template)
                val lastUpdateCoin = context.resources.getString(R.string.last_update_coin)
                tvSymbols.text = String.format(symbolsTemplate, fromSymbol, tosymbol)
                tvCoinPrice.text = price.toString()
                tvLastUpdate.text = String.format(lastUpdateCoin, getFormattedTime())
                Picasso.get().load(getFullImageURL()).into(holder.ivLogoCoin)

                itemView.setOnClickListener{
                    onCoinClickListener?.onCoinClick(this    )
                }
            }
        }
    }

    override fun getItemCount() = coinInfoList.size

    inner class CoinInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogoCoin = itemView.ivLogoCoin
        val tvSymbols = itemView.tvSymbols
        val tvCoinPrice = itemView.tvCoinPrice
        val tvLastUpdate = itemView.tvLastUpdate
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}