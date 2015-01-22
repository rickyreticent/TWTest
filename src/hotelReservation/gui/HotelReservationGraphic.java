package hotelReservation.gui;

import hotelReservation.data.Database;
import hotelReservation.exceptions.HotelReservationException;
import hotelReservation.helpers.ReservationOperations;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelReservationGraphic {
	JFrame frame;
	
	public HotelReservationGraphic() {
		this.frame = new JFrame();
		
	}
	
    public void createUI() {
        frame.setLayout(new BorderLayout());
        
        this.createAndShowUI();
    }
    
    protected JButton addOpenButton() {
    	JButton openButton = new JButton("Open");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser openFile = new JFileChooser();
                int returnVal = openFile.showOpenDialog(null);
                
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = openFile.getSelectedFile();
                    //This is where a real application would open the file.
                    System.out.println("Opening: " + file.getAbsolutePath() + "\n");
                    
                    String fileToRead = file.getAbsolutePath();
                    
                    Database database = new Database(); // TODO remover essa chamada
                    ReservationOperations reservationOperations = new ReservationOperations(database);
                    try {
						reservationOperations.getInformationsReservation(fileToRead);
					} catch (HotelReservationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                } else {
                	System.out.println("Open command cancelled by user.\n");
                }
            }
        });
    	
        return openButton;
    }
    
    public void createAndShowUI() {
    	frame.add(new JLabel("Hotel Reservation"), BorderLayout.NORTH);
        frame.add(this.addOpenButton(), BorderLayout.SOUTH);
        frame.setTitle("Hotel Reservation");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    	
    }
    
}