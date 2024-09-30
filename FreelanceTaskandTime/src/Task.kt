data class Task(
    val id: Int,
    val description: String,
    var freelancer: Freelancer,
    val estimatedHours: Int,
    var actualHours: Int = 0,
    var status: String = "Not Started"
) {
    init {
        require(description.isNotEmpty()) { "Description cannot be empty" }
        require(estimatedHours > 0) { "Estimated hours must be positive" }
    }
}