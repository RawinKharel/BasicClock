import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class MyFrame extends JFrame {

    LocalTime currentTime;
    LocalDate dayOfWeek;
    LocalDate date;

    DateTimeFormatter timeFormat;
    DateTimeFormatter dayOfWeekFormat;
    DateTimeFormatter dateFormat;

    JLabel timeLabel;
    JLabel dayOfWeekLabel;
    JLabel dateLabel;

    String formattedTime;
    String formattedDayOfWeek;
    String formattedDate;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("What Time Is It?");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);

        timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");
        dayOfWeekFormat = DateTimeFormatter.ofPattern("EEEE");
        dateFormat = DateTimeFormatter.ofPattern("MMMM dd yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.white);
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayOfWeekLabel = new JLabel();
        dayOfWeekLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dayOfWeekLabel.setForeground(Color.black);


        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dateLabel.setForeground(Color.black);

        this.add(timeLabel);
        this.add(dayOfWeekLabel);
        this.add(dateLabel);

        this.setVisible(true);

        setTime();

    }

    public void setTime() {
        while (true) {
            currentTime = LocalTime.now();
            formattedTime = currentTime.format(timeFormat);
            timeLabel.setText(formattedTime);

            setDayOfWeek();
            setDate();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setDayOfWeek() {
        dayOfWeek = LocalDate.now();
        formattedDayOfWeek = dayOfWeek.format(dayOfWeekFormat);
        dayOfWeekLabel.setText(formattedDayOfWeek);
    }

    public void setDate() {
        date = LocalDate.now();
        formattedDate = date.format(dateFormat);
        dateLabel.setText(formattedDate);
    }

}
