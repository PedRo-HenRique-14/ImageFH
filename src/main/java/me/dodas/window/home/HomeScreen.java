package me.dodas.window.home;

import javax.swing.*;
import java.awt.*;

public class HomeScreen {

    JPanel imgPanel;
    JPanel zipSelectPanel;
    JPanel exportPanel;

    JLabel lblImgNull;

    JTextField zipPathTextField;
    JTextField exportPathTextField;

    JButton btnSelecImage;
    JButton btnSelectZip;
    JButton btnSelectExportPath;
    JButton btnExport;

    public HomeScreen(){
        JFrame jFrame = new JFrame();

        jFrame.setTitle("ImageFH");
        jFrame.setResizable(false);
        jFrame.setSize(500, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);
        jFrame.setUndecorated(false);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        // Add component
        jFrame.add(imgPanel());
        jFrame.add(zipSelectPanel());
        jFrame.add(exportPanel());
        jFrame.add(btnSelecImage());
    }

    private JPanel imgPanel(){
        imgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 95));
        lblImgNull = new JLabel("Select Image.");

        lblImgNull.setFont(new Font("Arial", Font.PLAIN, 12));

        imgPanel.setBounds(150, 10, 200,200);
        imgPanel.setBackground(new Color(197, 197, 197));

        imgPanel.add(lblImgNull);

        return imgPanel;
    }

    private JPanel zipSelectPanel(){
        zipSelectPanel = new JPanel(new FlowLayout());
        zipPathTextField = new JTextField();
        btnSelectZip = new JButton();
        JLabel zipPanelDescription = new JLabel("Select .zip file.");

        zipPanelDescription.setFont(new Font("Arial", Font.PLAIN, 12));
        zipPanelDescription.setForeground(new Color(0, 0, 0));
        zipPanelDescription.setSize(100, 25);
        zipPanelDescription.setLocation(10, 10);

        zipPathTextField.setFont(new Font("Arial", Font.PLAIN, 12));
        zipPathTextField.setBounds(10, 40, 270,40);
        zipPathTextField.setPreferredSize(new Dimension(270, 40));

        btnSelectZip.setFont(new Font("Arial", Font.PLAIN, 12));
        btnSelectZip.setText("Select");
        btnSelectZip.setBounds(290, 40, 100, 40);
        btnSelectZip.setPreferredSize(new Dimension(100, 40));


        zipSelectPanel.setBounds(45, 260, 400,100);
        zipSelectPanel.setPreferredSize(new Dimension(400,100));
        zipSelectPanel.setBackground(new Color(197, 197, 197));

        zipSelectPanel.add(zipPathTextField);
        zipSelectPanel.add(btnSelectZip);
        zipSelectPanel.add(zipPanelDescription);

        return zipSelectPanel;
    }

    private JPanel exportPanel(){
        exportPanel = new JPanel();
        exportPathTextField = new JTextField();
        btnSelectExportPath = new JButton();
        btnExport = new JButton();
        JLabel exportPanelDescription = new JLabel("Select the export path.");

        exportPanelDescription.setFont(new Font("Arial", Font.PLAIN, 12));
        exportPanelDescription.setForeground(new Color(0, 0, 0));
        exportPanelDescription.setSize(200, 25);
        exportPanelDescription.setLocation(10, 10);

        exportPathTextField.setFont(new Font("Arial", Font.PLAIN, 12));
        exportPathTextField.setBounds(10, 40, 160,40);
        exportPathTextField.setPreferredSize(new Dimension(270, 40));

        btnSelectExportPath.setFont(new Font("Arial", Font.PLAIN, 12));
        btnSelectExportPath.setText("Choose");
        btnSelectExportPath.setBounds(180, 40, 100, 40);
        btnSelectExportPath.setPreferredSize(new Dimension(100, 40));

        btnExport.setFont(new Font("Arial", Font.PLAIN, 12));
        btnExport.setText("Export");
        btnExport.setBounds(290, 40, 100, 40);
        btnExport.setPreferredSize(new Dimension(100, 40));

        exportPanel.setBounds(45, 390, 400,100);
        exportPanel.setPreferredSize(new Dimension(400,100));
        exportPanel.setBackground(new Color(197, 197, 197));

        exportPanel.add(exportPanelDescription);
        exportPanel.add(exportPathTextField);
        exportPanel.add(btnSelectExportPath);
        exportPanel.add(btnExport);

        return  exportPanel;
    }

    private JButton btnSelecImage(){
        btnSelecImage = new JButton("Select Image");

        btnSelecImage.setBounds(175,220,150,25);
        btnSelecImage.setFont(new Font("Arial", Font.PLAIN, 10));

        return btnSelecImage;
    }

}
