import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FlightBookingDemo extends JFrame {

    private final JTextField domainField = new JTextField("flyair.co.za", 20);
    private final JButton resolveBtn = new JButton("Resolve IP");
    private final JLabel ipLabel = new JLabel("Please enter an airline domain and click Resolve IP.");
    private final JButton seat1A = new JButton("Seat 1A");
    private final JButton seat1B = new JButton("Seat 1B");
    private final JButton seat1C = new JButton("Seat 1C");

    public FlightBookingDemo() {
        super("Flight Booking (Demo)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Top: domain input + button
        JPanel top = new JPanel(new BorderLayout(8, 8));
        JPanel inputRow = new JPanel(new BorderLayout(8, 8));
        inputRow.add(new JLabel("Airline domain:"), BorderLayout.WEST);
        inputRow.add(domainField, BorderLayout.CENTER);
        inputRow.add(resolveBtn, BorderLayout.EAST);

        top.add(inputRow, BorderLayout.NORTH);

        JPanel ipRow = new JPanel(new BorderLayout());
        ipRow.add(new JLabel("IP Result"), BorderLayout.WEST);
        ipRow.add(ipLabel, BorderLayout.CENTER);
        top.add(ipRow, BorderLayout.SOUTH);

        // Seats
        JPanel seats = new JPanel(new GridLayout(1, 3, 8, 8));
        seats.setBorder(BorderFactory.createTitledBorder("Select your seat"));
        seats.add(seat1A);
        seats.add(seat1B);
        seats.add(seat1C);

        // Root layout
        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        root.add(top, BorderLayout.NORTH);
        root.add(seats, BorderLayout.CENTER);
        setContentPane(root);

        // Wire actions
        resolveBtn.addActionListener(this::onResolve);
        seat1A.addActionListener(e -> onReserve(seat1A, "1A"));
        seat1B.addActionListener(e -> onReserve(seat1B, "1B"));
        seat1C.addActionListener(e -> onReserve(seat1C, "1C"));

        pack();
        setLocationRelativeTo(null);
    }

    private void onResolve(ActionEvent e) {
        String domain = domainField.getText().trim();
        if (domain.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a domain.", "Input required", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            InetAddress[] addrs = InetAddress.getAllByName(domain);
            String list = Arrays.stream(addrs)
                    .map(InetAddress::getHostAddress)
                    .distinct()
                    .collect(Collectors.joining(", "));
            ipLabel.setText(domain + " -> " + (list.isEmpty() ? "(no IPs found)" : list));
        } catch (UnknownHostException ex) {
            ipLabel.setText("Could not resolve: " + domain);
        }
    }

    private void onReserve(JButton seatBtn, String seatCode) {
        int result = JOptionPane.showConfirmDialog(this,
                "Seat " + seatCode + " reserved!",
                "Seat Confirmation",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        // Optionally disable the seat after "reservation"
        seatBtn.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlightBookingDemo().setVisible(true));
    }
}

    

