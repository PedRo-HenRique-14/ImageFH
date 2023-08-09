package me.dodas.window.home;

import javax.swing.*;
import java.awt.*;

public class HomeScreen {

    JPanel imgPanel;
    JLabel lblImgNull;

    JButton btnSelecImage;

    public HomeScreen(){
        JFrame jFrame = new JFrame();

        jFrame.setTitle("ImageFH");
        jFrame.setResizable(false);
        jFrame.setSize(500, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        // Add component
        jFrame.add(imgPanel());
        jFrame.add(btnSelecImage());
    }

    private JPanel imgPanel(){
        imgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 95));
        lblImgNull = new JLabel("Escolha uma imagem.");

        lblImgNull.setFont(new Font("Arial", Font.PLAIN, 12));

        imgPanel.setBounds(149, 10, 200,200);
        imgPanel.setBackground(new Color(197, 197, 197));

        imgPanel.add(lblImgNull);

        return imgPanel;
    }

    private JButton btnSelecImage(){
        btnSelecImage = new JButton("Selecionar Imagem");

        btnSelecImage.setBounds(175,220,150,25);
        btnSelecImage.setFont(new Font("Arial", Font.PLAIN, 10));

        return btnSelecImage;
    }

}
