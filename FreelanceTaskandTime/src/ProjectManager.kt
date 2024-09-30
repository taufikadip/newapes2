import java.time.LocalDate

class ProjectManager {
    val freelancers = mutableListOf<Freelancer>()
    val projects = mutableListOf<Project>()

    //Add new freelancer
    fun addFreelancer(name: String, hourlyRate: Double) {
        val freelancer = Freelancer(
            id = freelancers.size + 1,
            name = name,
            hourlyRate = hourlyRate
        )
        freelancers.add(freelancer)
        println("Freelancer Added Successfully!")
    }

    //Create new project
    fun createProject(name: String, client: String, deadline: LocalDate) {
        val project = Project(
            id = projects.size + 1,
            name = name,
            client = client,
            deadline = deadline,
            tasks = mutableListOf(),
            totalBudget = 0.0
        )
        projects.add(project)
        println("Project Created Successfully!")
    }

    //Assign task to user
    fun assignTask(projectId: Int, freelancerId: Int, description: String, estimatedHours: Int) {
        val project = projects.find { it.id == projectId }
        val freelancer = freelancers.find { it.id == freelancerId }
        if (project != null && freelancer != null) {

            val task = Task(
                id = project.tasks.size + 1,
                description = description,
                freelancer = freelancer,
                estimatedHours = estimatedHours
            )
            project.tasks.add(task)
            freelancer.assignedTasks.add(task)
            println("Task Assigned Successfully!")
        } else {
            throw Exception ("Project or freelancer not found!")
        }
    }

    //Log Hours Worked
    fun logHoursWorked(taskId: Int, hoursWorked: Int) {
        val task = projects.flatMap { it.tasks }.find { it.id == taskId }
        if (task != null) {
            // Check if task was completed
            if (task.status != "Completed") {
                task.actualHours += hoursWorked
                if (task.actualHours > task.estimatedHours * 1.5) {
                    throw Exception("Warning: Actual hours exceed estimated hours by more than 50%")
                }
                updateTaskStatus(task)
                val projectId = projects.flatMap { it.tasks }.find { it.id == taskId }
                    ?.let { task -> projects.find { it.tasks.contains(task) }?.id }
                if (projectId != null) {
                    calculateProjectBudget(projectId)
                }
                println("Hours Worked Logged Successfully!")
            } else {
                throw Exception("Project already finished")
            }
        }  else {
            throw Exception("Task not found!")
        }
    }

    //Update Task Status
    fun updateTaskStatus(task: Task) {
        if (task.actualHours >= task.estimatedHours) {
            task.status = "Completed"
        } else if (task.actualHours > 0) {
            task.status = "In Progress"
        }
    }

    //Calculate project budget by Id
    fun calculateProjectBudget(projectId: Int) {
        val project = projects.find { it.id == projectId }
        project?.let {
            it.totalBudget = it.tasks.sumByDouble { task ->
                task.actualHours * (task.freelancer?.hourlyRate ?: 0.0)
            }
            println("Project Total Budget : ${it.totalBudget}")
        }
    }

    //View project Detais by Id
    fun viewProjectDetails(projectId: Int) {
        val project = projects.find { it.id == projectId }
        if (project != null) {
            println("Project Name: ${project.name}")
            println("Client: ${project.client}")
            println("Deadline: ${project.deadline}")
            println("Tasks:")
            project.tasks.forEach {
                println("ID : ${it.id}")
                println("Freelancer : ${it.freelancer.name}")
                println("Status : ${it.status}")
                println("Description : ${it.description}")
                println("Actual Hours : ${it.actualHours}")
                println("Estimate Hours : ${it.estimatedHours}") }
            calculateProjectBudget(projectId)
            println("Total Budget: ${project.totalBudget}")
        }
    }
}