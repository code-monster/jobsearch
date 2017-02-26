package ua.pp.iserf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author alex
 */
public class Helper {
        
    /**
     * 
     * @param stringDate format "dd/MM/yyyy"
     * @return 
     */
    public static java.sql.Date convertStringToSqlDate(String stringDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = new java.util.Date();
        try {
            utilDate = sdf.parse(stringDate);
        } catch (ParseException ex) {
            throw new RuntimeException("Error, while string date has been converted:" + ex.getMessage());
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;

    }

}
