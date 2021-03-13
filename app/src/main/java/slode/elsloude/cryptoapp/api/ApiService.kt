package slode.elsloude.cryptoapp.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import slode.elsloude.cryptoapp.pojo.CoinInfoListOfData
import slode.elsloude.cryptoapp.pojo.CoinPriceInfoRawData

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "471b5acba97864f928020172560210dd9b42b2d45b96e89db1a7c896a2216fa8",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
        ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFulPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "471b5acba97864f928020172560210dd9b42b2d45b96e89db1a7c896a2216fa8",
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY
    ): Single<CoinPriceInfoRawData>

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        private const val CURRENCY = "USD"
    }
}