package FlipKar.repository;

import FlipKar.entities.Branch;
import FlipKar.exceptions.BranchAlreadyExistsException;
import FlipKar.exceptions.BranchNotFoundException;

import java.util.List;

public interface BranchRepository {
    void addBranch(Branch branch) throws BranchAlreadyExistsException;
    Branch getBranch(String name) throws BranchNotFoundException;
    List<Branch> getAllBranches();

}
