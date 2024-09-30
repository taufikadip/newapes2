data class Freelancer(
    val id: Int,
    val name: String,
    val hourlyRate: Double,
    var assignedTasks: MutableList<Task> = mutableListOf()
) {
    init {
        require(name.isNotEmpty()) { "Name cannot be empty" }
        require(hourlyRate > 0) { "Hourly rate must be positive" }
    }
}