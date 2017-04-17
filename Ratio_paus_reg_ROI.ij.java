run("Bio-Formats Importer");
rename("stack");
//run("Channels Tool...");
Stack.setDisplayMode("composite");
Stack.setActiveChannels("110");
run("Stack to RGB", "frames");
waitForUser("Pause", "Do you want \n to run StackReg?")
run("ROI Manager...");
setTool("polygon");
waitForUser("Pause","Draw ROIs \n press 't' to add ROI");
run("Split Channels");
close();
//run("Brightness/Contrast...");
setMinAndMax(25, 254);
imageCalculator("Divide create 32-bit stack", "stack (red)","stack (green)");
selectWindow("Result of stack (red)");
count=roiManager("count"); 
array=newArray(count); 
for(i=0; i<count;i++) { 
        array[i] = i; 
} 
roiManager("Select", array);
roiManager("Multi Measure");

//After you 'run' this macro, Bio-Formats Importer will automatically run.  Make sure to 'view stack with' is set at 'Hyperstack.'  Select your .lsm, .czi, or whatever file extension your images are saved as.  

//The first pause will give you the option to run whatever registration process you prefer to align the slices in your stack if you're analyzing a stack (I happen to prefer StackReg, but I'm sure whatever choice you make will be the right choice ;))

//The second pause will allow you to select multiple ROIs for analysis.  The initial selection tool is the polygon tool, but you can select whatever tool you would prefer from the FIJI/ImageJ GUI