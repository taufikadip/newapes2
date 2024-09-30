class ProjectManager {


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
