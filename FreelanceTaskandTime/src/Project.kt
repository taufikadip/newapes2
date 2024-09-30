import java.time.LocalDate

data class Project(
    val id: Int,
    val name: String,
    val client: String,
    val deadline: LocalDate,
    val tasks: MutableList<Task> = mutableListOf(),
    var totalBudget: Double
) { init {
    require(name.isNotEmpty()) { "Name can not be empty" }
    require(client.isNotEmpty()) { "Client can not be empty" }
    }

    fun addTask(task: Task) {
        tasks.add(task)
        task.freelancer?.assignedTasks?.add(task)
        calculateBudget()
    }

    fun calculateBudget() {
        totalBudget = tasks.sumByDouble { it.actualHours * (it.freelancer?.hourlyRate ?: 0.0) }
    }

    fun projectProgress(): Double {
        if (tasks.isEmpty()) return 0.0
        val completedTasks = tasks.count { it.status == "Completed" }
        return (completedTasks.toDouble() / tasks.size) * 100
    }

}