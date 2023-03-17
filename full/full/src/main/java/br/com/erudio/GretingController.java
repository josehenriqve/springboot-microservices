package br.com.erudio;

import br.com.erudio.exceptions.UnsuportedException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GretingController {
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double somar(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double subtrair(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value="/mult/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double multiplicar(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public Double dividir(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value="/raiz/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public String calcularRaiz(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedException("Please set a numeric value");
        }
        Double number1 = Math.sqrt(convertToDouble(numberOne));
        Double number2 = Math.sqrt(convertToDouble(numberTwo));
        return "Raiz quadrada de: "+numberOne+ " "+number1+" Raiz quadrada de: "+numberOne+" "+number2;
    }

    @RequestMapping(value="/potencia/{numberOne}/{numberTwo}",method = RequestMethod.GET)
    public String calcularPotencia(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedException("Please set a numeric value");
        }
        Double potencia = Math.pow(convertToDouble(numberOne),convertToDouble(numberTwo));

        return "A potencia entre os numeros eh de: "+potencia;
    }

    public Double convertToDouble(String strnumber) {
        if (strnumber == null) return 0D;
        String number = strnumber.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }
    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
