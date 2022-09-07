package controller.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class DataStructures_Utility {
    /**
     * Function that retur last item in List<String>
     *
     * @param list input string list
     * @return retrieve last item from list
     */
    public static String getLastItemFromList(ArrayList<String> list) {
        return list.get(list.size() - 1);
    }

    /**
     * Function that replace found characters in another string
     *
     * @param inputString
     * @param matchToReplace
     * @param newString
     * @return String
     */
    public static String replaceCharMatchesWithAnotherChar(String inputString, String matchToReplace, String newString) {
        String strResult = null;
        try {
            StringBuilder result = new StringBuilder();
            Scanner scan = new Scanner(inputString);
            scan.useDelimiter(matchToReplace);
            while (scan.hasNext()) {
                result.append(scan.next());
                result.append(newString);
            }
            strResult = result.toString();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error Replacer : " + e.getMessage());
            e.printStackTrace();
        }
        return strResult;
    }

    /**
     * Function GETs DataType Name of an object
     *
     * @param o Object Type
     * @return Object DataType by it's name
     */
    public static String getDataTypeObject(Object o) {
        return o.getClass().getSimpleName();
    }

    /**
     * Function that returns DataType Name of an Array of Objects
     *
     * @param objT Object Array
     */
    public static void getDataTypeObject(Object[] objT) {
        if (objT.length > 0) {
            for (Object o : objT) {
                System.out.println("Datatype: " + o.getClass().getName());
            }
        } else {
            System.out.println("Non Elements in Array Object");
        }
    }
}
