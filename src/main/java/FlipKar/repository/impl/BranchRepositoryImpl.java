package FlipKar.repository.impl;

import FlipKar.entities.Branch;
import FlipKar.exceptions.BranchAlreadyExistsException;
import FlipKar.exceptions.BranchNotFoundException;
import FlipKar.repository.BranchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BranchRepositoryImpl implements BranchRepository {
    private List<Branch> branches ;

    public BranchRepositoryImpl() {
        this.branches = new ArrayList<>();
    }

    @Override
    public void addBranch(Branch branch) throws BranchAlreadyExistsException {
        if(Objects.nonNull(getBranchIfExists(branch.getName()))) {
            throw new BranchAlreadyExistsException("Branch already exists: " + branch.getName());
        }
        branches.add(branch);
    }

    @Override
    public Branch getBranch(String name) throws BranchNotFoundException {
        Branch branch = getBranchIfExists(name);
        if(Objects.isNull(branch)) {
            throw new BranchNotFoundException("Branch not found: " + name);
        }
        return branch;
    }

    @Override
    public List<Branch> getAllBranches() {
        return branches;
    }

    private Branch getBranchIfExists(String name) {
        Optional<Branch> branch =
                branches.stream().filter(b ->
                        b.getName().equals(name)).findFirst();
        return branch.orElse(null);
    }
}
