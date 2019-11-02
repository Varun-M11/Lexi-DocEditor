
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Varun M
 */
class DoLexi implements BaseComposite {

    JFrame frame;
    JPanel north, editPane, status, image, tools, menu, east, west, padding1, padding2, padding_bottom;
    JLabel message, background, title, foreground;
    JTextPane editarea2;
    int flagSave = 0;
    File fileSave = null;
    int clickCount = 0;

    DoLexi() {
        frame = new JFrame("Document Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        background = new JLabel(new ImageIcon("C:\\Users\\ruch0\\OneDrive\\Documents\\NetBeansProjects\\Document\\src\\document\\bg7.jpg"));
        frame.setContentPane(background);
        frame.setLayout(new BorderLayout());
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public JPanel addComposite() {
        north = new JPanel(new BorderLayout());
        editPane = new JPanel();
        status = new JPanel(new BorderLayout());
        image = new JPanel(new FlowLayout());
        tools = new JPanel(new BorderLayout());
        east = new JPanel();
        west = new JPanel();
        message = new JLabel("Status will be displayed here.");
        message.setForeground(Color.WHITE);
        message.setFont(f);
        padding1 = new JPanel();
        padding2 = new JPanel();
        padding_bottom = new JPanel();
        title = new JLabel("Document Editor");
        title.setForeground(Color.WHITE);
        title.setFont(f1);
        menu = new JPanel(new BorderLayout());

        frame.add(north, BorderLayout.NORTH);
        frame.add(editPane, BorderLayout.CENTER);
        frame.add(status, BorderLayout.SOUTH);
        frame.add(east, BorderLayout.EAST);
        frame.add(west, BorderLayout.WEST);
        north.add(image, BorderLayout.NORTH);
        north.add(menu, BorderLayout.SOUTH);
        
        image.add(title);
       
        message.setPreferredSize(new Dimension(600, 200));
        
        padding_bottom.setPreferredSize(new Dimension(800, 200));
        status.add(padding_bottom, BorderLayout.WEST);
        status.add(message, BorderLayout.CENTER);
        menu.add(padding1, BorderLayout.WEST);
        menu.add(padding2, BorderLayout.EAST);
        menu.add(tools, BorderLayout.CENTER);
        tools.setLayout(new BoxLayout(tools, BoxLayout.X_AXIS));

        image.setPreferredSize(new Dimension(500, 100));
        tools.setPreferredSize(new Dimension(500, 100));
        editPane.setPreferredSize(new Dimension(600, 150));
        status.setPreferredSize(new Dimension(100, 100));
        east.setPreferredSize(new Dimension(200, 100));
        west.setPreferredSize(new Dimension(200, 100));
        padding1.setPreferredSize(new Dimension(200, 100));
        padding2.setPreferredSize(new Dimension(200, 100));

        padding_bottom.setOpaque(false);
        menu.setOpaque(false);
        tools.setOpaque(false);
        east.setOpaque(false);
        west.setOpaque(false);
        status.setOpaque(false);
        padding1.setOpaque(false);
        padding2.setOpaque(false);
        image.setOpaque(false);
        editPane.setOpaque(false);
        north.setOpaque(false);
        return tools;
    }

    @Override
    public JTextPane addLeaf() {
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        menubar.add(file);

        editarea2 = new JTextPane();
        editarea2.setMargin(new Insets(50, 50, 50, 50));
        editarea2.setPreferredSize(new Dimension(600, 600));
        JScrollPane scroll = new JScrollPane(editarea2);

        JMenuItem open = new JMenuItem("Open");
        file.add(open);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                        editarea2.read(input, "READING FILE :-)");
                        fis.close();
                    } catch (Exception ex) {
                        System.out.println("problem accessing file" + file.getAbsolutePath());
                    }
                } else {
                    System.out.println("File access cancelled by user.");
                }
            }
        });

        JMenuItem neww = new JMenuItem("New");
        file.add(neww);
        neww.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (editarea2.getText().isEmpty()) {
                    editarea2.setText("");
                } else {
                    save();
                    editarea2.setText("");
                    flagSave = 0;
                    fileSave = null;
                }
            }
        });

        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (flagSave == 1) {
                    BufferedWriter outFile = null;
                    try {
                        outFile = new BufferedWriter(new FileWriter(fileSave));
                    } catch (IOException ex) {
                        Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        editarea2.write(outFile);
                    } catch (IOException ex) {
                        Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if (outFile != null) {
                            try {
                                outFile.close();
                            } catch (IOException e) {
                            }
                        }
                    }
                } else {
                    save();
                }
            }
        });

        JMenuItem saveas = new JMenuItem("Save As");
        file.add(saveas);
        saveas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                save();
            }
        });

        JMenuItem quit = new JMenuItem("Quit");
        file.add(quit);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
            }
        });

        JMenu edit = new JMenu("Edit");
        menubar.add(edit);
        JMenuItem undo = new JMenuItem("Undo");
        edit.add(undo);
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
        cut.setText("Cut");
        edit.add(cut);

        JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        copy.setText("Copy");
        edit.add(copy);

        JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        paste.setText("Paste");
        edit.add(paste);
        
        JRootPane root = image.getRootPane();
        root.setJMenuBar(menubar);
        JRootPane root2 = editPane.getRootPane();

        root2.getContentPane().add(scroll);
        editPane.setVisible(true);
        return editarea2;
    }

    public void save() {
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
        final JFileChooser saveAsFileChooser = new JFileChooser();
        saveAsFileChooser.setApproveButtonText("Save");
        saveAsFileChooser.setFileFilter(extensionFilter);
        int actionDialog = saveAsFileChooser.showOpenDialog(frame);
        if (actionDialog != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = saveAsFileChooser.getSelectedFile();
        if (!file.getName().endsWith(".txt")) {
            file = new File(file.getAbsolutePath() + ".txt");
        }

        BufferedWriter outFile = null;
        try {
            outFile = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            System.out.println("Exception Occurred");
        }

        try {
            editarea2.write(outFile);
        } catch (IOException ex) {
            System.out.println("Exception occurred");
        } finally {
            if (outFile != null) {
                try {
                    outFile.close();
                } catch (IOException e) {
                }
            }

        }
    }
}