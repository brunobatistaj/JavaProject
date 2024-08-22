package programa.utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

    static NumberFormat formataValor = new DecimalFormat("R$ #,##0.00");

    public static String doubleToString(Double valor){
        return formataValor.format(valor);
    }

}
