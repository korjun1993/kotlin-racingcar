package racingcar

data class Car(
    var location: Int = CAR_DEFAULT_LOCATION,
    val name: String,
    private val engine: Engine = RandomPowerEngine(),
) {
    init {
        require(this.name.length <= CAR_MAX_NAME_LENGTH) { "자동차 이름은 최대 ${CAR_MAX_NAME_LENGTH}글자 입니다" }
    }

    fun moveOrStop() {
        val power = engine.powerUp()
        location += if (isMovablePower(power)) 1 else 0
    }

    override fun toString(): String {
        return "$name : " + CAR_LOCATION_PATH_SYMBOL.repeat(location)
    }

    private fun isMovablePower(power: Int) =
        power in MOVABLE_MIN_POWER..MOVABLE_MAX_POWER

    companion object {
        private const val CAR_DEFAULT_LOCATION = 0
        private const val MOVABLE_MAX_POWER = 9
        private const val MOVABLE_MIN_POWER = 4
        private const val CAR_LOCATION_PATH_SYMBOL = "-"
        private const val CAR_MAX_NAME_LENGTH = 5
    }
}
