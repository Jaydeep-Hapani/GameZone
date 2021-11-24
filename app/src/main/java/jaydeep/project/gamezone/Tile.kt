package jaydeep.project.gamezone

class Tile(
    private var number:Int? = null
) {
    fun number():Int{
        return number!!
    }
}