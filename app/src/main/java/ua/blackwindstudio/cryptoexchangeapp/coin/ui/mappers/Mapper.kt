package ua.blackwindstudio.cryptoexchangeapp.coin.ui.mappers

import ua.blackwindstudio.cryptoexchangeapp.coin.data.db.model.CoinDbModel
import ua.blackwindstudio.cryptoexchangeapp.coin.ui.ResourceProvider
import ua.blackwindstudio.cryptoexchangeapp.coin.ui.model.UiCoin
import ua.blackwindstudio.cryptoexchangeapp.coin.ui.utils.DATE_TIME_STRING_NAME
import ua.blackwindstudio.cryptoexchangeapp.coin.ui.utils.formatDate
import javax.inject.Inject

class Mapper @Inject constructor(private val resourceProvider: ResourceProvider) {
    fun mapDbModelToUiCoin(dbModel: CoinDbModel): UiCoin =
        UiCoin(
            fromSymbol = dbModel.fromSymbol,
            toSymbol = dbModel.toSymbol,
            price = dbModel.price,
            dailyMin = dbModel.lowDay,
            dailyMax = dbModel.highDay,
            lastMarket = dbModel.lastMarket,
            updated = formatDate(
                dbModel.lastUpdate,
                resourceProvider.stringsMap[DATE_TIME_STRING_NAME] ?: DEFAULT_DATE_TIME_PATTERN
            ),
            imageUrl = dbModel.imageUrl
        )

    companion object {
        private const val DEFAULT_DATE_TIME_PATTERN = "%02d.%d %s"
    }
}