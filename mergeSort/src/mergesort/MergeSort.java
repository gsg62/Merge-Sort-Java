/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;
/**
 * class for mergeSort Algorithm
 * <p>
 * @author GregGeary
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create and load sample array
        int[] testArray;
        int numValues = 25, lowLimit = 10, highLimit = 99;
        String resultString;                    
        testArray = loadRands( numValues, lowLimit, highLimit );
        resultString = arrayToString( testArray, numValues );
        
        // test merge sort
        System.out.println( "\nArray before Merge Sort: " + resultString );
        runMergeSort( testArray, numValues );
        resultString = arrayToString( testArray, numValues );
        System.out.println( "Array after Merge Sort: " + resultString );
       
    }
    
    /**
     * Data sorted using merge sort algorithm
     * <p>
     * Note: Call runMergeSortHelper with lower and upper
     * indices of array to be sorted
     * 
     * @param localArray integer array holding unsorted values
     * 
     * @param size integer value holding number of values in array
     */
    public static void runMergeSort( int[] localArray, int size )
    {
        //long startTime = System.nanoTime();
        runMergeSortHelper(localArray, 0, size - 1); 
        //long endTime = System.nanoTime();
        //String time = Long.toString((endTime - startTime));
        //System.out.println("merge sort time: " + time);
    }
   
    /**
     * Merge sort helper, places low and high indices of 
     * array segment to be processed into recursive method,
     * then sorts data using merge sort algorithm
     * 
     * @param localArray integer array holding unsorted values
     * 
     * @param lowIndex lowest partIndex of array segment to be managed;
 this varies as the segments are broken down recursively
     * 
     * @param highIndex highest partIndex of array segment to be managed;
 this varies as the segments are broken down recursively
     */
    private static void runMergeSortHelper( int[] localArray, int lowIndex, int highIndex )
    {
        int middleIndex;
        if( lowIndex < highIndex )
        {
            middleIndex = (highIndex + lowIndex) / 2;
            runMergeSortHelper(localArray, lowIndex, middleIndex);
            runMergeSortHelper(localArray, (middleIndex + 1), highIndex);
            runMerge(localArray, lowIndex, middleIndex, highIndex);
        }
    }

    /** Merges values brought in between a low and high partIndex
 segment of an array
     * <p>
     * Note: uses locally sized single array for temporary storage
     * 
     * @param localArray integer array holding unsorted values
     * 
     * @param lowIndex lowest partIndex of array segment to be managed
     * 
     * @param halfWayIndex middle partIndex of array segment to be managed
     * 
     * @param highIndex high partIndex of array segment to be managed
     */
  private static void runMerge(int[] localArray, int lowIndex,
        int middleIndex, int highIndex)
    {
    // find end index for sub array
    int endIndex = highIndex - lowIndex;
    // index where split tempArray into two sub Arrays 
    int halfWayIndex = endIndex / 2;
    // create temp array
    int[] tempArr = new int[endIndex + 1];
    // sets local array index to first index
    int localArrayIndex = lowIndex;
    // sets first half index to low
    int firstHalfIndex = 0;
    // sets second half index to middle + 1
    int secondHalfIndex = halfWayIndex + 1;  
    // copies values from portion of localArray to tempArray
    int index = 0;
    while( index <= endIndex )
    {
        tempArr[index] = localArray[index + lowIndex];
        index++;
    }
    // sorts values in tempArray to merge back to localArray
    while (firstHalfIndex <= halfWayIndex && secondHalfIndex <= endIndex)
        {
        if (tempArr[firstHalfIndex] <= tempArr[secondHalfIndex])
            {
                localArray[localArrayIndex] = tempArr[firstHalfIndex];
                firstHalfIndex++;
            }
        else
            {
                localArray[localArrayIndex] = tempArr[secondHalfIndex];
                secondHalfIndex++;
            }
        localArrayIndex++;
        }
    // adds remaining values back to local w two loops
    while (firstHalfIndex <= halfWayIndex)
        {
            localArray[localArrayIndex] = tempArr[firstHalfIndex];
            firstHalfIndex++;
            localArrayIndex++;
        }
    } 
    /**
     * Method to load a given integer array with random values
     * 
     * @param numRands integer identifies number of values to generate
     * 
     * @param lowLimit integer identifies low limit of generated randoms
     * 
     * @param highLimit integer identifies high limit of generated randoms
     * 
     * @return integer array with data loaded
     */
    public static int[] loadRands( int numRands, int lowLimit, int highLimit )
       {
        int index;
        int[] localArray = new int[ numRands ];
       
        for( index = 0; index < numRands; index++ )
           {
            localArray[ index ] = generateRandBetween( lowLimit, highLimit );
           }

        return localArray;
       }

    /**
     * Generate random value between the lowest and highest
     * specified limits inclusive
     * 
     * @param lowLimit specified integer low limit of random value range
     * 
     * @param highLimit specified integer high limit of random value range
     * 
     * @return random integer value generated between the inclusive limits
     */
    public static int generateRandBetween( int lowLimit, int highLimit )
       {
        int randVal, range;
       
        if( highLimit > lowLimit )
           {
            // create range of numbers
            range = highLimit - lowLimit + 1;
           
            // find random integer value from value between 0 and 1
            randVal = (int)( Math.random() * 1000000 );
           
            return randVal % range + lowLimit;
           }
       
        return 0;
       }

    /**
     * Converts array of integers into string for output or display
     * 
     * @param localArray integer array of values
     * 
     * @param size number of values in the array
     * 
     * @return String holding a list of all values, comma-delimited
     */
    public static String arrayToString( int[] localArray, int size )
       {
        int index;
        String outString ="";
        
        for( index = 0; index < size; index++ )
           {
            if( index > 0 )
               {
                outString += ", ";
               }
            
            outString += localArray[ index ];
           }
        
        return outString;
       }
    
    /**
     * Swaps values within given array
     * 
     * @param localArray array of Objects used for swapping
     * 
     * @param indexOne integer partIndex for one of the two items to be swapped
     * 
     * @param indexOther integer partIndex for the other of the two items 
 to be swapped
     */
    public static void swapValues( int[] localArray, int indexOne, int indexOther )
       {
        int temp = localArray[ indexOne ];
        
        localArray[ indexOne ] = localArray[ indexOther ];
        
        localArray[ indexOther ] = temp;        
       }           
}
