# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
    ―――――――――――――――――――――――――――――――――――――――――――
          Yahallo! I'm Singlish bot! I'm here to make ur day nicer :)
                          What u wan me help u do?
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    Looks like u dun have a save folder, lemme make one now
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    I made a folder for u here: C:\Users\WindowsUser\data
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    I can't find any save file here, lemme make one now
    ―――――――――――――――――――――――――――――――――――――――――――
   ```

## Using Singlish bot in the command line

Prerequisites: JDK 11

1. Download `SinglishBot.jar` from [here](https://github.com/homingjun/ip/releases/download/A-Jar/SinglishBot.jar).
1. Copy the jar file into an empty folder.
1. Setup the command prompt as follows:
    1. Open a command window in that folder.
    1. Right click the command prompt window and select `Properties` > `Font` > `NSimSun`.
    1. Click `OK`
    1. Run the command `chcp 65001` to enable special, non-ASCII characters.
1. Run the command `java -Dfile.encoding=UTF-8 -jar C:\SinglishBot\SinglishBot.jar`. Ensure that the `SinglishBot.jar` filepath is specified correctly according to where you copied it to. If the setup is correct, you should see something like the below:
   ```
    ―――――――――――――――――――――――――――――――――――――――――――
          Yahallo! I'm Singlish bot! I'm here to make ur day nicer :)
                          What u wan me help u do?
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    Looks like u dun have a save folder, lemme make one now
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    I made a folder for u here: C:\Users\WindowsUser\data
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    I can't find any save file here, lemme make one now
    ―――――――――――――――――――――――――――――――――――――――――――
   ``` 

## What is Singlish bot?

Singlish bot is a simple task scheduler that you can use to keep track of deadlines, events and todos. It also comes with a handy save and load function so that you never have to worry about losing your list of tasks ever again.

## What can you do with Singlish bot?

* Keep track of deadlines, events and todos.
* Get a concise list of all the things you need to do.
* Find a specific event using keywords.
* Delete items from the list.
* Automatically save the list when exiting the program.
* Automatically load the saved list when using the program again.
   
## Features

### 1. Add a `todo` task to the list
Creates a todo task and adds it to the list.  
Syntax: `todo <description>`  
Example: `todo assignment`
```
    ―――――――――――――――――――――――――――――――――――――――――――
    Ok I add this task to ur list liao:
    [T][✘] assignment
    Now you have 1 tasks in the list.
    ―――――――――――――――――――――――――――――――――――――――――――
```

### 2. Add a `deadline` to the list
Creates a deadline and adds it to the list.  
Syntax: `deadline <description> /by <date> <time>`  
Supported formats for date: `d/M/yyyy` | `dd/MM/yyyy` | `d/M/yy` | `dd/MM/yy` | `d-M-yyyy` | `dd-MM-yyyy` | `d-M-yy` | `dd-MM-yy`  
Supported formats for time: `h:m a` | `hhmm a` | `H:m` | `HHmm`  
Example: `deadline finish assignment /by 27/9/2020 1100 PM`  
```
    ―――――――――――――――――――――――――――――――――――――――――――
    Ok I add this task to ur list liao:
    [D][✘] finish assignment (by: 27 Sep 2020 11:00 PM)
    Now you have 2 tasks in the list.
    ―――――――――――――――――――――――――――――――――――――――――――
```

### 3. Add an `event` to the list.
Creates an event and adds it to the list.  
Syntax: `event <description> /at <date> <time>`  
Supported formats for date: `d/M/yyyy` | `dd/MM/yyyy` | `d/M/yy` | `dd/MM/yy` | `d-M-yyyy` | `dd-MM-yyyy` | `d-M-yy` | `dd-MM-yy`  
Supported formats for time: `h:m a` | `hhmm a` | `H:m` | `HHmm`  
Example: `event celebrate birthday /at 1/1/2021 1300`
```
    ―――――――――――――――――――――――――――――――――――――――――――
    Ok I add this task to ur list liao:
    [E][✘] celebrate birthday (at: 1 Jan 2021 01:00 PM)
    Now you have 3 tasks in the list.
    ―――――――――――――――――――――――――――――――――――――――――――
