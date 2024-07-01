package FlipKar.service;

import FlipKar.entities.Vehicle;
import FlipKar.exceptions.BranchAlreadyExistsException;
import FlipKar.exceptions.BranchNotFoundException;
import FlipKar.exceptions.VehicleNotFoundException;

import java.util.List;

public interface RentalService {
    void onBoardBranch(String name, List<Vehicle> vehicles) throws BranchAlreadyExistsException;
    void addVehicleToBranch(String branchName, Vehicle vehicle) throws BranchNotFoundException;
    boolean rentVehicle(String type, String branchName, String startTime, String endTime) throws BranchNotFoundException, VehicleNotFoundException;
    void printSystemView(String timeslot);
}
