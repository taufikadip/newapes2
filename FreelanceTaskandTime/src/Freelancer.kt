data class Freelancer(
    val id: Int,
    val name: String,
    val hourlyRate: Double,
    val assignedTasks: MutableList<Task> = mutableListOf()
) {
    init {
        require(name.isNotEmpty()) { "Nama tidak boleh kosong" }
        require(hourlyRate > 0) { "Estimasi waktu harus bernilai positif" }
    }
}