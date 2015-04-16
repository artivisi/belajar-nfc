/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar.nfc.helper;

import java.util.Date;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/**
 *
 * @author mohamad
 */
public class DateHelper {
    
    public static Date dateWithMinTime(Date startDate){
        Instant start = Instant.ofEpochMilli(startDate.getTime());
        LocalDateTime localdt = LocalDateTime.ofInstant(start, ZoneId.systemDefault());
        localdt = localdt.with(ChronoField.MILLI_OF_DAY, 0);
        return new Date(localdt.toInstant(localdt.atZone(ZoneId.systemDefault()).getOffset()).toEpochMilli());
    }
   
    public static Date dateWithMaxTime(Date endDate){
        Instant start = Instant.ofEpochMilli(endDate.getTime());
        LocalDateTime localdt = LocalDateTime.ofInstant(start, ZoneId.systemDefault());
        localdt = localdt.plus(1, ChronoUnit.DAYS).with(ChronoField.MILLI_OF_DAY, 0).minus(1, ChronoUnit.SECONDS);
        return new Date(localdt.toInstant(localdt.atZone(ZoneId.systemDefault()).getOffset()).toEpochMilli());
    }
}
