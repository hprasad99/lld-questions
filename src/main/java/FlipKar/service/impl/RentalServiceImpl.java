package FlipKar.service.impl;

import FlipKar.entities.Booking;
import FlipKar.entities.Branch;
import FlipKar.entities.Vehicle;
import FlipKar.exceptions.BranchAlreadyExistsException;
import FlipKar.exceptions.BranchNotFoundException;
import FlipKar.exceptions.VehicleNotFoundException;
import FlipKar.repository.BranchRepository;
import FlipKar.service.RentalService;
import FlipKar.util.DateTimeUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class RentalServiceImpl implements RentalService {
    private final BranchRepository branchRepository;

    public RentalServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public void onBoardBranch(String name, List<Vehicle> vehicles) throws BranchAlreadyExistsException {
        Branch branch = new Branch(name, vehicles);
        branchRepository.addBranch(branch);
    }

    @Override
    public void addVehicleToBranch(String branchName, Vehicle vehicle) throws BranchNotFoundException {
        Branch branch = branchRepository.getBranch(branchName);
        branch.addVehicle(vehicle);
    }

    @Override
    public boolean rentVehicle(String type, String branchName, String startTime, String endTime) throws BranchNotFoundException, VehicleNotFoundException {
        Branch branch = branchRepository.getBranch(branchName);
        LocalDateTime start = LocalDateTime.parse(startTime, DateTimeUtil.formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, DateTimeUtil.formatter);
        List<Vehicle> availableVehicles = getAvailableVehicles(branch, start, end);
        for(Vehicle vehicle: availableVehicles) {
            if(vehicle.getType().equalsIgnoreCase(type)) {
                Booking booking = new Booking(vehicle, start, end);
                branch.getVehicles().remove(vehicle);
                return true;
            }
        }
        throw new VehicleNotFoundException("Vehicle not found: " + type);
    }

    @Override
    public void printSystemView(String timeslot) {
        System.out.println("System view for time slot: " + timeslot);
        LocalDateTime slot = LocalDateTime.parse(timeslot, DateTimeUtil.formatter);
        for(Branch branch: branchRepository.getAllBranches()) {
            System.out.println(branch.getName() + ":");
            List<Vehicle> availableVehicles = getAvailableVehicles(branch, slot, slot.plusHours(1));
            if (availableVehicles.isEmpty()) {
                System.out.println("All vehicles are booked");
            } else {
                for (Vehicle vehicle : availableVehicles) {
                    System.out.println(vehicle.getType() + " available for Rs." + vehicle.getPricePerHour() + " per hour");
                }
            }
        }
    }

    private List<Vehicle> getAvailableVehicles(Branch branch, LocalDateTime start, LocalDateTime end) {
        List<Vehicle> bookedVehicles = branch.getBookings().stream()
                .filter(booking -> DateTimeUtil.overlaps(booking.getStartTime(), booking.getEndTime(), start, end))
                .map(Booking::getVehicle)
                .collect(Collectors.toList());
        return  branch.getVehicles().stream()
                .filter(vehicle -> !bookedVehicles.contains(vehicle))
                .collect(Collectors.toList());
    }


}
