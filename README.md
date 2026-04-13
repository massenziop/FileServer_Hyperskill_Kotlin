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


## Stage 2/4: Networking
### Description
We aim to store files on the file server and make them accessible through the Internet. To achieve that, separate the
program. Make two of them: a file server, which stores our files and processes client requests, and a client to make
requests to `create`, `get`, and `delete` files on our server.

Let's consider an essential term for this stage: Java `Socket`. A socket is an interface used to send and receive data
between different processes running on the same computer or others connected through the Internet.

In this stage, you will implement the simplest connection between one server and one client. The client should send the
message `Give me everything you have!` to the server, and the server should reply `All files were sent!`. The client and
server should print the received messages to the console.

The very first message the server outputs before the client connects to it should be `Server started!`.

The client must know the server's address to connect to the server. The address consists of two parts: the IP address
and the port number. In your program, use _127.0.0.1_ as the IP address, which is the localhost (your computer). The
port can be any number from _0_ to _65535_, preferably higher than _1024_. The server and the client should use the
same IP address and port number; otherwise, they won't find each other.

To start, import `java.io.*` and `java.net.*` necessary for input/output operations with the socket.

Let's take a look at the client-side code:

```java
val address = "127.0.0.1"
val port = 23456
val socket = Socket(InetAddress.getByName(address), port)
val input = DataInputStream(socket.getInputStream())
val output = DataOutputStream(socket.getOutputStream())
```

The client creates a new socket, which means that it's trying to connect to the server. The successful creation of
a socket means that the client has found the server and connected to it.

After that, you can see the creation of the `DataInputStream` and `DataOutputStream` objects. These are input and
output connections to the server. If you expect data from the server, you need to write `input.readUTF()`. This returns
the String object that the server sent to the client. If you want to send data to the server, you need to write
`output.writeUTF(stringText)`, and the message will be sent to the server.

Now, let's look at the server-side code:

```java
val address = "127.0.0.1"
val port = 23456
val server = ServerSocket(port, 50, InetAddress.getByName(address))
val socket = server.accept()
val input = DataInputStream(socket.getInputStream())
val output = DataOutputStream(socket.getOutputStream())
```

The server creates a ServerSocket object that listens for client connections. When the client connects,
the `server.accept()` method returns the socket connection to the client. After that, two objects are created:
`DataInputStream` and `DataOutputStream`. These are the input and output connections to the client, now from the server
side. To receive data from the client, you need to write `input.readUTF()`. To send data to the client, write 
`output.writeUTF(stringText)`.

Create two packages named `client` and `server` and then create the `Main.java` function in both of these packages.
Both classes should contain the `main(args: Array<String>)` method. To start the server, just run `main` from the 
`server` package. To start the client, run `main` from the `client` package. 
The tests depend on the presence of these classes!

Finally, make sure to close all the sockets and streams!

### Objectives
In this stage, your client-side program should:

1. Print `Client started!` when the program starts;
2. Send the message `Give me everything you have!` to the server;
3. Receive a response message from the server.

Your server-side program should:

1. Print `Server started!` when the program starts;
2. Receive a message from the client;
3. Send the response message `All files were sent!` to the client.

Print the sent and received messages in both programs.


### Example
The server output should look like this:
```terminaloutput
Server started!
Received: Give me everything you have!
Sent: All files were sent!
```
The client output should be as follows:
```terminaloutput
Client started!
Sent: Give me everything you have!
Received: All files were sent!
```
