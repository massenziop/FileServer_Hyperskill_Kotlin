package server

val storage = mutableSetOf<String>()
val allowedFilenames = setOf("file1", "file2", "file3", "file4", "file5", "file6", "file7", "file8", "file9", "file10")

fun main(args: Array<String>) {

    while (true) {
        val input = readlnOrNull()
        if (input == null) {
            println("Wrong command")
            continue
        }

        if (input == "exit") {
            return
        }
        val splitted = input.split(" ")

        val command = splitted[0]
        val filename = splitted[1]

        when (command) {
            "add" -> {
                if (filename !in allowedFilenames) {
                    println("Cannot add the file $filename")
                    continue
                }

                if (storage.contains(filename)) {
                    println("Cannot add the file $filename")
                } else {
                    storage.add(filename)
                    println("The file $filename added successfully")
                }
                continue
            }
            "delete" -> {
                if (storage.contains(filename)) {
                    storage.remove(filename)
                    println("The file $filename was deleted")
                } else {
                    println("The file $filename not found")
                }
                continue
            }
            "get" -> {
                if (storage.contains(filename)) {
                    println("The file $filename was sent")
                } else {
                    println("The file $filename not found")
                }
                continue
            }
        }
    }
}