package me.dodas.window.main;

import me.dodas.util.FileManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainScreen {

    // Panel
    JPanel imgPanel;
    JPanel zipSelectPanel;
    JPanel exportPanel;

    // Label
    JLabel lblImg;

    // Text Field
    JTextField zipPathTextField;
    JTextField exportPathTextField;

    // Button
    JButton btnSelecImage;
    JButton btnSelectZip;
    JButton btnSelectExportPath;
    JButton btnExport;

    // File Chooser
    JFileChooser imgFileChooser;
    JFileChooser zipFileChooser;
    JFileChooser exportFileChooser;

    // Files
    File imgFileSelectedPath;
    File zipFileSelectedPath;

    //Booleans
    Boolean imageFileIsValid = false;
    Boolean zipFileIsValid = false;

    //Strings
    String zipFileAbsolutePath;
    String imgFileAbsolutePath;

    public MainScreen(){
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
        //Image selection panel builder

        imgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 95));
        lblImg = new JLabel("Select Image.");

        lblImg.setFont(new Font("Arial", Font.PLAIN, 12));

        imgPanel.setBounds(150, 10, 200,200);
        imgPanel.setBackground(new Color(197, 197, 197));

        imgPanel.add(lblImg);

        return imgPanel;
    }

    private JPanel zipSelectPanel(){
        //Zip file selection panel builder

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
        btnSelectZip.addActionListener(this::selectZip);


        zipSelectPanel.setBounds(45, 260, 400,100);
        zipSelectPanel.setPreferredSize(new Dimension(400,100));
        zipSelectPanel.setBackground(new Color(197, 197, 197));

        zipSelectPanel.add(zipPathTextField);
        zipSelectPanel.add(btnSelectZip);
        zipSelectPanel.add(zipPanelDescription);

        return zipSelectPanel;
    }

    private JPanel exportPanel(){
        //Export panel builder

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

        btnSelecImage.addActionListener(this::selectImage);

        return btnSelecImage;
    }

    private void selectImage(ActionEvent a){
        imageFileIsValid = imageFileChooser();
    }

    private void selectZip(ActionEvent a){
        zipFileAbsolutePath = zipPathTextField.getText().strip();

        if (zipFileAbsolutePath == null || zipFileAbsolutePath == ""){

            zipFileIsValid = zipFileChooser();
            zipPathTextField.setText(zipFileAbsolutePath);

        } else {

            try {

                zipFileSelectedPath = new File(zipFileAbsolutePath);
                zipFileIsValid = FileManager.verifyZipFile(zipFileSelectedPath);

                if (zipFileIsValid){

                    zipSelectPanel.setBackground(new Color(76, 204, 87));

                } else {

                    JOptionPane.showMessageDialog(null, "The selected file is invalid. It is necessary to choose an zip file.", "Caution!", JOptionPane.WARNING_MESSAGE);
                    zipSelectPanel.setBackground(new Color(204, 76, 76));
                    zipFileAbsolutePath = "";
                    zipPathTextField.setText("");

                }

            } catch (Exception e){

                System.out.println(e);

            }

        }
    }

    private Boolean zipFileChooser(){
        /**
         * Select files and filter for zip files
         * Returns true if a file is selected and it contains one of the extensions: [zip]
         * If the operation is cancelled, or an invalid file is selected, the function will return false
         */

        List<String> zipFileExtensions = new ArrayList<>();
        zipFileExtensions.add("zip");

        try {

            zipFileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Zip File", "zip");
            zipFileChooser.setFileFilter(filter);
            zipFileChooser.setCurrentDirectory(new File("."));

            Integer zipFileChooserResult = zipFileChooser.showOpenDialog(null);
            System.out.println(zipFileChooserResult);

            if (zipFileChooserResult == JFileChooser.APPROVE_OPTION){

                zipFileSelectedPath = new File(zipFileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(zipFileSelectedPath);

                if (FileManager.verifyZipFile(zipFileSelectedPath)){

                    zipSelectPanel.setBackground(new Color(76, 204, 87));
                    zipFileAbsolutePath = zipFileSelectedPath.getAbsolutePath();
                    return true;

                } else {

                    JOptionPane.showMessageDialog(null, "The selected file is invalid. It is necessary to choose an zip file.", "Caution!", JOptionPane.WARNING_MESSAGE);
                    zipSelectPanel.setBackground(new Color(204, 76, 76));
                    zipFileAbsolutePath = zipFileSelectedPath.getAbsolutePath();

                }

            } else if (zipFileChooserResult == JFileChooser.CANCEL_OPTION){

                if (zipFileSelectedPath == null) {

                    zipSelectPanel.setBackground(new Color(204, 76, 76));
                    return false;

                }

            }

        }catch (Exception e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error when trying to select file.", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;

        }

        return false;
    }

    private Boolean imageFileChooser(){
        /**
         * Select files and filter for images
         * Returns true if a file is selected and it contains one of the extensions: [png, jpg, jpeg]
         * If the operation is cancelled, or an invalid file is selected, the function will return false
         */

        List<String> imgFilesExtensions = new ArrayList<>();
        imgFilesExtensions.add("png");
        imgFilesExtensions.add("jpg");
        imgFilesExtensions.add("jpeg");

        try{

            imgFileChooser = new JFileChooser();
            FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg");
            imgFileChooser.setFileFilter(imgFilter);
            imgFileChooser.setCurrentDirectory(new File("."));

            Integer imgFileChooserResult = imgFileChooser.showOpenDialog(null);
            System.out.println(imgFileChooserResult);

            if (imgFileChooserResult == JFileChooser.APPROVE_OPTION){

                imgFileSelectedPath = new File(imgFileChooser.getSelectedFile().getAbsolutePath());
                imgFileAbsolutePath = imgFileSelectedPath.getAbsolutePath();
                System.out.println(imgFileSelectedPath);

                if (FileManager.verifyImageFile(imgFileSelectedPath)){

                    lblImg.setText("Nice!");
                    imgPanel.setBackground(new Color(76, 204, 87));

                } else {

                    JOptionPane.showMessageDialog(null, "The selected file is invalid. It is necessary to choose an image file.", "Caution!", JOptionPane.WARNING_MESSAGE);
                    lblImg.setText("Invalid file.");
                    imgPanel.setBackground(new Color(204, 76, 76));

                }

            } else if (imgFileChooserResult == JFileChooser.CANCEL_OPTION){

                if (imgFileSelectedPath == null) {

                    lblImg.setText("Invalid file.");
                    imgPanel.setBackground(new Color(204, 76, 76));

                }

            }

        }catch (Exception e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error when trying to select file.", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;

        }

        return false;
    }

}
