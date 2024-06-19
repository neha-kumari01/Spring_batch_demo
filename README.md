LEARNING
---------------------
Spring Batch Demo project for learning purposes.
1. Job, Job launcher, job Repository, Job Execution
2. Step, Step Execution
3. Chunk-based steps, Tasklet-based steps.
4. Different types of ItemReader, ItemWriter, and ItemProcessor.
5. TaskExceutor
6. Conditional Flow
7. FaultTolerance
8. Async

IMPLEMENTATIONS
-----------------------
1. Read data from the CSV file and populate the "Customer_info" table using flatFileItemReader and RepositoryItemWriter.
2. Implemented a complex scenario, where using one ItemReader(fetching data from Customer_info table populated previously) to populated two tables based on country(US_Customer_Info, China_Customer_Info)
using CompositeItemProcessor & CompositeItemWriter.

COMMITS
----------------------
Day 1: Spring Batch configuration is done to read from a CSV file and save it in the database. (MYSQL database)
Day 2: Spring job created using chunk step, flatFileItemReader, and RepositoryItemWriter, a database hosted on AWS. 
       Successfully ran.
Day 3: Changes are done to implement, to populate two tables using One single ItemReader, using compositeItemWriter (not working)
Day 4: Implemented CompositeItemWriter and CompositeItemProcessor, code is finally working.
