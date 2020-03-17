package com.shopstack.repository.businessuser;



import com.shopstack.model.businessuser.BusinessUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusinessUserRepository extends JpaRepository<BusinessUser, Integer> {

    @Query("SELECT b FROM BusinessUser b WHERE LOWER(b.email) = LOWER(:email) ")
    public BusinessUser findByEmail(@Param("email") String email);

    @Query("SELECT b FROM BusinessUser b WHERE LOWER(b.token) = LOWER(:token) ")
    public BusinessUser findByToken(@Param("token") String token);
}
