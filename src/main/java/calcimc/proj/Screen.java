package calcimc.proj;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    // Criando os elementos fora do construtor pra nao bugar ;-;

    Font font1 = new Font("Calibri", Font.BOLD, 24);
    Font font2 = new Font("Calibri", Font.PLAIN, 12);
    Font font3 = new Font("Calibri", Font.BOLD, 14);

    JLabel tituloLB = new JLabel();
    JTextField alturaTF = new JTextField();
    JTextField pesoTF = new JTextField();

    JButton calcBT = new JButton();

    JLabel resulLB = new JLabel();
    JLabel alturaLB = new JLabel();
    JLabel pesoLB = new JLabel();
    JLabel seuImcLB = new JLabel();

    public Screen() {
        // Adcionando os componentes
        tituloLB.setBounds(115, 10, 300, 20);
        tituloLB.setFont(font1);
        tituloLB.setText("Calculo de IMC");
        add(tituloLB);

        alturaTF.setText("");
        alturaTF.setBounds(170, 70, 200, 30);
        alturaTF.setFont(font2);
        add(alturaTF);

        alturaLB.setText("Sua altura em metros:");
        alturaLB.setFont(font3);
        alturaLB.setBounds(10, 75, 200, 15);
        add(alturaLB);

        pesoTF.setText("");
        pesoTF.setBounds(170, 130, 200, 30);
        alturaTF.setFont(font2);
        add(pesoTF);

        pesoLB.setText("Seu peso em kg:");
        pesoLB.setFont(font3);
        pesoLB.setBounds(30, 130, 200, 30);
        add(pesoLB);

        calcBT.setFont(font1);
        calcBT.setBounds(125, 200, 150, 30);
        calcBT.setText("Calcular");
        add(calcBT);

        calcBT.addActionListener(e -> {
            try {

                String txtPeso = pesoTF.getText();
                String txtAltura = alturaTF.getText();
                if ((txtPeso.isEmpty()) || (txtAltura.isEmpty())) {
                    resulLB.setText("");
                    seuImcLB.setText("");
                } else {
                    Calculador c1 = new Calculador(Double.parseDouble(txtPeso.replaceAll(",", ".")), Double.parseDouble(txtAltura.replaceAll(",", ".")));
                    resulLB.setText(c1.calcular());
                    seuImcLB.setText("Seu IMC é de " + String.valueOf(c1.getImcFinal()));
                }
                } catch (NumberFormatException ex) {
                    resulLB.setText("Peso e/ou altura inválido");
                    seuImcLB.setText("");
                }



        });


        resulLB.setText("");
        resulLB.setFont(font1);
        resulLB.setBounds(30, 300, 350, 35);
        resulLB.setHorizontalAlignment(SwingConstants.CENTER);
        add(resulLB);

        seuImcLB.setText("");
        seuImcLB.setForeground(Color.red);
        seuImcLB.setFont(font1);
        seuImcLB.setBounds(30, 400, 350, 30);
        seuImcLB.setHorizontalAlignment(SwingConstants.CENTER);
        add(seuImcLB);



        // Configs do JFrame

        setLayout(null);

        setTitle("Caculadora de IMC");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
