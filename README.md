# Java_Basic_Two

## Calculating Weather Averages for Calgary

Write a program to analyse Environment Canada’s weather data for Calgary since 2009. The data is stored in multiple files. You are given 10 years of data. Analyse the data and produce the report (Test Plan) shown below:
                                     Calgary climate data for 2009-2018

      Year  Days Data         Avg Max         Avg Min        Ave Mean       Days Rain       Days Snow
      2009        365           10.17           -2.20            3.99              55              66
      2010        365           10.32           -1.26            4.53              85              51
      2011        365            9.89           -1.46            4.22              70              56
      2012        346           11.10           -0.69            5.20              75              51
      2013        305           11.86           -0.45            5.70              63              36
      2014        365           10.21           -1.38            4.42              72              54
      2015        365           12.67           -0.11            6.28              75              47
      2016        364           12.16            0.32            6.24              93              29
      2017        347           11.21           -1.00            5.11              74              44
      2018        356           10.46           -1.69            4.39              74              54

Tips and Tricks	
There are some challenges with reading the data files so a skeleton program along with some sample data is provided. There are some of the things to watch for:
•	the files contain UTF-8 encoded characters so they must be opened using FileInputStream as shown in the skeleton program:
Scanner input = new Scanner(new FileInputStream(filename), "UTF-8");
•	the data is comma delimited so you need to set the delimiter to be comma as shown in the skeleton program:
input.useDelimiter(",");
•	it is possible that for some dates no data are available (e.g. jan 3 2009). The skeleton program demonstrates how to detect the absence of data and advance to the end line
o	use the test data file “simple sample.csv” in conjunction with the skeleton program to see how it deals with missing data
•	In the real data you can assume:
o	if there is no max temp, there is no min temp, no rainfall and snowfall amounts, so only do the average if there is a max and min
o	if there is no rainfall amount there may not be snowfall amounts. Count the number of days of rain, if rain > 0, count the number of days of snow if snow >  0.  
