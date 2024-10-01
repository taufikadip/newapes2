import java.time.LocalDate

data class Project(
    val id: Int,
    val name: String,
    val client: String,
    val deadline: LocalDate,
    var tasks: MutableList<Task> = mutableListOf(),
    var totalBudget: Double = 0.0
) {
    init {
        require(name.isNotEmpty()) { "Name cannot be empty" }
        require(client.isNotEmpty()) { "Client cannot be empty" }
        require(deadline >= LocalDate.now()) { "Date must be today or future" }
    }
}