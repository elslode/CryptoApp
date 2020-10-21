package slode.elsloude.cryptoapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import slode.elsloude.cryptoapp.api.ApiFactory.BASE_IMAGE_URL
import slode.elsloude.cryptoapp.utils.convertTimeStampToTime

@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    val type: String?,

    @SerializedName("MARKET")
    @Expose
    val market: String?,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String,

    @SerializedName("TOSYMBOL")
    @Expose
    val tosymbol: String?,

    @SerializedName("FLAGS")
    @Expose
    val flags: String?,

    @SerializedName("PRICE")
    @Expose
    val price: Double?,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastupdate: Long,

    @SerializedName("MEDIAN")
    @Expose
    val median: Double?,

    @SerializedName("LASTVOLUME")
    @Expose
    val lastvolum: Double?,

    @SerializedName("LASTVOLUMETO")
    @Expose
    val lastvolumto: Double?,

    @SerializedName("LASTTRADEID")
    @Expose
    val lasttradeid: String?,

    @SerializedName("VOLUMEDAY")
    @Expose
    val volumeday: Double?,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    val volumdayto: Double?,

    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24hour: Double?,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24hourTo: Double?,

    @SerializedName("OPENDAY")
    @Expose
    val openday: Double?,

    @SerializedName("HIGHDAY")
    @Expose
    val highday: Double?,

    @SerializedName("LOWDAY")
    @Expose
    val lowDay: Double?,

    @SerializedName("OPEN24HOUR")
    @Expose
    val open24Hour: Double?,

    @SerializedName("HIGH24HOUR")
    @Expose
    val high24Hour: Double?,

    @SerializedName("LOW24HOUR")
    @Expose
    val low24HOur: Double?,

    @SerializedName("LASTMARKET")
    @Expose
    val lastMarket: String?,

    @SerializedName("VOLUMEHOUR")
    @Expose
    val volumeHour: Double?,

    @SerializedName("VOLUMEHOURTO")
    @Expose
    val vOLUMEHOURTO: Double?,

    @SerializedName("OPENHOUR")
    @Expose
    val oPENHOUR: Double?,

    @SerializedName("HIGHHOUR")
    @Expose
    val highHour: Double?,

    @SerializedName("LOWHOUR")
    @Expose
    val lowHour: Double?,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    val topTrierVolume24Hour: Double?,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    val ropTierVolume24HourTo: Double?,

    @SerializedName("CHANGE24HOUR")
    @Expose
    val change24Hour: Double?,

    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    val changepct24Hour: Double?,

    @SerializedName("CHANGEDAY")
    @Expose
    val changeDay: Double?,

    @SerializedName("CHANGEPCTDAY")
    @Expose
    val changePCTDay: Double?,

    @SerializedName("CHANGEHOUR")
    @Expose
    val changeHour: Double?,

    @SerializedName("CHANGEPCTHOUR")
    @Expose
    val changePCTHour: Double?,

    @SerializedName("CONVERSIONTYPE")
    @Expose
    val converstionType: String?,

    @SerializedName("CONVERSIONSYMBOL")
    @Expose
    val converstionSymbol: String?,

    @SerializedName("SUPPLY")
    @Expose
    val supply: Int?,

    @SerializedName("MKTCAP")
    @Expose
    val mktCap: Int?,

    @SerializedName("TOTALVOLUME24H")
    @Expose
    val totalVolum24H: Double?,

    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    val totalVolum24HTo: Double?,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    val totalTopTierVolume24H: Double?,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    val totalTopTierVolume24HTo: Double?,

    @SerializedName("IMAGEURL")
    @Expose
    val imageURL: String?
) {
    fun getFormattedTime(): String {
        return convertTimeStampToTime(lastupdate)
    }

    fun getFullImageURL(): String {
        return BASE_IMAGE_URL + imageURL
    }
}
