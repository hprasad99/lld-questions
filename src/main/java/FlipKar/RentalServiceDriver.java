package FlipKar;

import FlipKar.entities.Bike;
import FlipKar.entities.Car;
import FlipKar.exceptions.BranchAlreadyExistsException;
import FlipKar.exceptions.BranchNotFoundException;
import FlipKar.exceptions.VehicleNotFoundException;
import FlipKar.repository.BranchRepository;
import FlipKar.repository.impl.BranchRepositoryImpl;
import FlipKar.service.RentalService;
import FlipKar.service.impl.RentalServiceImpl;

import java.util.Arrays;

public class RentalServiceDriver {
    public static void main(String[] args) {
        BranchRepository branchRepository = new BranchRepositoryImpl();
        RentalService rentalService = new RentalServiceImpl(branchRepository);

        // todo: Happy Flow
        System.out.println("**********Positive Test Cases*************");
        try {
            // todo: Onboard branches
            rentalService.onBoardBranch (
                    "kormangala",
                    Arrays.asList(
                        new Car("suv", 12),
                        new Car("sedan", 10),
                        new Bike("bike", 20)
                    )
            );

            rentalService.onBoardBranch (
                    "jayanagar",
                    Arrays.asList(
                            new Car("sedan", 11),
                            new Bike("bike", 30)
                            )
            );


            // todo: Add vehicle to branch
            rentalService.addVehicleToBranch (
                    "kormangala",
                    new Car("sedan", 10)
            );

            // todo: Rent vehicles
            boolean success = rentalService.rentVehicle("suv", "kormangala", "20 Feb 2024 10:00 am", "20 Feb 2024 12:00 pm");

            if(success) {
                System.out.println("Vehicle rented successfully.");
            } else {
                System.out.println("Failed to rent vehicle");
            }

            // todo: Print the system view
            rentalService.printSystemView (
                    "20 Feb 2024 11:00 am"

            );
        } catch (BranchAlreadyExistsException | BranchNotFoundException | VehicleNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("**********Negative Test Cases*************");
        System.out.println("Case 1: Adding vehicle to unknown branch");
        try {
            rentalService.addVehicleToBranch (
                    "unknown_branch",
                    new Car("sedan", 10)
                    );
        } catch (BranchNotFoundException e) {
            System.out.println("Expected Error: " + e.getMessage());
        }

        System.out.println("Case 2: Renting Vehicle that does not exist");
        try {
            boolean success = rentalService.rentVehicle(
                    "nonexistent_vehicle",
                    "kormangala",
                    "20 Feb 2024 10:00 am",
                    "20 Feb 2024 12:00 pm"
            );
        } catch (BranchNotFoundException | VehicleNotFoundException e) {
            System.out.println("Expected Error: " + e.getMessage());
        }

    }
}
