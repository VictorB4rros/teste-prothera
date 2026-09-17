package utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conversor {

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatoMoeda(BigDecimal valor) {
        return NumberFormat.getCurrencyInstance().format(valor);
    }

    public static String formatoData(LocalDate data) {
        return dateTimeFormatter.format(data);
    }
}
