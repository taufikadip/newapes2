import java.time.LocalDate

fun main() {
    val projectManager = ProjectManager()
    var menuNum = 0
    while (menuNum >= 0) {
        println("Menu :")
        println("1. Add Freelancer")
        println("2. Create Project")
        println("3. Assign Task")
        println("4. Total Budget")
        println("5. Log Hours Worked")
        println("6. View Project Details")
        println("7. Exit")
        print("Choose Menu : ")
        var input = readLine()!!
        when(input){
            "1" -> {
                println("Enter Freelancer Name: ")
                var name = readLine()!!
                println("Enter Freelancer Hourly Rate: ")
                var hourlyRate = readLine()!!
                projectManager.addFreelancer(name, hourlyRate.toDouble())
                println("Freelancer Added Successfully!")
            }
            "2" -> {
                println("Enter Project Name: ")
                var name = readLine()!!
                println("Enter Client Name: ")
                var client = readLine()!!
                println("Enter Project Deadline (YYYY-MM-DD): ")
                var deadline = readLine()!!
                projectManager.createProject(name, client, LocalDate.parse(deadline))
                println("Project Created Successfully!")
            }
            "3" -> {
                println("Enter Project ID: ")
                var projectId = readLine()!!
                println("Enter Freelancer ID: ")
                var freelancerId = readLine()!!
                println("Enter Task Description: ")
                var description = readLine()!!
                println("Enter Estimated Hours: ")
                var estimatedHours = readLine()!!
                projectManager.assignTask(projectId.toInt(), freelancerId.toInt(), description, estimatedHours.toInt())
                println("Task Assigned Successfully!")
            }
            "4" -> {
                println("Enter Project ID:")
                var projectId = readLine()!!.toInt()
                projectManager.calculateProjectBudget(projectId)
            }
            "5" -> {
                println("Enter Task ID: ")
                var taskId = readLine()!!
                println("Enter Hours Worked: ")
                var hoursWorked = readLine()!!
                projectManager.logHoursWorked(taskId.toInt(), hoursWorked.toInt())
                println("Hours Worked Logged Successfully!")
            }
            "6" -> {
                println("Enter Project ID: ")
                var projectId = readLine()!!
                projectManager.viewProjectDetails(projectId.toInt())
            }
            "7" -> {
                menuNum = -1
            }
            else -> {
                println("Invalid Choice. Please choose a valid option.")
            }
        }
    }
}