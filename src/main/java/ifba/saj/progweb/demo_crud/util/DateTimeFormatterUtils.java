package ifba.saj.progweb.demo_crud.util;

import org.springframework.format.datetime.DateFormatter;

import java.time.format.DateTimeFormatter;

public final class DateTimeFormatterUtils {

    public static DateTimeFormatter FORMATO_DATA_BRASIL = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private DateTimeFormatterUtils() {}

}
