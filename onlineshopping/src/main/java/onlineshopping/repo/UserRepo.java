package onlineshopping.repo;

import onlineshopping.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Customer,Long> {

    Customer findByEmail(String email);

    Customer findByMobile(String mobile);

    @Query("SELECT u.name, u.email, u.mobile, u.enrollNumber, u.date_created, u.role " +
            "FROM Customer u " +
            "ORDER BY u.date_created "
    )
    Page<Object[]> findAllUsers(Pageable pageable);

    @Query("SELECT u FROM Customer u WHERE u.enrollNumber = :enrollmentID")
    Optional<Customer> findByEnrollmentNumber(@Param("enrollmentID") String enrollmentID);
}