```

### 4. View the `list`.
Lists out all the items currently in the list.  
Syntax: `list`  
Example: `list`
```
    ―――――――――――――――――――――――――――――――――――――――――――
    U haven't done any tasks yet... U shud start soon!
    1. [T][✘] assignment
    2. [D][✘] finish assignment (by: 27 Sep 2020 11:00 PM)
    3. [E][✘] celebrate birthday (at: 1 Jan 2021 01:00 PM)
    ―――――――――――――――――――――――――――――――――――――――――――
```

### 5. Mark a task as `done`.
Sets the status of a specified task to done.  
Syntax: `done <task number>`  
Example: `done 2`
```
    ―――――――――――――――――――――――――――――――――――――――――――
    Congrats on completing this task! U damn ups :D
    [D][✓] finish assignment (by: 27 Sep 2020 11:00 PM)
    ―――――――――――――――――――――――――――――――――――――――――――
```

### 6. `Find` an item in the list.
Searches the list based on the given keyword and returns all matching items.  
Syntax: `find <item description>`  
Example: `find assignment`
```
    ―――――――――――――――――――――――――――――――――――――――――――
    I found ur items le! Here they are:
    1. [T][✘] assignment
    2. [D][✓] finish assignment (by: 27 Sep 2020 11:00 PM)
    ―――――――――――――――――――――――――――――――――――――――――――

```

### 7. `Delete` an item from the list.
Deletes a specified item from the list.  
Syntax: `delete <task number>` 
Example: `delete 3`
```
    ―――――――――――――――――――――――――――――――――――――――――――
    Ok I deleted it liao
    [E][✘] celebrate birthday (at: 1 Jan 2021 01:00 PM)
    Now you have 2 tasks in the list.
    ―――――――――――――――――――――――――――――――――――――――――――
```

### 8. `Bye` command exits the app and saves the list to `..\data\tasks.txt`
Goodbye greeting is given by the bot and list is saved before exiting the program.  
Syntax: `bye`  
Example: `bye`
```
    ―――――――――――――――――――――――――――――――――――――――――――
    Thank you for using me! See u again soon ya :)
    ―――――――――――――――――――――――――――――――――――――――――――

```

### 9. Saving the list
The list is automatically saved to `..\data\tasks.txt`.  
All changes made to the list during the program will automatically be saved after exiting the program.

### 10. Loading the list from the save file
The list is automatically loaded from `..\data\tasks.txt` once the program starts.
```
    ―――――――――――――――――――――――――――――――――――――――――――
          Yahallo! I'm Singlish bot! I'm here to make ur day nicer :)
                          What u wan me help u do?
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    I found ur file le! :D
    ―――――――――――――――――――――――――――――――――――――――――――
```  
If no such directory or file is found, a new directory and save file `..\data\tasks.txt` will be created.
```
    ―――――――――――――――――――――――――――――――――――――――――――
          Yahallo! I'm Singlish bot! I'm here to make ur day nicer :)
                          What u wan me help u do?
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    Looks like u dun have a save folder, lemme make one now
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    I made a folder for u here: C:\Users\WindowsUser\data
    ―――――――――――――――――――――――――――――――――――――――――――
    ―――――――――――――――――――――――――――――――――――――――――――
    I can't find any save file here, lemme make one now
    ―――――――――――――――――――――――――――――――――――――――――――
```
## Command Summary

| **Action** | **Description** | **Syntax** |
| --- | --- | --- |
| **todo** | Creates a todo task and adds it to the list. | `todo <description>` |
| **deadline** | Creates a deadline and adds it to the list. | `deadline <description> /by <date> <time>` |
| **event** | Creates an event and adds it to the list. | `event <description> /at <date> <time>` |
| **list** | Lists out all the items currently in the list. | `list` |
| **done** | Sets the status of a specified task to done. | `done <task number>` |
| **find** | Searches the list based on the given keyword and returns all matching items. | `find <item description>` |
| **delete** | Deletes a specified item from the list. | `delete <task number>` |
| **bye** | Goodbye greeting is given by the bot and list is saved before exiting the program. | `bye` |

