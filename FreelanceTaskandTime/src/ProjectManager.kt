import java.time.LocalDate

class ProjectManager {
    private val freelancers = mutableListOf<Freelancer>()
    private val projects = mutableListOf<Project>()

    fun addFreelancer(name: String, hourlyRate: Double) {
        val freelancer = Freelancer(
            id = freelancers.size + 1,
            name = name,
            hourlyRate = hourlyRate
        )
        freelancers.add(freelancer)
    }

    fun createProject(name: String, client: String, deadline: LocalDate) {
        val project = Project(
            id = projects.size + 1,
            name = name,
            client = client,
            deadline = deadline
        )
        projects.add(project)
    }
}

    // Assign Task to freelance
    fun assignTaskToFreelancer(task: Task, freelancer: Freelancer) {
        task.freelancer = freelancer
        freelancer.assignedTasks.add(task)
    }

    //Log Hours Worked
    fun logHours(task: Task, hours: Int) {
        task.logHours(hours)
        task.freelancer?.let { freelancer ->
            freelancer.assignedTasks.find { it.id == task.id }?.logHours(hours)
        }
        // Update project budget
        projects.find { it.tasks.contains(task) }?.calculateBudget()
    }
}
