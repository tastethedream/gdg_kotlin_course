# Tasks and back stack

## Tasks

Activities in Android exist within tasks. When you open an app for the first time from the launcher icon, Android creates a new task with your main activity. A task is a collection of activities that the user interacts with when performing a certain job (i.e. checking email, creating a cupcake order, taking a photo).

Activities are arranged in a stack, known as a back stack, where each new activity the user visits gets pushed onto the back stack for the task. You can think of it as a stack of pancakes, where each new pancake is added on top of the stack. The activity on the top of the stack is the current activity the user is interacting with. The activities below it on the stack have been put in the background and have been stopped.

The back stack is useful for when the user wants to navigate backwards. Android can remove the current activity from the top of the stack, destroy it, and start the activity underneath it again. It's known as popping an activity off the stack, and bringing the previous activity to the foreground for the user to interact with. If the user wants to go back multiple times, Android will keep popping the activities off the top of the stack until you get closer to the bottom of the stack. When there are no more activities in the backstack, the user is brought back to the launcher screen of the device (or to the app that launched this one).


