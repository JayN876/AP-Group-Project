package interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import databaseAction.PaySlipDatabaseAction;

import com.toedter.calendar.JCalendar;

public class PaySlipJPanel {

    private JPanel panel;
    private JLabel headingLabel;
    private GridBagConstraints gbc;
    private DefaultTableModel model;
    private PaySlipDatabaseAction paySlipAction;
    public GeneratePaySlip generatePaySlip;
    private String startDateSelected;
    private String endDateSelected;
    private String actionString;
    private JLabel startDateLabel;
    private JLabel endDateLabel;

    public PaySlipJPanel() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        paySlipAction = new PaySlipDatabaseAction();

        headingLabel = new JLabel("Pay Slips");
        gbc.gridx = 0;
        gbc.gridy = 0;
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(headingLabel, gbc);
       
        JButton viewAllButton = new JButton("View All");
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 90, 0, 0);
        viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                addRecords(paySlipAction.getPaySlipDetails());
            }
        });
        panel.add(viewAllButton, gbc);

        JButton startDateButton = new JButton("Start Period: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 100); // Increase the right padding
        startDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalendarFrame();
                actionString = "Start";
            }
        });
        panel.add(startDateButton, gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        startDateLabel = new JLabel("yyyy-mm-dd");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 35, 0, 0);
        panel.add(startDateLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        JButton endDateButton = new JButton("End Period");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 50, 0, 100); // Increase the right padding
        endDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalendarFrame();
                actionString = "End";
            }
        });
        panel.add(endDateButton, gbc);

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        endDateLabel = new JLabel("yyyy-mm-dd");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 160, 0, 0);
        panel.add(endDateLabel, gbc);

        JButton goButton = new JButton("Filter by Date");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 80, 0, 0);
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startDateLabel.getText().equals("yyyy-mm-dd") || endDateLabel.getText().equals("yyyy-mm-dd")) {
                    JOptionPane.showMessageDialog(null, "Please enter both start date and end date.", "Pay Slip Status", JOptionPane.ERROR_MESSAGE);
                } else {
                    model.setRowCount(0);
                    addRecords(paySlipAction.getPaySlipDetailsByDateRange(startDateLabel.getText(), endDateLabel.getText()));
                }
            }
        });
        panel.add(goButton, gbc);

        String[] columnNames = {"Pay Slip ID","Staff ID" ,"Start Date", "End Date", "Salary", "View Pay Slip"};

        model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);

        ButtonRenderer buttonRenderer = new ButtonRenderer();
        ButtonEditor buttonEditor = new ButtonEditor(new JTextField());
        table.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);
        table.getColumnModel().getColumn(5).setCellEditor(buttonEditor);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(980, 400));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(20, 0, 0, 0); // Added some vertical space above the table
        panel.add(scrollPane, gbc);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.setPreferredSize(new Dimension(1000, 600));

        // Load the pay slip information when the page is loaded
        addRecords(paySlipAction.getPaySlipDetails());
    }

    public JPanel getPanel() {
        return panel;
    }

    public void addRecords(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                String paySlipId = resultSet.getString("payId");
                String staffID = resultSet.getString("staffID");
                String startDate = resultSet.getString("startDate");
                String endDate = resultSet.getString("endDate");
                String salary = resultSet.getString("salary");

                model.addRow(new Object[]{paySlipId, staffID,startDate, endDate, salary});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value != null) {
                setText(value.toString());
            } else {
                setText("View Pay Slip");
            }
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        JButton button;
        private String label = "View Pay Slip";
        private boolean isPushed;
        String staffID;
        String paySlipId;

        public ButtonEditor(JTextField textField) {
            super(textField);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }
            
            paySlipId = (String) table.getModel().getValueAt(row, 0);
            staffID = (String) table.getModel().getValueAt(row, 1);
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                generatePaySlip = new GeneratePaySlip();
                generatePaySlip.getRecords(staffID,paySlipId);
                
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    class CalendarFrame {
        private JFrame frame;
        private JCalendar calendar;
        private JPanel panel;
        private JButton confirmButton;
        private GridBagConstraints gbc;

        public CalendarFrame() {
            frame = new JFrame();
            frame.setLayout(new GridBagLayout());
            panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();

            calendar = new JCalendar();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 0, 0);
            panel.add(calendar, gbc);

            confirmButton = new JButton("Confirm");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 0, 0, 0);
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    java.util.Date date = calendar.getDate();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH) + 1; // Month is 0-based, so we add 1
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    String formattedYear = String.format("%04d", year);
                    String formattedMonth = String.format("%02d", month);
                    String formattedDay = String.format("%02d", day);
                    String formattedDate = formattedYear + "-" + formattedMonth + "-" + formattedDay;
                    if(actionString.equals("Start")) {
                        startDateSelected = formattedDate;
                        startDateLabel.setText(formattedDate);
                    }
                    else if(actionString.equals("End")) {
                        endDateSelected = formattedDate;
                        endDateLabel.setText(formattedDate);
                    }
                    frame.dispose();
                }
            });

            panel.add(confirmButton, gbc);

            panel.setPreferredSize(new Dimension(300, 300));
            frame.add(panel, gbc);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.setLocationRelativeTo(null); // Set the frame to appear at the center of the screen
            frame.setVisible(true);
        }
    }

}

