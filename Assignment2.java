import java.util.*;
import java.io.*;
public class Assignment2
  {
    public static void main (String [] args) throws IOException {
        String filename, line;
        int month, day, year;
        int numOfDays, daysRain, daysSnow;
        int years = 2009;
        double max, min, mean, rain, snow, averageMax = 0, 
               averageMin = 0, averageMean = 0;
        String baseDirectory = "C:/CMPP269G/Assignment/data/Calgary ";
        // Print report header
        System.out.printf ("%35s Calgary climate data for 2009-2018%n%n", "");
        System.out.printf ("%10s %10s %15s %15s %15s %15s %15s%n", 
            "Year", "Days Data", "Avg Max", "Avg Min", "Ave Mean", "Days Rain", "Days Snow");
        
        // Loop through all data files
        while (years <= 2018) 
        {
            numOfDays = 0;
            daysRain = daysSnow = 0;
            // create filename and then open the data file for that year
            filename = String.format ("%s%4d.csv", baseDirectory, years);
            Scanner input = new Scanner(new FileInputStream(filename), "UTF-8");
            //strip header info.
            boolean isFirstLineOfData = false;
            while(input.hasNextLine() && !isFirstLineOfData) 
            {
                line = input.nextLine();
                if (line.startsWith("Date/Time,Year")) 
                {
                    isFirstLineOfData = true;
                }
            }   
            // change delimiter to be a comma
            input.useDelimiter(","); 
            // start to process data here
            while (input.hasNextLine()) 
            {
                line = input.next();
                year = input.nextInt();
                month = input.nextInt();
                day = input.nextInt();
                input.next();
                String maxString = input.next();
                // is there a max temp? 
                if (!maxString.equals ("")) 
                {
                    // There is a max temp, convert it
                    max = Double.parseDouble(maxString);
                    input.next();
                    // is there a min temp?
                    String minString = input.next();
                    if (!minString.equals("")) 
                    {
                        //there is a min temp, convert it
                        min = Double.parseDouble(minString);
                        //count number of days of max and min
                        numOfDays++;
                        //compute mean
                        mean = (max+min)/2;
                        //accumulate values
                        averageMax += max;
                        averageMin += min;
                        averageMean += mean;
                    }
                    else {
                        //no min 
                    }
                    // discard 7 empty values
                    for ( int i = 0; i < 7; i++) 
                    {
                        input.next();
                    }
                    // is there a rain?
                    String rainString = input.next();
                    if (!rainString.equals("")) 
                    {
                        //there is rain data, convert it
                        rain = Double.parseDouble(rainString);
                        input.next();
                        snow = input.nextDouble();
                        //discard the rest of the stuff
                        input.nextLine();
                        //count number of days of rain
                        if (rain > 0) {
                            daysRain++;
                        }
                        if (snow > 0) {
                            daysSnow++;
                        }
                    } 
                    else {
                        // no rain data
                        input.nextLine();
                    }
                }
                else {
                    //if no max temperature, ignore rest of line
                    max = 0;
                    input.nextLine();
                }
             }//end parsing a year
            input.close();
            //calculate averages
            averageMax /= numOfDays;
            averageMin /= numOfDays;
            averageMean /= numOfDays;
            // print report values
            System.out.printf ("%10d %10d %15.2f %15.2f %15.2f %15d %15d%n",
                years, numOfDays, averageMax, averageMin, averageMean, daysRain, daysSnow);
            years++;//increment years counter var.
        }//end processing all data files
    }//end main method
}//end class program