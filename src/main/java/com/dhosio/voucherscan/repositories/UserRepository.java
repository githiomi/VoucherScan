package com.dhosio.voucherscan.repositories;

import com.dhosio.voucherscan.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUsername(String username);

    User findUserByEmpId(String empId);

}
