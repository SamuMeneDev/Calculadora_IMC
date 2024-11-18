package calcimc.proj;

import java.text.DecimalFormat;

public class Calculador {
    private double peso;
    private double altura;
    private double imcFinal;

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getImcFinal() {
        return imcFinal;
    }
    public void setImcFinal(double imcFinal) {
        this.imcFinal = imcFinal;
    }

    public Calculador(double peso, double altura) {
        setPeso(peso);
        setAltura(altura);
    }

    public String calcular() {
        DecimalFormat deci = new DecimalFormat("0.0");
        String msg;
        double preImc = (getPeso() / (getAltura() * getAltura()));
        double imc = Double.parseDouble(deci.format(preImc).replaceAll(",", "."));

        setImcFinal(imc);

        if (imc <= 18.50f) {
            msg = "Abaixo do peso";
        } else if ((imc >= 18.60f) && (imc <= 24.90f)) {
            msg = "Peso ideal";
        } else if ((imc >= 25.0f) && (imc <= 29.90f)) {
            msg = "Levemente acima do peso";
        } else if ((imc >= 30.0f) && (imc <= 34.90f)) {
            msg = "Obesidade grau I";
        } else if ((imc >= 35.0f) && (imc <= 39.90f)) {
            msg = "Obesidade grau II";
        } else if (imc > 40.0f) {
            msg = "Obesidade grau III";
        } else {
            msg = "Ocorreu um erro.";
        }

        return msg;
    }
}
