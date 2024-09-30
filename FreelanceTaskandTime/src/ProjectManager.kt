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