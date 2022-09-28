# Analysis of YouTube's Trending Videos using Hadoop MapReduce

## Introduction
In this project we aim to gather information relating to recently trending videos on the YouTube platform, such as, which channels make these videos and which categories of videos reach the trending page the most.  

We gathered this information from the YouTube API and processed it using Hadoop’s MapReduce.  

We will be focusing on the following:  

- Videos from which categories most frequently come into the trending page
- Which channels most frequently appear on the trending page
- How many views each of these trending categories receive.

## Implementation
### On the Command Line
First, we need to setup the processes needed for Hadoop to run from the CLI
- Set classpath for Hadoop to output the compiled classes 
- Compile Java Files 
- Obtain class files: Hadoop outputs the created class files to the path mentioned above.
- Create .jar file from the class files that we have now. This is what Hadoop is going to use to run all the required classes.
- Create an input directory for HDFS to take input from and copy the dataset we created into it.
- Run the jar file using hadoop with the input and output directories as arguments
- Output is sent to specified output directory

### In the Driver Code
Here, we will be creating and configuring a “Job” for Hadoop to execute.
- First, we create the client to run the job and the configuration object for the job
- To configure the Job we need to set the following parameters:
  - The name
  - Output key type and value type (Text and int for us)
  - Specify the names of the Mapper and Reducer Classes that need to be used
  - Input and Output paths (These have been given to the .jar file as arguments)
- Finally, we make the client created run the job with the configuration

### MapReduce Operations
Within the Mapper, we will be using the dataset in the provided Input directory and mapping each key (not unique) to their respective values based on our requirement (CategoryID and Frequency, ChannelID and Frequency, CategoryID and Views)
- This requires us to split the .csv dataset into the separate fields and taking the ones we need 
Within the Reducer, we go through each of the outputs of the Mapper class (Mapped key-value pairs) and sum up the values of similar keys until we get a reduced list with only unique keys.
- This is done by taking a key-value pair and incrementing it’s value each time the same key is encountered.

#### Workflow for Dataset Processing (Hadoop MapReduce)
  <p align = "center">
  <img align = "center" src = "https://user-images.githubusercontent.com/73750950/192682144-96a534e7-4442-4bc3-ba2c-586f00d3e86e.png"/>  
  <br/><br/>
  </p>


## Workflow for Dataset Preparation
  
  <p align = "center">
  <img align = "center" src = "https://user-images.githubusercontent.com/73750950/192682165-33e08f4e-d8a7-44f8-b61b-6bdc0aeef96c.png"/> 
  <br/><br/>
  </p>


  
## Results / Output
  <p align = "center">
  
  <img align = "center" src = "https://user-images.githubusercontent.com/73750950/192682187-519fcaa9-3e9d-4e79-9476-d0ff7fd4f959.jpeg"/>  
  <br/><br/>
  <img align = "center" src = "https://user-images.githubusercontent.com/73750950/192682220-b4626645-719d-45d0-8483-9c56cb817124.jpeg"/>
  <br/><br/>
  <img align = "center" src = "https://user-images.githubusercontent.com/73750950/192682203-5beb952e-4212-4dee-9a77-57a0d1f1640a.jpeg"/>
  <br/><br/>
  <img align = "center" src = "https://user-images.githubusercontent.com/73750950/192682195-b012f8c4-5c5c-4161-b11b-86e64ace956a.jpeg"/>
  <br/><br/>
  
  </p>
