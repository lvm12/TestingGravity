Simulation of the two body problem in kotlin.
Was accurately able to simulate the movement of the ISS around the earth.
![image](https://github.com/lvm12/TestingGravity/assets/118291069/2e7b70b4-5081-4e48-9798-052f59327c93)

Contains some, presets which you can feel free to mess around with.

Usage:
1. Download project and open in intellij idea or an ide of your choice provided it has kotlin and jupyter notebook support
2. Change the values in the list in Main.kt to try with different objects
3. Change the condition used in Main.kt in the repeatUntil function, the default simulates 90 minutes
4. Change time interval if neccesary
5. Run Main.kt, you can choose between 3 options:  
     Enter 0: Go step by step with extra logging information. Press enter to go to the next step  
     Enter 1: Runs the program indefinitley, no real reason to do this  
     Just hit enter: Runs the program untile the choosen condition becomes true  
6. This creates results in a "results.csv" file
7. To graph the results open Plot.ipynb and run the cell
