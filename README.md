About
It's so easy to lose your precious data — unless you store it on a server. Besides, file servers allow you to access your files remotely, no matter where you are. In this project, you will create your own file server, even though a simple one.

## Stage 1/4
For a start, write a program that simulates the work of a file storage server.

## Stage 2/4
Time to practice using sockets: establish a client-server connection and learn how to handle errors on your server.

## Stage 3/4
Save a simple text file on your server: enter the name and the contents of the file and save it.

## Stage 4/4
Upgrade your server so that it can handle any type of files using multithreading and serialization.

# Assignments

## Stage 1/4: Storage Emulator

### Description
An HTTP File Server is, in a way, a remote file storage. If you have a connection to the Internet, you can manage your files from anywhere in the world. In this project, you will create your file keeper to save, get, and delete files.

Let's start by creating a simulation of a file storage that can save only ten files: `file1`, `file2`, `file3`, ... `file10`. At first, when the file server starts, there are no files there; add them with the `add` command followed by the name of the file, for example, `add NAME`, where `NAME` is the file name.

Your program should support three additional commands: `get`, `delete`, and `exit`. The `get` command retrieves a file: `get NAME`. The `delete` command deletes a file: `delete NAME`. The `exit` command terminates the program.

### Objectives
In this stage, your program should:

*   Accept a command and a file name from the user;
*   For `add`, print the message `The file NAME added successfully` if the file has been added; otherwise, print the message `Cannot add the file NAME`;
*   For `get`, print the message `The file NAME was sent` if the file exists; otherwise, print the message `The file NAME not found`.
*   For `delete`, print the message `The file NAME was deleted` if the file has been deleted successfully; otherwise, print the message `The file NAME not found`.

### Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

Below is an output example of the program. Try to output all the messages from the example.

```terminaloutput
> add file1
The file file1 added successfully
> add file1
Cannot add the file file1
> add file11
Cannot add the file file11
> get file1
The file file1 was sent
> get file2
The file file2 not found
> get abcd1
The file abcd1 not found
> delete file2
The file file2 not found
> delete file1
The file file1 was deleted
> exit
```