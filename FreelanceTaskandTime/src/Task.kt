data class Task (
    val id: Int,
    var description: String,
    var freelancer: Freelancer? = null,
    val estimatedHours: Int,
    var actualHours: Int = 0,
    var status: String = "Not Started"
    ) {
        init {
            require(description.isNotEmpty()) { "Deskripsi tidak boleh kosong" }
            require(estimatedHours > 0) { "Estimasi waktu harus bernilai positif" }
        }

        fun logHours(hours: Int) {
            require(status != "Completed") { "Tidak bisa menambahkan jam kepada Task yang selesai" }
            actualHours += hours
            if (actualHours >= estimatedHours) {
                status = "Completed"
            } else {
                status = "In Progress"
            }
        }
    }