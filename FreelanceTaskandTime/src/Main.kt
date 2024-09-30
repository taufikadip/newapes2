import java.time.LocalDate
import java.util.Scanner

fun main() {
    val projectManager = ProjectManager()

    while (true) {
        println("Menu :")
        println("1. Add Freelancer")
        println("2. Create Project")
        println("3. Assign Task")
        println("4. Log Hours Worked")
        println("5. View Project Details")
        println("6. Exit")
        print("Choose Menu : ")
        try{
            val input = Scanner(System.`in`).nextInt()
            when(input){
                1 -> {
                    println("Enter Freelancer Name: ")
                    val name = readLine()!!
                    println("Enter Freelancer Hourly Rate: ")
                    val hourlyRate = readLine()!!
                    projectManager.addFreelancer(name, hourlyRate.toDouble())
                    println("Freelancer Added Successfully!")
                }
                2 -> {
                    println("Enter Project Name: ")
                    val name = readLine()!!
                    println("Enter Client Name: ")
                    val client = readLine()!!
                    println("Enter Project Deadline (YYYY-MM-DD): ")
                    val deadline = readLine()!!
                    projectManager.createProject(name, client, LocalDate.parse(deadline))
                    println("Project Created Successfully!")
                }
                3 -> {
                    println("Enter Project ID: ")
                    val projectId = readLine()!!
                    println("Enter Freelancer ID: ")
                    val freelancerId = readLine()!!
                    println("Enter Task Description: ")
                    val description = readLine()!!
                    println("Enter Estimated Hours: ")
                    val estimatedHours = readLine()!!
                    projectManager.assignTask(projectId.toInt(), freelancerId.toInt(), description, estimatedHours.toInt())
                    println("Task Assigned Successfully!")
                }
                4 -> {
                    println("Enter Task ID: ")
                    val taskId = readLine()!!
                    println("Enter Hours Worked: ")
                    val hoursWorked = readLine()!!
                    projectManager.logHoursWorked(taskId.toInt(), hoursWorked.toInt())
                    println("Hours Worked Logged Successfully!")
                }
                5 -> {
                    println("Enter Project ID: ")
                    val projectId = readLine()!!
                    projectManager.viewProjectDetails(projectId.toInt())
                }
                6 -> {
                    break
                }
                else -> {
                    println("Please Input 1 - 6")
                }
            }
        }catch (e: Exception){
            if(e.message == null){
                println("Invalid Choice. Please choose a valid option")
            }else{
                println(e.message)
            }
        }

    }
}