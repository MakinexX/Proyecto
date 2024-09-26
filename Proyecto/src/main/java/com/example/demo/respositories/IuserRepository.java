
package com.example.demo.respositories;

import com.example.demo.models.User;
import com.example.demo.models.UserPk;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface IuserRepository extends JpaRepository<User, UserPk>{
    public Optional<User> getByPassword(String password);
    public Optional<User> getByUsername(String userName);
    @Modifying
    @Transactional
    @Query("UPDATE User u   SET u.password= :newPassword WHERE u.password = :oldPassword AND u.username=:usern")
    public void alterPassword(@Param("oldPassword")String oldPassword,@Param("newPassword")String newPassword,@Param("usern") String userM);
}
