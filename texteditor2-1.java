//simple text editor in java swing

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class texteditor2 extends JFrame implements ActionListener {
    private JTextArea ta;
    private int count;
    private JMenuBar menuBar;
    private JMenu fileM, editM, viewM, helpM;
    private JScrollPane scpane;
    private JMenuItem exitI, cutI, copyI, pasteI, selectI, saveI, loadI, statusI, saveasI, printI, helpI, aboutI;
    private String pad;
    private JToolBar toolBar;

    public texteditor2() {
        setTitle("My Text Editor");
        setSize(600, 600);
        setLocationRelativeTo(null);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        count = 0;
        pad = " ";
        ta = new JTextArea(); // textarea
        menuBar = new JMenuBar(); // menubar
        fileM = new JMenu("File"); // file menu
        editM = new JMenu("Edit"); // edit menu
        viewM = new JMenu("View"); // edit menu

        helpM = new JMenu("Help"); // help menu

        scpane = new JScrollPane(ta); // scrollpane and add textarea to scrollpane
        exitI = new JMenuItem("Exit");
        cutI = new JMenuItem("Cut");
        copyI = new JMenuItem("Copy");
        pasteI = new JMenuItem("Paste");
        selectI = new JMenuItem("Select All"); // menuitems
        saveI = new JMenuItem("Save"); // menuitems

        saveasI = new JMenuItem("Save As"); // menuitems

        printI = new JMenuItem("Print"); // Print menu item

        loadI = new JMenuItem("Load"); // menuitems

        statusI = new JMenuItem("Status"); // menuitems

        helpI = new JMenuItem("Online Help");

        aboutI = new JMenuItem("About My text editor");
        toolBar = new JToolBar();

        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);

        setJMenuBar(menuBar);
        menuBar.add(fileM);
        menuBar.add(editM);
        menuBar.add(viewM);

        menuBar.add(helpM);

        fileM.add(saveI);
        fileM.add(saveasI);

        fileM.add(loadI);
        fileM.add(printI);
        fileM.add(exitI);

        editM.add(cutI);
        editM.add(copyI);
        editM.add(pasteI);
        editM.add(selectI);

        viewM.add(statusI);

        helpM.add(helpI);
        helpM.add(aboutI);

        saveI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        saveasI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ALT, ActionEvent.CTRL_MASK));

        printI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exitI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        loadI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        cutI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copyI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        pasteI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        selectI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        pane.add(scpane, BorderLayout.CENTER);
        pane.add(toolBar, BorderLayout.SOUTH);

        saveI.addActionListener(this);
        saveasI.addActionListener(this);
        loadI.addActionListener(this);
        printI.addActionListener(this);
        exitI.addActionListener(this);
        cutI.addActionListener(this);
        copyI.addActionListener(this);
        pasteI.addActionListener(this);
        selectI.addActionListener(this);
        statusI.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        //
        // Component modalToComponent = null;
        // if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        // File file = fileChooser.getSelectedFile();
        // // load from file
        // }
        //

        JMenuItem choice = (JMenuItem) e.getSource();
        if (choice == saveI) {

            Component modalToComponent = null;
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                // save from file
            }

        }

        else if (choice == loadI) {

            Component modalToComponent = null;
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                // load from file
            }
        }

        else if (choice == printI) {

            Component modalToComponent = null;
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                // load from file
            }

        } else if (choice == exitI)
            System.exit(0);

        else if (choice == cutI) {
            pad = ta.getSelectedText();
            ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());
        } else if (choice == copyI)
            pad = ta.getSelectedText();
        else if (choice == pasteI)
            ta.insert(pad, ta.getCaretPosition());
        else if (choice == selectI)
            ta.selectAll();
        else if (e.getSource() == statusI) {
            JOptionPane.showMessageDialog(this, "Active");
        }

        else if (e.getSource() == aboutI) {
            // message box of help
            JOptionPane.showMessageDialog(this,
                    "This is the text box which can be used for multiple uses like entering new text, edit text and many More.");

        }
    }

    public static void main(String[] args) {

        new texteditor2();
    }
}